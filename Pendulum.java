import java.awt.Component;
import javax.swing.JFrame;
import java.awt.Event;
import java.awt.Color;
import java.awt.Graphics;
import java.applet.Applet;

class Pendulum extends Applet implements Runnable
{
    public Cord cord;
    public Weight weight;
    private Thread myThread;
    private boolean freeze;
    
    Pendulum() {
        super();
        this.freeze = true;
    }
    
    @Override
    public void init() {
        this.cord = new Cord(this);
        this.weight = new Weight(this);
    }
    
    @Override
    public void start() {
        if (this.myThread == null) {
            (this.myThread = new Thread(this, "Pendulum")).start();
        }
    }
    
    @Override
    public void run() {
        while (this.myThread != null) {
            try {
                final Thread myThread = this.myThread;
                Thread.sleep(100L);
            }
            catch (InterruptedException ex) {}
            if (!this.freeze) {
                this.weight.swing();
            }
            this.myRepaint();
        }
    }
    
    @Override
    public void stop() {
        this.myThread.stop();
        this.myThread = null;
    }
    
    @Override
    public void paint(final Graphics g) {
        this.cord.draw(g);
        this.weight.draw(g);
        g.setColor(Color.red);
        g.fillOval(247, 17, 6, 6);
        g.setColor(Color.YELLOW);
        g.drawLine(250, 20, 25, 467);
        g.setColor(Color.black);
        g.drawString("100cm", 25, 467);
        g.drawString("90cm", 48, 423);
        g.drawString("80cm", 70, 378);
        g.drawString("70cm", 91, 332);
        g.drawString("60cm", 113, 288);
        g.drawString("50cm", 137, 244);
        String Orientation = "";
        if (Math.toDegrees(this.cord.angle) == 0.0) {
            Orientation = "";
        }
        else if (Math.toDegrees(this.cord.angle) < 0.0) {
            Orientation = "West";
        }
        else {
            Orientation = "East";
        }
        g.setColor(Color.BLACK);
        g.drawString("Length of String: " + this.cord.length / 5 + "cm", 650, 250);
        g.drawString("Angle of Inclination: " + Math.round(Math.abs(Math.toDegrees(this.cord.angle))) + " degrees " + Orientation, 650, 310);
    }
    
    @Override
    public boolean mouseDrag(final Event e, final int x, final int y) {
        this.weight.newPosition(x, y);
        this.repaint();
        return false;
    }
    
    @Override
    public boolean mouseDown(final Event e, final int x, final int y) {
        this.freeze = true;
        return false;
    }
    
    @Override
    public boolean mouseUp(final Event e, final int x, final int y) {
        this.freeze = false;
        this.repaint();
        return false;
    }
    
    private void myRepaint() {
        final int border = 100;
        final int y = 20;
        final int h = this.weight.ypos + 50;
        final int x = (this.weight.xpos > 250) ? (250 - border) : (this.weight.xpos - border);
        final int w = Math.abs(250 - this.weight.xpos) + border * 2;
        this.repaint(x, y, w, h);
    }
    
    public static void main(final String[] args) {
        final Pendulum p = new Pendulum();
        p.setSize(300, 300);
        p.init();
        final JFrame f = new JFrame("Pendulum");
        f.add(p);
        f.resize(500, 400);
        f.show();
        f.setTitle("Simple Harmonic Motion Experiment");
        f.setLocationRelativeTo(null);
        p.start();
    }
}
