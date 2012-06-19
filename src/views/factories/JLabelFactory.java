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
	 * @wbp.factory
	 * @wbp.factory.parameter.source text "Athene"
	 */
	public static JLabel createAntwoordJLabel(String text) {
		JLabel label = new JLabel();
		label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label.setForeground(Color.BLACK);
		label.setText(text);
		return label;
	}

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

	/**
	 * @param arg0
	 *            tekst
	 * @return
	 * @wbp.factory
	 * @wbp.factory.parameter.source arg0 tekst
	 */
	public static JLabel createJokerLabel(String arg0) {
		JLabel label = new JLabel(arg0);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		return label;
	}
}
