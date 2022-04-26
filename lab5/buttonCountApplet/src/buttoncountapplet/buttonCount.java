package buttoncountapplet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonCount extends Applet {

    Button b;
    Button c;
    int x;

    public void init() {
        b = new Button("increment");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                if (x < 10) {
                    x++;
                }

                repaint();
            }
        });
        add(b);
        c = new Button("decrement");
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev2) {

                if (x > 0) {
                    x--;
                }
                repaint();
            }
        });
        add(c);
    }

    public void paint(Graphics g) {
        g.drawString("count is: " + x, 50, 50);
    }
}
