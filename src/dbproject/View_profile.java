package dbproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class View_profile extends javax.swing.JFrame {

    int emp;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public View_profile(int emp) {
        initComponents();
        this.emp = emp;

        //making connection to database
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        setfields();
    }

    private void setfields() {
        try {
            pst = con.prepareStatement("select * from employee e inner join department d using (department_ID)\n"
                    + "left outer join (select employee_id, Concat_WS(\" \", first_name, last_name) as Mname from employee) m\n"
                    + " on m.`Employee_ID`= d.`manager_ID` where e.employee_id = ? ");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (rs.next()) {
                fname.setText(rs.getString("e.first_name"));
                lname.setText(rs.getString("last_name"));
                email.setText(rs.getString("email"));
                eid.setText(rs.getString("e.employee_id"));
                bankacc.setText(rs.getString("bank_account"));
                address.setText(rs.getString("address"));
                deptid.setText(rs.getString("department_id"));
                dname.setText(rs.getString("department_name"));
                hiredate.setText(rs.getString("hire_date"));
                mid.setText(rs.getString("manager_id"));
                mname.setText(rs.getString("mname"));
                password.setText(rs.getString("password"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(View_profile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        first_name1 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        first_name2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        first_name3 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        first_name4 = new javax.swing.JLabel();
        bankacc = new javax.swing.JTextField();
        first_name6 = new javax.swing.JLabel();
        hiredate = new javax.swing.JTextField();
        first_name7 = new javax.swing.JLabel();
        deptid = new javax.swing.JTextField();
        first_name8 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        empID = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        first_name9 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        first_name10 = new javax.swing.JLabel();
        mid = new javax.swing.JTextField();
        first_name11 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Profile");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 260, 43);

        first_name.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name.setForeground(new java.awt.Color(52, 45, 71));
        first_name.setText("First Name:");
        jPanel1.add(first_name);
        first_name.setBounds(50, 80, 80, 15);

        fname.setEditable(false);
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(50, 100, 240, 30);

        first_name1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name1.setForeground(new java.awt.Color(52, 45, 71));
        first_name1.setText("Last Name:");
        jPanel1.add(first_name1);
        first_name1.setBounds(340, 80, 80, 15);

        eid.setEditable(false);
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });
        jPanel1.add(eid);
        eid.setBounds(340, 160, 240, 30);

        first_name2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name2.setForeground(new java.awt.Color(52, 45, 71));
        first_name2.setText("Email:");
        jPanel1.add(first_name2);
        first_name2.setBounds(50, 140, 80, 15);

        email.setEditable(false);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(50, 160, 240, 30);

        first_name3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name3.setForeground(new java.awt.Color(52, 45, 71));
        first_name3.setText("Address:");
        jPanel1.add(first_name3);
        first_name3.setBounds(50, 200, 80, 15);

        address.setEditable(false);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(50, 220, 240, 50);

        first_name4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name4.setForeground(new java.awt.Color(52, 45, 71));
        first_name4.setText("Bank Account:");
        jPanel1.add(first_name4);
        first_name4.setBounds(340, 200, 80, 15);

        bankacc.setEditable(false);
        bankacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankaccActionPerformed(evt);
            }
        });
        jPanel1.add(bankacc);
        bankacc.setBounds(340, 220, 240, 30);

        first_name6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name6.setForeground(new java.awt.Color(52, 45, 71));
        first_name6.setText(" Hiredate:");
        jPanel1.add(first_name6);
        first_name6.setBounds(50, 410, 80, 15);

        hiredate.setEditable(false);
        hiredate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiredateActionPerformed(evt);
            }
        });
        jPanel1.add(hiredate);
        hiredate.setBounds(50, 430, 240, 30);

        first_name7.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name7.setForeground(new java.awt.Color(52, 45, 71));
        first_name7.setText("Department ID:");
        jPanel1.add(first_name7);
        first_name7.setBounds(50, 290, 80, 15);

        deptid.setEditable(false);
        deptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptidActionPerformed(evt);
            }
        });
        jPanel1.add(deptid);
        deptid.setBounds(50, 310, 240, 30);

        first_name8.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name8.setForeground(new java.awt.Color(52, 45, 71));
        first_name8.setText("Password:");
        jPanel1.add(first_name8);
        first_name8.setBounds(340, 410, 80, 15);

        password.setEditable(false);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password);
        password.setBounds(340, 430, 240, 30);

        empID.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        empID.setForeground(new java.awt.Color(52, 45, 71));
        empID.setText("Employee ID:");
        jPanel1.add(empID);
        empID.setBounds(340, 140, 80, 15);

        lname.setEditable(false);
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(340, 100, 240, 30);

        first_name9.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name9.setForeground(new java.awt.Color(52, 45, 71));
        first_name9.setText("Department Name:");
        jPanel1.add(first_name9);
        first_name9.setBounds(340, 290, 100, 15);

        dname.setEditable(false);
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });
        jPanel1.add(dname);
        dname.setBounds(340, 310, 240, 30);

        first_name10.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name10.setForeground(new java.awt.Color(52, 45, 71));
        first_name10.setText("Manager ID:");
        jPanel1.add(first_name10);
        first_name10.setBounds(50, 350, 80, 15);

        mid.setEditable(false);
        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });
        jPanel1.add(mid);
        mid.setBounds(50, 370, 240, 30);

        first_name11.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name11.setForeground(new java.awt.Color(52, 45, 71));
        first_name11.setText("Manager Name:");
        jPanel1.add(first_name11);
        first_name11.setBounds(340, 350, 90, 15);

        mname.setEditable(false);
        mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnameActionPerformed(evt);
            }
        });
        jPanel1.add(mname);
        mname.setBounds(340, 370, 240, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(52, 45, 71));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jButton2.setText("Dashboard");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 45, 71)));
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 0, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void deptidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptidActionPerformed

    private void hiredateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiredateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hiredateActionPerformed

    private void bankaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankaccActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eidActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnameActionPerformed

    private void midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midActionPerformed

    private void mnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(View_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_profile(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField bankacc;
    private javax.swing.JTextField deptid;
    private javax.swing.JTextField dname;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField email;
    private javax.swing.JLabel empID;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel first_name10;
    private javax.swing.JLabel first_name11;
    private javax.swing.JLabel first_name2;
    private javax.swing.JLabel first_name3;
    private javax.swing.JLabel first_name4;
    private javax.swing.JLabel first_name6;
    private javax.swing.JLabel first_name7;
    private javax.swing.JLabel first_name8;
    private javax.swing.JLabel first_name9;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField hiredate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mid;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables
}
