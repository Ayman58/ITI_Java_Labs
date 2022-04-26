package datetime;

import java.awt.Graphics;
import java.applet.Applet;
import java.util.Date;

public class DateTimeApp extends Applet implements Runnable {

    Thread th;

    @Override
    public void init() {
        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), 50, 100);
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
