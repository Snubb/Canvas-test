import javax.crypto.Cipher;
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

        drawBigTree(g,300,300);

        drawMan(g,400,300);


    }

    private void drawMan(Graphics g, int x, int y) {
        //Face
        g.setColor(new Color(218, 189, 171, 255));
        g.fillOval(0+x,0+y,100,100);
        //Eyes
        g.setColor(new Color(255,255,255));
        g.fillOval(20+x,30+y,15,15);
        g.fillOval(65+x,30+y,15,15);
        //Pupils
        g.setColor(Color.black);
        g.fillOval(25+x,35+y,7,7);
        g.fillOval(70+x,35+y,7,7);
        //Hair
        g.setColor(new Color(0,0,0));
        g.fillArc(0+x,0+y,100,70,360,180);
        //Mouth
        g.setColor(Color.black);
        g.fillRect(30+x,70+y,40,5);


    }

    private void drawBigTree(Graphics g, int x, int y) {
        g.setColor(new Color(141, 71, 47));
        g.fillRect(40+x,30+y,20,70);

        g.setColor(new Color(54, 127, 38));
        g.fillOval(10+x,20+y,40,40);
        g.fillOval(50+x,20+y,40,40);
        g.fillOval(30+x,0+y,40,40);
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
