package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.GekozenAntwoord;
import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import views.components.NicePanel;
import views.factories.JLabelFactory;
import views.factories.JPanelFactory;
import controllers.Spel;

public class ResultatenScherm extends JPanel {
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

					List<logic.Onderdeel> onderdelen = spel.getOnderdelen();

					for (logic.Onderdeel o : onderdelen) {
						spel.volgendeOnderdeel();
						spel.kiesOnderdeel(o);
					}

					SpeelScherm speelscherm = new SpeelScherm(spel);
					spel.openPanel(speelscherm);
					speelscherm.openResultaten();
					
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel	onderdelen;
	private JPanel	panel_1;

	/**
	 * Create the panel.
	 * 
	 * @param spel
	 */
	public ResultatenScherm(final Spel spel) {
		ArrayList<GekozenAntwoord> gekozenAntwoorden = spel.getGekozenAntwoorden();
		
		setBackground(new Color(0,0,0,150));
		setBorder(null);
		setLayout(new MigLayout("", "[grow][77px][grow]", "[grow][20px,growprio 50,grow][grow]"));

		JPanel panel =  JPanelFactory.createTransparentJPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[77px][95px]", "[20px,growprio 50,grow]"));

		onderdelen = JPanelFactory.createTransparentJPanel();
		panel.add(onderdelen, "cell 0 0,grow");
		onderdelen.setLayout(new MigLayout("", "[100px:100px][86px]",
				"[20px][20px][20px][20.00px][20px][20px][20px][20.00px]"));

		panel_1 = JPanelFactory.createTransparentJPanel();
		panel.add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[95px][90px]", "[20px,growprio 50,grow][20px]"));

		JLabel dtrpnScore = new JLabel();
		panel_1.add(dtrpnScore, "cell 0 0 2 1,grow");
		dtrpnScore.setBackground(new Color(0, 0, 0, 0));
		dtrpnScore.setForeground(Color.WHITE);
		
		int aantalGoed = 0;
		int aantalFout = 0;
		
		for (GekozenAntwoord gk : gekozenAntwoorden)
			if(gk.isGoed()) aantalGoed++;
			else aantalFout++;
		
		
		dtrpnScore.setText("<html>" +
				"Aantal goed: "+ aantalGoed +"<br/>" +
				"Aantal fout: "+ aantalFout +"<br/>" +
				"Aantal jokers gebruikt: 0<br/><br/>" +
				"Score: 1500<br/><br/>" +
				"Tijd: 90 sec" +
				"</html>");

		NiceButton btnStoppen = new NiceButton("Stoppen");
		panel_1.add(btnStoppen, "cell 0 1,grow");

		NiceButton btnNewButton = new NiceButton("Verder");
		panel_1.add(btnNewButton, "cell 1 1,grow");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spel.volgendeVraag();
			}
		});
		btnStoppen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spel.backToMainMenu();
			}
		});

		int i = 0;
		for (GekozenAntwoord gk : gekozenAntwoorden) {
			JLabel txt = JLabelFactory.createAntwoordJLabel(gk.getHuidigeOnderdeel().getTekst());
			onderdelen.add(txt, "cell 0 " + i + ",grow");

			JLabel txtBoolean = new JLabel();

			txtBoolean.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			if (gk.isGoed())
				txtBoolean.setForeground(Color.GREEN);
			else txtBoolean.setForeground(Color.RED);

			txtBoolean.setText(gk.getGekozenOnderdeel().getTekst());

			onderdelen.add(txtBoolean, "cell 1 " + i + ",grow");

			i++;
		}

	}

}
