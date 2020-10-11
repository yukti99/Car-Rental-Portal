/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yukti
 */
public class customerRegistration extends javax.swing.JFrame {

    /**
     * Creates new form carRegistration
     */
    public customerRegistration() {
        initComponents();
        autoID();
        table_update();
    }

  
    @SuppressWarnings("unchecked")
    Connection con;
    PreparedStatement pst;
    
    public void table_update(){
        int c;
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from customers");  
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)custTable.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("cust_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("address"));                   
                    v2.add(rs.getString("mobile")); 
                     System.out.println("tableMobile = "+rs.getString("mobile"));
                    System.out.println("tableAddress = "+rs.getString("address"));
                }
                df.addRow(v2);            
            }         
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
    }    
    public void autoID(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(cust_id) from customers");
            rs.next();
            rs.getString("Max(cust_id)");
            if (rs.getString("Max(cust_id)")== null){
                custId.setText("U0001");
            }else{
                long id = Long.parseLong(rs.getString("Max(cust_id)").substring(2,rs.getString("Max(cust_id)").length()));
                System.out.println("ID  = "+id);
                id++;
                custId.setText("U0"+String.format("%03d",id));
            }            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custAdd = new javax.swing.JButton();
        custDelete = new javax.swing.JButton();
        custEdit = new javax.swing.JButton();
        custBack = new javax.swing.JButton();
        custId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        custAddress = new java.awt.TextArea();
        custMobile = new javax.swing.JTextField();
        custName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Customer Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Address");

        custAdd.setBackground(new java.awt.Color(204, 204, 204));
        custAdd.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        custAdd.setForeground(new java.awt.Color(54, 33, 89));
        custAdd.setText("Add");
        custAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custAddActionPerformed(evt);
            }
        });

        custDelete.setBackground(new java.awt.Color(204, 204, 204));
        custDelete.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        custDelete.setForeground(new java.awt.Color(54, 33, 89));
        custDelete.setText("Delete");
        custDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custDeleteActionPerformed(evt);
            }
        });

        custEdit.setBackground(new java.awt.Color(204, 204, 204));
        custEdit.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        custEdit.setForeground(new java.awt.Color(54, 33, 89));
        custEdit.setText("Edit");
        custEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custEditActionPerformed(evt);
            }
        });

        custBack.setBackground(new java.awt.Color(204, 204, 204));
        custBack.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        custBack.setForeground(new java.awt.Color(54, 33, 89));
        custBack.setText("Back");
        custBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custBackActionPerformed(evt);
            }
        });

        custId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        custId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Mobile No.");

        custAddress.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        custMobile.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        custMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custMobileActionPerformed(evt);
            }
        });

        custName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        custName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(custMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(81, 81, 81))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(custId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(custName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(custAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(custAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(custEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(custId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(custMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(custAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 500, 600));

        custTable.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Address", "Mobile No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        custTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 510, 595));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void custBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custBackActionPerformed
      //setVisible(false);    
      dispose();
    }//GEN-LAST:event_custBackActionPerformed

    private void custIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custIdActionPerformed

    private void custAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custAddActionPerformed

        String id = custId.getText();
        String name = custName.getText();
        String address = custAddress.getText();
        String mobile = custMobile.getText();
        System.out.println("addAddress = "+address);
        System.out.println("addMobile = "+mobile);
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");           
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            pst = con.prepareStatement("insert into customers(cust_id,name,address,mobile) values(?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,address);
            pst.setString(4,mobile);  
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Customer Registration Successfull!");     
            custId.setText("");
            custName.setText("");
            custAddress.setText("");
            custMobile.setText("");
            custId.requestFocus();
            autoID();
            table_update();          
              
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
        
    }//GEN-LAST:event_custAddActionPerformed

    private void custTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTableMouseClicked
       DefaultTableModel d1 = (DefaultTableModel)custTable.getModel();
       int selectIndex = custTable.getSelectedRow();
       custId.setText(d1.getValueAt(selectIndex,0).toString());
       custName.setText(d1.getValueAt(selectIndex,1).toString());
       custAddress.setText(d1.getValueAt(selectIndex,2).toString());
       custMobile.setText(d1.getValueAt(selectIndex,3).toString());
       
    }//GEN-LAST:event_custTableMouseClicked

    private void custEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custEditActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)custTable.getModel();
        int selectIndex = custTable.getSelectedRow();
        try{
            String id = custId.getText();
            String name = custName.getText();
            String address = custAddress.getText();
            String mobile = custMobile.getText();  
            System.out.println("editMobile = "+mobile);
            System.out.println("editAddress = "+address);
            Class.forName("com.mysql.cj.jdbc.Driver");        
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root",""); 
            pst = con.prepareStatement("update customers set name=?,address=?,mobile=? where cust_id=? ");
            pst.setString(1,name);
            pst.setString(2,address);
            pst.setString(3,mobile);
            pst.setString(4,id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Customer Record Updated Successfully!");
            custId.setText("");
            custName.setText("");
            custAddress.setText("");
            custMobile.setText("");
            custId.requestFocus();
            autoID();
            table_update();           
              
        }catch(ClassNotFoundException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
    }//GEN-LAST:event_custEditActionPerformed

    private void custDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custDeleteActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)custTable.getModel();
        int selectIndex = custTable.getSelectedRow();
        String id = d1.getValueAt(selectIndex,0).toString();
            int dialogResult = JOptionPane.showConfirmDialog(this,"Do you want delete this record?","Warning",JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){ 
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root",""); 
                    pst = con.prepareStatement("delete from customers where cust_id =?");
                    pst.setString(1,id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
                    custId.setText("");
                    custName.setText("");
                    custAddress.setText("");
                    custMobile.setText("");
                    custId.requestFocus();
                    autoID();
                    table_update(); 

                }catch(ClassNotFoundException ex){
                    Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
                }catch(SQLException ex){
                    Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                } 

            }else{
                
            }     
  
            
            
            
    }//GEN-LAST:event_custDeleteActionPerformed

    private void custMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custMobileActionPerformed

    private void custNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custNameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton custAdd;
    private java.awt.TextArea custAddress;
    private javax.swing.JButton custBack;
    private javax.swing.JButton custDelete;
    private javax.swing.JButton custEdit;
    private javax.swing.JTextField custId;
    private javax.swing.JTextField custMobile;
    private javax.swing.JTextField custName;
    private javax.swing.JTable custTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
