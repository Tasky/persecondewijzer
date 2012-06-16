package views.factories;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author nanne
 *
 */
public final class JLabelFactory {

	/**
	 * @param arg0 
	 * @return label
	 * @wbp.factory
	 * @wbp.factory.parameter.source arg0 vraag
	 */
	public static JLabel createJLabel(String arg0) {
		JLabel label = new JLabel(arg0);
		label.setForeground(Color.WHITE);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 47));
		return label;
	}

}
