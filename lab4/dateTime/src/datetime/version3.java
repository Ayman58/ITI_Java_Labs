package datetime;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class version3 extends Applet {

    @Override
    public void init() {
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
        MyThread th = new MyThread();
        th.start();
    }

    @Override
    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), 50, 100);
    }
}
