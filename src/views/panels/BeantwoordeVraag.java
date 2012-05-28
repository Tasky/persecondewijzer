package views.panels;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import views.components.ImagePanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class BeantwoordeVraag extends JPanel {
	private final JComboBox comboBox = new JComboBox();

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public BeantwoordeVraag() throws IOException 
	{
    	ImageIcon imageIcon = new ImageIcon("\\images\\Steden\\athene.jpg");
    	JLabel label = new JLabel((Icon) null);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(comboBox, 0, 200, Short.MAX_VALUE)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 149, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
