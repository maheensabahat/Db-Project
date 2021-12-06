package dbproject;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class Change_password extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Database db;
    int emp;
    boolean isMgr;

    public Change_password(int emp, boolean isMgr) {
        initComponents();
        this.emp = emp;
        this.isMgr = isMgr;

        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

    }

    private boolean checkfields() { //check if required fields are there
        if (Current.getText().equals("") || newpw.getText().equals("")
                || Confirm.getText().equals("")) {
            error1.setVisible(true);

            if (Current.getText().trim().isEmpty()) {
                Current.grabFocus();
                return true;
            } else if (newpw.getText().trim().isEmpty()) {
                newpw.grabFocus();
                return true;
            } else if (Confirm.getText().trim().isEmpty()) {
                Confirm.grabFocus();
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        first_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        first_name4 = new javax.swing.JLabel();
        first_name5 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        newpw = new javax.swing.JPasswordField();
        Confirm = new javax.swing.JPasswordField();
        Current = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel2.setLayout(null);

        first_name.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name.setForeground(new java.awt.Color(52, 45, 71));
        first_name.setText("*Current Password:");
        jPanel2.add(first_name);
        first_name.setBounds(50, 100, 170, 15);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Change Password");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 20, 330, 41);

        first_name4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name4.setForeground(new java.awt.Color(52, 45, 71));
        first_name4.setText("*New Password:");
        jPanel2.add(first_name4);
        first_name4.setBounds(50, 170, 130, 15);

        first_name5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name5.setForeground(new java.awt.Color(52, 45, 71));
        first_name5.setText("*Confirm Password:");
        jPanel2.add(first_name5);
        first_name5.setBounds(50, 240, 160, 15);

        cancel.setBackground(new java.awt.Color(52, 45, 71));
        cancel.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setFocusPainted(false);
        cancel.setFocusable(false);
        cancel.setRequestFocusEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(50, 320, 110, 30);

        confirm.setBackground(new java.awt.Color(52, 45, 71));
        confirm.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirm");
        confirm.setFocusPainted(false);
        confirm.setFocusable(false);
        confirm.setRequestFocusEnabled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel2.add(confirm);
        confirm.setBounds(180, 320, 110, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("enter all required fields.");
        jPanel2.add(error1);
        error1.setBounds(170, 300, 160, 17);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("*Confirm Password does not match.");
        jPanel2.add(error3);
        error3.setBounds(50, 220, 220, 20);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("*Incorrect Password");
        jPanel2.add(error2);
        error2.setBounds(170, 100, 140, 15);

        newpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpwKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newpwKeyTyped(evt);
            }
        });
        jPanel2.add(newpw);
        newpw.setBounds(50, 190, 240, 30);

        Confirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ConfirmKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ConfirmKeyTyped(evt);
            }
        });
        jPanel2.add(Confirm);
        Confirm.setBounds(50, 260, 240, 30);

        Current.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CurrentKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CurrentKeyTyped(evt);
            }
        });
        jPanel2.add(Current);
        Current.setBounds(50, 120, 240, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        //req fields are there
        if (!checkfields()) {
            try {
                pst = con.prepareStatement("select password from employee where Employee_ID = ?");
                pst.setInt(1, emp);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String qpw = rs.getString("password");
                    String old = Current.getText();
                    String newpass = newpw.getText();
                    String confp = Confirm.getText();

                    if (old.equals(qpw)) {
                        if (newpass.equals(confp)) {
                            String query = "update Employee set password = ? "
                                    + " where Employee_ID = ?";
                            pst = con.prepareStatement(query);
                            pst.setString(1, newpass);
                            pst.setInt(2, emp);
                            pst.executeUpdate();
                            new View_profile(emp, isMgr).setVisible(true);
                            this.setVisible(false);
                        } else {
                            Confirm.setText("");
                            error3.setVisible(true);
                        }
                    } else {
                        Current.setText("");
                        error2.setVisible(true);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Change_password.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
      //  new View_profile(emp, isMgr).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void newpwKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpwKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_newpwKeyTyped

    private void ConfirmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmKeyTyped

    private void CurrentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurrentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentKeyTyped

    private void CurrentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurrentKeyPressed
        error1.setVisible(false);
        error2.setVisible(false);
    }//GEN-LAST:event_CurrentKeyPressed

    private void newpwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpwKeyPressed
        error1.setVisible(false);
        error3.setVisible(false);
    }//GEN-LAST:event_newpwKeyPressed

    private void ConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmKeyPressed
        error1.setVisible(false);
        error3.setVisible(false);
    }//GEN-LAST:event_ConfirmKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Change_password(1, true).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Confirm;
    private javax.swing.JPasswordField Current;
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name4;
    private javax.swing.JLabel first_name5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField newpw;
    // End of variables declaration//GEN-END:variables
}
