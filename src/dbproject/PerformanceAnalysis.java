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
public class PerformanceAnalysis extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public PerformanceAnalysis() {
        initComponents();
        
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PerformanceAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;


        PA.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        PA.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        PA.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));

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
        jScrollPane1 = new javax.swing.JScrollPane();
        PA = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Sbdate = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        Month = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        empID2 = new javax.swing.JLabel();
        searchbemp = new javax.swing.JLabel();
        Date1 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        searchbemp1 = new javax.swing.JLabel();
        empid1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 45, 71)));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        PA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 45, 71)));
        PA.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        PA.setForeground(new java.awt.Color(52, 45, 71));
        PA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Month", "Year", "Task Rating", "Absences", "Tasks completed"
            }
        ));
        PA.setGridColor(new java.awt.Color(52, 45, 71));
        PA.setSelectionBackground(new java.awt.Color(130, 120, 158));
        jScrollPane1.setViewportView(PA);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 690, 280);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Performance Analysis");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 340, 40);

        Sbdate.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Date:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(350, 70, 120, 20);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(320, 420, 190, 30);

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
        search1.setBounds(230, 92, 90, 25);

        Date.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Month: ");
        jPanel1.add(Date);
        Date.setBounds(350, 100, 80, 14);

        Month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthActionPerformed(evt);
            }
        });
        jPanel1.add(Month);
        Month.setBounds(390, 90, 90, 30);

        search2.setBackground(new java.awt.Color(38, 32, 54));
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search2.setText("Search");
        search2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search2MouseExited(evt);
            }
        });
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        jPanel1.add(search2);
        search2.setBounds(630, 92, 90, 25);

        empID2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        empID2.setForeground(new java.awt.Color(52, 45, 71));
        empID2.setText("Employee ID:");
        jPanel1.add(empID2);
        empID2.setBounds(30, 100, 80, 14);

        searchbemp.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        searchbemp.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp.setText("Star Employee:");
        jPanel1.add(searchbemp);
        searchbemp.setBounds(210, 430, 100, 18);

        Date1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        Date1.setForeground(new java.awt.Color(52, 45, 71));
        Date1.setText("Year:");
        jPanel1.add(Date1);
        Date1.setBounds(490, 100, 80, 14);

        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel1.add(year);
        year.setBounds(520, 90, 90, 30);

        searchbemp1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        searchbemp1.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp1.setText("Search by Employee:");
        jPanel1.add(searchbemp1);
        searchbemp1.setBounds(30, 70, 150, 18);

        empid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empid1ActionPerformed(evt);
            }
        });
        jPanel1.add(empid1);
        empid1.setBounds(110, 90, 100, 30);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel2.setText("Dashboard");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 10, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void MonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
        int c;

        String m = Month.getText();
        String y = year.getText();
        String d = m + " " + y;

        try {

            pst = con.prepareStatement("SELECT substr(date, 1, instr(date, \" \")) as month,"
                    + "substr(date, instr(date, \" \"))as year, task_rating, absences,\n"
                    + " tasks_completed FROM Performance_analysis"
                    + " where date = ? ");

            pst.setString(1, d);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) PA.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("task_rating"));
                    v2.add(rs.getString("absences"));
                    v2.add(rs.getString("tasks_completed"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_search2ActionPerformed

    private void empid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empid1ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
        int c;

        String empid = empid1.getText();
        try {

            pst = con.prepareStatement("SELECT substr(date, 1, instr(date, \" \")) as month,"
                    + "substr(date, instr(date, \" \"))as year, task_rating, absences,\n"
                    + " tasks_completed FROM Performance_analysis"
                    + " where employee_id = ?");
           // pst.setInt(1, empid);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) PA.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("task_rating"));
                    v2.add(rs.getString("absences"));
                    v2.add(rs.getString("tasks_completed"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Employee_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_search1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void search1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseEntered
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search1MouseEntered

    private void search1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseExited
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(38, 32, 54));


    }//GEN-LAST:event_search1MouseExited

    private void search2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseEntered
        // TODO add your handling code here:
        search2.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search2MouseEntered

    private void search2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseExited
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search2MouseExited

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
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerformanceAnalysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Date1;
    private javax.swing.JTextField Month;
    private javax.swing.JTable PA;
    private javax.swing.JLabel Sbdate;
    private javax.swing.JLabel empID2;
    private javax.swing.JTextField empid;
    private javax.swing.JTextField empid1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JLabel searchbemp;
    private javax.swing.JLabel searchbemp1;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}