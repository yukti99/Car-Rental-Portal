/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import carrental.welcome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Admin.carRegistration;
import extra.customerRegistration;

/**
 *
 * @author yukti
 */
public class rentACar extends javax.swing.JFrame {

    /**
     * Creates new form rentACar
     */
    public rentACar() {
        initComponents();
        String cust_id = userLogin.cust_id;
        checkForRent(cust_id);       
        
        String userName = userLogin.name;
        txtwelcome.setText(userName);
        table_font();
        table_update();
    }
    Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs;
    String rentalID;
    String custid = userLogin.cust_id;
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        bgPanel = new javax.swing.JPanel();
        getCarBtn = new javax.swing.JButton();
        fromDate = new com.toedter.calendar.JDateChooser();
        toDate = new com.toedter.calendar.JDateChooser();
        carImage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalCost = new javax.swing.JTextField();
        tablePane = new javax.swing.JScrollPane();
        carsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        sidepane = new javax.swing.JPanel();
        txtwelcome = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        carRegister = new javax.swing.JButton();
        rentHistory = new javax.swing.JButton();
        myRents = new javax.swing.JButton();
        cancelRent = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("The rent fee is not 100% refundable. ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 360, 50));

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));

        getCarBtn.setBackground(new java.awt.Color(85, 65, 118));
        getCarBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getCarBtn.setForeground(new java.awt.Color(54, 33, 89));
        getCarBtn.setText("Get Car");
        getCarBtn.setBorder(null);
        getCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCarBtnActionPerformed(evt);
            }
        });

        fromDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        toDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        carImage.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        carImage.setForeground(new java.awt.Color(54, 33, 89));
        carImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carImage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 33, 89));
        jLabel5.setText("From");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(54, 33, 89));
        jLabel4.setText("To");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(54, 33, 89));
        jLabel6.setText("Cost(Rs.)");

        totalCost.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        carsTable.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        carsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID", "Make", "Model", "Color", "Capacity", "Cost/day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        carsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carsTableMouseClicked(evt);
            }
        });
        tablePane.setViewportView(carsTable);

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(53, 53, 53)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fromDate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(toDate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(totalCost))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                        .addComponent(getCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addComponent(carImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPanelLayout.createSequentialGroup()
                        .addComponent(carImage, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalCost))
                        .addGap(18, 18, 18)
                        .addComponent(getCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 910, 550));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rent Cars");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, -20, 280, 130));

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

        rentHistory.setBackground(new java.awt.Color(85, 65, 118));
        rentHistory.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        rentHistory.setForeground(new java.awt.Color(204, 204, 204));
        rentHistory.setText("Rent History");
        rentHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentHistoryActionPerformed(evt);
            }
        });
        sidepane.add(rentHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 260, 50));

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void checkForRent(String cust_id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from rental where cust_id = ?");  
            pst.setString(1,cust_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                bgPanel.setVisible(false);
                JOptionPane.showMessageDialog(this,"Sorry you cannot rent another car before you return the previous one!!");                
            }
               
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
        
    }
    public void table_font(){
        carsTable.setBackground(Color.decode("#554176"));        
        // set Font To table
        carsTable.setFont(new Font("Calibri", 1, 18));        
        // set height to the table rows
        carsTable.setRowHeight(25);        
        // set color to the JTable Font
        carsTable.setForeground(Color.white);        
        tablePane.setFont(new Font("", 1, 20));
        tablePane.setForeground(Color.white);
        tablePane.setBackground(Color.decode("#362159"));
        carsTable.setPreferredScrollableViewportSize(new Dimension(500, 70)); 
        // set font for headers
        Font f = new Font("Calibri", Font.BOLD, 22);
        JTableHeader header = carsTable.getTableHeader();
        header.setFont(f);
        header.setBackground(Color.decode("#362159"));
        header.setForeground(Color.white);    
        
    }
     public void table_update(){
        int c;
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            pst = con.prepareStatement("select * from carsrental");  
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)carsTable.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                if (rs.getString("available").equals("Yes")){
                    for(int i=1;i<=c;i++){
                        v2.add(rs.getString("car_id"));
                        v2.add(rs.getString("make"));
                        v2.add(rs.getString("model"));
                        v2.add(rs.getString("color"));
                        v2.add(rs.getString("capacity"));
                        if (rs.getString("rentalCost")==null){
                            v2.add("null");
                        }else{
                            v2.add(rs.getString("rentalCost"));
                        }
                    }
                    df.addRow(v2);  
                }
            }         
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }        
    }    
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        dispose();
        updateProfile u = new updateProfile();
        u.setVisible(true);
    }//GEN-LAST:event_updatebtnActionPerformed

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutBtnActionPerformed
        dispose();
        about a = new about();
        a.setVisible(true);
    }//GEN-LAST:event_aboutBtnActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
        welcome w = new welcome();
        w.setVisible(true);

    }//GEN-LAST:event_exitActionPerformed

    private void carRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carRegisterActionPerformed
       
    }//GEN-LAST:event_carRegisterActionPerformed

    private void rentHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentHistoryActionPerformed
        dispose();
        RentHistory rh = new RentHistory();
        rh.setVisible(true);
    }//GEN-LAST:event_rentHistoryActionPerformed

    private void getCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCarBtnActionPerformed

        SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat Date_Format2 = new SimpleDateFormat("yyyy-MM-dd");
        if (fromDate.getDate()==null){
            JOptionPane.showMessageDialog(this,"Please enter when do you want to rent the car!");
        }
        else{
            if (toDate.getDate()==null){
                JOptionPane.showMessageDialog(this,"Please enter till when do you want to rent the car!");

            }else{
                String from = Date_Format1.format(fromDate.getDate());
                String to = Date_Format2.format(toDate.getDate());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();

                long diff = toDate.getDate().getTime() - fromDate.getDate().getTime();
                long fDate = fromDate.getDate().getTime()-date.getTime();
                System.out.println("Fadate = "+fDate);
                if (fDate < 0){
                    JOptionPane.showMessageDialog(this,"Please enter a valid from date!!");
                }
                else{
                    long diffSeconds = diff / 1000 % 60;
                    long diffMinutes = diff / (60 * 1000) % 60;
                    long diffHours = diff / (60 * 60 * 1000) % 24;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    System.out.print(diffDays + " days, ");
                    System.out.print(diffHours + " hours, ");
                    System.out.print(diffMinutes + " minutes, ");
                    System.out.print(diffSeconds + " seconds.");
                    if (diffDays > 5){
                        JOptionPane.showMessageDialog(this,"Sorry a car can only be rented for maximum 5 days!");
                    }else{
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
                            Statement s = con.createStatement();
                            DefaultTableModel d1 = (DefaultTableModel)carsTable.getModel();
                            int selectIndex = carsTable.getSelectedRow();
                            String car_id = d1.getValueAt(selectIndex,0).toString();
                            //String cust_id = "";
                            long costperday = Integer.parseInt(d1.getValueAt(selectIndex,5).toString());
                            String fee = String.valueOf(costperday*diffDays);
                            totalCost.setText(fee);
                            String id = autoID();
                            // getting all the info from rental table
                            pst = con.prepareStatement("insert into rental(id,car_id,cust_id,fee,date,due) values(?,?,?,?,?,?)");
                            pst.setString(1,id);
                            pst.setString(2,car_id);
                            pst.setString(3,custid);
                            pst.setString(4,fee);
                            pst.setString(5,from);
                            pst.setString(6,to);
                            pst.executeUpdate();
                            // making the rented car unavailable
                            pst1 = con.prepareStatement("update carsrental set available = 'No' where car_id = ? ");
                            pst1.setString(1,car_id);
                            pst1.executeUpdate();
                            JOptionPane.showMessageDialog(this,"Car Rented Successfully!!");
                            JOptionPane.showMessageDialog(this,"Your Rental ID = "+id);                            

                        }catch(ClassNotFoundException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                        }catch(SQLException ex){
                            Logger.getLogger(customerRegistration.class.getName()).log(Level.SEVERE,null,ex);
                        }

                    }
                }

            }
    }//GEN-LAST:event_getCarBtnActionPerformed
    }
    public String autoID(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(id) from rental");
            rs.next();
            rs.getString("Max(id)");
            if (rs.getString("Max(id)")==null){
                return "R0001";
            }else{
                long id = Long.parseLong(rs.getString("Max(id)").substring(2,rs.getString("Max(id)").length()));
                System.out.println("RENTAL ID  = "+id);
                id++;
                String r = "R0"+String.format("%03d",id);
                return r;
            }            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);            
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;        
    }
    private void carsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carsTableMouseClicked
        String car_id = null;
        DefaultTableModel d1 = (DefaultTableModel)carsTable.getModel();
        int selectIndex = carsTable.getSelectedRow();
        carImage.setIcon(null);
        car_id = d1.getValueAt(selectIndex,0).toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cars","root","");
            pst = con.prepareStatement("select image from carsrental where car_id = ? ");
            pst.setString(1,car_id);
            ResultSet rs = pst.executeQuery();
            System.out.println("car_id = "+car_id);
            if(rs.next()){
                Blob blb = rs.getBlob("image");
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

            } else{
                System.out.println("rs null");
            }

        }catch(ClassNotFoundException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(carRegistration.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_carsTableMouseClicked

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
            java.util.logging.Logger.getLogger(rentACar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rentACar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rentACar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rentACar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rentACar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutBtn;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton cancelRent;
    private javax.swing.JLabel carImage;
    private javax.swing.JButton carRegister;
    private javax.swing.JTable carsTable;
    private javax.swing.JButton exit;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JButton getCarBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton myRents;
    private javax.swing.JButton rentHistory;
    private javax.swing.JPanel sidepane;
    private javax.swing.JScrollPane tablePane;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JTextField totalCost;
    private javax.swing.JLabel txtwelcome;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
