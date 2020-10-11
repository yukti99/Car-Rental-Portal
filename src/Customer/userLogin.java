/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

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


public class userLogin extends javax.swing.JFrame {

    public userLogin() {
        initComponents();
    }
    Connection con;
    PreparedStatement pst,pst1,pst2; 
    static String name,username,password,cust_id;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerBtn = new javax.swing.JButton();
        textPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        backtomain = new javax.swing.JButton();
        textUsername = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerBtn.setBackground(new java.awt.Color(0, 0, 0));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(204, 204, 204));
        registerBtn.setText("Register");
        registerBtn.setBorder(null);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 110, 50));

        textPassword.setBackground(new java.awt.Color(0, 0, 0));
        textPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPassword.setForeground(new java.awt.Color(255, 255, 255));
        textPassword.setBorder(null);
        getContentPane().add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 180, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 360, 20));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 360, 20));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("login");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 90, 60));

        backtomain.setBackground(new java.awt.Color(0, 0, 0));
        backtomain.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backtomain.setForeground(new java.awt.Color(204, 204, 204));
        backtomain.setText("Back");
        backtomain.setBorder(null);
        backtomain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtomainActionPerformed(evt);
            }
        });
        getContentPane().add(backtomain, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 110, 50));

        textUsername.setBackground(new java.awt.Color(0, 0, 0));
        textUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textUsername.setForeground(new java.awt.Color(255, 255, 255));
        textUsername.setBorder(null);
        getContentPane().add(textUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 180, 30));

        loginBtn.setBackground(new java.awt.Color(0, 0, 0));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(204, 204, 204));
        loginBtn.setText("Login");
        loginBtn.setBorder(null);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 110, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Or");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 30, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 110, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, 60));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 45)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Don't Dream it, Drive it..");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 640, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 470, 170));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/carback.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        dispose();
        userRegister r = new userRegister();
        r.setVisible(true);
    }//GEN-LAST:event_registerBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
       username = textUsername.getText();
       password = textPassword.getText();
       if (username.equals("")){
           JOptionPane.showMessageDialog(this,"Please enter your username!");  
       }else{
           if (password.equals("")){
               JOptionPane.showMessageDialog(this,"Please enter your password!");  
           }else{
                        try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
                        Statement s = con.createStatement();
                        pst = con.prepareStatement("select * from customerinfo where username = ?");   
                        pst.setString(1,username);
                       
                        
                        ResultSet rs = pst.executeQuery();
                        /*if (rs.next()){
                            String c  = rs.getString("cust_id"); 
                            pst2 = con.prepareStatement("select * from custsecurity where cust_id = ?");   
                            pst2.setString(1,c);
                            ResultSet rs1 = pst2.executeQuery();
                            if (rs1.next()){
                                String y;
                                y = rs1.getString("Cust_rating");
                                if (y.equals("BLACKLIST")){
                                    JOptionPane.showMessageDialog(this,"SORRY YOU ARE BLACKLISTED!!TALK TO ADMIN"); 
                                    dispose();
                                    welcome w = new welcome();
                                    w.setVisible(true);
                                }
                            }
                        }*/
                        
                        
                        if (rs.next()){
                            String pass = rs.getString("password");
                            cust_id = rs.getString("cust_id");
                            if (pass.equals(password)){
                                JOptionPane.showMessageDialog(this,"Welcome "+rs.getString("name")+"!");
                                name  = rs.getString("name");
                                dispose();
                                userHome h = new userHome();
                                h.setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(this,"Incorrect Password!!"); 
                                textPassword.setText("");
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(this,"Username does not exist! Please create an account..");    
                        }                      
                    
                        }catch(ClassNotFoundException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
                        }catch(SQLException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                        }                 
           }
       }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void backtomainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomainActionPerformed
        dispose();
        welcome w = new welcome();
        w.setVisible(true);
    }//GEN-LAST:event_backtomainActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtomain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
