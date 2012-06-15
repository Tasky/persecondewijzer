package views.panels;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import logic.Onderdeel;

import views.components.ImagePanel;

import net.miginfocom.swing.MigLayout;

public class GekozenAntwoord extends JPanel implements Observer {

	private JComboBox	combobox;
	private ImagePanel	imagePanel = null;
	private final ComboBoxModel	comboBoxModel;

	/**
	 * Create the panel.
	 */
	public GekozenAntwoord(File file, ComboBoxModel comboBoxModel) {
        this.comboBoxModel = comboBoxModel;
		try {
            imagePanel = new ImagePanel(file);
            imagePanel.setAutoResize(true);
            imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        add(imagePanel, "grow");
		
		
		setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][]"));
		combobox = new JComboBox();
		combobox.setMaximumRowCount(9);
		combobox.setModel(comboBoxModel);
		add(combobox, "cell 0 1,growx");
	}
	
	/**
	 * @return the comboBoxModel
	 */
	public ComboBoxModel getComboBoxModel() {
		return comboBoxModel;
	}

	public void geefLijntje(boolean goed) {
		if (goed) {
			imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.GREEN));
    	} else {
        	imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.RED));
    	}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Onderdeel onderdeel = ((logic.GekozenAntwoord) arg0).getGekozenOnderdeel();
		comboBoxModel.setSelectedItem(onderdeel);
		revalidate();
		repaint();
	}
}
