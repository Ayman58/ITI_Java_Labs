import java.applet.Applet;
import java.awt.Image;
import java.awt.Graphics;
public class Appletimg extends Applet {
    Image myImge;
    @Override
    public void init() {
        myImge = getImage(getDocumentBase(),"img.jpg");
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(myImge, 0, 0, getWidth(), getHeight(), this);
    }
}
