/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

import dbproject.Dashboard;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class Star_Employee extends javax.swing.JFrame {

    int emp;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public Star_Employee(int emp) {
        initComponents();
        this.emp = emp;
        error1.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        DateFormat df = new SimpleDateFormat("MMMMM");
        java.util.Date dateobj = new java.util.Date();
        month.setText(df.format(dateobj));

        df = new SimpleDateFormat("yyyy");
        year.setText(df.format(dateobj));

        setPanels();
        setStar();
    }

    private void setStar() {
        try {
            pst = con.prepareStatement("Select * from staremployees join employee using (employee_id) "
                    + "where month = Date_format(sysdate(),'%M %Y') ");
            rs = pst.executeQuery();

            if (rs.next()) {
                star.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
            } else {
                star.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Star_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setPanels() {
        try {
            pst = con.prepareStatement("Select * from performance_analysis "
                    + "where employee_id = ? and month_of_pa = Date_format(sysdate(),'%M %Y') ");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (rs.next()) {
                abs.setText(rs.getString("absences"));
                TC.setText(rs.getString("tasks_completed"));
                TS.setText(rs.getString("task_scores"));
            } else {
                error1.setVisible(true);
                abs.setText("");
                TC.setText("");
                TS.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Star_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TS = new javax.swing.JButton();
        TC = new javax.swing.JButton();
        staremp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        star = new javax.swing.JTextField();
        abs = new javax.swing.JButton();
        x = new javax.swing.JButton();
        star1 = new javax.swing.JTextField();
        month = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 425));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Task Scores");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(570, 130, 120, 40);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Star Employee");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 300, 40);

        TS.setBackground(new java.awt.Color(52, 45, 71));
        TS.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        TS.setForeground(new java.awt.Color(255, 255, 255));
        TS.setText("0");
        TS.setFocusPainted(false);
        TS.setFocusable(false);
        TS.setRequestFocusEnabled(false);
        TS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TSActionPerformed(evt);
            }
        });
        jPanel1.add(TS);
        TS.setBounds(510, 160, 230, 100);

        TC.setBackground(new java.awt.Color(52, 45, 71));
        TC.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        TC.setForeground(new java.awt.Color(255, 255, 255));
        TC.setText("0");
        TC.setFocusPainted(false);
        TC.setFocusable(false);
        TC.setRequestFocusEnabled(false);
        TC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCActionPerformed(evt);
            }
        });
        jPanel1.add(TC);
        TC.setBounds(270, 160, 230, 100);

        staremp.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        staremp.setForeground(new java.awt.Color(255, 255, 255));
        staremp.setText("Star Employee of the month:");
        jPanel1.add(staremp);
        staremp.setBounds(120, 320, 300, 22);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(52, 45, 71));
        jLabel8.setText("Absences");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 130, 100, 40);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(52, 45, 71));
        jLabel9.setText("Tasks Completed");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(310, 130, 160, 40);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel3.setText("Dashboard");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(630, 10, 130, 40);

        error1.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("Analysis not calculated for this month yet.");
        jPanel1.add(error1);
        error1.setBounds(200, 100, 370, 30);

        star.setEditable(false);
        star.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        star.setForeground(new java.awt.Color(52, 45, 71));
        star.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        star.setFocusable(false);
        star.setRequestFocusEnabled(false);
        star.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starActionPerformed(evt);
            }
        });
        jPanel1.add(star);
        star.setBounds(380, 315, 271, 32);

        abs.setBackground(new java.awt.Color(52, 45, 71));
        abs.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        abs.setForeground(new java.awt.Color(255, 255, 255));
        abs.setText("0");
        abs.setFocusPainted(false);
        abs.setFocusable(false);
        abs.setRequestFocusEnabled(false);
        abs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absActionPerformed(evt);
            }
        });
        jPanel1.add(abs);
        abs.setBounds(30, 160, 230, 100);

        x.setBackground(new java.awt.Color(52, 45, 71));
        x.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        x.setForeground(new java.awt.Color(255, 255, 255));
        x.setFocusPainted(false);
        x.setFocusable(false);
        x.setRequestFocusEnabled(false);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        jPanel1.add(x);
        x.setBounds(60, 280, 640, 100);

        star1.setEditable(false);
        star1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        star1.setFocusable(false);
        star1.setRequestFocusEnabled(false);
        star1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1ActionPerformed(evt);
            }
        });
        jPanel1.add(star1);
        star1.setBounds(380, 310, 271, 32);

        month.setEditable(false);
        month.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        month.setForeground(new java.awt.Color(52, 45, 71));
        month.setFocusable(false);
        month.setRequestFocusEnabled(false);
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(220, 70, 130, 25);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Month:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 70, 51, 20);

        year.setEditable(false);
        year.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        year.setForeground(new java.awt.Color(52, 45, 71));
        year.setFocusable(false);
        year.setRequestFocusEnabled(false);
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel1.add(year);
        year.setBounds(420, 70, 130, 25);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("Year:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(380, 70, 51, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TSActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xActionPerformed

    private void TCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        DashboardEmp db = new DashboardEmp(emp);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void starActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_starActionPerformed

    private void absActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_absActionPerformed

    private void star1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_star1ActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

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
            java.util.logging.Logger.getLogger(Star_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Star_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Star_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Star_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Star_Employee(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TC;
    private javax.swing.JButton TS;
    private javax.swing.JButton abs;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField month;
    private javax.swing.JTextField star;
    private javax.swing.JTextField star1;
    private javax.swing.JLabel staremp;
    private javax.swing.JButton x;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
