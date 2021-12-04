package dbproject;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class Employee_Salary extends javax.swing.JFrame {

    int emp;
    boolean isMgr;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public Employee_Salary(int emp, boolean isMgr) {
        initComponents();
        this.emp = emp;
        this.isMgr = isMgr;

        //making connection to database
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Salary.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();

        salrep.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        salrep.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        salrep.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));

    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("SELECT substr(date, 1, instr(date, \" \")) as month,"
                    + "substr(date, instr(date, \" \"))as year, salary, bonus,\n"
                    + " travel_allowance, medical_allowance FROM monthly_salary where employee_id = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) salrep.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("salary"));
                    v2.add(rs.getString("bonus"));
                    v2.add(rs.getString("travel_allowance"));
                    v2.add(rs.getString("medical_allowance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salrep = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        salrep.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        salrep.setForeground(new java.awt.Color(52, 45, 71));
        salrep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Month", "Year", "Salary", "Bonus", "Travel Allowance", "Medical Allowance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salrep.setFocusable(false);
        salrep.setGridColor(new java.awt.Color(52, 45, 71));
        salrep.setSelectionBackground(new java.awt.Color(130, 120, 158));
        jScrollPane1.setViewportView(salrep);
        if (salrep.getColumnModel().getColumnCount() > 0) {
            salrep.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 680, 350);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Employee Salary Report");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 510, 43);

        search1.setBackground(new java.awt.Color(38, 32, 54));
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search1.setText("Search");
        search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search1MouseExited(evt);
            }
        });
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel1.add(search1);
        search1.setBounds(490, 72, 90, 25);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Month:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 80, 51, 20);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 45, 71));
        jLabel3.setText("Year:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 80, 51, 20);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel4.setText("Dashboard");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 10, 130, 40);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Table");
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
        reset.setBounds(610, 460, 100, 20);

        month.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", " " }));
        month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthMouseClicked(evt);
            }
        });
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(170, 70, 110, 29);

        year.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", " " }));
        year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearMouseClicked(evt);
            }
        });
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel1.add(year);
        year.setBounds(350, 70, 110, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        int c;

        String m = (String) month.getSelectedItem();
        String y = (String) year.getSelectedItem();
        String d = m + " " + y;

        try {

            pst = con.prepareStatement("SELECT substr(date, 1, instr(date, \" \")) as month,"
                    + "substr(date, instr(date, \" \"))as year, salary, bonus,\n"
                    + " travel_allowance, medical_allowance FROM monthly_salary"
                    + " where date = ? and employee_id = ?");
            pst.setInt(2, emp);
            pst.setString(1, d);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) salrep.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("salary"));
                    v2.add(rs.getString("bonus"));
                    v2.add(rs.getString("travel_allowance"));
                    v2.add(rs.getString("medical_allowance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_search1ActionPerformed

    private void search1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseEntered
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search1MouseEntered

    private void search1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseExited
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search1MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if (isMgr) {
            DashboardMgr db = new DashboardMgr(emp);
            db.setVisible(true);
        } else {
            DashboardMgr db = new DashboardMgr(emp);
            db.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_resetMouseExited

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        tableupdate();
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
    }//GEN-LAST:event_resetActionPerformed

    private void monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseClicked

    }//GEN-LAST:event_monthMouseClicked

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_yearMouseClicked

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
            java.util.logging.Logger.getLogger(Employee_Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Employee_Salary(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JButton reset;
    private javax.swing.JTable salrep;
    private javax.swing.JButton search1;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
