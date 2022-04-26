package animatedlamp;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class AnimatedApplet extends Applet implements Runnable {

    Color c; //black
    Color y = Color.YELLOW;
    Thread th;

    @Override
    public void init() {
        th = new Thread(this);
        th.start();
//y = Color.YELLOW;
}
//    public void update() {

//        y = Color.white;
//        y = Color.YELLOW;
//    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
                y = Color.white;
                repaint();
                Thread.sleep(1000);
                y = Color.YELLOW;
                repaint();
            } catch (InterruptedException ie) {
                System.out.println(ie);

            }
        }
    }

    @Override
    public void paint(Graphics g) {
//        y = Color.YELLOW;
        g.setColor(y);
        g.fillOval(97, 36, 229, 50);
        g.fillOval(293, 123, 37, 56);
        g.fillOval(163, 100, 100, 140);
        g.fillOval(86, 123, 37, 56);
        c = new Color(0, 0, 0);
        g.setColor(c);
        g.drawOval(97, 36, 229, 50);
        g.drawOval(163, 100, 100, 140);
        g.drawOval(86, 123, 37, 56);
        g.drawOval(293, 123, 37, 56);
        g.drawRect(98, 354, 220, 20);
        g.drawLine(177, 353, 200, 268);
        g.drawLine(237, 356, 215, 266);
        g.drawLine(97, 57, 60, 210);
        g.drawLine(325, 60, 363, 210);
        g.drawArc(60, 150, 300, 115, 0, -180);
    }

}
