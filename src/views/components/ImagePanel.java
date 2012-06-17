package views.components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private BufferedImage	image;
	private boolean			autoResize	= false;

	public ImagePanel(File plaatje) throws IOException {
		image = ImageIO.read(plaatje);
	}

	public ImagePanel(String path) throws IOException {
		image = ImageIO.read(new File(path));
	}

	public boolean getAutoResize() {
		return autoResize;
	}

	@Override
	public void paintComponent(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (autoResize) {
			boolean preserveAlpha = false;

			float imageWidth = image.getWidth();
			float imageHeight = image.getHeight();

			float maxWidth = getWidth();
			float maxHeight = getHeight();

			float widthRatio = imageWidth / maxWidth;
			float heightRatio = imageHeight / maxHeight;

			float scaleFactor = Math.max(widthRatio, heightRatio);

			float scaledWidth = imageWidth / scaleFactor;
			float scaledHeight = imageHeight / scaleFactor;

			int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage scaledBI = new BufferedImage(Math.round(scaledWidth), Math.round(scaledHeight), imageType);

			Graphics2D g2 = scaledBI.createGraphics();
			if (preserveAlpha) g2.setComposite(AlphaComposite.Src);

			g2.drawImage(image, 0, 0, Math.round(scaledWidth), Math.round(scaledHeight), null);
			g2.dispose();

			// Zet achtergrond op wit
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, Math.round(maxWidth), Math.round(maxHeight));

			// Gooi plaatje erop
			int left = 0;
			int top = 0;
			if (scaledWidth < maxWidth) left = (Math.round(maxWidth) - Math.round(scaledWidth)) / 2;
			if (scaledHeight < maxHeight) top = (Math.round(maxHeight) - Math.round(scaledHeight)) / 2;
			
			g.drawImage(scaledBI, left, top, null);
		} else g.drawImage(image, 0, 0, null);
	}

	public void setAutoResize(boolean autoResize) {
		this.autoResize = autoResize;
	}
}