/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Hp
 */
public class Admin_EmpTask extends javax.swing.JFrame {

    int taskid;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public Admin_EmpTask(int id) {
        initComponents();
        taskid = id;

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        setFields();
        tableupdate();
      
        ATask.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        ATask.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        ATask.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));

    }

    private void setFields() {
        try {

            pst = con.prepareStatement("select * from Task where task_id = ? ");
            pst.setInt(1, taskid);
            rs = pst.executeQuery();

            if (rs.next()) {

                taskID.setText(rs.getString("task_id"));
                Taskname.setText(rs.getString("task_name"));
                Taskdetail.setText(rs.getString("task_details"));
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Employee_task inner join "
                    + "employee using (employee_id) where task_ID = ?");
            pst.setInt(1, taskid);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) ATask.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("first_name") + " " + rs.getString("last_name"));
                    v2.add(rs.getString("Hours"));
                    v2.add(rs.getString("rating"));
                }

                dft.addRow(v2);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        taskID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Taskdetail = new javax.swing.JTextArea();
        Taskname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ATask = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hrs = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rating = new javax.swing.JTextField();
        Assign = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        taskID.setEditable(false);
        taskID.setFocusable(false);
        taskID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskIDActionPerformed(evt);
            }
        });
        jPanel2.add(taskID);
        taskID.setBounds(20, 90, 271, 28);

        Taskdetail.setEditable(false);
        Taskdetail.setColumns(20);
        Taskdetail.setRows(5);
        Taskdetail.setFocusable(false);
        jScrollPane1.setViewportView(Taskdetail);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 271, 70);

        Taskname.setEditable(false);
        Taskname.setFocusable(false);
        Taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasknameActionPerformed(evt);
            }
        });
        jPanel2.add(Taskname);
        Taskname.setBounds(20, 140, 271, 32);

        ATask.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        ATask.setForeground(new java.awt.Color(52, 45, 71));
        ATask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Hours", "Rating"
            }
        ));
        ATask.setFocusable(false);
        ATask.setGridColor(new java.awt.Color(52, 45, 71));
        ATask.setSelectionBackground(new java.awt.Color(130, 120, 158));
        ATask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ATaskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ATask);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(320, 80, 414, 370);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Task Details");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 11, 337, 43);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setText("Task ID:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 60, 130, 30);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Task Name:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 120, 160, 19);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("Task Details:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 180, 163, 13);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("Employee ID:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 270, 130, 24);

        empid.setEditable(false);
        empid.setFocusable(false);
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        empid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empidKeyTyped(evt);
            }
        });
        jPanel2.add(empid);
        empid.setBounds(20, 290, 271, 28);

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(52, 45, 71));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel6.setText("Dashboard");
        jLabel6.setFocusable(false);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6);
        jLabel6.setBounds(630, 10, 130, 40);

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 45, 71));
        jLabel11.setText("Hours Worked:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 320, 130, 24);

        hrs.setEditable(false);
        hrs.setFocusable(false);
        hrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrsActionPerformed(evt);
            }
        });
        hrs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hrsKeyTyped(evt);
            }
        });
        jPanel2.add(hrs);
        hrs.setBounds(20, 340, 271, 28);

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 45, 71));
        jLabel12.setText("Rating:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 370, 130, 24);

        rating.setEditable(false);
        rating.setFocusable(false);
        rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratingActionPerformed(evt);
            }
        });
        rating.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ratingKeyTyped(evt);
            }
        });
        jPanel2.add(rating);
        rating.setBounds(20, 390, 271, 28);

        Assign.setBackground(new java.awt.Color(38, 32, 54));
        Assign.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setText("Back to all tasks");
        Assign.setFocusable(false);
        Assign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AssignMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AssignMouseExited(evt);
            }
        });
        Assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignActionPerformed(evt);
            }
        });
        jPanel2.add(Assign);
        Assign.setBounds(90, 430, 160, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void taskIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskIDActionPerformed

    private void TasknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TasknameActionPerformed

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void empidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empidKeyTyped
        
    }//GEN-LAST:event_empidKeyTyped

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void hrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrsActionPerformed

    private void hrsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hrsKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_hrsKeyTyped

    private void ratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratingActionPerformed

    private void ratingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ratingKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ratingKeyTyped

    private void ATaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ATaskMouseClicked
        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) ATask.getModel();
        int selectedIndex = ATask.getSelectedRow();

        empid.setText(model.getValueAt(selectedIndex, 0).toString());
        if( model.getValueAt(selectedIndex, 2)!= null){
        hrs.setText(model.getValueAt(selectedIndex, 2).toString());
        } else{
            hrs.setText("");
        }
        
        if( model.getValueAt(selectedIndex, 3)!= null){
        rating.setText(model.getValueAt(selectedIndex, 3).toString());
        }else{
            rating.setText("");
        }

    }//GEN-LAST:event_ATaskMouseClicked

    private void AssignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseEntered
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_AssignMouseEntered

    private void AssignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseExited
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_AssignMouseExited

    private void AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignActionPerformed
            new Admin_Tasks().setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_AssignActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(Admin_EmpTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin_EmpTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin_EmpTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin_EmpTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new TaskAssignment().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ATask;
    private javax.swing.JButton Assign;
    private javax.swing.JTextArea Taskdetail;
    private javax.swing.JTextField Taskname;
    private javax.swing.JTextField empid;
    private javax.swing.JTextField hrs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField rating;
    private javax.swing.JTextField taskID;
    // End of variables declaration//GEN-END:variables
}
