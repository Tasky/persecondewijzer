package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NicePanel extends GradientPanel {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				NicePanel gradPaintPanel = new NicePanel();
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
	
	private static final Color	UPPER	= new Color(0, 42, 100);
	private static final Color	LOWER	= new Color(0, 63, 151);
	
	public NicePanel() {
		super(UPPER, LOWER);
	}
}
