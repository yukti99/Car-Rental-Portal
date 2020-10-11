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

/**
 *
 * @author yukti
 */
public class userRegister extends javax.swing.JFrame {

    /**
     * Creates new form userRegister
     */
    public userRegister() {
        initComponents();
    }
    
    Connection con,con1;
    PreparedStatement pst,pst1,pst2;   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adhar = new javax.swing.JTextField();
        license = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backtologin = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        registerBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adhar.setBackground(new java.awt.Color(0, 0, 0));
        adhar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adhar.setForeground(new java.awt.Color(255, 255, 255));
        adhar.setBorder(null);
        getContentPane().add(adhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 180, 30));

        license.setBackground(new java.awt.Color(0, 0, 0));
        license.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        license.setForeground(new java.awt.Color(255, 255, 255));
        license.setBorder(null);
        getContentPane().add(license, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 180, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Aadhar No");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 160, 60));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Driving License");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 160, 60));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sign up!");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 230, 60));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 110, 60));

        backtologin.setBackground(new java.awt.Color(0, 0, 0));
        backtologin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backtologin.setForeground(new java.awt.Color(204, 204, 204));
        backtologin.setText("Back");
        backtologin.setBorder(null);
        backtologin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtologinActionPerformed(evt);
            }
        });
        getContentPane().add(backtologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 110, 50));

        txtusername.setBackground(new java.awt.Color(0, 0, 0));
        txtusername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(null);
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 180, 30));

        txtphone.setBackground(new java.awt.Color(0, 0, 0));
        txtphone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtphone.setForeground(new java.awt.Color(255, 255, 255));
        txtphone.setBorder(null);
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 180, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 110, 60));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 360, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 110, 60));

        txtname.setBackground(new java.awt.Color(0, 0, 0));
        txtname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setBorder(null);
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 180, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 110, 60));

        txtpassword.setBackground(new java.awt.Color(0, 0, 0));
        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 180, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 360, 20));

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
        getContentPane().add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 110, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/carback.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 110, 60));

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 180, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public String autoID(){
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            String cust_id = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(cust_id) from customerinfo");
            rs.next();
            rs.getString("Max(cust_id)");
            if (rs.getString("Max(cust_id)")== null){
                cust_id = "U0001";
            }else{
                long id = Long.parseLong(rs.getString("Max(cust_id)").substring(2,rs.getString("Max(cust_id)").length()));
                System.out.println("ID  = "+id);
                id++;
                cust_id = "U0"+String.format("%03d",id);
                
            }  
            return cust_id;
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;        
        
    } 
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
       String name = txtname.getText();
       String username = txtusername.getText();
       String password = txtpassword.getText();
       String phone  = txtphone.getText();
       String aadharno = adhar.getText();
       String li  =  license.getText();
       String cust_id;
       if (name.equals("")){
           JOptionPane.showMessageDialog(this,"Please enter your name!");  
       }else{
           if (phone.equals("")){
               JOptionPane.showMessageDialog(this,"Please enter your Phone no!");  
           }else{
                if (username.equals("")){
                    JOptionPane.showMessageDialog(this,"Please enter your username!");
                }else{
                    if (password.equals("")){
                        JOptionPane.showMessageDialog(this,"Please enter your password!");  
                    }else{
                        if (aadharno.equals("")){
                            JOptionPane.showMessageDialog(this,"Please enter your aadhar no!");  
                        }else{
                             if (li.equals("")){
                            JOptionPane.showMessageDialog(this,"Please enter your driving licence!");  
                            }else{
                                  try{
                            Class.forName("com.mysql.jdbc.Driver");
                        
                            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
                            //con = DriverManager.getConnection("jdbc:mysql://localhost/cars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root",""); 
                           // con = DriverManager.getConnection("jdbc:mysql://localhost/cars?useTimezone=true&serverTimezone=UTC","root","");  
                            Statement s = con.createStatement();
                            pst = con.prepareStatement("insert into customerinfo(cust_id,username,password,name,phone,address) values(?,?,?,?,?,?)");
                            pst2 = con.prepareStatement("insert into custSecurity(cust_id,Adhar_no,driving_licence) values(?,?,?)");
                           
                            cust_id = autoID();
                             pst2.setString(1,cust_id);
                              pst2.setString(2,aadharno);
                               pst2.setString(3,li);
                            pst.setString(1,cust_id);
                            pst.setString(2,username);
                            pst.setString(3,password);
                            pst.setString(4,name);
                            pst.setString(5,phone);
                            pst.setString(6,"NA");
                            pst.executeUpdate();
                            pst2.executeUpdate();
                            JOptionPane.showMessageDialog(this,"Customer Registration Successfull!");     
                            txtusername.setText("");
                            txtpassword.setText("");
                            txtname.setText("");
                            txtphone.setText(""); 
                            adhar.setText("");
                            license.setText("");

                        }catch(ClassNotFoundException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
                        }catch(SQLException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                        }       
                                 

                            }
                        }
                                
                                              
                    }
                }
           }
       }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backtologinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtologinActionPerformed
        dispose();
        userLogin w = new userLogin();
        w.setVisible(true);
    }//GEN-LAST:event_backtologinActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adhar;
    private javax.swing.JButton backtologin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField license;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
