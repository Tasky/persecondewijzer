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
import net.miginfocom.swing.MigLayout;
import views.components.ImagePanel;

public class GekozenAntwoord extends JPanel implements Observer {

	private JComboBox			combobox;
	private ImagePanel			imagePanel	= null;
	private final ComboBoxModel	comboBoxModel;
	private final logic.GekozenAntwoord	gekozenAntwoord;

	/**
	 * Create the panel.
	 * @param gk 
	 * @param comboBoxModel 
	 */
	public GekozenAntwoord(logic.GekozenAntwoord gk, ComboBoxModel comboBoxModel) {
		this.gekozenAntwoord = gk;
		File file = gk.getHuidigeOnderdeel().getPlaatje();
		this.comboBoxModel = comboBoxModel;
		try {
			imagePanel = new ImagePanel(file);
			imagePanel.setAutoResize(true);
			imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		add(imagePanel, "grow");

		setLayout(new MigLayout("ins 0", "[grow,fill]", "[grow,fill][]"));
		combobox = new JComboBox();
		combobox.setMaximumRowCount(9);
		combobox.setModel(comboBoxModel);
		add(combobox, "cell 0 1,growx");
	}

	public void geefLijntje(boolean goed) {
		if (gekozenAntwoord.isGoed())
			imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.GREEN));
		else imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.RED));
	}

	/**
	 * @return the comboBoxModel
	 */
	public ComboBoxModel getComboBoxModel() {
		return comboBoxModel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Onderdeel onderdeel = ((logic.GekozenAntwoord) arg0).getGekozenOnderdeel();
		comboBoxModel.setSelectedItem(onderdeel);
		revalidate();
		repaint();
	}
}
