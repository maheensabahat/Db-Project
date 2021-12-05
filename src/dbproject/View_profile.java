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
    boolean isMgr;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public View_profile(int emp, boolean isMgr) {
        initComponents();
        this.emp = emp;
        this.isMgr = isMgr;

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
        jLabel2 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        first_name.setBounds(50, 60, 80, 20);

        fname.setEditable(false);
        fname.setFocusable(false);
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(50, 80, 240, 30);

        first_name1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name1.setForeground(new java.awt.Color(52, 45, 71));
        first_name1.setText("Last Name:");
        jPanel1.add(first_name1);
        first_name1.setBounds(340, 60, 80, 15);

        eid.setEditable(false);
        eid.setFocusable(false);
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });
        jPanel1.add(eid);
        eid.setBounds(340, 130, 240, 30);

        first_name2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name2.setForeground(new java.awt.Color(52, 45, 71));
        first_name2.setText("Email:");
        jPanel1.add(first_name2);
        first_name2.setBounds(50, 110, 80, 20);

        email.setEditable(false);
        email.setFocusable(false);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(50, 130, 240, 30);

        first_name3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name3.setForeground(new java.awt.Color(52, 45, 71));
        first_name3.setText("Address:");
        jPanel1.add(first_name3);
        first_name3.setBounds(50, 160, 80, 20);

        address.setEditable(false);
        address.setFocusable(false);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(50, 180, 240, 50);

        first_name4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name4.setForeground(new java.awt.Color(52, 45, 71));
        first_name4.setText("Bank Account:");
        jPanel1.add(first_name4);
        first_name4.setBounds(340, 160, 90, 20);

        bankacc.setEditable(false);
        bankacc.setFocusable(false);
        bankacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankaccActionPerformed(evt);
            }
        });
        jPanel1.add(bankacc);
        bankacc.setBounds(340, 180, 240, 30);

        first_name6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name6.setForeground(new java.awt.Color(52, 45, 71));
        first_name6.setText(" Hiredate:");
        jPanel1.add(first_name6);
        first_name6.setBounds(50, 330, 80, 20);

        hiredate.setEditable(false);
        hiredate.setFocusable(false);
        hiredate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiredateActionPerformed(evt);
            }
        });
        jPanel1.add(hiredate);
        hiredate.setBounds(50, 350, 240, 30);

        first_name7.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name7.setForeground(new java.awt.Color(52, 45, 71));
        first_name7.setText("Department ID:");
        jPanel1.add(first_name7);
        first_name7.setBounds(50, 230, 100, 20);

        deptid.setEditable(false);
        deptid.setFocusable(false);
        deptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptidActionPerformed(evt);
            }
        });
        jPanel1.add(deptid);
        deptid.setBounds(50, 250, 240, 30);

        first_name8.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name8.setForeground(new java.awt.Color(52, 45, 71));
        first_name8.setText("Password:");
        jPanel1.add(first_name8);
        first_name8.setBounds(340, 330, 80, 20);

        password.setEditable(false);
        password.setFocusable(false);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password);
        password.setBounds(340, 350, 240, 30);

        empID.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        empID.setForeground(new java.awt.Color(52, 45, 71));
        empID.setText("Employee ID:");
        jPanel1.add(empID);
        empID.setBounds(340, 110, 100, 20);

        lname.setEditable(false);
        lname.setFocusable(false);
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(340, 80, 240, 30);

        first_name9.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name9.setForeground(new java.awt.Color(52, 45, 71));
        first_name9.setText("Department Name:");
        jPanel1.add(first_name9);
        first_name9.setBounds(340, 230, 120, 20);

        dname.setEditable(false);
        dname.setFocusable(false);
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });
        jPanel1.add(dname);
        dname.setBounds(340, 250, 240, 30);

        first_name10.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name10.setForeground(new java.awt.Color(52, 45, 71));
        first_name10.setText("Manager ID:");
        jPanel1.add(first_name10);
        first_name10.setBounds(50, 280, 80, 20);

        mid.setEditable(false);
        mid.setFocusable(false);
        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });
        jPanel1.add(mid);
        mid.setBounds(50, 300, 240, 30);

        first_name11.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name11.setForeground(new java.awt.Color(52, 45, 71));
        first_name11.setText("Manager Name:");
        jPanel1.add(first_name11);
        first_name11.setBounds(340, 280, 100, 20);

        mname.setEditable(false);
        mname.setFocusable(false);
        mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnameActionPerformed(evt);
            }
        });
        jPanel1.add(mname);
        mname.setBounds(340, 300, 240, 30);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel2.setText("Dashboard");
        jLabel2.setFocusable(false);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(500, 0, 130, 40);

        add1.setBackground(new java.awt.Color(52, 45, 71));
        add1.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setText("Change Password");
        add1.setFocusPainted(false);
        add1.setFocusable(false);
        add1.setRequestFocusEnabled(false);
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1);
        add1.setBounds(450, 390, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        new Change_password(emp, isMgr).setVisible(true);
    }//GEN-LAST:event_add1ActionPerformed

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
               new View_profile(1, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mid;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables
}
