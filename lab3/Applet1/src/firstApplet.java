import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
public class firstApplet extends Applet {
    @Override
    public void paint (Graphics g){
        Color c= new Color(255,0,0);
        g.setColor(c);
        // this display fonts only in local server
        Toolkit t=Toolkit.getDefaultToolkit();
        String [] fontnames = t.getFontList(); //depricates function 
        int y=50;
        Font f;
        for (String current : fontnames){
            f =new Font(current, Font.BOLD,15);
            g.setFont(f);
            g.drawString("Hello Java  "+current, 50, y);
            y+=10;
        }
    }
}
