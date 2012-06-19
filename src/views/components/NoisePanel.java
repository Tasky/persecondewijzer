package views.components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Random;

import javax.swing.JFrame;

public class NoisePanel extends GradientPanel {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				NoisePanel gradPaintPanel = new NoisePanel();
				gradPaintPanel.setRoundedCorners(true);
				gradPaintPanel.setUpperColor(new Color(209, 199, 195));
				gradPaintPanel.setLowerColor(new Color(231, 226, 224));
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

	private Image	bufferedImage;
	private Random	ran;
	private byte[]	b;

	public NoisePanel() {
		super();
		b = new byte[100000];
		ran = new Random();
		ran.nextBytes(b);
	}

	private void generateNoise() {
		int wid = getSize().width, ht = getSize().height;
		int length = (wid + 5) * ht / 7;

		DataBuffer dataBuffer = new DataBufferByte(b, length);
		WritableRaster raster = Raster.createPackedRaster(dataBuffer, wid, ht, 1, null);
		ColorModel colorModel = new IndexColorModel(1, 2, new byte[] { (byte) 0, (byte) 250 }, new byte[] { (byte) 0,
				(byte) 250 }, new byte[] { (byte) 0, (byte) 250 });
		bufferedImage = new BufferedImage(colorModel, raster, false, null);

		// while () {

		// repaint();
		// }
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gradPaint = new GradientPaint(0, 0, getLowerColor(), 0, getHeight(), getUpperColor());
		g2.setPaint(gradPaint);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
		generateNoise();
		if (bufferedImage != null) {
			Composite original = g2.getComposite();
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.02F);
			g2.setComposite(alpha);
			g2.drawImage(bufferedImage, 0, 0, this);
			g2.setComposite(original);
		} else generateNoise();
	}
}
