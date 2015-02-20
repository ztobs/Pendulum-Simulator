import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

static final class Browser$1 implements ActionListener {
    final /* synthetic */ JTextField val$url;
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        OpenBrowser.openURL(this.val$url.getText().trim());
    }
}