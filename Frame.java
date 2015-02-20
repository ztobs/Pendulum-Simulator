import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Frame;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame
{
    Weight w;
    Pendulum p;
    int i;
    int sec;
    int min;
    int hour;
    Runnable runnable;
    Thread wat;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField jTextField1;
    
    public Frame() {
        super();
        this.w = new Weight(new Pendulum());
        this.p = this.w.p;
        this.i = 0;
        this.sec = 0;
        this.min = 0;
        this.hour = 0;
        this.runnable = new Runnable() {
            @Override
            public void run() {
                Frame.this.i = 0;
                while (true) {
                    Frame.this.jTextField1.setText("      " + Frame.this.hour + "  :   " + Frame.this.min + "   :   " + Frame.this.sec + "   :   " + Frame.this.i);
                    try {
                        Thread.sleep(7L);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (Frame.this.i == 100) {
                        Frame.this.i = 0;
                        final Frame this$0 = Frame.this;
                        ++this$0.sec;
                    }
                    if (Frame.this.sec == 60) {
                        Frame.this.sec = 0;
                        final Frame this$ = Frame.this;
                        ++this$.min;
                    }
                    if (Frame.this.min == 60) {
                        Frame.this.min = 0;
                        final Frame this$2 = Frame.this;
                        ++this$2.hour;
                    }
                    final Frame this$3 = Frame.this;
                    ++this$3.i;
                }
            }
        };
        this.wat = new Thread(this.runnable);
        this.initComponents();
    }
    
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel9 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem3 = new JMenuItem();
        this.jMenuItem1 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jMenuItem2 = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.setTitle("Simple Pendulum Computer Simulation to Determine Acceleration Due to Gravity");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/image.jpeg")));
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent evt) {
                Frame.this.windowActivated(evt);
            }
            
            @Override
            public void windowOpened(final WindowEvent evt) {
                Frame.this.windowOpened(evt);
            }
        });
        this.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(final ContainerEvent evt) {
                Frame.this.componentAdded(evt);
            }
        });
        this.jPanel1.setBackground(new Color(255, 153, 102));
        this.jPanel1.setDebugGraphicsOptions(-1);
        this.jPanel1.setFocusable(false);
        this.jLabel1.setFont(new Font("Wide Latin", 3, 24));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setText("SIMPLE");
        this.jLabel3.setFont(new Font("Wide Latin", 3, 24));
        this.jLabel3.setForeground(new Color(255, 255, 255));
        this.jLabel3.setText("PENDULUM");
        this.jLabel2.setFont(new Font("Wide Latin", 3, 24));
        this.jLabel2.setForeground(new Color(255, 255, 255));
        this.jLabel2.setText("SIMULATION");
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addGroup(jPanel1Layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.jLabel1)).addComponent(this.jLabel2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addContainerGap(74, 32767)));
        this.jPanel3.setBackground(new Color(255, 153, 102));
        this.jPanel2.setBackground(new Color(255, 255, 0));
        this.jTextField1.setText("      0  :   0   :   0   :   00");
        this.jTextField1.setFocusable(false);
        this.jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.jTextField1ActionPerformed(evt);
            }
        });
        this.jButton1.setBackground(new Color(51, 204, 0));
        this.jButton1.setText("start");
        this.jButton1.setFocusable(false);
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.startButton(evt);
            }
        });
        this.jButton2.setBackground(new Color(204, 0, 0));
        this.jButton2.setText("reset");
        this.jButton2.setFocusable(false);
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.reset(evt);
            }
        });
        this.jLabel9.setText("hh : mm : ss : ms");
        final GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton2)).addComponent(this.jTextField1, -2, 150, -2))).addGroup(jPanel2Layout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.jLabel9))).addContainerGap(25, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel9).addGap(4, 4, 4).addComponent(this.jTextField1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(17, 32767)));
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("STOP WATCH");
        final GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(66, 32767).addComponent(this.jPanel2, -2, -1, -2).addGap(59, 59, 59)).addGroup(jPanel3Layout.createSequentialGroup().addGap(110, 110, 110).addComponent(this.jLabel4).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(40, 32767)));
        this.jMenu1.setText("File");
        this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(67, 8));
        this.jMenuItem3.setText("Calculator");
        this.jMenuItem3.setFocusable(true);
        this.jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem3);
        this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(88, 8));
        this.jMenuItem1.setText("Exit");
        this.jMenuItem1.setFocusable(true);
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("Help");
        this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(65, 8));
        this.jMenuItem2.setText("About");
        this.jMenuItem2.setFocusable(true);
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Frame.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 612, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -2, -1, -2))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, 32767).addComponent(this.jPanel3, -2, -1, -2)));
        this.pack();
    }
    
    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        final aboutme dialog = new aboutme(new JFrame(), true);
        dialog.setVisible(true);
    }
    
    private void windowOpened(final WindowEvent evt) {
    }
    
    private void jMenuItem3ActionPerformed(final ActionEvent evt) {
        new Calc().setVisible(true);
    }
    
    private void componentAdded(final ContainerEvent evt) {
    }
    
    private void windowActivated(final WindowEvent evt) {
        this.setLocationRelativeTo(null);
        if (!this.p.isShowing()) {
            this.p.setSize(1500, 900);
            this.p.init();
            this.add(this.p);
            this.p.start();
        }
    }
    
    private void startButton(final ActionEvent evt) {
        if (this.jButton1.getText().equals("start") && this.wat.isAlive()) {
            this.jButton1.setText("pause");
            this.wat.resume();
        }
        else if (this.jButton1.getText().equals("start")) {
            this.jButton1.setText("pause");
            this.wat.start();
        }
        else if (this.jButton1.getText().equals("pause")) {
            this.jButton1.setText("resume");
            this.wat.suspend();
        }
        else if (this.jButton1.getText().equals("resume")) {
            this.jButton1.setText("pause");
            this.wat.resume();
        }
    }
    
    private void reset(final ActionEvent evt) {
        this.wat.suspend();
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
        this.i = 0;
        this.jTextField1.setText("      " + this.hour + "  :   " + this.min + "   :   " + this.sec + "   :   " + this.i);
        this.jButton1.setText("start");
    }
    
    private void jTextField1ActionPerformed(final ActionEvent evt) {
    }
    
    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        final int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit\nfrom the\nSimulation", "Confirmation Box", 0);
        if (reply == 0) {
            System.exit(0);
        }
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
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}
