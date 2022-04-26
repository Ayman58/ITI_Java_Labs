
package multiline2;
import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
public class MultiLine2 extends Applet  {


    int x1, y1, x2, y2;
    Vector<MyLine> obj = new Vector<>();

    public void init() {
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {

                x1 = e.getX();
                y1 = e.getY();

            }

            public void mouseReleased(MouseEvent e) {
                obj.add(new MyLine(x1, y1, x2, y2));

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

        for (int i = 0; i < obj.size(); i++) {
            MyLine line = obj.get(i);
            g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }

    }

    class MyLine {

        int X1, Y1, X2, Y2;

        MyLine(int xx1, int yy1, int xx2, int yy2) {
            this.X1 = xx1;
            this.X2 = xx2;
            this.Y1 = yy1;
            this.Y2 = yy2;
        }

        public int getX1() {
            return X1;
        }

        public void setX1(int X1) {
            this.X1 = X1;
        }

        public int getY1() {
            return Y1;
        }

        public void setY1(int Y1) {
            this.Y1 = Y1;
        }

        public int getX2() {
            return X2;
        }

        public void setX2(int X2) {
            this.X2 = X2;
        }

        public int getY2() {
            return Y2;
        }

        public void setY2(int Y2) {
            this.Y2 = Y2;
        }

    }

}

