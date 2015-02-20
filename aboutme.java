import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JDialog;

public class aboutme extends JDialog
{
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    
    public aboutme(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.initComponents();
    }
    
    public boolean OpenIE(final String path, final String filename) {
        final String[] executeCmd = { "cmd.exe", "/C", path + "" + filename, "http://ztobs.scienceontheweb.net" };
        try {
            System.out.println(executeCmd);
            final Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        }
        catch (Exception ex) {}
        return false;
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel1.setText("jLabel1");
        this.setDefaultCloseOperation(2);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/image.jpeg")));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent evt) {
                aboutme.this.windowActivated(evt);
            }
        });
        this.jPanel1.setBackground(new Color(255, 153, 153));
        this.jPanel1.setFocusable(false);
        this.jPanel1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent evt) {
                aboutme.this.focusGain(evt);
            }
        });
        this.jLabel2.setFont(new Font("Viner Hand ITC", 3, 36));
        this.jLabel2.setForeground(new Color(0, 0, 153));
        this.jLabel2.setText("Project Submitted");
        this.jLabel2.setFocusable(false);
        this.jPanel2.setFocusable(false);
        this.jLabel6.setFont(new Font("Tahoma", 2, 11));
        this.jLabel6.setText("http://ztobs.scienceontheweb.net");
        this.jLabel6.setToolTipText("click to open");
        this.jLabel6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                aboutme.this.mousePressed(evt);
            }
        });
        final GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel6)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6, GroupLayout.Alignment.TRAILING));
        this.jLabel8.setFont(new Font("Viner Hand ITC", 3, 36));
        this.jLabel8.setForeground(new Color(0, 0, 153));
        this.jLabel8.setText("to");
        this.jLabel8.setFocusable(false);
        this.jLabel9.setFont(new Font("Viner Hand ITC", 3, 36));
        this.jLabel9.setForeground(new Color(0, 0, 153));
        this.jLabel9.setText("Computer Science Department");
        this.jLabel9.setFocusable(false);
        this.jLabel10.setFont(new Font("Viner Hand ITC", 3, 36));
        this.jLabel10.setForeground(new Color(0, 0, 153));
        this.jLabel10.setText("by");
        this.jLabel10.setFocusable(false);
        this.jLabel11.setFont(new Font("Vrinda", 3, 36));
        this.jLabel11.setForeground(new Color(0, 0, 153));
        this.jLabel11.setText("Udeh Oluchi Ruth   (2010/267)");
        this.jLabel11.setFocusable(false);
        this.jLabel12.setFont(new Font("Viner Hand ITC", 3, 36));
        this.jLabel12.setForeground(new Color(0, 0, 153));
        this.jLabel12.setText("Federal College of Education, Kontagora");
        this.jLabel12.setFocusable(false);
        this.jLabel13.setFont(new Font("Vrinda", 3, 36));
        this.jLabel13.setForeground(new Color(0, 0, 153));
        this.jLabel13.setText("Oguntoye Damilola Lois  (2010/210)");
        this.jLabel13.setFocusable(false);
        this.jLabel14.setFont(new Font("Vrinda", 3, 36));
        this.jLabel14.setForeground(new Color(0, 0, 153));
        this.jLabel14.setText("and");
        this.jLabel14.setFocusable(false);
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel13, -2, 558, -2).addGap(95, 95, 95)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addGroup(jPanel1Layout.createSequentialGroup().addGap(86, 86, 86).addComponent(this.jLabel9)).addGroup(jPanel1Layout.createSequentialGroup().addGap(130, 130, 130).addComponent(this.jLabel11, -2, 475, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(342, 342, 342).addComponent(this.jLabel10)).addGroup(jPanel1Layout.createSequentialGroup().addGap(346, 346, 346).addComponent(this.jLabel8)).addGroup(jPanel1Layout.createSequentialGroup().addGap(204, 204, 204).addComponent(this.jLabel2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(337, 337, 337).addComponent(this.jLabel14, -2, 67, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8, -2, 38, -2).addGap(1, 1, 1).addComponent(this.jLabel9, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel12, -2, 38, -2).addGap(83, 83, 83).addComponent(this.jLabel10, -2, 38, -2).addGap(34, 34, 34).addComponent(this.jLabel11, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jPanel2, -2, -1, -2)));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        this.pack();
    }
    
    private void focusGain(final FocusEvent evt) {
        this.setLocationRelativeTo(null);
    }
    
    private void windowActivated(final WindowEvent evt) {
        this.setLocationRelativeTo(null);
    }
    
    private void mousePressed(final MouseEvent evt) {
        this.OpenIE("C:\\Program Files\\Internet Explorer\\", "iexplore.exe");
    }
    
    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(aboutme.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(aboutme.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(aboutme.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(aboutme.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
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
        });
    }
}
