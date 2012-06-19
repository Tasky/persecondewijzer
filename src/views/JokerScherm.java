package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import views.factories.JLabelFactory;
import views.factories.JPanelFactory;
import controllers.Spel;
import exceptions.LogicException;

/**
 * @author ?
 * 
 */
public class JokerScherm extends JPanel {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Spel spel = new Spel();
					List<logic.Onderwerp> onderwerpen = spel.getOnderwerpen();
					spel.setOnderwerp(onderwerpen.get(1));

					List<logic.Onderdeel> ondrln = spel.getOnderdelen();
					List<logic.Onderdeel> ondrln2 = new ArrayList<logic.Onderdeel>(); 
					
					ondrln2.add(ondrln.get(0)); // 0
					ondrln2.add(ondrln.get(1)); // 1
					ondrln2.add(ondrln.get(2)); // 2
					ondrln2.add(ondrln.get(3)); // 3
					ondrln2.add(ondrln.get(4)); // 4
					ondrln2.add(ondrln.get(8)); // 5
					ondrln2.add(ondrln.get(7)); // 6
					ondrln2.add(ondrln.get(6)); // 7
					ondrln2.add(ondrln.get(5)); // 8
					
					for (logic.Onderdeel o : ondrln2) {
						spel.volgendeOnderdeel();
						spel.kiesOnderdeel(o);
					}

					SpeelScherm speelscherm = new SpeelScherm(spel);
					spel.openPanel(speelscherm);
					speelscherm.openJokerscherm();
					spel.getTimer().stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the panel.
	 * 
	 * @param speelscherm
	 * 
	 * @param spel
	 */
	public JokerScherm(final SpeelScherm speelscherm, final Spel spel) {
		setBackground(new Color(0, 0, 0, 150));
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow][530,center][grow]", "[grow][200px,center][grow]"));

		JPanel panel = JPanelFactory.createBackgroundJPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[66px][12px][226px][4px][13px][93px][85px]", "[27px][28px][19px][19px][19px][29px]"));

		JLabel lblNewLabel = JLabelFactory.createJokerLabel("Hoeveel jokers wil je inzetten?");
		panel.add(lblNewLabel, "cell 0 0 5 1,alignx left,aligny top");

		final JSpinner spinner = new JSpinner();
		panel.add(spinner, "cell 0 1,growx,aligny top");
		spinner.setModel(new SpinnerNumberModel(0, 0, spel.getMaxJokers(), 1));

		JLabel lblJokers = JLabelFactory.createJokerLabel("jokers");
		JLabel lblJokersOver = JLabelFactory.createJokerLabel("Je hebt nog " + spel.getMaxJokers() + " jokers");
		JLabel lblJokerkosten = JLabelFactory.createJokerLabel("Een joker kost " + spel.getJokerKosten() + " seconden");
		JLabel lblHoeveelGoedVerplicht = JLabelFactory.createJokerLabel("Je moet deze ronde " + spel.getHoeveelGoedVerplicht() + " vragen goed hebben");
		JLabel lblHuidigeScore = JLabelFactory.createJokerLabel("Je huidige score is: " + spel.getScore());

		panel.add(lblHuidigeScore, "cell 0 4 3 1,alignx left,aligny top");
		panel.add(lblJokers, "cell 2 1,alignx left,growy");
		panel.add(lblJokersOver, "cell 0 2 3 1,alignx left,aligny top");
		panel.add(lblJokerkosten, "cell 4 2 3 1,alignx left,aligny top");
		panel.add(lblHoeveelGoedVerplicht, "cell 0 3 3 1,alignx left,aligny top");

		NiceButton btnNewButton = new NiceButton("Verder");
		panel.add(btnNewButton, "cell 6 5,growx,aligny top");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int jokers = (Integer) spinner.getValue();
					if(jokers > spel.getMaxJokers()) {
						spinner.setBackground(Color.red);
						return;
					}
					spel.zetJokersIn(jokers);
				} catch (LogicException e) {
					// TODO Auto-generated catch block
					// zoveel jokers heeft de gebruiker niet..
					e.printStackTrace();
				}
				speelscherm.openResultaten();
			}
		});
	}
}
