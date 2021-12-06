/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Hp
 */
public class AdminLogin extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public AdminLogin() throws SQLException {
        initComponents();

        empIDerror1.setVisible(false);
        pwerror.setVisible(false);
        error.setVisible(false);

        db = new Database();
        db.openConnection();

        con = db.con;
        pst = db.pst;
        rs = db.rs;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        pwerror = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        empIDerror1 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(47, 27, 71));
        jPanel2.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Mobile_login-amico_1_25.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(-50, 0, 480, 490);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(357, 0, 400, 490);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(64, 154, 231, 31);

        pwerror.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        pwerror.setForeground(new java.awt.Color(255, 0, 51));
        pwerror.setText("*incorrect password");
        jPanel1.add(pwerror);
        pwerror.setBounds(150, 200, 200, 40);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("*Password:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(64, 196, 124, 50);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setText("ADMIN LOGIN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 50, 180, 29);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("*Employee ID:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(64, 130, 150, 30);

        error.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 51));
        error.setText("*enter required fields to proceed");
        jPanel1.add(error);
        error.setBounds(90, 280, 200, 30);

        empIDerror1.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        empIDerror1.setForeground(new java.awt.Color(255, 0, 51));
        empIDerror1.setText("*invalid Employee ID");
        jPanel1.add(empIDerror1);
        empIDerror1.setBounds(170, 130, 200, 30);
        jPanel1.add(pw);
        pw.setBounds(64, 230, 231, 31);

        login.setBackground(new java.awt.Color(38, 32, 54));
        login.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/login_new (2).png"))); // NOI18N
        login.setText("Login");
        login.setFocusPainted(false);
        login.setFocusable(false);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(105, 319, 142, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/back_32.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        error.setVisible(false);
        empIDerror1.setVisible(false);
        pwerror.setVisible(false);

        int employeeID = Integer.parseInt(empid.getText());
        String password = pw.getText();

        if (empid.getText().equals("") || password.equals("")) {
            //check if both fields are filled
            error.setVisible(true);
            if (empid.getText().trim().isEmpty()) {
                empid.grabFocus();
                return;
            } else if (password.trim().isEmpty()) {
                pw.grabFocus();
                return;
            }
        } else {
        //when fields are filled
            try {
                pst = con.prepareStatement("select * from department d inner join"
                        + " employee e using (department_id)"
                        + " where employee_id = ? and status = 'Working' and department_name = 'Administration'");
                pst.setInt(1, employeeID);
                rs = pst.executeQuery();

                if (rs.next() == false) {
                    //given employee id doesnt exist in record
                    empIDerror1.setVisible(true);
                    empid.setText("");
                    pw.setText("");
                    empid.requestFocus();
                } else {
                    String qpw = rs.getString("Password");
                    //check user provided password against queried password
                    if (password.equals(qpw)) { //password matches
                        new Dashboard().setVisible(true);
                        this.setVisible(false);
                    } else {
                        pwerror.setVisible(true);
                        pw.setText("");
                        pw.requestFocus();
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        login.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        login.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_loginMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new MainPage().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked
    public void setColor(JButton button) {
        button.setBackground(new java.awt.Color(47, 27, 71));
        //102,0,204
    }

    public void resetColor(JButton button) {   //change
        button.setBackground(new java.awt.Color(52, 45, 71));
    }

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //checking connection
        //</editor-fold>
        //checking connection
        //</editor-fold>
        //checking connection
        //</editor-fold>
        //checking connection


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminLogin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel empIDerror1;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pw;
    private javax.swing.JLabel pwerror;
    // End of variables declaration//GEN-END:variables
}
