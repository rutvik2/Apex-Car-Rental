package com.dps.home;

import com.dps.connection.CarRental_Connection;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    static int user;      
    int eyeClick=0;
    CarRental_Connection crcon=null; //connection class object

    public Login() {
        initComponents();
        crcon=CarRental_Connection.getInstance();
        this.setTitle("Login");
        this.getContentPane().setBackground(new Color(20,20,197));

        logoPanel.setBackground(new Color(0,0,0,200));
        loginformPanel.setBackground(new Color(0,0,0,130));
        loginButton.setBackground(new Color(0,0,0,100));
        user_txt.setBackground(new Color(0,0,0,0));
        psd_txt.setBackground(new Color(0,0,0,0));
        psd_txt.setEchoChar((char)0);   
    }
    
    public static int id() //this will be used by other classes to access the current logged in employee
    {
        return user; 
    }
    
    public void empty() 
    {
        if(user_txt.getText().equals("Enter Username"))
        {
            jLabel9.setForeground(Color.red);
            jLabel9.setText("Field cannot be empty");
        }
        if(psd_txt.getText().equals("Enter Password"))
        {
            jLabel7.setForeground(Color.red);
            jLabel7.setText("Field cannot be empty");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_txt = new javax.swing.JTextField();
        psd_txt = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        eye = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        loginformPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 30));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 140, -1));

        user_txt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        user_txt.setForeground(new java.awt.Color(153, 153, 153));
        user_txt.setText("Enter Username");
        user_txt.setAutoscrolls(false);
        user_txt.setBorder(null);
        user_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        user_txt.setOpaque(false);
        user_txt.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        user_txt.setSelectionColor(new java.awt.Color(204, 204, 255));
        user_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_txtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_txtFocusLost(evt);
            }
        });
        jPanel1.add(user_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 260, 30));

        psd_txt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        psd_txt.setForeground(new java.awt.Color(153, 153, 153));
        psd_txt.setText("Enter Password");
        psd_txt.setAutoscrolls(false);
        psd_txt.setBorder(null);
        psd_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        psd_txt.setOpaque(false);
        psd_txt.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        psd_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                psd_txtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                psd_txtFocusLost(evt);
            }
        });
        jPanel1.add(psd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 220, 30));

        loginButton.setBackground(new java.awt.Color(51, 51, 51));
        loginButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Log In");
        loginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));
        loginButton.setContentAreaFilled(false);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtonMouseReleased(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 100, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 300, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 300, 10));

        eye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/hide.png"))); // NOI18N
        eye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeMouseClicked(evt);
            }
        });
        jPanel1.add(eye, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/_24px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 30, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/_30px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/grp.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 120, 80));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 200, 20));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 200, 20));
        jPanel1.add(loginformPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 400, 500));

        logoPanel.setRequestFocusEnabled(false);
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/imageedit_1_5182548822.png"))); // NOI18N
        logoPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 490, 140));

        getContentPane().add(logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 580, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dps/img/13.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-400, 0, 1020, 500));

        setSize(new java.awt.Dimension(1000, 515));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        empty();
        user=crcon.checkLoginDetails(user_txt.getText(),String.valueOf(psd_txt.getPassword())); //returns unique id of employee
        if(user>0)
        {
            Loading l =new Loading();
            l.setVisible(true);
            this.dispose();
        }        
        else
        {
            JOptionPane.showMessageDialog(null,"Wrong User ID or Password","",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_loginButtonActionPerformed

    //below button related code is for the beveled and responsive effect of the button
    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(0,69,177));
        loginButton.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black, Color.white, Color.white)); 
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        loginButton.setOpaque(false);
        loginButton.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white, Color.black, Color.black));
    }//GEN-LAST:event_loginButtonMouseExited

    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(0,0,140));
        loginButton.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black, Color.white, Color.white)); // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonMousePressed

    private void loginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseReleased
        loginButton.setOpaque(false);
        loginButton.setBorder(BorderFactory.createBevelBorder(1, Color.white, Color.white, Color.black, Color.black));
    }//GEN-LAST:event_loginButtonMouseReleased

    //following code is for the eye password functionality
    private void eyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeMouseClicked
        ++eyeClick;
        if(eyeClick%2==1)
        {
            eye.setIcon(null);
            eye.setIcon(new ImageIcon(getClass().getResource("/com/dps/img/show.png")));
            psd_txt.setEchoChar((char)0); 
        }
        if(eyeClick%2==0)
        {
            eye.setIcon(null);
            eye.setIcon(new ImageIcon(getClass().getResource("/com/dps/img/hide.png")));
            if(psd_txt.getText().equals("Enter Password"))
            {
                psd_txt.setEchoChar((char)0); 
            }
            else
            {
                psd_txt.setEchoChar('•');
            }
        }
    }//GEN-LAST:event_eyeMouseClicked

    //following code is for the responsiveness of the username and password fields
    private void user_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_txtFocusGained
        user_txt.setForeground(Color.white);
        if(user_txt.getText().equals("Enter Username"))
        {
            user_txt.setText("");    
        }
    }//GEN-LAST:event_user_txtFocusGained

    private void user_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_txtFocusLost
        if(user_txt.getText().isEmpty())
        {
            user_txt.setForeground(new Color(153,153,153));
            user_txt.setText("Enter Username");        
        }
    }//GEN-LAST:event_user_txtFocusLost

    private void psd_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_psd_txtFocusGained
        psd_txt.setForeground(Color.white);
        if(eyeClick%2!=1)
        {
            psd_txt.setEchoChar('•');
        }
        if(psd_txt.getText().equals("Enter Password"))
        {
            psd_txt.setText("");
        }
    }//GEN-LAST:event_psd_txtFocusGained

    private void psd_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_psd_txtFocusLost
        if(psd_txt.getText().isEmpty())
        {
            psd_txt.setForeground(new Color(153,153,153));
            psd_txt.setEchoChar((char)0);
            psd_txt.setText("Enter Password");        
        }       
    }//GEN-LAST:event_psd_txtFocusLost

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eye;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginformPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPasswordField psd_txt;
    private javax.swing.JTextField user_txt;
    // End of variables declaration//GEN-END:variables
}