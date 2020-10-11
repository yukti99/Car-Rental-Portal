/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import static Customer.userLogin.username;
import carrental.welcome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import extra.customerRegistration;

/**
 *
 * @author yukti
 */
public class updateProfile extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst,pst1;
    String name,username;
    
    public updateProfile() {
        initComponents();
        
        name = userLogin.name;
        txtwelcome.setText(name);
        username = userLogin.username;        
        displayInfo(username);
    }
     private void displayInfo(String username) {
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
                            Statement s = con.createStatement();
                            pst = con.prepareStatement("select * from customerinfo where username = ?");   
                            pst.setString(1,username);
                            ResultSet rs = pst.executeQuery();
                            while (rs.next()){
                                updateName.setText(rs.getString("name"));
                                updatePhone.setText(rs.getString("phone"));
                                updatePassword.setText(rs.getString("password"));
                                if  (!(rs.getString("address").equals("NA"))){
                                    updateAddress.setText(rs.getString("address"));
                                }                        
                            }                    
                    
                        }catch(ClassNotFoundException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
                        }catch(SQLException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                        }                      
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        updateAddress = new javax.swing.JTextArea();
        updateBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        updateName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        updatePhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        updatePassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        txtwelcome = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        rental = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        carRegister = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();
        myRents = new javax.swing.JButton();
        cancelRent = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(54, 33, 89));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateAddress.setColumns(20);
        updateAddress.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        updateAddress.setRows(5);
        jScrollPane1.setViewportView(updateAddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 180, 110));

        updateBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(54, 33, 89));
        updateBtn.setText("Update");
        updateBtn.setBorder(null);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 545, 100, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 110, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 110, 60));

        updateName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateName.setBorder(null);
        getContentPane().add(updateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 180, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phone");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 110, 60));

        updatePhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updatePhone.setBorder(null);
        getContentPane().add(updatePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 180, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 110, 60));

        updatePassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updatePassword.setBorder(null);
        getContentPane().add(updatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 180, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Update Your Profile");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 610, 130));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "update profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 17), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 460, 450));

        sidepane.setBackground(new java.awt.Color(54, 33, 89));
        sidepane.setPreferredSize(new java.awt.Dimension(244, 534));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtwelcome.setBackground(new java.awt.Color(255, 255, 255));
        txtwelcome.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtwelcome.setForeground(new java.awt.Color(204, 204, 204));
        txtwelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtwelcome.setText("Home");
        sidepane.add(txtwelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 50));

        updatebtn.setBackground(new java.awt.Color(85, 65, 118));
        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(204, 204, 204));
        updatebtn.setText("Update Profile");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        sidepane.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 50));

        rental.setBackground(new java.awt.Color(85, 65, 118));
        rental.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        rental.setForeground(new java.awt.Color(204, 204, 204));
        rental.setText("Rent History");
        rental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalActionPerformed(evt);
            }
        });
        sidepane.add(rental, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 260, 50));

        exit.setBackground(new java.awt.Color(85, 65, 118));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        exit.setForeground(new java.awt.Color(204, 204, 204));
        exit.setText("Logout");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        sidepane.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 260, 50));

        carRegister.setBackground(new java.awt.Color(85, 65, 118));
        carRegister.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        carRegister.setForeground(new java.awt.Color(204, 204, 204));
        carRegister.setText("Rent Car");
        carRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carRegisterActionPerformed(evt);
            }
        });
        sidepane.add(carRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 260, 50));

        aboutBtn.setBackground(new java.awt.Color(85, 65, 118));
        aboutBtn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        aboutBtn.setForeground(new java.awt.Color(204, 204, 204));
        aboutBtn.setText("About");
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });
        sidepane.add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 260, 50));

        myRents.setBackground(new java.awt.Color(85, 65, 118));
        myRents.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        myRents.setForeground(new java.awt.Color(204, 204, 204));
        myRents.setText("My Rents");
        myRents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myRentsActionPerformed(evt);
            }
        });
        sidepane.add(myRents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 260, 50));

        cancelRent.setBackground(new java.awt.Color(85, 65, 118));
        cancelRent.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        cancelRent.setForeground(new java.awt.Color(204, 204, 204));
        cancelRent.setText("Cancel Rent");
        cancelRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRentActionPerformed(evt);
            }
        });
        sidepane.add(cancelRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 260, 50));

        getContentPane().add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 700));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/carback.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/carback.jpg"))); // NOI18N
        jLabel4.setText("jLabel3");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 400, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
     
    }//GEN-LAST:event_updatebtnActionPerformed

    private void rentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalActionPerformed
        dispose();
        rentACar r = new rentACar();
        r.setVisible(true);
    }//GEN-LAST:event_rentalActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
        welcome w = new welcome();
        w.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void carRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carRegisterActionPerformed
        dispose();
        rentACar r = new rentACar();
        r.setVisible(true);
    }//GEN-LAST:event_carRegisterActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try{            
            Class.forName("com.mysql.jdbc.Driver");     
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root",""); 
            pst = con.prepareStatement("update customerinfo set name=?,password=?,phone=?,address=? where username =? ");
            pst.setString(1,updateName.getText());
            pst.setString(2,updatePassword.getText());
            pst.setString(3,updatePhone.getText());
            pst.setString(4,updateAddress.getText());
            pst.setString(5,username);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Customer Record Updated Successfully!");
            name = updateName.getText();
            txtwelcome.setText(name);       
                       
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }                                    
       
        

    }//GEN-LAST:event_updateBtnActionPerformed

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtnActionPerformed
          dispose();
          about a = new about();
          a.setVisible(true);
    }//GEN-LAST:event_aboutBtnActionPerformed

    private void myRentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myRentsActionPerformed
        dispose();
        myRents w = new myRents();
        w.setVisible(true);

    }//GEN-LAST:event_myRentsActionPerformed

    private void cancelRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRentActionPerformed
        dispose();  
        cancelRent r = new cancelRent();
           r.setVisible(true);
    }//GEN-LAST:event_cancelRentActionPerformed

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
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutBtn;
    private javax.swing.JButton cancelRent;
    private javax.swing.JButton carRegister;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton myRents;
    private javax.swing.JButton rental;
    private javax.swing.JPanel sidepane;
    private javax.swing.JLabel txtwelcome;
    private javax.swing.JTextArea updateAddress;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField updateName;
    private javax.swing.JPasswordField updatePassword;
    private javax.swing.JTextField updatePhone;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables

   
}
