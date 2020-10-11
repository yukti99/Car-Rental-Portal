/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import Customer.userLogin;
import static java.lang.System.exit;
import Admin.Login;

/**
 *
 * @author yukti
 */
public class welcome extends javax.swing.JFrame{
    public welcome(){
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        adminLogin1 = new javax.swing.JButton();
        customerLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 45)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Don't Dream it, Drive it..");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 640, 50));

        exitbtn.setBackground(new java.awt.Color(0, 0, 0));
        exitbtn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(204, 204, 204));
        exitbtn.setText("Bye!");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 210, 50));

        adminLogin1.setBackground(new java.awt.Color(0, 0, 0));
        adminLogin1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        adminLogin1.setForeground(new java.awt.Color(204, 204, 204));
        adminLogin1.setText("Are you an Admin?");
        adminLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(adminLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 210, 50));

        customerLogin.setBackground(new java.awt.Color(0, 0, 0));
        customerLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        customerLogin.setForeground(new java.awt.Color(204, 204, 204));
        customerLogin.setText("Rent a Car!");
        customerLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerLoginActionPerformed(evt);
            }
        });
        getContentPane().add(customerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 210, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CAR RENTAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 610, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/carback.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
       exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void adminLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLogin1ActionPerformed
        dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_adminLogin1ActionPerformed

    private void customerLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerLoginActionPerformed
        dispose();
        userLogin r = new Customer.userLogin();
        r.setVisible(true);
    }//GEN-LAST:event_customerLoginActionPerformed
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
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLogin1;
    private javax.swing.JButton customerLogin;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
