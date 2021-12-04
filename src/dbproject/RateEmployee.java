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

/**
 *
 * @author Hp
 */
public class RateEmployee extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    int taskid;
    int mgr;
    int dept;

    public RateEmployee(int taskid, int mgr) {
        initComponents();

        taskid = taskid;
        this.mgr = mgr;

        error3.setVisible(false);
        error4.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        getDept();
        setFields();
        tableupdate();

        task.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        task.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        task.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void setFields() {
        try {

            pst = con.prepareStatement("select * from Task where task_id = ? ");
            pst.setInt(1, taskid);
            rs = pst.executeQuery();

            if (rs.next()) {

                TaskID.setText(rs.getString("task_id"));
                Taskname.setText(rs.getString("task_name"));

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void getDept() {
        try {

            pst = con.prepareStatement("select * from department where manager_id = ? ");
            pst.setInt(1, mgr);
            rs = pst.executeQuery();

            if (rs.next()) {
                dept = rs.getInt("department_id");
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Employee_task inner join employee using (employee_id)"
                    + "where hours is not null and department_id = ?");
            pst.setInt(1, dept);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) task.getModel();
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

    private void setfieldsEmpty() {
        empid.setText("");
        hours.setText("");
        rating.setText("");
        task.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TaskID = new javax.swing.JTextField();
        Taskname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        task = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        add1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rating = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        hours = new javax.swing.JTextField();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        TaskID.setEditable(false);
        TaskID.setFocusable(false);
        TaskID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskIDActionPerformed(evt);
            }
        });
        jPanel2.add(TaskID);
        TaskID.setBounds(20, 117, 271, 28);

        Taskname.setEditable(false);
        Taskname.setFocusable(false);
        Taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasknameActionPerformed(evt);
            }
        });
        jPanel2.add(Taskname);
        Taskname.setBounds(20, 170, 271, 32);

        task.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        task.setForeground(new java.awt.Color(52, 45, 71));
        task.setModel(new javax.swing.table.DefaultTableModel(
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
        task.setFocusable(false);
        task.setGridColor(new java.awt.Color(52, 45, 71));
        task.setSelectionBackground(new java.awt.Color(130, 120, 158));
        task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(task);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(320, 100, 414, 310);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Employee Rating");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 337, 43);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setText("Task ID:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 90, 130, 30);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Task Name:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 150, 160, 19);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("Employee ID:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 210, 130, 24);

        empid.setEditable(false);
        empid.setFocusable(false);
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel2.add(empid);
        empid.setBounds(20, 230, 271, 28);

        add1.setBackground(new java.awt.Color(38, 32, 54));
        add1.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/save.png"))); // NOI18N
        add1.setText("Save");
        add1.setFocusable(false);
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add1MouseExited(evt);
            }
        });
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel2.add(add1);
        add1.setBounds(100, 380, 90, 40);

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 45, 71));
        jLabel11.setText("Rating:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 310, 130, 24);

        rating.setFocusable(false);
        rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratingActionPerformed(evt);
            }
        });
        jPanel2.add(rating);
        rating.setBounds(20, 330, 271, 28);

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 45, 71));
        jLabel12.setText("Hours Worked:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 260, 130, 24);

        hours.setEditable(false);
        hours.setFocusable(false);
        hours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursActionPerformed(evt);
            }
        });
        jPanel2.add(hours);
        hours.setBounds(20, 280, 271, 28);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Select an employee from table to proceed");
        jPanel2.add(error3);
        error3.setBounds(30, 350, 260, 40);

        error4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("Rate employee performance out of 10.");
        jPanel2.add(error4);
        error4.setBounds(70, 300, 240, 40);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel5.setText("Dashboard");
        jLabel5.setFocusable(false);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);
        jLabel5.setBounds(630, 10, 130, 40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TaskIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaskIDActionPerformed

    private void TasknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TasknameActionPerformed

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        if (!empid.getText().isEmpty()) {

            try {
                int eid = Integer.parseInt(empid.getText());
                int Rating = Integer.parseInt(rating.getText());

                if (Rating >= 0 && Rating <= 10) {

                    try {

                        String query = "update Employee_task set rating = ? where Employee_ID = ?";
                        pst = con.prepareStatement(query);
                        pst.setInt(1, Rating);
                        pst.setInt(2, eid);
                        pst.executeUpdate();
                        pst.close();
                        JOptionPane.showMessageDialog(this, "Record Updated.");

                        //Table updated after edits
                        tableupdate();

                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }

                    //fields set empty
                    setfieldsEmpty();
                    error4.setVisible(false);
                }
            } catch (NumberFormatException ex) {
                rating.setText("");
                rating.grabFocus();
            }
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void ratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratingActionPerformed

    private void hoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoursActionPerformed

    private void taskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskMouseClicked
        error3.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) task.getModel();
        int selectedIndex = task.getSelectedRow();

        TaskID.setText(model.getValueAt(selectedIndex, 0).toString());
        int tid = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        Taskname.setText(model.getValueAt(selectedIndex, 1).toString());
        empid.setText(model.getValueAt(selectedIndex, 2).toString());
        hours.setText(model.getValueAt(selectedIndex, 3).toString());
        rating.setText(model.getValueAt(selectedIndex, 4).toString());
    }//GEN-LAST:event_taskMouseClicked

    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered
        // TODO add your handling code here:
        add1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_add1MouseEntered

    private void add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseExited
        // TODO add your handling code here:
        add1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_add1MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        DashboardMgr db = new DashboardMgr(mgr);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(RateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new RateEmployee(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TaskID;
    private javax.swing.JTextField Taskname;
    private javax.swing.JButton add1;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JTextField hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField rating;
    private javax.swing.JTable task;
    // End of variables declaration//GEN-END:variables

}
