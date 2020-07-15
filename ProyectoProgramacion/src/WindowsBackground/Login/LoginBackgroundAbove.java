package WindowsBackground.Login;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author JD101
 * 
 * Establece el fondo de un panel con una imagen especifica.
 */
public class LoginBackgroundAbove extends JPanel{
    
    private Image image;
    
    @Override
    public void paint(Graphics g) {
    
        image = new ImageIcon(getClass().getResource("/Images/Login/background.png")).getImage();
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        
        super.paint(g);
    
    }
    
}
