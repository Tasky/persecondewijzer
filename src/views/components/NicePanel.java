package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NicePanel extends JPanel {

	private static final Color	LIGHT_BLUE	= new Color(41, 117, 200);
	private static final Color	DARK_BLUE	= new Color(2, 47, 106);

	private static void createAndShowUI() {
		NicePanel gradPaintPanel = new NicePanel();
		gradPaintPanel.setPreferredSize(new Dimension(400, 300));
		JFrame frame = new JFrame("GradientPaintEg");
		frame.getContentPane().add(gradPaintPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowUI();
			}
		});
	}

	public NicePanel() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gradPaint = new GradientPaint(0, 0, LIGHT_BLUE, 0,
				getHeight(), DARK_BLUE);
		g2.setPaint(gradPaint);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}

}
