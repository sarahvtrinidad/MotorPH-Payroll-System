//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package group8motorph;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PayrollGUIApp extends JFrame {
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPasswordField passwordField;
    private JTextField usernameField;

    public PayrollGUIApp() {
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.usernameField = new JTextField();
        this.passwordField = new JPasswordField();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setText("Username");
        this.jLabel2.setText("Password");
        this.usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PayrollGUIApp.this.usernameFieldActionPerformed(evt);
            }
        });
        this.passwordField.setText("jPasswordField1");
        this.passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PayrollGUIApp.this.passwordFieldActionPerformed(evt);
            }
        });
        this.jButton1.setText("LOGIN");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PayrollGUIApp.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(70, 70, 70).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.passwordField, -2, 98, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.usernameField, -2, 95, -2)))).addGroup(layout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.jButton1))).addContainerGap(156, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(102, 102, 102).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.usernameField, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.passwordField, -2, -1, -2)).addGap(26, 26, 26).addComponent(this.jButton1).addContainerGap(91, 32767)));
        this.pack();
    }

    private void usernameFieldActionPerformed(ActionEvent evt) {
    }

    private void passwordFieldActionPerformed(ActionEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog((Component)null, "Please enter the username!", "Error", 64);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog((Component)null, "Please enter the password!", "Error", 64);
        } else {
            JOptionPane.showMessageDialog((Component)null, "Login SuccessFully!", "Success", 1);
        }
    }

    public static void main(String[] args) {
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PayrollGUIApp.class.getName()).log(Level.SEVERE, (String)null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PayrollGUIApp.class.getName()).log(Level.SEVERE, (String)null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PayrollGUIApp.class.getName()).log(Level.SEVERE, (String)null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PayrollGUIApp.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new PayrollGUIApp()).setVisible(true);
            }
        });
    }
}
