package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author nanne
 * 
 */
public class NiceButton extends JButton {
	private boolean	isPressed	= false;

	/**
	 * @param string
	 */
	public NiceButton(String string) {
		super(string);
		setBackground(new Color(0, 0, 0, 0));
		setFocusPainted(false);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		setFont(new Font("Arial", Font.BOLD, 12));
		setForeground(Color.white);
		getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				isPressed = model.isPressed();
			}
		});
	}

	/**
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		Dimension originalSize = super.getSize();

		Color above = new Color(66, 122, 241);
		Color under = new Color(29, 82, 194);

		if (isPressed) {
			GradientPaint gradPaint = new GradientPaint(0, 0, above, 0, originalSize.height - 3, under);
			g.setPaint(gradPaint);
		} else {
			GradientPaint gradPaint = new GradientPaint(0, 0, under, 0, originalSize.height - 3, above);
			g.setPaint(gradPaint);
		}
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(1, 1, originalSize.width - 3, originalSize.height - 3, 7, 7);

		g.setColor(Color.black);
		g.drawRoundRect(0, 0, originalSize.width - 1, originalSize.height - 1, 7, 7);

		g.setColor(new Color(110, 152, 242));
		g.drawRoundRect(1, 1, originalSize.width - 3, originalSize.height - 3, 7, 7);

		if (!isEnabled()) {
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRoundRect(1, 1, originalSize.width - 2, originalSize.height - 2, 7, 7);
		}

		super.paintComponent(g);
		g.translate(0, 2);
	}
}
