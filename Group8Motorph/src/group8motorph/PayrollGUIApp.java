/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group8motorph;

/**
 *
 * @author sarahtrinidad
 */
public class PayrollGUIApp extends javax.swing.JFrame {

    /**
     * Creates new form PayrollGUIApp
     */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

    public PayrollGUIApp() {
        initComponents();
        static class Employee {
        private int id;
        private String name;
        private String position;
        private double salary;
        private LoginSession login;

        public Employee(int id, String name, String position, double salary, LoginSession login) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
            this.login = login;
        }

        public double calculateDeductions() {
            Deductions d = new Deductions(salary);
            return d.totalDeduction();
        }

        public double getNetPay() {
            return salary - calculateDeductions();
        }

        public String getPayslip() {
            Deductions d = new Deductions(salary);
            return "Employee: " + name + "\n" +
                   "Position: " + position + "\n" +
                   "Gross Pay: PHP " + salary + "\n" +
                   "--- Deductions ---\n" +
                   String.format("SSS (4.5%%): PHP %.2f\n", d.calculateSSS()) +
                   String.format("PhilHealth (3.5%%): PHP %.2f\n", d.calculatePhilHealth()) +
                   String.format("Pag-IBIG (2%%): PHP %.2f\n", d.calculatePagIbig()) +
                   String.format("Tax (10%%): PHP %.2f\n", d.calculateTax()) +
                   String.format("Other: PHP %.2f\n", d.calculateOtherDeductions()) +
                   String.format("Total Deductions: PHP %.2f\n", d.totalDeduction()) +
                   String.format("Net Pay: PHP %.2f\n", getNetPay());
        }
    }

    static class LoginSession {
        private String username;
        private String password;

        public LoginSession(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean authenticate(String inputUser, String inputPass) {
            return username.equals(inputUser) && password.equals(inputPass);
        }
    }

    static class Deductions {
        private double salary;

        public Deductions(double salary) {
            this.salary = salary;
        }

        public double calculateSSS() {
            return salary * 0.045;
        }

        public double calculatePhilHealth() {
            return salary * 0.035;
        }

        public double calculatePagIbig() {
            return salary * 0.02;
        }

        public double calculateTax() {
            return salary * 0.1;
        }

        public double calculateOtherDeductions() {
            return 50;
        }

        public double totalDeduction() {
            return calculateSSS() + calculatePhilHealth() + calculatePagIbig() + calculateTax() + calculateOtherDeductions();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }

    static class LoginFrame extends JFrame {
        private Map<String, Employee> employees;

        public LoginFrame() {
            setTitle("Payroll Login");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            employees = new HashMap<>();
            addDemoEmployees();

            JPanel panel = new JPanel(new GridLayout(3, 2));
            JLabel userLabel = new JLabel("Username:");
            JTextField userField = new JTextField();
            JLabel passLabel = new JLabel("Password:");
            JPasswordField passField = new JPasswordField();
            JButton loginBtn = new JButton("Login");

            panel.add(userLabel);
            panel.add(userField);
            panel.add(passLabel);
            panel.add(passField);
            panel.add(new JLabel());
            panel.add(loginBtn);

            add(panel);

            loginBtn.addActionListener(e -> {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                Employee emp = employees.get(username);

                if (emp != null && emp.login.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(this, "Welcome, " + emp.name);
                    new PayrollFrame(emp);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials.");
                }
            });

            setVisible(true);
        }

        private void addDemoEmployees() {
            employees.put("sarah", new Employee(1, "Sarah Trinidad", "Developer", 30000, new LoginSession("sarah", "pass123")));
            employees.put("juan", new Employee(2, "Juan Dela Cruz", "Designer", 28000, new LoginSession("juan", "pass123")));
            employees.put("maria", new Employee(3, "Maria Santos", "Manager", 50000, new LoginSession("maria", "pass123")));
            employees.put("pedro", new Employee(4, "Pedro Reyes", "QA Tester", 25000, new LoginSession("pedro", "pass123")));
            employees.put("ana", new Employee(5, "Ana Lim", "HR", 27000, new LoginSession("ana", "pass123")));
        }
    }

    static class PayrollFrame extends JFrame {
        public PayrollFrame(Employee emp) {
            setTitle("Payslip for " + emp.name);
            setSize(400, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea payslipArea = new JTextArea(emp.getPayslip());
            payslipArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(payslipArea);

            JButton closeBtn = new JButton("Close");
            closeBtn.addActionListener(e -> System.exit(0));

            add(scrollPane, BorderLayout.CENTER);
            add(closeBtn, BorderLayout.SOUTH);

            setVisible(true);
        }
    }
}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

String username = txtUsername.getText();
    String password = new String(txtPassword.getPassword());

    Employee emp = employees.get(username);

    if (emp != null && emp.login.authenticate(username, password)) {
        JOptionPane.showMessageDialog(this, "Welcome, " + emp.name);
        // Show payslip frame
        PayrollFrame payslipFrame = new PayrollFrame(emp);
        payslipFrame.setVisible(true);
        this.dispose(); // Close login form
    } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password.");
    }
} 



    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayrollGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollGUIApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
