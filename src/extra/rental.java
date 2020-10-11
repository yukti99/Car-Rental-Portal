/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import Admin.carRegistration;
import com.sun.glass.events.KeyEvent;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class rental extends javax.swing.JFrame {

    public rental() {
        initComponents();
        rentalDate.setDateFormatString("yyyy/MM/dd");
        rentalDue.setDateFormatString("yyy/MM/dd");
        loadCatID();
        rentalCustid.setEnabled(false);
        rentalName.setEnabled(false);
        rentalFee.setEnabled(false);
        rentalDate.setEnabled(false);
        rentalDue.setEnabled(false);
      
    }

    Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs;
    public void loadCatID(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from carreg");
            ResultSet rs = pst.executeQuery();
            comboCarId.removeAllItems();
            while(rs.next()){
                //if (rs.getString(5).equals("Yes")){
                    comboCarId.addItem(rs.getString(2)); 
                //}
            }           
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboCarId = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rentalCustid = new javax.swing.JTextField();
        rentalName = new javax.swing.JTextField();
        rentalFee = new javax.swing.JTextField();
        rentalDate = new com.toedter.calendar.JDateChooser();
        rentalDue = new com.toedter.calendar.JDateChooser();
        okBtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        txtAvl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rental", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 25), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Car Id");

        comboCarId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        comboCarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Customer Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Due Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Rental Fee");

        rentalCustid.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        rentalCustid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalCustidActionPerformed(evt);
            }
        });
        rentalCustid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rentalCustidKeyPressed(evt);
            }
        });

        rentalName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        rentalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalNameActionPerformed(evt);
            }
        });

        rentalFee.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        rentalFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalFeeActionPerformed(evt);
            }
        });

        rentalDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        rentalDue.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        okBtn.setBackground(new java.awt.Color(204, 204, 204));
        okBtn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        okBtn.setForeground(new java.awt.Color(54, 33, 89));
        okBtn.setText("Ok");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(204, 204, 204));
        backbtn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        backbtn.setForeground(new java.awt.Color(54, 33, 89));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        txtAvl.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtAvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvlActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Available");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rentalCustid)
                                    .addComponent(comboCarId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rentalFee)
                                    .addComponent(rentalName)
                                    .addComponent(rentalDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rentalDue, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCarId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(rentalCustid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentalName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentalFee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(rentalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentalDue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rentalCustidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalCustidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentalCustidActionPerformed

    private void rentalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentalNameActionPerformed

    private void rentalFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentalFeeActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        String car_id = comboCarId.getSelectedItem().toString();
        String cust_id = rentalCustid.getText();        
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        String date = Date_Format.format(rentalDate.getDate());
        SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
        String due = Date_Format1.format(rentalDue.getDate());
        String fee = rentalFee.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("insert into rental(car_id,cust_id,fee,date,due) values(?,?,?,?,?)");
            pst.setString(1,car_id);
            pst.setString(2,cust_id);
            pst.setString(3,fee);
            pst.setString(4,date);
            pst.setString(5,due);             
            pst.executeUpdate();
            pst1 = con.prepareStatement("update carreg set available = 'No' where car_no=?");
            pst1.setString(1, car_id);
            pst1.executeUpdate();       
            
            JOptionPane.showMessageDialog(this,"Car Rented Successfully!"); 
            rentalCustid.setText("");
            rentalName.setText("");
            rentalFee.setText("");            
            rentalDate.setDate(null);
            rentalDue.setDate(null);
            txtAvl.setText(null);
        
                  
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        
        
    }//GEN-LAST:event_okBtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        //dispose();
        this.hide();
    }//GEN-LAST:event_backbtnActionPerformed

    private void comboCarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarIdActionPerformed
        String car_id = comboCarId.getSelectedItem().toString();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst1 = con.prepareStatement("select * from carreg where car_no = ?");
            pst1.setString(1,car_id);
            rs = pst1.executeQuery();            
            if (rs.next()==false){
                JOptionPane.showMessageDialog(this,"Car Not Found!");  
            }else{             
                String aval = rs.getString("available");
                txtAvl.setText(aval.trim());
                if (aval.equals("Yes")){
                    rentalCustid.setEnabled(true);
                    rentalName.setEnabled(true);
                    rentalFee.setEnabled(true);
                    rentalDate.setEnabled(true);
                    rentalDue.setEnabled(true);                    
                }else{
                    rentalCustid.setEnabled(false);
                    rentalName.setEnabled(false);
                    rentalFee.setEnabled(false);
                    rentalDate.setEnabled(false);
                    rentalDue.setEnabled(false);       
                    
                }
                       
            }
                     
              
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
        
    }//GEN-LAST:event_comboCarIdActionPerformed

    private void rentalCustidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rentalCustidKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            String cust_id = rentalCustid.getText();
            try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from customers where cust_id = ?");
            pst.setString(1,cust_id);
            rs = pst.executeQuery();
            if (rs.next()==false){
                 JOptionPane.showMessageDialog(this,"Customer Not Found!");  
            }else{
                String custName = rs.getString("name");
                rentalName.setText(custName);
            }
            
                 
              
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
        }
    }//GEN-LAST:event_rentalCustidKeyPressed

    private void txtAvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvlActionPerformed

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
            java.util.logging.Logger.getLogger(rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rental().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox<String> comboCarId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField rentalCustid;
    private com.toedter.calendar.JDateChooser rentalDate;
    private com.toedter.calendar.JDateChooser rentalDue;
    private javax.swing.JTextField rentalFee;
    private javax.swing.JTextField rentalName;
    private javax.swing.JTextField txtAvl;
    // End of variables declaration//GEN-END:variables
}
