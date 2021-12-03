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
public class Admin_Tasks extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    

    public Admin_Tasks() {
        initComponents();

        error1.setVisible(false);

//        error1.setVisible(false);
//        error2.setVisible(false);
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

        Task.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Task.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Task.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate(String s) { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Task" + s);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Task.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("task_id"));
                    v2.add(rs.getString("task_name"));
                    v2.add(rs.getString("start_date"));
                    v2.add(rs.getString("end_date"));
                    v2.add(rs.getString("status"));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Task = new javax.swing.JTable();
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
        jLabel3 = new javax.swing.JLabel();
        Assign = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(772, 425));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Tasks");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(21, 11, 337, 43);

        Task.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Task.setForeground(new java.awt.Color(52, 45, 71));
        Task.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Task ID", "Task Name", "Start Date", "End Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Task.setFocusable(false);
        Task.setGridColor(new java.awt.Color(52, 45, 71));
        Task.setSelectionBackground(new java.awt.Color(130, 120, 158));
        Task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Task);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(312, 85, 414, 360);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Task ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 100, 160, 19);

        taskid.setEditable(false);
        taskid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskidActionPerformed(evt);
            }
        });
        jPanel1.add(taskid);
        taskid.setBounds(20, 120, 271, 32);

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 45, 71));
        jLabel12.setText("Task Name:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 160, 160, 19);

        taskname.setEditable(false);
        taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasknameActionPerformed(evt);
            }
        });
        jPanel1.add(taskname);
        taskname.setBounds(20, 180, 271, 32);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("Task Details:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 210, 163, 22);

        taskdet.setEditable(false);
        taskdet.setColumns(20);
        taskdet.setRows(5);
        jScrollPane1.setViewportView(taskdet);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 230, 271, 70);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("Start Date:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 300, 160, 19);

        startdate.setEditable(false);
        startdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdateActionPerformed(evt);
            }
        });
        jPanel1.add(startdate);
        startdate.setBounds(20, 320, 271, 32);

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 45, 71));
        jLabel11.setText("End Date:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 350, 160, 19);

        enddate.setEditable(false);
        enddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddateActionPerformed(evt);
            }
        });
        jPanel1.add(enddate);
        enddate.setBounds(20, 370, 271, 32);

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

        Assign.setBackground(new java.awt.Color(38, 32, 54));
        Assign.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setText("View Employees assigned this task.");
        Assign.setFocusable(false);
        Assign.setRequestFocusEnabled(false);
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
        jPanel1.add(Assign);
        Assign.setBounds(40, 430, 230, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("Select a Task from table to proceed");
        jPanel1.add(error1);
        error1.setBounds(50, 400, 230, 40);

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

    private void TaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaskMouseClicked
        error1.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Task.getModel();
        int selectedIndex = Task.getSelectedRow();

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
    }//GEN-LAST:event_TaskMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void AssignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseEntered
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_AssignMouseEntered

    private void AssignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseExited
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_AssignMouseExited

    private void AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignActionPerformed

        if (Task.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) Task.getModel();
            int selectedIndex = Task.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            new Admin_EmpTask(id).setVisible(true);
            this.setVisible(false);
        }else{
            error1.setVisible(true);
        }
    }//GEN-LAST:event_AssignActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Tasks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assign;
    private javax.swing.JTable Task;
    private javax.swing.JTextField enddate;
    private javax.swing.JLabel error1;
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
    private javax.swing.JTextField startdate;
    private javax.swing.JTextArea taskdet;
    private javax.swing.JTextField taskid;
    private javax.swing.JTextField taskname;
    // End of variables declaration//GEN-END:variables
}
