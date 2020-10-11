/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.sql.Connection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yukti
 */
public class carRegistration extends javax.swing.JFrame {

    /**
     * Creates new form carRegistration
     */
    public carRegistration() {
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
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from carsrental");  
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)regTable.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("car_id"));
                    v2.add(rs.getString("make"));
                    v2.add(rs.getString("model"));
                    v2.add(rs.getString("color"));
                    v2.add(rs.getString("capacity"));
                    v2.add(rs.getObject("rentalCost"));
                    v2.add(rs.getString("available"));
                    v2.add(rs.getObject("image"));
                    System.out.println("A = "+rs.getString("available"));                                 
                }
                df.addRow(v2);            
            }        
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
    }    
    public void autoID(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(car_id) from carsrental");
            rs.next();
            rs.getString("Max(car_id)");
            if (rs.getString("Max(car_id)")==null){
                txtID.setText("C0001");
            }else{
                long id = Long.parseLong(rs.getString("Max(car_id)").substring(2,rs.getString("Max(car_id)").length()));
                System.out.println("ID  = "+id);
                id++;
                txtID.setText("C0"+String.format("%03d",id));
            }            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        carImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        txtMake = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        avlCombo = new javax.swing.JComboBox<>();
        txtColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        regTable = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carImage.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        carImage.setForeground(new java.awt.Color(204, 204, 204));
        carImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carImage.setText("Car Image");
        jPanel2.add(carImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 2, 610, 280));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 610, 280));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Car Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 25), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Car ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Make");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Model");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Available");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(204, 204, 204));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        addBtn.setForeground(new java.awt.Color(54, 33, 89));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(54, 33, 89));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(204, 204, 204));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        editBtn.setForeground(new java.awt.Color(54, 33, 89));
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(204, 204, 204));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        backBtn.setForeground(new java.awt.Color(54, 33, 89));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        txtMake.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtMake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMakeActionPerformed(evt);
            }
        });

        txtModel.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelActionPerformed(evt);
            }
        });

        avlCombo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        avlCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        txtColor.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Color");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Capacity");

        txtCapacity.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacityActionPerformed(evt);
            }
        });

        txtCost.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Cost/day");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addComponent(txtMake, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtModel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCapacity, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtColor))
                            .addComponent(avlCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avlCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 610));

        regTable.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        regTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID", "Make", "Model", "Color", "Capacity", "Cost/day", "Available", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        regTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(regTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 610, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regTableMouseClicked
        DefaultTableModel d1 = (DefaultTableModel)regTable.getModel();
        carImage.setIcon(null);
        int selectIndex = regTable.getSelectedRow();
        txtID.setText(d1.getValueAt(selectIndex,0).toString());
        txtMake.setText(d1.getValueAt(selectIndex,1).toString());
        txtModel.setText(d1.getValueAt(selectIndex,2).toString());
        txtColor.setText(d1.getValueAt(selectIndex,3).toString());
        txtCapacity.setText(d1.getValueAt(selectIndex,4).toString());
        txtCost.setText(d1.getValueAt(selectIndex,5).toString());
        avlCombo.setSelectedItem(d1.getValueAt(selectIndex,6).toString());
        String car_id = txtID.getText();      
        try{
         
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
            pst = con.prepareStatement("select image from carsrental where car_id=? ");
            pst.setString(1,car_id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Blob blb = rs.getBlob("image");  
                //byte[] imagebytes = blb.getBytes(0, (int) blb.length());
                //carImage.setIcon((Icon) d1.getValueAt(selectIndex,6));
                if (blb!=null){
                    InputStream in = blb.getBinaryStream();  
                    if (in!=null){
                        BufferedImage image;
                        try {
                            image = ImageIO.read(in);
                            if (image!=null){
                                ImageIcon icon = new ImageIcon(image);
                                carImage.setIcon(icon);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
               
            }
            

        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }

        // convert byte-Array into Buffered Image (Subclass of Image)
        //BufferedImage theImage=ImageIO.read(new ByteArrayInputStream(imagebytes));        
        
        
    }//GEN-LAST:event_regTableMouseClicked

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostActionPerformed

    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelActionPerformed

    private void txtMakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMakeActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        //setVisible(false);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        DefaultTableModel d1 = (DefaultTableModel)regTable.getModel();
        int selectIndex = regTable.getSelectedRow();
        try{
            String id = d1.getValueAt(selectIndex,0).toString();
            String make = txtMake.getText();
            String model = txtModel.getText();
            String status = avlCombo.getSelectedItem().toString();
            String color = txtColor.getText();
            String capacity = txtCapacity.getText();
            String cost = txtCost.getText();

            //Object icon = carImage.getIcon();
            //Image img = carImage.createImage((ImageProducer) icon);

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
            pst = con.prepareStatement("update carsrental set make=?,model=?,color=?,capacity=?,available=?,rentalCost=? where car_id = ? ");
            pst.setString(1,make);
            pst.setString(2,model);
            pst.setString(3,color);
            pst.setString(4,capacity);
            pst.setString(5,status);
            pst.setString(6,cost);
            pst.setObject(7,id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Updated Successfully!");
            txtID.setText("");
            txtMake.setText("");
            txtCapacity.setText("");
            txtColor.setText("");
            txtModel.setText("");
            avlCombo.setSelectedIndex(-1);
            txtMake.requestFocus();
            carImage.setIcon(null);
            autoID();
            table_update();

        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)regTable.getModel();
        int selectIndex = regTable.getSelectedRow();
        String id = d1.getValueAt(selectIndex,0).toString();
        int dialogResult = JOptionPane.showConfirmDialog(this,"Do you want delete this record?","Warning",JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
                pst = con.prepareStatement("delete from carsrental where car_id=?");
                pst.setString(1,id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
                txtID.setText("");
                txtMake.setText("");
                txtCapacity.setText("");
                txtColor.setText("");
                txtModel.setText("");
                txtCost.setText("");
                avlCombo.setSelectedIndex(-1);
                txtMake.requestFocus();
                carImage.setIcon(null);
                autoID();
                table_update();

            }catch(ClassNotFoundException ex){
                Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
            }catch(SQLException ex){
                Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
            }

        }else{

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        String regNo = txtID.getText();
        String make = txtMake.getText();
        String model = txtModel.getText();
        String avl = avlCombo.getSelectedItem().toString();
        String color = txtColor.getText();
        String capacity = txtCapacity.getText();
        String cost = txtCost.getText();
        Object image = carImage.getIcon();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
            Statement s = con.createStatement();
            pst = con.prepareStatement("insert into carsrental(car_id,make,model,color,capacity,available,image,rentalCost) values(?,?,?,?,?,?,?,?)");
            pst.setString(1,regNo);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,color);
            pst.setString(5,capacity);
            pst.setString(6,avl);
            pst.setObject(7,image);
            pst.setObject(8,cost);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Car Registration Successfull!");
            txtID.setText("");
            txtMake.setText("");
            txtCapacity.setText("");
            txtColor.setText("");
            txtModel.setText("");
            txtCost.setText("");
            avlCombo.setSelectedIndex(-1);
            txtMake.requestFocus();
            carImage.setIcon(null);
            autoID();
            table_update();

        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> avlCombo;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel carImage;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable regTable;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMake;
    private javax.swing.JTextField txtModel;
    // End of variables declaration//GEN-END:variables
}
