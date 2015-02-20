import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Calc extends JFrame
{
    int i;
    int j;
    float[][] tab;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    
    public Calc() {
        super();
        this.tab = new float[6][6];
        this.tab[0][0] = 100.0f;
        this.tab[1][0] = 90.0f;
        this.tab[2][0] = 80.0f;
        this.tab[3][0] = 70.0f;
        this.tab[4][0] = 60.0f;
        this.tab[5][0] = 50.0f;
        this.initComponents();
    }
    
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Period Calculator");
        this.setAlwaysOnTop(true);
        this.setCursor(new Cursor(1));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/image.jpeg")));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent evt) {
                Calc.this.windowActivated(evt);
            }
        });
        this.jPanel1.setBackground(new Color(255, 153, 153));
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setText("Period Calculator");
        this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6" }));
        this.jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent evt) {
                Calc.this.keyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        this.jButton1.setText("Calculate");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Calc.this.calc(evt);
            }
        });
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(320, 320, 320).addComponent(this.jLabel1).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 742, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButton1))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767).addComponent(this.jButton1).addContainerGap()));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }
    
    private void windowActivated(final WindowEvent evt) {
        this.jTable1.getColumnModel().getColumn(0).setHeaderValue("lenght (cm)");
        this.jTable1.getColumnModel().getColumn(1).setHeaderValue("t1 (s)");
        this.jTable1.getColumnModel().getColumn(2).setHeaderValue("t2 (s)");
        this.jTable1.getColumnModel().getColumn(3).setHeaderValue("Average time t (s)");
        this.jTable1.getColumnModel().getColumn(4).setHeaderValue("Period T=t/20");
        this.jTable1.getColumnModel().getColumn(5).setHeaderValue("T-sqr");
        this.i = 0;
        this.j = 0;
        while (this.i <= 5) {
            this.jTable1.setValueAt(this.tab[this.i][this.j], this.i, this.j);
            ++this.i;
        }
        this.jTable1.getTableHeader().resizeAndRepaint();
    }
    
    private void keyPressed(final KeyEvent evt) {
    }
    
    private void calc(final ActionEvent evt) {
        this.i = 0;
        this.j = 0;
        do {
            try {
                this.tab[this.i][this.j] = Float.parseFloat(this.jTable1.getValueAt(this.i, this.j).toString());
            }
            catch (Exception e) {
                this.jTable1.setValueAt(null, this.i, this.j);
                JOptionPane.showMessageDialog(null, "Make sure columns: l, t1, t2 are not empty and contains only numbers", "Error Message", 0);
                break;
            }
            ++this.i;
            if (this.i == 6) {
                this.i = 0;
                ++this.j;
            }
        } while (this.j != 3);
        this.i = 0;
        this.j = 3;
        while (this.i <= 5) {
            this.jTable1.setValueAt((this.tab[this.i][1] + this.tab[this.i][2]) / 2.0f, this.i, this.j);
            this.tab[this.i][this.j] = (this.tab[this.i][1] + this.tab[this.i][2]) / 2.0f;
            ++this.i;
        }
        this.i = 0;
        this.j = 4;
        while (this.i <= 5) {
            this.jTable1.setValueAt(this.tab[this.i][3] / 20.0f, this.i, this.j);
            this.tab[this.i][this.j] = this.tab[this.i][3] / 20.0f;
            ++this.i;
        }
        this.i = 0;
        this.j = 5;
        while (this.i <= 5) {
            this.jTable1.setValueAt(this.tab[this.i][4] * this.tab[this.i][4], this.i, this.j);
            ++this.i;
        }
        this.jTable1.getTableHeader().resizeAndRepaint();
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
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }
}
