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
public class TaskAssignment extends javax.swing.JFrame {

    int taskid;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public TaskAssignment(int id) {
        initComponents();
        taskid = id;

        error1.setVisible(false);
        error2.setVisible(false);

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

            pst = con.prepareStatement("select * from Employee_task inner join employee using (employee_id)");
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
        add1 = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        taskID.setEditable(false);
        taskID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskIDActionPerformed(evt);
            }
        });
        jPanel2.add(taskID);
        taskID.setBounds(20, 117, 271, 28);

        Taskdetail.setEditable(false);
        Taskdetail.setColumns(20);
        Taskdetail.setRows(5);
        jScrollPane1.setViewportView(Taskdetail);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 230, 271, 70);

        Taskname.setEditable(false);
        Taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasknameActionPerformed(evt);
            }
        });
        jPanel2.add(Taskname);
        Taskname.setBounds(20, 170, 271, 32);

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
        jScrollPane2.setViewportView(ATask);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(320, 100, 414, 310);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Task Assignment");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 11, 337, 43);

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

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("Task Details:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 210, 163, 13);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("Employee ID:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 310, 130, 24);

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
        empid.setBounds(20, 330, 271, 28);

        add1.setBackground(new java.awt.Color(38, 32, 54));
        add1.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/assign_20.png"))); // NOI18N
        add1.setText("Assign");
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

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText(" Employee ID is required.");
        jPanel2.add(error1);
        error1.setBounds(100, 300, 200, 40);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("This employee is already assigned to this task.");
        jPanel2.add(error2);
        error2.setBounds(20, 350, 280, 40);

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(52, 45, 71));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel6.setText("Dashboard");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6);
        jLabel6.setBounds(630, 10, 130, 40);

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

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        if (!empid.getText().isEmpty()) {
            try {
                int id = Integer.parseInt(empid.getText());

                try {
                    String query = "insert into Employee_task(task_id, employee_id)"
                            + "values(?,?)";
                    pst = con.prepareStatement(query);
                    pst.setInt(1, taskid);
                    pst.setInt(2, id);
                    pst.execute();
                    pst.close();
                    JOptionPane.showMessageDialog(this, "Record Addedd.");

                    //Table updates after insertion
                    tableupdate();
                    empid.setText("");

                } catch (SQLIntegrityConstraintViolationException e) {
                    error2.setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }
            } catch (NumberFormatException ex) {

            }
        } else {
            error1.setVisible(true);
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void empidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empidKeyTyped
        error1.setVisible(false);
        error2.setVisible(false);
    }//GEN-LAST:event_empidKeyTyped

    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered
        // TODO add your handling code here:
                add1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_add1MouseEntered

    private void add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseExited
        // TODO add your handling code here:
                add1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_add1MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(TaskAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TaskAssignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ATask;
    private javax.swing.JTextArea Taskdetail;
    private javax.swing.JTextField Taskname;
    private javax.swing.JButton add1;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField taskID;
    // End of variables declaration//GEN-END:variables
}
