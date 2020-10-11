/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;
import extra.customerRegistration;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class returnCar extends javax.swing.JFrame { 
    public returnCar() {
        initComponents();
        comboCustId.setSelectedItem("");  
        damage.setText("0");
        loadCustID();
        table_update();
        table_font();        
    }
    Connection con;
    PreparedStatement pst,pst1,pst2,pst3,pst4,pst5;
    ResultSet rs;   

    @SuppressWarnings("unchecked")
     public void loadCustID(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from rental");
            ResultSet rs = pst.executeQuery();
            comboCustId.removeAllItems();
            while(rs.next()){
                 comboCustId.addItem(rs.getString("cust_id"));
                
            }           
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void table_update(){
         int c;
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from carsreturned");  
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)returnInfoTable.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("return_id"));
                    v2.add(rs.getString("cust_id"));
                    v2.add(rs.getString("car_id"));
                    v2.add(rs.getString("rentalDate")); 
                    v2.add(rs.getString("returnDate"));
                    v2.add(rs.getString("lateDays")); 
                    v2.add(rs.getString("fine"));  
                    v2.add(rs.getString("totalCost")); 
                }
                df.addRow(v2);            
            }         
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }      
    }    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        returnCarBtn = new javax.swing.JButton();
        returnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboCustId = new javax.swing.JComboBox<>();
        returnCarID = new javax.swing.JTextField();
        dueDate = new javax.swing.JTextField();
        returnFine = new javax.swing.JTextField();
        returnDate = new javax.swing.JTextField();
        daysElapsed = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalRevenue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rentalID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rent = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        damage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        returnInfoTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Car Rental Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 23), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Customer ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Car ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Due Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Return Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Fine (Rs.)");

        returnCarBtn.setBackground(new java.awt.Color(204, 204, 204));
        returnCarBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnCarBtn.setForeground(new java.awt.Color(54, 33, 89));
        returnCarBtn.setText("Return Car");
        returnCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnCarBtnActionPerformed(evt);
            }
        });

        returnBack.setBackground(new java.awt.Color(204, 204, 204));
        returnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnBack.setForeground(new java.awt.Color(54, 33, 89));
        returnBack.setText("BACK");
        returnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBackActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Rs.1000 per day late fee applicable ");

        comboCustId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        comboCustId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCustIdActionPerformed(evt);
            }
        });

        returnCarID.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        returnCarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnCarIDActionPerformed(evt);
            }
        });

        dueDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        returnFine.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        returnDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        daysElapsed.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Days Elapsed");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Total Revenue");

        totalRevenue.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Rental ID");

        rentalID.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        rentalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalIDActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Rent");

        rent.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Damage fine");

        damage.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(returnCarBtn)
                        .addGap(93, 93, 93)
                        .addComponent(returnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel11))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rentalID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(daysElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCustId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(returnCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(returnFine, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(damage, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCustId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentalID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(daysElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(returnFine, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(damage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnCarBtn)
                    .addComponent(returnBack))
                .addGap(20, 20, 20)
                .addComponent(jLabel7))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 610));

        returnInfoTable.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        returnInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Return ID", "Cust ID", "Car ID", "Rental Date", "Return Date", "Days Late", "Fine (Rs.)", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(returnInfoTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 0, 670, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     public void table_font(){
        returnInfoTable.setBackground(Color.decode("#554176"));        
        // set Font To table
        returnInfoTable.setFont(new Font("", 1, 15));        
        // set height to the table rows
        returnInfoTable.setRowHeight(25);        
        // set color to the JTable Font
        returnInfoTable.setForeground(Color.white);        
        returnInfoTable.setFont(new Font("", 1, 15));
        returnInfoTable.setForeground(Color.white);
        returnInfoTable.setBackground(Color.decode("#362159"));
        returnInfoTable.setPreferredScrollableViewportSize(new Dimension(500, 70)); 
        // set font for headers
        Font f = new Font("Calibri", Font.BOLD, 15);
        JTableHeader header = returnInfoTable.getTableHeader();
        header.setFont(f);
        header.setBackground(Color.decode("#362159"));
        header.setForeground(Color.white);    
        
    }
     public String autoID(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(return_id) from carsreturned");
            rs.next();
            rs.getString("Max(return_id)");
            if (rs.getString("Max(return_id)")==null){
                return "RE0001";               
            }else{
                long id = Long.parseLong(rs.getString("Max(return_id)").substring(2,rs.getString("Max(return_id)").length()));
                System.out.println("ID  = "+id);
                id++;
                return("RE0"+String.format("%03d",id));                
            }            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
        
    }
    private void returnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBackActionPerformed
        dispose();
    }//GEN-LAST:event_returnBackActionPerformed

    private void returnCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnCarBtnActionPerformed
        // rental info from rantal table to be deleted once the a car is returned and returncar table is updated
        String return_id = rentalID.getText();
        String cust_id = comboCustId.getSelectedItem().toString();
        String car_id = returnCarID.getText();
        String due_date = dueDate.getText();
        String return_date = returnDate.getText();
        String late_days = daysElapsed.getText(); 
        String fine = returnFine.getText();
        String cost = totalRevenue.getText();
        
        long dfine = Integer.valueOf(damage.getText());
        long tcost = Integer.valueOf(cost);
        String finalCost = String.valueOf(dfine+tcost);
        try{                
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
                Statement s = con.createStatement();
                pst = con.prepareStatement("insert into carsreturned(return_id,cust_id,car_id,rentalDate,returnDate,lateDays,fine,totalCost) values(?,?,?,?,?,?,?,?)");
                pst4 = con.prepareStatement("insert into defaulters(cust_id,rental_id,car_id,fine) values(?,?,?,?)");
                
                if (!(damage.getText().equals("0"))){
                    pst5 = con.prepareStatement("update custsecurity set Cust_rating = 'BLACKLIST' where cust_id = ? ");
                    
                    pst5.setString(1,cust_id);
                    pst5.executeUpdate();
                }else{
                    System.out.println("no fine ");
                }
                pst.setString(1,return_id);
                pst.setString(2,cust_id);
                pst.setString(3,car_id);
                pst.setString(4,due_date);
                pst.setString(5,return_date);
                pst.setString(6,late_days);
                pst.setString(7,fine);
                pst.setString(8,finalCost);                
                pst.executeUpdate();
                
                pst4.setString(1,cust_id);
                pst4.setString(2,return_id);
                pst4.setString(3,car_id);
                pst4.setString(4,damage.getText());
                pst4.executeUpdate(); 
                
                // make the car available
                pst1 = con.prepareStatement("update carsrental set available = 'Yes' where car_id = ? ");
                pst1.setString(1,car_id);                
                pst1.executeUpdate();
                // delete correspoding rent record from rental table
                pst2 = con.prepareStatement("delete from rental where car_id = ? and cust_id = ?");
                pst2.setString(1,car_id);
                pst2.setString(2,cust_id);
                pst2.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"Car Returned Successfully!");
                table_update();
                rentalID.setText("");
                returnCarID.setText("");
                dueDate.setText("");
                returnDate.setText("");
                rent.setText("");
                daysElapsed.setText("");
                returnFine.setText("");
                totalRevenue.setText("");
                comboCustId.setSelectedItem("");
                damage.setText("0");
                loadCustID();            
                
               
            }catch(ClassNotFoundException ex){
                Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);            
            }catch(SQLException ex){
                Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
            }        
        
    }//GEN-LAST:event_returnCarBtnActionPerformed

    private void comboCustIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCustIdActionPerformed
        if (comboCustId.getSelectedItem()!=null){
            String cust_id = comboCustId.getSelectedItem().toString();    
            System.out.println(cust_id);
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
                pst1 = con.prepareStatement("select * from rental where cust_id = ?");
                pst1.setString(1,cust_id);
                rs = pst1.executeQuery();
                if (rs.next()==false){
                    JOptionPane.showMessageDialog(this,"Customer Not Found!");
                }else{
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateobj = new Date();
                    System.out.println(df.format(dateobj));
                    returnDate.setText(df.format(dateobj));
                    rentalID.setText(rs.getString("id"));
                    returnCarID.setText(rs.getString("car_id"));                    
                    rent.setText(rs.getString("fee")); 
                    long rentprice = Integer.valueOf(rs.getString("fee"));
                    long dfine = Integer.valueOf(damage.getText());
                    dueDate.setText(rs.getString("due")); 
                    Date date = new Date();
                    Date date1;  
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("due"));
                        long diff = date.getTime()-date1.getTime();
                        if (diff > 0){
                            long diffDays = diff / (24 * 60 * 60 * 1000);
                            System.out.print(diffDays + " days, ");
                            long returnfine = diffDays*1000;
                            daysElapsed.setText(String.valueOf(diffDays));
                            returnFine.setText(String.valueOf(returnfine));
                           
                            long totalrevenue = rentprice + returnfine + dfine;
                            totalRevenue.setText(String.valueOf(totalrevenue)); 
                        }else{
                            daysElapsed.setText("0");
                            returnFine.setText("0");                       
                            totalRevenue.setText(String.valueOf(rentprice));                        
                           // JOptionPane.showMessageDialog(this,"Early return of car will not reduce the rent amount!!!");
                        }                                        
                    } catch (ParseException ex) {
                        Logger.getLogger(returnCar.class.getName()).log(Level.SEVERE, null, ex);
                    }                   

                }

            }catch(ClassNotFoundException ex){
                Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
            }catch(SQLException ex){
                Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
            }
        }

    }//GEN-LAST:event_comboCustIdActionPerformed

    private void returnCarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnCarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnCarIDActionPerformed

    private void rentalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentalIDActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCustId;
    private javax.swing.JTextField damage;
    private javax.swing.JTextField daysElapsed;
    private javax.swing.JTextField dueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rent;
    private javax.swing.JTextField rentalID;
    private javax.swing.JButton returnBack;
    private javax.swing.JButton returnCarBtn;
    private javax.swing.JTextField returnCarID;
    private javax.swing.JTextField returnDate;
    private javax.swing.JTextField returnFine;
    private javax.swing.JTable returnInfoTable;
    private javax.swing.JTextField totalRevenue;
    // End of variables declaration//GEN-END:variables
}
