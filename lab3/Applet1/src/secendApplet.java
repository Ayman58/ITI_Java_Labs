import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
public class secendApplet extends Applet {
@Override
public void paint (Graphics g){
    Color c= new Color(255,0,0);
    g.setColor(c);
     // to display all fonts on the local machine 
    String[] fontnames= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int y=50;
        Font f;
        for (String current : fontnames){
            f =new Font(current, Font.BOLD,15);
            g.setFont(f);
            g.drawString("Hello Java", 50, y);
            y+=10;
        }
    }
}
