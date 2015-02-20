import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

class Weight extends JPanel
{
    public static final Color WEIGHT_COLOR;
    public static final int WEIGHT_DIAMETER = 50;
    public static final int RIGHT = 1;
    public static final int LEFT = -1;
    int xpos;
    int ypos;
    private int dir;
    public Pendulum p;
    private int h;
    private boolean reverseOk;
    private double speed;
    private double fastestSpeed;
    double delta;
    double divisions;
    double theta;
    
    Weight(final Pendulum pen) {
        super();
        this.reverseOk = true;
        this.dir = 0;
        this.speed = 0.0;
        this.fastestSpeed = 0.0;
        this.xpos = 250;
        this.ypos = 170;
        this.h = this.ypos;
        this.p = pen;
    }
    
    public void swing() {
        this.divisions = this.p.cord.getDivisions();
        this.delta = this.speed * (3.141592653589793 / this.divisions) * this.dir;
        this.theta = this.p.cord.angle + this.delta;
        this.xpos = (int)(Math.sin(this.theta) * this.p.cord.length) + 250;
        this.ypos = (int)(Math.cos(this.theta) * this.p.cord.length) + 20;
        if (this.sign(this.theta) != this.sign(this.p.cord.angle)) {
            this.reverseOk = true;
        }
        this.p.cord.angle = this.theta;
        if (this.ypos < this.h && this.reverseOk) {
            this.dir = -this.dir;
            this.reverseOk = false;
        }
        this.speed = this.newSpeed();
    }
    
    private double newSpeed() {
        double ratio = (this.ypos - this.h) / (this.p.cord.length + 20 - this.h);
        if (ratio < 0.0) {
            ratio = 0.0;
        }
        return (ratio + 0.1) * this.fastestSpeed;
    }
    
    public void newPosition(final int x, final int y) {
        this.xpos = x;
        this.ypos = y;
        System.out.println(x + "," + y);
        this.speed = 0.1;
        if (x < 250) {
            this.dir = 1;
        }
        else {
            this.dir = -1;
        }
        this.p.cord.newLength(this.xpos, this.ypos);
        this.h = this.ypos;
        this.reverseOk = false;
        this.fastestSpeed = Math.sqrt(20.0 * this.p.cord.length / 10.0 * (1.0 - Math.cos(this.p.cord.angle)));
    }
    
    public void draw(final Graphics g) {
        final int radius = 25;
        g.setColor(Weight.WEIGHT_COLOR);
        g.fillOval(this.xpos - radius, this.ypos - radius, 50, 50);
    }
    
    private int sign(final double value) {
        if (value > 0.0) {
            return 1;
        }
        return -1;
    }
    
    static {
        WEIGHT_COLOR = Color.blue;
    }
}
