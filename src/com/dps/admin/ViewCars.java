/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dps.admin;

import com.dps.connection.CarRental_Connection;
import com.dps.emp.AddCustomer;
import com.dps.emp.AddDriver;
import com.dps.emp.ChangePassword;
import com.dps.emp.EmpPanel;
import com.dps.emp.ListOfCustomers;
import com.dps.emp.ListOfDrivers;
import com.dps.emp.ModifyCustomer;
import com.dps.emp.ModifyDriver;
import com.dps.emp.ReturnCar;
import com.dps.home.Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ViewCars extends javax.swing.JFrame {
DefaultTableModel dtm;
Connection con;
PreparedStatement psmt=null;
ResultSet rst=null;
CarRental_Connection crcon=new CarRental_Connection(); 
Timer t1,t2,t3,t4;
int p1=40,p2=40,p3=40,p4=60;
    /**
     * Creates new form ViewCars
     */
    public ViewCars() {
        initComponents();
         dtm=(DefaultTableModel)jTable1.getModel(); 
        intoCombo();
        jPanel2.setBackground(new Color(0,0,0,50));
            jTable1.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,16));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setForeground(Color.blue);
        jTable1.setBackground(new Color(0,0,0,150));
          jScrollPane1.setBackground(new Color(0,0,0,150));
       jScrollPane1.getViewport().setOpaque(false);
       jScrollPane1.getViewport().setBackground(new Color(0,0,0,150));
       jTable1.setShowGrid(true);
       
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(27);
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
                    jPanel1.setSize(jPanel1.getWidth(),p1);
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
                    jPanel13.setSize(jPanel13.getWidth(),p2);
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
                    jPanel3.setSize(jPanel3.getWidth(),p1);
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
                    jPanel30.setSize(jPanel30.getWidth(),p2);
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
                    jPanel35.setSize(jPanel35.getWidth(),p3);
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
    }
    public void adminOff()
    {
        jPanel1.setVisible(false);
        jPanel13.setVisible(false);
        jPanel18.setVisible(false);
        jPanel22.setVisible(false);
    }
    public void empOff()
    {
        jPanel3.setVisible(false);
        jPanel30.setVisible(false);
        jPanel35.setVisible(false);
        jPanel39.setVisible(false);
    }
        
     public void getCarRecords()
  {
      dtm.setRowCount(0);
    String comp=jComboBox1.getSelectedItem().toString();
         String use=jComboBox2.getSelectedItem().toString();
         String status=jComboBox3.getSelectedItem().toString();
    try {  
       
         con=crcon.getConnectionDB();
         
         String str="select model,company,carnumber,makeyear,seat_cap,engine_cap,type,varient,rent,driverid,status from servicecars where type is not null";
         String str1=" AND company='"+comp+"'";
         String str2=" AND useas='"+use+"'";
         String str3=" AND status='"+status+"'";
         if(comp.equals("Select"))
         {
             str1="";
         }
         if(use.equals("Select"))
         {
             str2="";
         }
         if(status.equals("Select"))
         {
             str3="";
         }
         String qry=str+str1+str2+str3;
         psmt=con.prepareStatement(qry);
        rst=psmt.executeQuery();
       while(rst.next())
       {
           dtm.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11)} );
       }
           
    }catch(SQLException e)
      {
          
            JOptionPane.showMessageDialog(null,"Error in connection");
      }  
}
     public void intoCombo()
    {
         jComboBox1.removeAllItems();
       jComboBox1.addItem("Select");
        String[] comp=new String[50];
    comp=crcon.getCompanyList();
    int i=0;
    while(i<Integer.parseInt(comp[0]))
    {
        ++i;
        jComboBox1.addItem(comp[i]);
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

        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel33 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 188, 40));

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

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel20.setBackground(new java.awt.Color(0, 0, 111));
        jPanel20.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel20MouseReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Add company");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 140, 40));

        jPanel21.setBackground(new java.awt.Color(0, 0, 111));
        jPanel21.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel21MouseReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("add car");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addGap(28, 28, 28))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 140, 40));

        jPanel17.setBackground(new java.awt.Color(0, 0, 111));
        jPanel17.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel17MouseReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("View cars");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addGap(15, 15, 15))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 40));

        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 140, 40));

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
        jLabel16.setText("View Records");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(23, 23, 23))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel16))
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 192, 40));

        jPanel15.setBackground(new java.awt.Color(0, 0, 111));
        jPanel15.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel15MouseReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Customer Records");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel16MouseReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Driver Records");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 192, 40));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 192, 40));

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

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Employee");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel10.setBackground(new java.awt.Color(0, 0, 111));
        jPanel10.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel10MouseReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Add Employee");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, 40));

        jPanel11.setBackground(new java.awt.Color(0, 0, 111));
        jPanel11.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel11MouseReleased(evt);
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
                .addGap(52, 52, 52)
                .addComponent(jLabel14)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 190, 40));

        jPanel12.setBackground(new java.awt.Color(0, 0, 111));
        jPanel12.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel12MouseReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("List Of Employees");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 190, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 111));
        jPanel3.setForeground(new java.awt.Color(0, 0, 111));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(0, 0, 111));
        jPanel26.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel26MouseEntered(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Driver Records");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5))
        );

        jPanel3.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 161, 40));

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
        jLabel27.setText("Add Driver");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel27)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 161, 40));

        jPanel28.setBackground(new java.awt.Color(0, 0, 111));
        jPanel28.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel28MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel28MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel28MouseExited(evt);
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
                .addGap(41, 41, 41)
                .addComponent(jLabel28)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 161, 40));

        jPanel29.setBackground(new java.awt.Color(0, 0, 111));
        jPanel29.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel29MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel29MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel29MouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setText("List Of Drivers");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel29)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 161, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 161, 40));

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
        jLabel30.setText("Customer Records");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel30))
        );

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 192, 40));

        jPanel32.setBackground(new java.awt.Color(0, 0, 111));
        jPanel32.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel32MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel32MouseExited(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Add Customer");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel31)
                .addContainerGap(25, Short.MAX_VALUE))
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel33MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel33MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel33MouseExited(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("Modify");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel32)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        jPanel30.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 192, 40));

        jPanel34.setBackground(new java.awt.Color(0, 0, 111));
        jPanel34.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel34MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel34MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel34MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel34MouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 51));
        jLabel33.setText("List Of Customers");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel33)
                .addGap(2, 2, 2))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 192, 40));

        getContentPane().add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 192, 40));

        jPanel35.setBackground(new java.awt.Color(0, 0, 111));
        jPanel35.setForeground(new java.awt.Color(0, 0, 111));
        jPanel35.setPreferredSize(new java.awt.Dimension(120, 160));
        jPanel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel35MouseExited(evt);
            }
        });
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(0, 0, 111));
        jPanel36.setMinimumSize(new java.awt.Dimension(120, 40));
        jPanel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel36MouseEntered(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setText("Vehicles");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel34)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 129, 40));

        jPanel37.setBackground(new java.awt.Color(0, 0, 111));
        jPanel37.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel37MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel37MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel37MouseExited(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("View Cars");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 129, 40));

        jPanel38.setBackground(new java.awt.Color(0, 0, 111));
        jPanel38.setMaximumSize(new java.awt.Dimension(120, 40));
        jPanel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel38MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel38MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel38MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel38MouseExited(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 51));
        jLabel36.setText("Return Cars");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 129, 40));

        getContentPane().add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 129, 40));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel42MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel42MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel42MouseExited(evt);
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

        getContentPane().add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 188, 40));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/sm.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 51, 49));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/mm.png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 990, 70));

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Model", "Company", "Number", "Make Year", "Seating Capacity", "Engine Capacity", "Type", "Varient", "Rent", "Driver ID", "Status"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(35);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(204, 51, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1010, 297));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Company");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Use As");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 170, 30));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Individual Rent", "With Driver" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 170, 30));

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Rented", "Not Rented" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 170, 30));

        jButton3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("view available cars");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 220, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/sd.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        setSize(new java.awt.Dimension(969, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        p1=40;
        p2=40;
        p4=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        jPanel13.setSize(jPanel13.getWidth(),p2);
        jPanel22.setSize(jPanel22.getWidth(),p4);
        t3.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        AddCompany ac=new AddCompany();
        ac.setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        jPanel20.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        jPanel20.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MousePressed
        jPanel20.setBackground(new Color(29,37,130));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MousePressed

    private void jPanel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseReleased
        jPanel20.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseReleased

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        AddCar ac=new AddCar();
        ac.setVisible(true);
        this.setVisible(false);     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        jPanel21.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        jPanel21.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        jPanel21.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MousePressed

    private void jPanel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseReleased
        jPanel21.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseReleased

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        ViewCars vc=new ViewCars();
        vc.setVisible(true);
        this.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        jPanel17.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        jPanel17.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        jPanel17.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseReleased
        jPanel17.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseReleased

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        t3.stop();
        p3=40;
        jPanel18.setSize(jPanel18.getWidth(),p3);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        p1=40;
        p3=40;
        p4=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        jPanel18.setSize(jPanel18.getWidth(),p3);
        jPanel22.setSize(jPanel22.getWidth(),p4);

        t2.start();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        ListOfCustomers loc=new ListOfCustomers();
        loc.setVisible(true);
        this.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        jPanel15.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        jPanel15.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        jPanel15.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseReleased
        jPanel15.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseReleased

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        ListOfDrivers lod=new ListOfDrivers();
        lod.setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        jPanel16.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        jPanel16.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        jPanel16.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseReleased
        jPanel16.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseReleased

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        t2.stop();
        p2=40;
        jPanel13.setSize(jPanel13.getWidth(),p2);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        p2=40;
        p3=40;
        p4=40;
        jPanel13.setSize(jPanel13.getWidth(),p2);
        jPanel18.setSize(jPanel18.getWidth(),p3);
        jPanel22.setSize(jPanel22.getWidth(),p4);
        t1.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        AddEmployee ae=new AddEmployee();
        ae.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(new Color(49,57,163));     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed

    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseReleased
        jPanel10.setBackground(new Color(0,0,111));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseReleased

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        ModifyEmp me=new ModifyEmp();
        me.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        jPanel11.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        jPanel11.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        jPanel11.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
        jPanel11.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
  ListOfEmployees loe=new ListOfEmployees();
        loe.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        jPanel12.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        jPanel12.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        jPanel12.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseReleased
        jPanel12.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseReleased

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        t1.stop();
        p1=40;
        jPanel1.setSize(jPanel1.getWidth(),p1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseExited

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        jButton3.setOpaque(true);
        jButton3.setBackground(new Color(0,0,0,50));
        jButton3.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black, Color.white, Color.white));          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        jButton3.setOpaque(false);

        jButton3.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white, Color.black, Color.black));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black, Color.white, Color.white));      // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white, Color.black, Color.black));        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   getCarRecords();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
  p1=40;
       jPanel1.setSize(jPanel1.getWidth(),p1);
       jPanel3.setSize(jPanel3.getWidth(),p1);
        p2=40;
       jPanel13.setSize(jPanel13.getWidth(),p2);
       jPanel30.setSize(jPanel30.getWidth(),p2);
        p3=40;
       jPanel18.setSize(jPanel18.getWidth(),p3);
       jPanel35.setSize(jPanel35.getWidth(),p3);
        p4=40;
       jPanel22.setSize(jPanel22.getWidth(),p4);   
       jPanel39.setSize(jPanel39.getWidth(),p4);  
    }//GEN-LAST:event_formMouseEntered

    private void jPanel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseEntered
        p2=40;
        p3=40;
        p4=40;
        jPanel30.setSize(jPanel30.getWidth(),p2);
        jPanel35.setSize(jPanel35.getWidth(),p3);
        jPanel39.setSize(jPanel39.getWidth(),p4);
        t1.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel26MouseEntered

    private void jPanel27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MousePressed
   jPanel27.setBackground(new Color(29,37,130));  
    }//GEN-LAST:event_jPanel27MousePressed

    private void jPanel27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseReleased
        jPanel28.setBackground(new Color(0,0,111));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseReleased

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        AddDriver ad=new AddDriver();
        ad.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jPanel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseEntered
        jPanel27.setBackground(new Color(49,57,163));     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseEntered

    private void jPanel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseExited
        jPanel27.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseExited

    private void jPanel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MousePressed
        jPanel28.setBackground(new Color(29,37,130));         // TODO add your handling code here:

    }//GEN-LAST:event_jPanel28MousePressed

    private void jPanel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseReleased
        jPanel28.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseReleased

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
        ModifyDriver md=new ModifyDriver();
        md.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jPanel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseEntered
        jPanel28.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseEntered

    private void jPanel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseExited
        jPanel28.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseExited

    private void jPanel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MousePressed
        jPanel29.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MousePressed

    private void jPanel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseReleased
        jPanel29.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseReleased

    private void jPanel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseClicked
        ListOfDrivers lod=new ListOfDrivers();
        lod.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseClicked

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
        jPanel29.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited
        jPanel29.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseExited

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        t1.stop();
        p1=40;
        jPanel3.setSize(jPanel3.getWidth(),p1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseEntered
        p1=40;
        p3=40;
        p4=40;
        jPanel3.setSize(jPanel3.getWidth(),p1);
        jPanel35.setSize(jPanel35.getWidth(),p3);
        jPanel39.setSize(jPanel39.getWidth(),p4);

        t2.start();    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel31MouseEntered

    private void jPanel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MousePressed
        jPanel32.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MousePressed

    private void jPanel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseReleased
        jPanel32.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseReleased

    private void jPanel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseClicked
        AddCustomer ac=new AddCustomer();
        ac.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseClicked

    private void jPanel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseEntered
        jPanel32.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseEntered

    private void jPanel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseExited
        jPanel32.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel32MouseExited

    private void jPanel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MousePressed
        jPanel33.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MousePressed

    private void jPanel33MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseReleased
        jPanel33.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseReleased

    private void jPanel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseClicked
        ModifyCustomer mc=new ModifyCustomer();
        mc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseClicked

    private void jPanel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseEntered
        jPanel33.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseEntered

    private void jPanel33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseExited
        jPanel33.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel33MouseExited

    private void jPanel34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MousePressed
        jPanel34.setBackground(new Color(29,37,130));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MousePressed

    private void jPanel34MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MouseReleased
        jPanel34.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MouseReleased

    private void jPanel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MouseClicked
        ListOfCustomers loc=new ListOfCustomers();
        loc.setVisible(true);
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MouseClicked

    private void jPanel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MouseEntered
        jPanel34.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MouseEntered

    private void jPanel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel34MouseExited
        jPanel34.setBackground(new Color(0,0,111));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel34MouseExited

    private void jPanel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseExited
        t2.stop();
        p2=40;
        jPanel30.setSize(jPanel30.getWidth(),p2);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseExited

    private void jPanel36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel36MouseEntered
        p1=40;
        p2=40;
        p4=40;
        jPanel3.setSize(jPanel3.getWidth(),p1);
        jPanel30.setSize(jPanel30.getWidth(),p2);
        jPanel39.setSize(jPanel39.getWidth(),p4);
        t3.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel36MouseEntered

    private void jPanel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MousePressed
        jPanel37.setBackground(new Color(29,37,130));       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MousePressed

    private void jPanel37MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseReleased
        jPanel37.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseReleased

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        ViewCars vc=new ViewCars();
        vc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void jPanel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseEntered
        jPanel37.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseEntered

    private void jPanel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseExited
        jPanel37.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseExited

    private void jPanel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MousePressed
        jPanel38.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MousePressed

    private void jPanel38MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseReleased
        jPanel38.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseReleased

    private void jPanel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseClicked
        ReturnCar rc=new ReturnCar();
        rc.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseClicked

    private void jPanel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseEntered
        jPanel38.setBackground(new Color(49,57,163));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseEntered

    private void jPanel38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseExited
        jPanel38.setBackground(new Color(0,0,111));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel38MouseExited

    private void jPanel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel35MouseExited
        t3.stop();
        p3=40;
        jPanel35.setSize(jPanel35.getWidth(),p3);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel35MouseExited

    private void jPanel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseEntered
        p1=40;
        p2=40;
        p3=40;
        jPanel30.setSize(jPanel30.getWidth(),p2);
        jPanel35.setSize(jPanel35.getWidth(),p3);
        jPanel3.setSize(jPanel3.getWidth(),p1);
        t4.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel40MouseEntered

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

    private void jPanel41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MousePressed
        jPanel41.setBackground(new Color(29,37,130));         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MousePressed

    private void jPanel41MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseReleased
        jPanel41.setBackground(new Color(0,0,111));          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel41MouseReleased

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
            java.util.logging.Logger.getLogger(ViewCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel3;
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
