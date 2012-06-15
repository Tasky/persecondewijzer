package views;

import controllers.Spel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import logic.GekozenAntwoord;
import logic.Onderdeel;
import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;
import views.components.NicePanel;
import java.awt.GridLayout;

public class SpeelScherm extends NicePanel {
	private int currentCell = 0;
	private final JPanel middenvlak = new JPanel();
	private List<Onderdeel>	onderdelen;
	private Onderdeel	huidigeOnderdeel;
	private JPanel	gekozenAntwoordenPanel;
	private Spel spel;
	
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
    	this.spel = spel;
    	
    	// Haal informatie uit de controller
    	String vraag = spel.getVraagTekst();
    	onderdelen = spel.getOnderdelen();
    	
        // Layout instellingen
        setBounds(0, 0, 1024, 768);
        setLayout(new MigLayout("", "[124][grow][]", "[110.00][350px:24.00,grow][:126.00:250px,grow,fill]"));
        
        // Middenvlak toevoegen
        middenvlak.setLayout(new GridLayout(1, 0, 0, 0));
        add(middenvlak, "cell 1 1 2 1,grow");

        JLabel lblTitle = new JLabel(vraag);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 47));
        add(lblTitle, "cell 1 0 2 1");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));
        add(buttonsPanel, "cell 0 1,grow");
        
        gekozenAntwoordenPanel = new JPanel();
        gekozenAntwoordenPanel.setLayout(new MigLayout("", "[][][][][][][][][][]", "[grow,fill]"));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(gekozenAntwoordenPanel);
        add(scrollPane, "cell 0 2 2 1,grow");

        
        volgendeOnderdeel();

        JPanel panel_1 = new JPanel();
        add(panel_1, "cell 2 2,grow");
        panel_1.setLayout(new MigLayout("", "[116px,grow]", "[grow][154px]"));

        final views.panels.InfoPanel timer = new views.panels.InfoPanel(spel);
        panel_1.add(timer, "cell 0 0,grow");

        JButton btnStoppen = new JButton("Stop de tijd");
        initStopButton(timer, btnStoppen);
        panel_1.add(btnStoppen, "cell 0 1,alignx left,growy");

        toonOnderdelen(buttonsPanel, onderdelen);

    }

	private void initStopButton(final views.panels.InfoPanel timer, final JButton btnStoppen) {
		btnStoppen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    middenvlak.removeAll();
                    middenvlak.add(new JokerScherm(spel));
                    middenvlak.revalidate(); 
                    middenvlak.repaint();
                    
                    btnStoppen.setEnabled(false);
                    timer.stopTimer();
                }
            });
	}
    
	private void toonOnderdelen(JPanel buttonsPanel,
			final List<Onderdeel> onderdelen) {
		int cell = 0;
		for (final Onderdeel optie : onderdelen) {			
            //antwoorden.add(label, "cell 0 "+cell+",alignx left,aligny top");
            final JButton button = new JButton(optie.getTekst());
            button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	kiesOnderdeel(optie);
                    	button.setEnabled(false);
                    }
                });
            buttonsPanel.add(button, "cell 0 "+(cell)+",growx");
            cell++;
        }
	}
	
	/**
	 * @throws IOException
	 */
	private void volgendeOnderdeel() throws IOException {
		spel.volgendeOnderdeel();
		huidigeOnderdeel = spel.getHuidigeOnderdeel();
		
        middenvlak.removeAll();
        ImagePanel plaatje = new ImagePanel(huidigeOnderdeel.getPlaatje());
        plaatje.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        plaatje.setAutoResize(true);
        middenvlak.add(plaatje);
        middenvlak.revalidate(); 
        middenvlak.repaint();
	}
	
	/**
	 * @param optie
	 */
	private void kiesOnderdeel(final Onderdeel optie){
		final GekozenAntwoord gk = spel.kiesOnderdeel(optie);
		
		final DefaultComboBoxModel onderdelenComboBoxModel = new DefaultComboBoxModel();
        for(Onderdeel comboOptie : onderdelen) {
        	onderdelenComboBoxModel.addElement(comboOptie);
        }
        onderdelenComboBoxModel.setSelectedItem(gk.getGekozenOnderdeel());
        onderdelenComboBoxModel.addListDataListener(new ListDataListener() {
			@Override
			public void contentsChanged(ListDataEvent e) {
				Onderdeel van = gk.getGekozenOnderdeel();
				Onderdeel naar = (Onderdeel) onderdelenComboBoxModel.getSelectedItem();
				spel.wijzigAntwoord(van, naar);
				System.out.println("update(" + van + "," + naar + ");");
			}

			@Override
			public void intervalAdded(ListDataEvent e) { }

			@Override
			public void intervalRemoved(ListDataEvent e) {

			}
		});
        
		views.panels.GekozenAntwoord gkView = new views.panels.GekozenAntwoord(huidigeOnderdeel.getPlaatje(), onderdelenComboBoxModel);
        gekozenAntwoordenPanel.add(gkView, "cell "+currentCell+" 0,grow");
        gk.addObserver(gkView);
        currentCell++;
        
        gekozenAntwoordenPanel.getParent().validate();
        
        try {
			volgendeOnderdeel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
