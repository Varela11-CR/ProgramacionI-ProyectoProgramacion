package WindowsBackground.PatientSearch;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PatientSearchBackgroundAbove extends JPanel{
    
    private Image image;
    
    @Override
    public void paint(Graphics g) {
    
        image = new ImageIcon(getClass().getResource("/Images/PatientSearch/background.png")).getImage();
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        
        super.paint(g);
    
    }
    
}
