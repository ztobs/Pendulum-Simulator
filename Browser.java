import java.awt.Component;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Browser
{
    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JTextField url = new JTextField(20);
        final JButton button = new JButton("Open Browser");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                OpenBrowser.openURL(url.getText().trim());
            }
        });
        frame.setDefaultCloseOperation(3);
        panel.add(new JLabel("URL:"));
        panel.add(url);
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
