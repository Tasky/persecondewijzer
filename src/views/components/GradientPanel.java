package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author nanne
 * 
 */
public class GradientPanel extends JPanel {
	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GradientPanel gradPaintPanel = new GradientPanel();
				gradPaintPanel.setPreferredSize(new Dimension(400, 300));
				JFrame frame = new JFrame("GradientPaintEg");
				frame.getContentPane().add(gradPaintPanel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private Color	upper	= new Color(255, 255, 255);
	private Color	lower	= new Color(0, 0, 0);

	/**
	 * Open gradientpanel.
	 */
	public GradientPanel() {}

	/**
	 * @param lower
	 * @param upper
	 */
	public GradientPanel(Color lower, Color upper) {
		setLowerColor(lower);
		setUpperColor(upper);
	}

	/**
	 * @return the lower
	 */
	public Color getLowerColor() {
		return lower;
	}

	/**
	 * @return the upper
	 */
	public Color getUpperColor() {
		return upper;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gradPaint = new GradientPaint(0, 0, getLowerColor(), 0, getHeight(), getUpperColor());
		g2.setPaint(gradPaint);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * @param lower
	 *            the lower to set
	 */
	public void setLowerColor(Color lower) {
		this.lower = lower;
	}

	/**
	 * @param upper
	 *            the upper to set
	 */
	public void setUpperColor(Color upper) {
		this.upper = upper;
	}

}
