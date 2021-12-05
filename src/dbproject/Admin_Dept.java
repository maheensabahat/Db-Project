package dbproject;

import java.beans.Statement;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class Admin_Dept extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Database db;

    public Admin_Dept() {
        initComponents();

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Dept.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();

        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);
        error6.setVisible(false);
        error7.setVisible(false);

        Dept.getTableHeader().setOpaque(true);
//        Dept.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Dept.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Dept.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("SELECT d.department_ID, CONCAT_WS(\" \", m.first_name, m.last_name) as Mname,"
                    + " d.department_name, d.manager_id \n"
                    + "FROM department d\n"
                    + "left outer JOIN Employee m on d.manager_id = m.employee_id");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Dept.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("department_id"));
                    v2.add(rs.getString("department_name"));
                    v2.add(rs.getString("manager_id"));
                    v2.add(rs.getString("Mname"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private boolean checkfields() { //check if required fields are there
        if (DeptID.getText().equals("") || DeptName.getText().equals("")
                || MgrID.getText().equals("")) {
            error1.setVisible(true);

            if (DeptID.getText().trim().isEmpty()) {
                DeptID.grabFocus();
                return true;
            } else if (DeptName.getText().trim().isEmpty()) {
                DeptName.grabFocus();
                return true;
            } else if (MgrID.getText().trim().isEmpty()) {
                MgrID.grabFocus();
                return true;
            }
        }

        return false;

    }

    public boolean checkEmployeeExist(int emp) {
        try {
            pst = con.prepareStatement("select * from Employee where employee_ID = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { //employee not exists
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Dept.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkManagerExist(int emp) {
        try {
            pst = con.prepareStatement("select * from Department where manager_ID = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { //Manager not exists
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Dept.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void setfieldsEmpty() {
        DeptID.setText("");
        DeptName.setText("");
        MgrID.setText("");
        DeptID.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dept = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        DeptID = new javax.swing.JTextField();
        first_name1 = new javax.swing.JLabel();
        DeptName = new javax.swing.JTextField();
        first_name2 = new javax.swing.JLabel();
        MgrID = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        error6 = new javax.swing.JLabel();
        error7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        Dept.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Dept.setForeground(new java.awt.Color(52, 45, 71));
        Dept.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Department ID", "Depart Name", "Manager ID", "Manager Name", "No of Employees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Dept.setFocusable(false);
        Dept.setGridColor(new java.awt.Color(52, 45, 71));
        Dept.setSelectionBackground(new java.awt.Color(130, 120, 158));
        Dept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Dept);
        Dept.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N

        Dept.setForeground(new java.awt.Color(52, 45, 71));

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(278, 60, 452, 340);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Departments");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 330, 43);

        first_name.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name.setForeground(new java.awt.Color(52, 45, 71));
        first_name.setText("*Department ID:");
        jPanel1.add(first_name);
        first_name.setBounds(20, 100, 110, 15);

        DeptID.setSelectionColor(new java.awt.Color(130, 120, 158));
        DeptID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptIDActionPerformed(evt);
            }
        });
        DeptID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DeptIDKeyTyped(evt);
            }
        });
        jPanel1.add(DeptID);
        DeptID.setBounds(20, 120, 250, 30);

        first_name1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name1.setForeground(new java.awt.Color(52, 45, 71));
        first_name1.setText("*Department Name:");
        jPanel1.add(first_name1);
        first_name1.setBounds(20, 170, 130, 15);

        DeptName.setSelectionColor(new java.awt.Color(130, 120, 158));
        DeptName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptNameActionPerformed(evt);
            }
        });
        jPanel1.add(DeptName);
        DeptName.setBounds(20, 190, 250, 30);

        first_name2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        first_name2.setForeground(new java.awt.Color(52, 45, 71));
        first_name2.setText("*Manager ID:");
        jPanel1.add(first_name2);
        first_name2.setBounds(20, 230, 120, 15);

        MgrID.setSelectionColor(new java.awt.Color(130, 120, 158));
        MgrID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MgrIDActionPerformed(evt);
            }
        });
        MgrID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MgrIDKeyPressed(evt);
            }
        });
        jPanel1.add(MgrID);
        MgrID.setBounds(20, 250, 250, 30);

        delete.setBackground(new java.awt.Color(38, 32, 54));
        delete.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.setFocusable(false);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(185, 310, 86, 30);

        add.setBackground(new java.awt.Color(38, 32, 54));
        add.setFont(new java.awt.Font("Rockwell", 1, 9)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/add_new.png"))); // NOI18N
        add.setText("Add");
        add.setFocusable(false);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(19, 310, 70, 30);

        Update.setBackground(new java.awt.Color(38, 32, 54));
        Update.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/update.png"))); // NOI18N
        Update.setText("Update");
        Update.setFocusable(false);
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(94, 310, 87, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("*enter required fields to proceed");
        jPanel1.add(error1);
        error1.setBounds(30, 270, 200, 60);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("Numeric values only");
        jPanel1.add(error2);
        error2.setBounds(123, 100, 200, 15);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Numeric values only");
        jPanel1.add(error3);
        error3.setBounds(110, 230, 200, 15);

        error4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("Invalid Manager ID");
        jPanel1.add(error4);
        error4.setBounds(110, 230, 200, 15);

        error5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error5.setForeground(new java.awt.Color(255, 0, 51));
        error5.setText("Department already exists.");
        jPanel1.add(error5);
        error5.setBounds(20, 80, 240, 20);

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
        jLabel2.setBounds(630, 10, 130, 40);

        error6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error6.setForeground(new java.awt.Color(255, 0, 51));
        error6.setText("Select a record from table to delete/update.");
        jPanel1.add(error6);
        error6.setBounds(10, 280, 280, 40);

        error7.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        error7.setForeground(new java.awt.Color(255, 0, 51));
        error7.setText("This employee manages another department.");
        jPanel1.add(error7);
        error7.setBounds(10, 210, 260, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeptIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptIDActionPerformed

    }//GEN-LAST:event_DeptIDActionPerformed

    private void DeptNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptNameActionPerformed

    private void MgrIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MgrIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MgrIDActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);

        //req fields are there
        if (!checkfields()) {

            //gets Data of selected record from table
            DefaultTableModel model = (DefaultTableModel) Dept.getModel();
            int selectedIndex = Dept.getSelectedRow();

            String Dname = DeptName.getText();

            try {
                int dept = Integer.parseInt(DeptID.getText());
                int mgr = Integer.parseInt(MgrID.getText());

                if (!checkManagerExist(mgr)) {
                    try {

                        String query = "update Department set department_name = ?, manager_ID = ?"
                                + " where department_id = ?";
                        pst = con.prepareStatement(query);
                        pst.setString(1, Dname);
                        pst.setInt(2, mgr);
                        pst.setInt(3, dept);
                        pst.executeUpdate();
                        pst.close();
                        JOptionPane.showMessageDialog(this, "Record Updated.");

                        //Table updated after edits
                        tableupdate();
                        //fields set empty
                        setfieldsEmpty();

                    } catch (SQLIntegrityConstraintViolationException e) {
                        if (checkEmployeeExist(mgr)) {
                            error5.setVisible(true);
                        } else {
                            error4.setVisible(true);
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Dept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else {
                    error7.setVisible(true);
                }

            } catch (NumberFormatException ex) {
                error2.setVisible(true);
                error3.setVisible(true);
            }

        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);

        //req fields are there
        if (!checkfields()) {

            String Dname = DeptName.getText();

            try {
                int dept = Integer.parseInt(DeptID.getText());
                int mgr = Integer.parseInt(MgrID.getText());

                if (!checkManagerExist(mgr)) {
                    try {
                        String query = "insert into Department(department_id, department_name, manager_id)"
                                + " values(?,?,?)";
                        pst = con.prepareStatement(query);
                        pst.setInt(1, dept);
                        pst.setString(2, Dname);
                        pst.setInt(3, mgr);
                        pst.execute();
                        pst.close();
                        JOptionPane.showMessageDialog(this, "Record Addedd.");

                        //Table updates after insertion
                        tableupdate();
                        //fields are set empty again
                        setfieldsEmpty();

                    } catch (SQLIntegrityConstraintViolationException e) {
                        if (checkEmployeeExist(mgr)) {
                            error5.setVisible(true);
                        } else {
                            error4.setVisible(true);
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else {
                    error7.setVisible(true);
                }

            } catch (NumberFormatException ex) {
                error2.setVisible(true);
                error3.setVisible(true);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void DeptIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeptIDKeyTyped
        error1.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);
    }//GEN-LAST:event_DeptIDKeyTyped

    private void DeptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseClicked
        error6.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Dept.getModel();
        int selectedIndex = Dept.getSelectedRow();

        DeptID.setText(model.getValueAt(selectedIndex, 0).toString());
        DeptName.setText(model.getValueAt(selectedIndex, 1).toString());
        try {
            MgrID.setText(model.getValueAt(selectedIndex, 2).toString());
        } catch (NullPointerException ex) {
            MgrID.setText("");
        }

        error1.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);
    }//GEN-LAST:event_DeptMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        //getting selected record
        DefaultTableModel model = (DefaultTableModel) Dept.getModel();
        int selectedIndex = Dept.getSelectedRow();

        if (selectedIndex != -1) {
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogresult == JOptionPane.YES_NO_OPTION) {
                try {

                    pst = con.prepareStatement("delete from Department where department_id = ?");
                    pst.setInt(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Record Deleted.");

                    tableupdate();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }

            //fields set empty
            setfieldsEmpty();
        } else {
            error6.setVisible(false);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        add.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_addMouseEntered

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_UpdateMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBackground(new java.awt.Color(38, 32, 54));


    }//GEN-LAST:event_deleteMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_deleteMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        add.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_addMouseExited

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_UpdateMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void MgrIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MgrIDKeyPressed
        error7.setVisible(false);
    }//GEN-LAST:event_MgrIDKeyPressed

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
                new Admin_Dept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Dept;
    private javax.swing.JTextField DeptID;
    private javax.swing.JTextField DeptName;
    private javax.swing.JTextField MgrID;
    private javax.swing.JButton Update;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel error7;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel first_name2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
