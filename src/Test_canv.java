import javax.swing.*;
import java.awt.*;

public class Test_canv extends Canvas {
    public Test_canv() {

        JFrame frame = new JFrame("Title goes here");
        this.setSize(600,400);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(200,200,100,50);
        g.setColor(new Color(200,150,100));
        g.drawOval(200,200,100,50);
        drawTree(g,100,200);
        drawTree(g,110,195);
        drawTree(g,120,200);
        drawTree(g,130,195);
        drawTree(g,140,200);
        drawTree(g,150,195);
        drawTree(g,160,200);


    }

    private void drawTree(Graphics g, int x, int y) {
        g.setColor(new Color(0,100,0));
        int[] xs = {0+x, 10+x, 20+x};
        int[] ys = {30+y, 0+y, 30+y};
        g.fillPolygon(xs, ys, 3);

        g.setColor(new Color(200,128,30));
        g.fillRect(7+x,30+y,6,10);
    }

    public static void main(String[] args) {
        Test_canv painting = new Test_canv();
    }
}