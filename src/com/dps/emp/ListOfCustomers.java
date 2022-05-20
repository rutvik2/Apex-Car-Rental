/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dps.emp;

import com.dps.admin.AddCar;
import com.dps.admin.AddCompany;
import com.dps.admin.AddEmployee;
import com.dps.admin.AdminPanel;
import com.dps.admin.ListOfEmployees;
import com.dps.admin.ModifyEmp;
import com.dps.admin.ViewCars;
import com.dps.connection.CarRental_Connection;
import com.dps.home.Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ListOfCustomers extends javax.swing.JFrame {
DefaultTableModel dtm;
Connection con;
PreparedStatement psmt=null;
ResultSet rst=null;
CarRental_Connection crcon=new CarRental_Connection(); 
Timer t1,t2,t3,t4;
int p1=40,p2=40,p3=40,p4=60;
    /**
     * Creates new form ListOfCustomers
     */
    public ListOfCustomers() {
        initComponents();
          jTable1.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,16));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setForeground(Color.blue);
        jTable1.setBackground(new Color(0,0,0,150));
          jScrollPane1.setBackground(new Color(0,0,0,100));
       jScrollPane1.getViewport().setOpaque(false);
       jScrollPane1.getViewport().setBackground(new Color(0,0,0,100));
       jTable1.setShowGrid(true);
        dtm=(DefaultTableModel)jTable1.getModel(); 
        getCustomerRecords();
         menu();
    }
    public void menu()
    {
      
        if(Login.id()==1)
        {
             empOff();
              t1 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p1>160)
         {
             t1.stop();
         }
             else
                 {
                    jPanel2.setSize(jPanel2.getWidth(),p1);
                    p1+=20;
                 }
            }
        });     
       t2 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p2>120)
         {
             t2.stop();
         }
             else
                 {
                    jPanel30.setSize(jPanel30.getWidth(),p2);
                    p2+=20;
                 }
            }
        });     
       t3 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p3>160)
         {
             t3.stop();
         }
             else
                 {
                    jPanel34.setSize(jPanel34.getWidth(),p3);
                    p3+=20;
                 }
            }
        });     
       t4 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p4>120)
         {
             t4.stop();
         }
             else
                 {
                    jPanel39.setSize(jPanel39.getWidth(),p4);
                    p4+=20;
                 }
            }
        }); 
        }
        else
        {
            adminOff();
             t1 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p1>160)
         {
             t1.stop();
         }
             else
                 {
                     
                        jPanel1.setSize(jPanel1.getWidth(),p1);
                        p1+=20;
                     
                 }
            }
        });     
       t2 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p2>160)
         {
             t2.stop();
         }
             else
                 {
                    jPanel13.setSize(jPanel13.getWidth(),p2);
                    p2+=20;
                 }
            }
        });     
       t3 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p3>120)
         {
             t3.stop();
         }
             else
                 {
                    jPanel18.setSize(jPanel18.getWidth(),p3);
                    p3+=20;
                 }
            }
        });     
       t4 = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(p4>120)
         {
             t4.stop();
         }
             else
                 {
                    jPanel22.setSize(jPanel22.getWidth(),p4);
                    p4+=20;
                 }
            }
        });  
        }
    }
    public void empOff()
    {
        jPanel1.setVisible(false);
        jPanel13.setVisible(false);
        jPanel18.setVisible(false);
        jPanel22.setVisible(false);
    }
    public void adminOff()
    {
        jPanel2.setVisible(false);
        jPanel30.setVisible(false);
        jPanel34.setVisible(false);
        jPanel39.setVisible(false);
    }
    public void getCustomerRecords()
  {
  
    try {  
         con=crcon.getConnectionDB();
         String str="select name,gender,address,phoneno,company,customerid,driverid,carnumber,rentingdays from customerdetails";
         psmt=con.prepareStatement(str);
        rst=psmt.executeQuery();
       while(rst.next())
       {
           dtm.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9)});
       }
          
               
    }catch(SQLException e)
      {
            JOptionPane.showMessageDialog(null,"Error in connection");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Address", "Phone No.", "Car Company", "Customer ID", "Driver ID", "Car Number", "Renting Days"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(35);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1000, 320));

        jPanel1.setBackground(new java.awt.Color(0, 0, 111));
        jPanel1.setForeground(new java.awt.Color(0, 0, 111));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 0, 111));
        jPanel9.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Driver Records");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 161, 40));

        jPanel10.setBackground(new java.awt.Color(0, 0, 111));
        jPanel10.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel10MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Add Driver");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 161, 40));

        jPanel11.setBackground(new java.awt.Color(0, 0, 111));
        jPanel11.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel11MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("Modify");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel14)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 161, 40));

        jPanel12.setBackground(new java.awt.Color(0, 0, 111));
        jPanel12.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel12MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("List Of Drivers");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 161, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 0, 161, 40));

        jPanel13.setBackground(new java.awt.Color(0, 0, 111));
        jPanel13.setForeground(new java.awt.Color(0, 0, 111));
        jPanel13.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 0, 111));
        jPanel14.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Customer Records");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16))
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 192, 40));

        jPanel15.setBackground(new java.awt.Color(0, 0, 111));
        jPanel15.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel15MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Add Customer");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 192, 40));

        jPanel16.setBackground(new java.awt.Color(0, 0, 111));
        jPanel16.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel16MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Modify");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel18)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 192, 40));

        jPanel17.setBackground(new java.awt.Color(0, 0, 111));
        jPanel17.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel17MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("List Of Customers");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel19)
                .addGap(2, 2, 2))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 192, 40));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 192, 40));

        jPanel18.setBackground(new java.awt.Color(0, 0, 111));
        jPanel18.setForeground(new java.awt.Color(0, 0, 111));
        jPanel18.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(0, 0, 111));
        jPanel19.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel19MouseEntered(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Vehicles");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 129, 40));

        jPanel20.setBackground(new java.awt.Color(0, 0, 111));
        jPanel20.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel20MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("View Cars");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 129, 40));

        jPanel21.setBackground(new java.awt.Color(0, 0, 111));
        jPanel21.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel21MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Return Cars");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 129, 40));

        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 129, 40));

        jPanel22.setBackground(new java.awt.Color(0, 0, 111));
        jPanel22.setForeground(new java.awt.Color(0, 0, 111));
        jPanel22.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
        });
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(0, 0, 111));
        jPanel23.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23MouseEntered(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("Others");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel23)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 188, 40));

        jPanel24.setBackground(new java.awt.Color(0, 0, 111));
        jPanel24.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel24MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24MouseExited(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Change Password");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel24)
                .addContainerGap())
        );

        jPanel22.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 188, 40));

        jPanel25.setBackground(new java.awt.Color(0, 0, 111));
        jPanel25.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel25MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel25MouseExited(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("Log Out");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel25)
                .addGap(37, 37, 37))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );

        jPanel22.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 188, 40));

        getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 188, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 111));
        jPanel2.setForeground(new java.awt.Color(0, 0, 111));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(0, 0, 111));
        jPanel26.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel26MouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Employee");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jPanel2.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel27.setBackground(new java.awt.Color(0, 0, 111));
        jPanel27.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel27MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel27MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel27MouseReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Add Employee");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel27)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, 40));

        jPanel28.setBackground(new java.awt.Color(0, 0, 111));
        jPanel28.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel28MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel28MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel28MouseReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("Modify");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel28)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 190, 40));

        jPanel29.setBackground(new java.awt.Color(0, 0, 111));
        jPanel29.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel29MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel29MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel29MouseReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setText("List Of Employees");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 0, 190, 40));

        jPanel30.setBackground(new java.awt.Color(0, 0, 111));
        jPanel30.setForeground(new java.awt.Color(0, 0, 111));
        jPanel30.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel30MouseExited(evt);
            }
        });
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(0, 0, 111));
        jPanel31.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel31MouseEntered(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 51));
        jLabel30.setText("View Records");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(23, 23, 23))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel30))
        );

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 192, 40));

        jPanel32.setBackground(new java.awt.Color(0, 0, 111));
        jPanel32.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel32MouseReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Customer Records");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 192, 40));

        jPanel33.setBackground(new java.awt.Color(0, 0, 111));
        jPanel33.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel33MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel33MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel33MouseReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("Driver Records");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel32)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 192, 40));

        getContentPane().add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 192, 40));

        jPanel34.setBackground(new java.awt.Color(0, 0, 111));
        jPanel34.setForeground(new java.awt.Color(0, 0, 111));
        jPanel34.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel34MouseExited(evt);
            }
        });
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(0, 0, 111));
        jPanel35.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel35MouseEntered(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 51));
        jLabel33.setText("Vehicles");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel33)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel36.setBackground(new java.awt.Color(0, 0, 111));
        jPanel36.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel36MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel36MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel36MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel36MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel36MouseReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Add company");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 140, 40));

        jPanel37.setBackground(new java.awt.Color(0, 0, 111));
        jPanel37.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel37MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel37MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel37MouseReleased(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 51));
        jLabel35.setText("add car");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel35)
                .addGap(28, 28, 28))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 140, 40));

        jPanel38.setBackground(new java.awt.Color(0, 0, 111));
        jPanel38.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel38MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel38MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel38MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel38MouseReleased(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 51));
        jLabel36.setText("View cars");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel36)
                .addGap(15, 15, 15))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 40));

        getContentPane().add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 140, 40));

        jPanel39.setBackground(new java.awt.Color(0, 0, 111));
        jPanel39.setForeground(new java.awt.Color(0, 0, 111));
        jPanel39.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel39MouseExited(evt);
            }
        });
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(0, 0, 111));
        jPanel40.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel40MouseEntered(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 51));
        jLabel37.setText("Others");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel37)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 188, 40));

        jPanel41.setBackground(new java.awt.Color(0, 0, 111));
        jPanel41.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel41MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel41MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel41MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel41MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel41MouseReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 51));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Change Password");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel38)
                .addContainerGap())
        );

        jPanel39.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 188, 40));

        jPanel42.setBackground(new java.awt.Color(0, 0, 111));
        jPanel42.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel42MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel42MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel42MouseReleased(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 51));
        jLabel39.setText("Log Out");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel39)
                .addGap(37, 37, 37))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );

        jPanel39.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 188, 40));

        getContentPane().add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 188, 40));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/sm.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 51, 49));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/mm.png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 990, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/qq.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 510));

        setSize(new java.awt.Dimension(1002, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
 p1=40;
       jPanel1.setSize(jPanel1.getWidth(),p1);
        p2=40;
       jPanel13.setSize(jPanel13.getWidth(),p2);
        p3=40;
       jPanel18.setSize(jPanel18.getWidth(),p3);
        p4=40;
       jPanel22.setSize(jPanel22.getWidth(),p4);        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        p2=40;
        p3=40;
        p4=40;
        jPanel13.setSize(jPanel13.getWidth(),p2);
        jPanel18.setSize(jPanel18.getWidth(),p3);
        jPanel22.setSize(jPanel22.getWidth(),p4);
        t1.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        jPanel10.setBackground(new Color(29,37,130));
    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseReleased
        jPanel10.setBackground(new Color(0,0,111));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseReleased

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        AddDriver ad=new AddDriver();
        ad.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(new Color(49,57,163));     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        jPanel11.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
        jPanel11.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        ModifyDriver md=new ModifyDriver();
        md.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        jPanel11.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        jPanel11.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        jPanel12.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseReleased
        jPanel12.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseReleased

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        ListOfDrivers lod=new ListOfDrivers();
        lod.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        jPanel12.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        jPanel12.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        t1.stop();
        p1=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        p1=40;
        p3=40;
        p4=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        jPanel18.setSize(jPanel18.getWidth(),p3);
        jPanel22.setSize(jPanel22.getWidth(),p4);

        t2.start();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        jPanel15.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseReleased
        jPanel15.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseReleased

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        AddCustomer ac=new AddCustomer();
        ac.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        jPanel15.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        jPanel15.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        jPanel16.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseReleased
        jPanel16.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseReleased

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        ModifyCustomer mc=new ModifyCustomer();
        mc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        jPanel16.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        jPanel16.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        jPanel17.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseReleased
        jPanel17.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseReleased

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        ListOfCustomers loc=new ListOfCustomers();
        loc.setVisible(true);
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        jPanel17.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        jPanel17.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        t2.stop();
        p2=40;
        jPanel13.setSize(jPanel13.getWidth(),p2);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        p1=40;
        p2=40;
        p4=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        jPanel13.setSize(jPanel13.getWidth(),p2);
        jPanel22.setSize(jPanel22.getWidth(),p4);
        t3.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MousePressed
        jPanel20.setBackground(new Color(29,37,130));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MousePressed

    private void jPanel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseReleased
        jPanel20.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseReleased

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        ViewCars vc=new ViewCars();
        vc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        jPanel20.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        jPanel20.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        jPanel21.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MousePressed

    private void jPanel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseReleased
        jPanel21.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseReleased

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        ReturnCar rc=new ReturnCar();
        rc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        jPanel21.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        jPanel21.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        t3.stop();
        p3=40;
        jPanel18.setSize(jPanel18.getWidth(),p3);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
        p1=40;
        p2=40;
        p3=40;
        jPanel13.setSize(jPanel13.getWidth(),p2);
        jPanel18.setSize(jPanel18.getWidth(),p3);
        jPanel1.setSize(jPanel1.getWidth(),p1);
        t4.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel23MouseEntered

    private void jPanel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MousePressed
        jPanel24.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MousePressed

    private void jPanel24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseReleased
        jPanel24.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MouseReleased

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        ChangePassword cp=new ChangePassword();
        cp.setVisible(true);  
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        jPanel24.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        jPanel24.setBackground(new Color(0,0,111));      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel24MouseExited

    private void jPanel25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MousePressed
        jPanel25.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel25MousePressed

    private void jPanel25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseReleased
        jPanel25.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel25MouseReleased

    private void jPanel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseClicked
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel25MouseClicked

    private void jPanel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseEntered
        jPanel25.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel25MouseEntered

    private void jPanel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseExited
        jPanel25.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel25MouseExited

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        t4.stop();
        p4=40;
        jPanel22.setSize(jPanel22.getWidth(),p4);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel22MouseExited

    private void jPanel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseEntered
        p2=40;
        p3=40;
        p4=40;
        jPanel13.setSize(jPanel30.getWidth(),p2);
        jPanel18.setSize(jPanel34.getWidth(),p3);
        jPanel22.setSize(jPanel39.getWidth(),p4);
        t1.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel26MouseEntered

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        AddEmployee ae=new AddEmployee();
        ae.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jPanel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseEntered
        jPanel27.setBackground(new Color(49,57,163));     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseEntered

    private void jPanel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseExited
        jPanel27.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseExited

    private void jPanel27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MousePressed
 jPanel27.setBackground(new Color(29,37,130));
    }//GEN-LAST:event_jPanel27MousePressed

    private void jPanel27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseReleased
        jPanel27.setBackground(new Color(0,0,111));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseReleased

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
        ModifyEmp me=new ModifyEmp();
        me.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jPanel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseEntered
        jPanel28.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseEntered

    private void jPanel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseExited
        jPanel28.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseExited

    private void jPanel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MousePressed
        jPanel28.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MousePressed

    private void jPanel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseReleased
        jPanel28.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseReleased

    private void jPanel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseClicked
         ListOfEmployees loe=new ListOfEmployees();
        loe.setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseClicked

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
        jPanel29.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited
        jPanel29.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseExited

    private void jPanel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MousePressed
        jPanel29.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MousePressed

    private void jPanel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseReleased
        jPanel29.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseReleased

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        t1.stop();
        p1=40;
        jPanel2.setSize(jPanel2.getWidth(),p1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseEntered
        p1=40;
        p3=40;
        p4=40;
        jPanel2.setSize(jPanel2.getWidth(),p1);
        jPanel34.setSize(jPanel34.getWidth(),p3);
        jPanel39.setSize(jPanel39.getWidth(),p4);

        t2.start();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel31MouseEntered

    private void jPanel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseClicked
        ListOfCustomers loc=new ListOfCustomers();
        loc.setVisible(true);
        this.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseClicked

    private void jPanel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseEntered
        jPanel32.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseEntered

    private void jPanel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseExited
        jPanel32.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseExited

    private void jPanel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MousePressed
        jPanel32.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MousePressed

    private void jPanel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseReleased
        jPanel32.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseReleased

    private void jPanel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseClicked
        ListOfDrivers lod=new ListOfDrivers();
        lod.setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseClicked

    private void jPanel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseEntered
        jPanel33.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseEntered

    private void jPanel33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseExited
        jPanel33.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseExited

    private void jPanel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MousePressed
        jPanel33.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MousePressed

    private void jPanel33MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseReleased
        jPanel33.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseReleased

    private void jPanel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseExited
        t2.stop();
        p2=40;
        jPanel30.setSize(jPanel30.getWidth(),p2);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseExited

    private void jPanel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel35MouseEntered
        p1=40;
        p2=40;
        p4=40;
        jPanel2.setSize(jPanel2.getWidth(),p1);
        jPanel30.setSize(jPanel30.getWidth(),p2);
        jPanel39.setSize(jPanel39.getWidth(),p4);
        t3.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel35MouseEntered

    private void jPanel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseClicked
        AddCompany ac=new AddCompany();
        ac.setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MouseClicked

    private void jPanel36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseEntered
        jPanel36.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MouseEntered

    private void jPanel36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseExited
        jPanel36.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MouseExited

    private void jPanel36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MousePressed
        jPanel36.setBackground(new Color(29,37,130));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MousePressed

    private void jPanel36MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseReleased
        jPanel36.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MouseReleased

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        AddCar ac=new AddCar();
        ac.setVisible(true);
        this.setVisible(false);     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void jPanel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseEntered
        jPanel37.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseEntered

    private void jPanel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseExited
        jPanel37.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseExited

    private void jPanel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MousePressed
        jPanel37.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MousePressed

    private void jPanel37MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseReleased
        jPanel37.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseReleased

    private void jPanel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseClicked
        ViewCars vc=new ViewCars();
        vc.setVisible(true);
        this.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseClicked

    private void jPanel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseEntered
        jPanel38.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseEntered

    private void jPanel38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseExited
        jPanel38.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseExited

    private void jPanel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MousePressed
        jPanel38.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MousePressed

    private void jPanel38MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseReleased
        jPanel38.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseReleased

    private void jPanel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MouseExited
        t3.stop();
        p3=40;
        jPanel34.setSize(jPanel34.getWidth(),p3);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MouseExited

    private void jPanel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseEntered
        p1=40;
        p2=40;
        p3=40;
        jPanel30.setSize(jPanel30.getWidth(),p2);
        jPanel34.setSize(jPanel34.getWidth(),p3);
        jPanel2.setSize(jPanel2.getWidth(),p1);
        t4.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel40MouseEntered

    private void jPanel41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MousePressed
        jPanel41.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MousePressed

    private void jPanel41MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseReleased
        jPanel41.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MouseReleased

    private void jPanel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseClicked
        ChangePassword cp=new ChangePassword();
        cp.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MouseClicked

    private void jPanel41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseEntered
        jPanel41.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MouseEntered

    private void jPanel41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseExited
        jPanel41.setBackground(new Color(0,0,111));      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MouseExited

    private void jPanel42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MousePressed
        jPanel42.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MousePressed

    private void jPanel42MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseReleased
        jPanel42.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MouseReleased

    private void jPanel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseClicked
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MouseClicked

    private void jPanel42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseEntered
        jPanel42.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MouseEntered

    private void jPanel42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseExited
        jPanel42.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MouseExited

    private void jPanel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel39MouseExited
        t4.stop();
        p4=40;
        jPanel39.setSize(jPanel39.getWidth(),p4);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel39MouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        p1=40;
       jPanel1.setSize(jPanel1.getWidth(),p1);
       jPanel2.setSize(jPanel2.getWidth(),p1);
        p2=40;
       jPanel13.setSize(jPanel13.getWidth(),p2);
       jPanel30.setSize(jPanel30.getWidth(),p2);
        p3=40;
       jPanel18.setSize(jPanel18.getWidth(),p3);
       jPanel34.setSize(jPanel34.getWidth(),p3);
        p4=40;
       jPanel22.setSize(jPanel22.getWidth(),p4);   
       jPanel39.setSize(jPanel39.getWidth(),p4);   
    }//GEN-LAST:event_formMouseEntered

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
if(Login.id()==1)
{
    AdminPanel ap=new AdminPanel();
     ap.setVisible(true);
        this.dispose();
}
else
{
    EmpPanel ep=new EmpPanel();
     ep.setVisible(true);
        this.dispose();
}
           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

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
            java.util.logging.Logger.getLogger(ListOfCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfCustomers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
