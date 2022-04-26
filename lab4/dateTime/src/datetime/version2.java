package datetime;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class version2 extends Applet {
    MyThread th;
    @Override
    public void init() {
        th = new MyThread();
        th.start();
    }
    @Override
    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), 50, 100);
    }
    class MyThread extends Thread {
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
}
