package views.components;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    private JLabel label;
    private boolean autoResize = false;

    public ImagePanel(String path) throws IOException 
    {    	
        image = ImageIO.read(new File(path));
    }

    @Override
    public void paintComponent(Graphics g) 
    {
    	if(autoResize){
	    	int scaledWidth = this.getWidth();
	    	int scaledHeight = this.getHeight();
	
	        boolean preserveAlpha = false;
	        
	        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
	        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
	        Graphics2D g2 = scaledBI.createGraphics();
	        if(preserveAlpha) g2.setComposite(AlphaComposite.Src);
	        
	        g2.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
	        g2.dispose();
	        g.drawImage(scaledBI, 0, 0, null);
    	} else {
    		g.drawImage(image, 0, 0, null);
    	}
    }

	public void setAutoResize(boolean autoResize) {
		this.autoResize = autoResize;
	}
	public boolean getAutoResize() {
		return(autoResize);
	}
}