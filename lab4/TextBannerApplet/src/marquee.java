
import java.applet.Applet;
import java.awt.*;

public class marquee extends Applet implements Runnable {

    private String display;
    private int x, y, flag;
    Thread t;

    @Override
    public void init() {

        display = "JAVA WORLD";
        x = 100;
        y = 100;
        flag = 1;

        t = new Thread(this);

        t.start();
    }

    public void update() {

        x = x + 10 * flag;
        if (x > 300) {
            flag = -1;
        }
        if (x < 100) {
            flag = 1;
        }
    }

    @Override
    public void run() {

        while (true) {
            repaint();
            update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
    Color c = new Color(255, 0, 0);
    Font f = new Font(Font.DIALOG, Font.BOLD, 20);

    @Override
    public void paint(Graphics g) {
        g.setFont(f);
        g.setColor(c);
        g.drawString(display, x, y);
    }
}