import java.awt.Graphics;
import java.awt.Color;

public class Cord
{
    public static final Color CORD_COLOR;
    public static final int CORD_PIVOT_X = 250;
    public static final int CORD_PIVOT_Y = 20;
    public static final double MIN_DIVISIONS = 60.0;
    public int length;
    public double angle;
    public double fastestSpeed;
    Pendulum p;
    
    Cord(final Pendulum pen) {
        super();
        this.length = 10;
        this.angle = 0.0;
        this.p = pen;
        this.fastestSpeed = 20.0;
    }
    
    public void newLength(final int x, final int y) {
        final double sqx = (250 - x) * (250 - x);
        final double sqy = (20 - y) * (20 - y);
        final double len = Math.sqrt(sqx + sqy);
        this.length = (int)len;
        this.newAngle(x);
    }
    
    public void newAngle(final int x) {
        final double opp = x - 250;
        if (Math.abs(opp) < 1.0) {
            this.angle = 0.0;
        }
        else {
            this.angle = Math.asin(opp / this.length);
        }
    }
    
    public double getDivisions() {
        if (this.length < 60.0) {
            return 60.0;
        }
        return this.length;
    }
    
    public void draw(final Graphics g) {
        g.setColor(Cord.CORD_COLOR);
        g.drawLine(250, 20, this.p.weight.xpos, this.p.weight.ypos);
    }
    
    static {
        CORD_COLOR = Color.black;
    }
}
