package multipleline;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class multibleLineApplet extends Applet {
 int x1, y1, x2, y2;
Vector lines =new Vector();
    public void init() {
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
//int[]
//lines.add(x1);
            }

            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
//                repaint();
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }

        });
    }

    public void paint(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }
}