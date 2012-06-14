package views;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import controllers.Spel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import logic.Onderdeel;
import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;
import views.components.NicePanel;
import java.awt.GridLayout;

public class SpeelScherm extends NicePanel {
	private int currentCell = 0;
	private final JPanel middenvlak = new JPanel();
	
    /**
     * Opstarten speelscherm, handig voor debuggen of snel testen.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Spel spel = new Spel();
                    List<logic.Onderwerp> onderwerpen = spel.getOnderwerpen();
                    spel.setOnderwerp(onderwerpen.get(0));
                    spel.openPanel(new SpeelScherm(spel));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Opstarten van speelscherm
     * @param spel 
     * @throws IOException 
     */
    public SpeelScherm(Spel spel) {
        try {
            initialize(spel);
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    /**
     * Initialize the contents of the frame.
     * @param mainWindow 
     * @throws IOException 
     */
    private void initialize(final Spel spel) throws IOException {
    	String vraag = spel.getVraagTekst();
        //setBackground(SystemColor.info);
        setBounds(0, 0, 1024, 768);
        setLayout(new MigLayout("", "[124][grow][]", "[110.00][350px:24.00,grow][:126.00:250px,grow,fill]"));
        
        middenvlak.setLayout(new GridLayout(1, 0, 0, 0));
        add(middenvlak, "cell 1 1 2 1,grow");

        JLabel lblTitle = DefaultComponentFactory.getInstance().createTitle(vraag);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 47));
        add(lblTitle, "cell 1 0 2 1");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));
        add(buttonsPanel, "cell 0 1,grow");
        
        final JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[grow][]"));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(panel);
        add(scrollPane, "cell 0 2 2 1,grow");

        final List<Onderdeel> onderdelen = spel.getOnderdelen();
        
        Onderdeel huidigeOnderdeel = onderdelen.get(0);
        
        ImagePanel plaatje = new ImagePanel(huidigeOnderdeel.getPlaatje());
        plaatje.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        plaatje.setAutoResize(true);
        middenvlak.add(plaatje);

        JPanel panel_1 = new JPanel();
        add(panel_1, "cell 2 2,grow");
        panel_1.setLayout(new MigLayout("", "[116px,grow]", "[grow][154px]"));

        final views.panels.InfoPanel timer = new views.panels.InfoPanel(spel);
        panel_1.add(timer, "cell 0 0,grow");

        JButton btnStoppen = new JButton("Stop de tijd");
        initStopButton(spel, timer, btnStoppen);
        panel_1.add(btnStoppen, "cell 0 1,alignx left,growy");

        iterateChoices(buttonsPanel, panel, onderdelen);
    }

	private void initStopButton(final Spel spel,
			final views.panels.InfoPanel timer, final JButton btnStoppen) {
		btnStoppen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    middenvlak.removeAll();
                    middenvlak.add(new JokerScherm(spel));
                    middenvlak.revalidate(); 
                    middenvlak.repaint();
                    btnStoppen.setEnabled(false);
                    // Tijd stoppen
                    timer.stopTimer();
                }
            });
	}

	private void iterateChoices(JPanel buttonsPanel, final JPanel panel,
			final List<Onderdeel> onderdelen) {
		int cell = 0;
		for (final Onderdeel optie : onderdelen) {			
            //antwoorden.add(label, "cell 0 "+cell+",alignx left,aligny top");
            final JButton button = new JButton(optie.getAntwoord());
            button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JComboBox combobox = new JComboBox();
                        DefaultComboBoxModel model = new DefaultComboBoxModel();
                        for(Onderdeel comboOptie : onderdelen) {
                            model.addElement(comboOptie.getAntwoord());
                        }
                        model.setSelectedItem(optie.getAntwoord());
                        combobox.setModel(model);
                        combobox.setMaximumRowCount(9);
                        panel.add(combobox, "cell "+currentCell+" 1,growx");

                        ImagePanel imagePanel = null;
                        try {
                            imagePanel = new ImagePanel(optie.getPlaatje());
                            imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        panel.add(imagePanel, "cell "+currentCell+" 0,grow");
                        imagePanel.setAutoResize(true);

                        if (optie.isGoed()) {
                            imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.GREEN));
                        } else {
                            imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.RED));
                        }

                        currentCell++;
                        button.setEnabled(false);
                        panel.getParent().validate();
                    }
                });
            buttonsPanel.add(button, "cell 0 "+(cell)+",growx");
            cell++;
        }
	}

}
