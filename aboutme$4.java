import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Frame;
import javax.swing.JFrame;

static final class aboutme$4 implements Runnable {
    @Override
    public void run() {
        final aboutme dialog = new aboutme(new JFrame(), true);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }
}