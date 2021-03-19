import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Test_canv extends Canvas implements Runnable {

    private int width = 600;
    private int height = 400;

    private int faceX, faceY;
    private int faceVX, faceVY;

    private Thread thread;

    int fps = 30;

    private  boolean isRunning;

    private BufferStrategy bs;
    //private BufferedImage img;

    private int bigTreeX, bigTreeY;

    public Test_canv() {

        JFrame frame = new JFrame("Title goes here");
        this.setSize(width,height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        isRunning = false;

        faceX = 300;
        faceY = 300;
        faceVX = 10;

        bigTreeX = 400;
        bigTreeY = 200;
    }

    public void update() {
        faceX += faceVX;
        if (faceX > width) {
            faceVX = -faceVX;
        } else if (faceX < 0) {
            faceVX = -faceVX;
        }
    }

    public void draw() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        update();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
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

        drawBigTree(g,bigTreeX,bigTreeY);

        drawMan(g,faceX,faceY);
        g.dispose();
        bs.show();
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
        painting.start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double deltaT = 1000.0/fps;
        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long now = System.currentTimeMillis();
            if (now-lastTime > deltaT) {
                update();
                draw();
                lastTime = now;
            }
        }
        stop();

    }

    private class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                bigTreeX -= 5;
                System.out.println("LEFT");
            }
            if (keyEvent.getKeyChar() == 'd') {
                bigTreeX += 5;
            }
            if (keyEvent.getKeyChar() == 'w') {
                bigTreeY -= 5;
                System.out.println("UP");
            }
            if (keyEvent.getKeyChar() == 's') {
                bigTreeY += 5;
            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                bigTreeX -= 5;
                System.out.println("LEFT");
            }
            if (keyEvent.getKeyChar() == 'd') {
                bigTreeX += 5;
            }
            if (keyEvent.getKeyChar() == 'w') {
                bigTreeY -= 5;
                System.out.println("UP");
            }
            if (keyEvent.getKeyChar() == 's') {
                bigTreeY += 5;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                bigTreeX -= 5;
                System.out.println("LEFT");
            }
            if (keyEvent.getKeyChar() == 'd') {
                bigTreeX += 5;
            }
            if (keyEvent.getKeyChar() == 'w') {
                bigTreeY -= 5;
                System.out.println("UP");
            }
            if (keyEvent.getKeyChar() == 's') {
                bigTreeY += 5;
            }
        }
    }

    private class ML implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class MML implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
