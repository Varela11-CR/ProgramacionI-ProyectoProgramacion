package Utilities.WindowsBackground;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author JD101
 * 
 * Establece el fondo de un panel con una imagen especifica.
 */
public class CustomPanel extends JPanel{
    
    private String imageURL;
    private Image image;

    public CustomPanel(String imageURL) {
        this.imageURL = imageURL;
    }
    
    @Override
    public void paint(Graphics g) {
    
        image = new ImageIcon(getClass().getResource(this.imageURL)).getImage();
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        
        super.paint(g);
    
    }
    
}