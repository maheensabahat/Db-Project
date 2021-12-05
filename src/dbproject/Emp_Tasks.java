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
public class Emp_Tasks extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    int empid;

    public Emp_Tasks(int empid) {
        initComponents();
        this.empid = empid;

        alert1.setVisible(false);
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

        //setFields();
        tableupdate("");

        Etask.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Etask.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Etask.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate(String s) { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Task join employee_Task "
                    + "using (task_id) where employee_id = ? " + s);
            pst.setInt(1, empid);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Etask.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("task_id"));
                    v2.add(rs.getString("task_name"));
                    v2.add(rs.getString("start_date"));
                    v2.add(rs.getString("end_date"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("hours"));
                    v2.add(rs.getString("rating"));
                }

                dft.addRow(v2);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void setfieldsEmpty() {
        taskid.setText("");
        taskname.setText("");
        taskdet.setText("");
        startdate.setText("");
        enddate.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Etask = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        taskid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        taskname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskdet = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        startdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        enddate = new javax.swing.JTextField();
        MarkComplete = new javax.swing.JButton();
        Pending = new javax.swing.JButton();
        Missed = new javax.swing.JButton();
        Finished = new javax.swing.JButton();
        alert1 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(772, 425));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Your Tasks");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(21, 11, 337, 43);

        Etask.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Etask.setForeground(new java.awt.Color(52, 45, 71));
        Etask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Task ID", "Task Name", "Start Date", "End Date", "Status", "Hours", "Rating"
            }
        ));
        Etask.setFocusable(false);
        Etask.setGridColor(new java.awt.Color(52, 45, 71));
        Etask.setSelectionBackground(new java.awt.Color(130, 120, 158));
        Etask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtaskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Etask);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(312, 85, 414, 360);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Task ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 160, 19);

        taskid.setEditable(false);
        taskid.setFocusable(false);
        taskid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskidActionPerformed(evt);
            }
        });
        jPanel1.add(taskid);
        taskid.setBounds(20, 100, 271, 32);

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 45, 71));
        jLabel12.setText("Task Name:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 140, 160, 19);

        taskname.setEditable(false);
        taskname.setFocusable(false);
        taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasknameActionPerformed(evt);
            }
        });
        jPanel1.add(taskname);
        taskname.setBounds(20, 160, 271, 32);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("Task Details:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 190, 163, 22);

        taskdet.setEditable(false);
        taskdet.setColumns(20);
        taskdet.setRows(5);
        taskdet.setFocusable(false);
        jScrollPane1.setViewportView(taskdet);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 271, 70);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("Start Date:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 280, 160, 19);

        startdate.setEditable(false);
        startdate.setFocusable(false);
        startdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdateActionPerformed(evt);
            }
        });
        jPanel1.add(startdate);
        startdate.setBounds(20, 300, 271, 32);

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 45, 71));
        jLabel11.setText("End Date:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 330, 160, 19);

        enddate.setEditable(false);
        enddate.setFocusable(false);
        enddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddateActionPerformed(evt);
            }
        });
        jPanel1.add(enddate);
        enddate.setBounds(20, 350, 271, 32);

        MarkComplete.setBackground(new java.awt.Color(38, 32, 54));
        MarkComplete.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        MarkComplete.setForeground(new java.awt.Color(255, 255, 255));
        MarkComplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/mark.png"))); // NOI18N
        MarkComplete.setText("Mark Done");
        MarkComplete.setFocusable(false);
        MarkComplete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MarkCompleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MarkCompleteMouseExited(evt);
            }
        });
        MarkComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkCompleteActionPerformed(evt);
            }
        });
        jPanel1.add(MarkComplete);
        MarkComplete.setBounds(100, 410, 120, 30);

        Pending.setBackground(new java.awt.Color(38, 32, 54));
        Pending.setForeground(new java.awt.Color(255, 255, 255));
        Pending.setText("Pending");
        Pending.setFocusable(false);
        Pending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PendingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PendingMouseExited(evt);
            }
        });
        Pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingActionPerformed(evt);
            }
        });
        jPanel1.add(Pending);
        Pending.setBounds(470, 60, 80, 23);

        Missed.setBackground(new java.awt.Color(38, 32, 54));
        Missed.setForeground(new java.awt.Color(255, 255, 255));
        Missed.setText("Missed");
        Missed.setFocusable(false);
        Missed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MissedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MissedMouseExited(evt);
            }
        });
        Missed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MissedActionPerformed(evt);
            }
        });
        jPanel1.add(Missed);
        Missed.setBounds(555, 60, 80, 23);

        Finished.setBackground(new java.awt.Color(38, 32, 54));
        Finished.setForeground(new java.awt.Color(255, 255, 255));
        Finished.setText("Finished");
        Finished.setFocusable(false);
        Finished.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FinishedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FinishedMouseExited(evt);
            }
        });
        Finished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishedActionPerformed(evt);
            }
        });
        jPanel1.add(Finished);
        Finished.setBounds(640, 60, 80, 23);

        alert1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        alert1.setForeground(new java.awt.Color(102, 255, 102));
        alert1.setText("Assignment has been marked done.");
        jPanel1.add(alert1);
        alert1.setBounds(60, 380, 230, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("You have missed the deadline.");
        jPanel1.add(error1);
        error1.setBounds(70, 380, 200, 30);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("Task has been cancelled.");
        jPanel1.add(error2);
        error2.setBounds(80, 390, 200, 20);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Task has been marked done.");
        jPanel1.add(error3);
        error3.setBounds(70, 380, 200, 30);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel3.setText("Dashboard");
        jLabel3.setFocusable(false);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(630, 10, 130, 40);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Table");
        reset.setFocusPainted(false);
        reset.setFocusable(false);
        reset.setRequestFocusEnabled(false);
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(630, 450, 100, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void taskidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskidActionPerformed

    private void tasknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tasknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tasknameActionPerformed

    private void startdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startdateActionPerformed

    private void enddateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enddateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enddateActionPerformed

    private void MarkCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkCompleteActionPerformed

        //gets Data of selected record from table
        DefaultTableModel model = (DefaultTableModel) Etask.getModel();
        int selectedIndex = Etask.getSelectedRow();

        if (selectedIndex != -1) {
            //emp id of selected record, used to update record
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String status = model.getValueAt(selectedIndex, 4).toString();
            //if hours have not been calculated
            if (model.getValueAt(selectedIndex, 5) == null) {

                //can ony mark open tasks 
                if (status.equals("Open")) {
                    try {

                        //Hours = No of days between start date and today, multiplied by 9(office hours)
                        String query = "update Employee_Task set hours ="
                                + " ((Datediff(sysdate(),(select start_date from Task where Task_ID = ?))+1)*9)"
                                + " where task_ID = ? and hours is Null";
                        pst = con.prepareStatement(query);
                        pst.setInt(1, id);
                        pst.setInt(2, id);

                        pst.executeUpdate();
                        pst.close();
                        alert1.setVisible(true);

                        //Table updated after edits
                        tableupdate("");

                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Employee.class
                                .getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else if (status.equals("Closed")) {
                    error1.setVisible(true);
                } else {
                    error2.setVisible(true);
                }
            } else {
                error3.setVisible(true);
            }
        }

    }//GEN-LAST:event_MarkCompleteActionPerformed

    private void EtaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtaskMouseClicked
        alert1.setVisible(false);
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Etask.getModel();
        int selectedIndex = Etask.getSelectedRow();

        taskid.setText(model.getValueAt(selectedIndex, 0).toString());
        int tid = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        taskname.setText(model.getValueAt(selectedIndex, 1).toString());
        startdate.setText(model.getValueAt(selectedIndex, 2).toString());
        enddate.setText(model.getValueAt(selectedIndex, 3).toString());

        //bring other fields from table
        try {
            pst = con.prepareStatement("select task_details from Task where task_ID = ?");
            pst.setInt(1, tid);
            rs = pst.executeQuery();

            if (rs.next()) {
                taskdet.setText(rs.getString("task_details"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Employee.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EtaskMouseClicked

    private void MissedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MissedActionPerformed
        //Task that are closed but not done by employee
        //status is closed and hours not calculated

        String q = " and status = 'closed' and Hours is Null";
        tableupdate(q);
        setfieldsEmpty();
    }//GEN-LAST:event_MissedActionPerformed

    private void PendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendingActionPerformed
        //Task that are open but not done by employee
        //status is open and hours are not calculated

        String q = " and status = 'Open' and Hours is Null";
        tableupdate(q);
        setfieldsEmpty();
    }//GEN-LAST:event_PendingActionPerformed

    private void FinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishedActionPerformed
        //Task that are closed but not done by employee
        //hours are calculated

        String q = " and Hours is not Null";
        tableupdate(q);
        setfieldsEmpty();
    }//GEN-LAST:event_FinishedActionPerformed

    private void MarkCompleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkCompleteMouseEntered
        // TODO add your handling code here:
        MarkComplete.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_MarkCompleteMouseEntered

    private void PendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingMouseEntered
        // TODO add your handling code here:
        Pending.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_PendingMouseEntered

    private void MissedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MissedMouseEntered
        // TODO add your handling code here:
        Missed.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_MissedMouseEntered

    private void FinishedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinishedMouseEntered
        // TODO add your handling code here:
        Finished.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_FinishedMouseEntered

    private void MarkCompleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkCompleteMouseExited
        // TODO add your handling code here:
        MarkComplete.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_MarkCompleteMouseExited

    private void PendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingMouseExited
        // TODO add your handling code here:
        Pending.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_PendingMouseExited

    private void MissedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MissedMouseExited
        // TODO add your handling code here:
        Missed.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_MissedMouseExited

    private void FinishedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinishedMouseExited
        // TODO add your handling code here:
        Finished.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_FinishedMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        DashboardEmp db = new DashboardEmp(empid);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_resetMouseExited

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        tableupdate("");
        setfieldsEmpty();
    }//GEN-LAST:event_resetActionPerformed

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
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_Tasks(8).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Etask;
    private javax.swing.JButton Finished;
    private javax.swing.JButton MarkComplete;
    private javax.swing.JButton Missed;
    private javax.swing.JButton Pending;
    private javax.swing.JLabel alert1;
    private javax.swing.JTextField enddate;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reset;
    private javax.swing.JTextField startdate;
    private javax.swing.JTextArea taskdet;
    private javax.swing.JTextField taskid;
    private javax.swing.JTextField taskname;
    // End of variables declaration//GEN-END:variables
}
