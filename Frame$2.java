import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class Frame$2 extends WindowAdapter {
    @Override
    public void windowActivated(final WindowEvent evt) {
        Frame.access$100(Frame.this, evt);
    }
    
    @Override
    public void windowOpened(final WindowEvent evt) {
        Frame.access$200(Frame.this, evt);
    }
}