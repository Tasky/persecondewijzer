package views.factories;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author nanne
 * 
 */
public final class JPanelFactory {
	/**
	 * @param viewportView
	 * @return scrollpane
	 * @wbp.factory
	 * @wbp.factory.parameter.source viewportView gekozenAntwoordenPanel
	 */
	public static JScrollPane createJScrollPane(Component viewportView) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(viewportView);
		return scrollPane;
	}

	/**
	 * @return scrollpane
	 * @wbp.factory
	 */
	public static JPanel createTransparentJPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		return panel;
	}
}