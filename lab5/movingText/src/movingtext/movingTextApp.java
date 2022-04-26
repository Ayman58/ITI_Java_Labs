package movingtext;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class movingTextApp extends Applet {

    int x = 50, y = 50;
    Key k;

    public void init() {
        k = new Key();
        this.addKeyListener(k);

    }

    class Key implements KeyListener {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {

                if (y >= 0) {
                    y -= 10;

                } else {
                    y = 200;
                }
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                y += 10;
                if (y < 200) {
                    y += 10;
                } else {
                    y = 0;
                }
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x >= 0) {
                    x -= 10;
                } else {
                    x = 300;
                }
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x <= 300) {
                    x += 10;

                } else {
                    x = 0;
                }
                repaint();
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public void paint(Graphics g) {
        g.drawString("java" + Applet.HEIGHT + "" + Applet.WIDTH, x, y);
    }
}
