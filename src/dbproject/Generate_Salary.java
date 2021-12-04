/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

import java.beans.Statement;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abc
 */
public class Generate_Salary extends javax.swing.JFrame {

    int emp;
    boolean isMgr;
    boolean noSal;
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Database db;

    public Generate_Salary(int emp, boolean isMgr) {
        initComponents();
        this.emp = emp;
        this.isMgr = isMgr;

        error1.setVisible(false);
        Check.setVisible(false);
        Name.setVisible(false);
        Date.setVisible(false);
        Amount.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Generate_Salary.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        setFields();
    }

    private void setFields() { //table updated after every change
        empid.setText(Integer.toString(emp));

        DateFormat df = new SimpleDateFormat("dd-MM-yy");
        Date dateobj = new Date();
        date.setText(df.format(dateobj));

        try {

            pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\"-\", e.first_name, e.last_name) as name,"
                    + "s.salary, s.bonus, s.travel_allowance, s.medical_allowance, e.status\n"
                    + "FROM monthly_salary s\n"
                    + "INNER JOIN Employee e using (Employee_ID) "
                    + "where employee_id = ? and date = Date_format(sysdate(),'%M %Y') ");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (rs.next()) {
                Name.setText(rs.getString("name"));
                Date.setText(date.getText());
                Double sal = Double.parseDouble(rs.getString("salary"));
                Double b = Double.parseDouble(rs.getString("bonus"));
                Double TA = Double.parseDouble(rs.getString("travel_allowance"));
                Double MA = Double.parseDouble(rs.getString("medical_allowance"));
                Double Total = sal + b + TA + MA;

                Amount.setText(Total.toString());
                salary.setText(rs.getString("salary"));
                bonus.setText(rs.getString("bonus"));
                travel.setText(rs.getString("travel_allowance"));
                medical.setText(rs.getString("medical_allowance"));
                total.setText(Total.toString());

            } else {
                error1.setVisible(true);
                noSal = true;
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
        Salary_txt = new javax.swing.JLabel();
        emp_id_txt = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        date_txt = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        base_salary = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        bonus_txt = new javax.swing.JLabel();
        bonus = new javax.swing.JTextField();
        travel_allowance = new javax.swing.JLabel();
        travel = new javax.swing.JTextField();
        Generate = new javax.swing.JButton();
        medical_allowance = new javax.swing.JLabel();
        medical = new javax.swing.JTextField();
        error1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        medical_allowance1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        Date = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Amount = new javax.swing.JLabel();
        Check = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 550));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(52, 45, 71));
        jPanel1.setLayout(null);

        Salary_txt.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        Salary_txt.setForeground(new java.awt.Color(52, 45, 71));
        Salary_txt.setText("Generate Salary");
        jPanel1.add(Salary_txt);
        Salary_txt.setBounds(20, 10, 330, 43);

        emp_id_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        emp_id_txt.setForeground(new java.awt.Color(52, 45, 71));
        emp_id_txt.setText("*Employee ID:");
        jPanel1.add(emp_id_txt);
        emp_id_txt.setBounds(30, 70, 90, 20);

        empid.setEditable(false);
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
        jPanel1.add(empid);
        empid.setBounds(30, 90, 90, 30);

        date_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        date_txt.setForeground(new java.awt.Color(52, 45, 71));
        date_txt.setText("Date:");
        jPanel1.add(date_txt);
        date_txt.setBounds(140, 70, 90, 20);

        date.setEditable(false);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(140, 90, 150, 30);

        base_salary.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        base_salary.setForeground(new java.awt.Color(52, 45, 71));
        base_salary.setText("*Base Salary:");
        jPanel1.add(base_salary);
        base_salary.setBounds(310, 70, 120, 20);

        salary.setEditable(false);
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        jPanel1.add(salary);
        salary.setBounds(310, 90, 260, 30);

        bonus_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        bonus_txt.setForeground(new java.awt.Color(52, 45, 71));
        bonus_txt.setText("Bonus:");
        jPanel1.add(bonus_txt);
        bonus_txt.setBounds(30, 170, 110, 20);

        bonus.setEditable(false);
        bonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonusActionPerformed(evt);
            }
        });
        jPanel1.add(bonus);
        bonus.setBounds(30, 190, 260, 30);

        travel_allowance.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        travel_allowance.setForeground(new java.awt.Color(52, 45, 71));
        travel_allowance.setText("Travel allowance:");
        jPanel1.add(travel_allowance);
        travel_allowance.setBounds(30, 120, 100, 20);

        travel.setEditable(false);
        travel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                travelActionPerformed(evt);
            }
        });
        jPanel1.add(travel);
        travel.setBounds(30, 140, 260, 30);

        Generate.setBackground(new java.awt.Color(38, 32, 54));
        Generate.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        Generate.setForeground(new java.awt.Color(255, 255, 255));
        Generate.setText("Generate Pay Check");
        Generate.setFocusPainted(false);
        Generate.setFocusable(false);
        Generate.setRequestFocusEnabled(false);
        Generate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GenerateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GenerateMouseExited(evt);
            }
        });
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });
        jPanel1.add(Generate);
        Generate.setBounds(230, 225, 130, 30);

        medical_allowance.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        medical_allowance.setForeground(new java.awt.Color(52, 45, 71));
        medical_allowance.setText("Medical Allowance:");
        jPanel1.add(medical_allowance);
        medical_allowance.setBounds(310, 120, 110, 20);

        medical.setEditable(false);
        medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalActionPerformed(evt);
            }
        });
        jPanel1.add(medical);
        medical.setBounds(310, 140, 260, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("Salary for this Month has not been added to record yet.");
        jPanel1.add(error1);
        error1.setBounds(30, 50, 370, 30);

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
        jLabel2.setBounds(500, 0, 130, 40);

        medical_allowance1.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        medical_allowance1.setForeground(new java.awt.Color(52, 45, 71));
        medical_allowance1.setText("Total:");
        jPanel1.add(medical_allowance1);
        medical_allowance1.setBounds(310, 170, 110, 20);

        total.setEditable(false);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel1.add(total);
        total.setBounds(310, 190, 260, 30);

        Date.setText("Date");
        jPanel1.add(Date);
        Date.setBounds(430, 300, 140, 20);

        Name.setText("Name");
        jPanel1.add(Name);
        Name.setBounds(140, 344, 290, 30);

        Amount.setText("Amount");
        jPanel1.add(Amount);
        Amount.setBounds(470, 350, 90, 20);

        Check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Cheque.jpg"))); // NOI18N
        jPanel1.add(Check);
        Check.setBounds(30, 250, 580, 250);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 630, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void empidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empidKeyTyped

    }//GEN-LAST:event_empidKeyTyped

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed

    private void bonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bonusActionPerformed

    private void travelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_travelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_travelActionPerformed

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        if (!noSal) {
            Check.setVisible(true);
            Name.setVisible(true);
            Date.setVisible(true);
            Amount.setVisible(true);
        }
    }//GEN-LAST:event_GenerateActionPerformed

    private void medicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicalActionPerformed

    private void GenerateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateMouseExited
        // TODO add your handling code here:
        Generate.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_GenerateMouseExited

    private void GenerateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateMouseEntered
        // TODO add your handling code here:
        Generate.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_GenerateMouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (isMgr) {
            DashboardMgr db = new DashboardMgr(emp);
            db.setVisible(true);
        } else {
            DashboardEmp db = new DashboardEmp(emp);
            db.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

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
            java.util.logging.Logger.getLogger(Generate_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generate_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generate_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generate_Salary.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Generate_Salary(6, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel Check;
    private javax.swing.JLabel Date;
    private javax.swing.JButton Generate;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Salary_txt;
    private javax.swing.JLabel base_salary;
    private javax.swing.JTextField bonus;
    private javax.swing.JLabel bonus_txt;
    private javax.swing.JTextField date;
    private javax.swing.JLabel date_txt;
    private javax.swing.JLabel emp_id_txt;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField medical;
    private javax.swing.JLabel medical_allowance;
    private javax.swing.JLabel medical_allowance1;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField total;
    private javax.swing.JTextField travel;
    private javax.swing.JLabel travel_allowance;
    // End of variables declaration//GEN-END:variables
}
