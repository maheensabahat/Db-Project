package dbproject;

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
public class PerformanceAnalysis extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public PerformanceAnalysis() {
        initComponents();

        error1.setVisible(false);
        error2.setVisible(false);

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

        tableupdate();
        setStarName();
    }

    private void setStarName() {
        String query = "select * from staremployees join employee using (employee_id)"
                + " where month = Date_format(sysdate(),'%M %Y')";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                name.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerformanceAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select employee_id, substr(month_of_pa, "
                    + "1, instr(month_of_pa, \" \")) as month,"
                    + "substr(month_of_pa, instr(month_of_pa, \" \"))as year, task_scores,"
                    + "absences, tasks_completed from performance_analysis");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) PA.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("Month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("task_scores"));
                    v2.add(rs.getString("absences"));
                    v2.add(rs.getString("task_scores"));
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
        PA = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Sbdate = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        searchemp = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        search2 = new javax.swing.JButton();
        empID2 = new javax.swing.JLabel();
        searchbemp = new javax.swing.JLabel();
        Date1 = new javax.swing.JLabel();
        searchbemp1 = new javax.swing.JLabel();
        empid1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Generate_Analysis = new javax.swing.JButton();
        setstar = new javax.swing.JButton();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        reset = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();

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
                "Employee ID", "Month", "Year", "Task Scores", "Absences", "Tasks completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PA.setFocusable(false);
        PA.setGridColor(new java.awt.Color(52, 45, 71));
        PA.setSelectionBackground(new java.awt.Color(130, 120, 158));
        PA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PA);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 180, 690, 270);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Performance Analysis");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 340, 40);

        Sbdate.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Date:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(350, 120, 120, 20);

        name.setEditable(false);
        name.setFocusable(false);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });
        jPanel1.add(name);
        name.setBounds(150, 70, 180, 30);

        searchemp.setBackground(new java.awt.Color(38, 32, 54));
        searchemp.setForeground(new java.awt.Color(255, 255, 255));
        searchemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        searchemp.setText("search");
        searchemp.setFocusPainted(false);
        searchemp.setFocusable(false);
        searchemp.setRequestFocusEnabled(false);
        searchemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchempMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchempMouseExited(evt);
            }
        });
        searchemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchempActionPerformed(evt);
            }
        });
        jPanel1.add(searchemp);
        searchemp.setBounds(220, 140, 90, 25);

        Date.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Month: ");
        jPanel1.add(Date);
        Date.setBounds(350, 150, 80, 14);

        search2.setBackground(new java.awt.Color(38, 32, 54));
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search2.setText("Search");
        search2.setFocusPainted(false);
        search2.setFocusable(false);
        search2.setRequestFocusEnabled(false);
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
        search2.setBounds(630, 140, 90, 25);

        empID2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        empID2.setForeground(new java.awt.Color(52, 45, 71));
        empID2.setText("Employee ID:");
        jPanel1.add(empID2);
        empID2.setBounds(30, 150, 80, 14);

        searchbemp.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        searchbemp.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp.setText("Star Employee:");
        jPanel1.add(searchbemp);
        searchbemp.setBounds(30, 80, 110, 18);

        Date1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        Date1.setForeground(new java.awt.Color(52, 45, 71));
        Date1.setText("Year:");
        jPanel1.add(Date1);
        Date1.setBounds(490, 150, 80, 14);

        searchbemp1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        searchbemp1.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp1.setText("Search by Employee:");
        jPanel1.add(searchbemp1);
        searchbemp1.setBounds(30, 120, 150, 18);

        empid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empid1ActionPerformed(evt);
            }
        });
        jPanel1.add(empid1);
        empid1.setBounds(110, 140, 100, 30);

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

        Generate_Analysis.setBackground(new java.awt.Color(38, 32, 54));
        Generate_Analysis.setForeground(new java.awt.Color(255, 255, 255));
        Generate_Analysis.setText("Generate Analysis for this month");
        Generate_Analysis.setFocusPainted(false);
        Generate_Analysis.setFocusable(false);
        Generate_Analysis.setRequestFocusEnabled(false);
        Generate_Analysis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Generate_AnalysisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Generate_AnalysisMouseExited(evt);
            }
        });
        Generate_Analysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_AnalysisActionPerformed(evt);
            }
        });
        jPanel1.add(Generate_Analysis);
        Generate_Analysis.setBounds(500, 70, 210, 25);

        setstar.setBackground(new java.awt.Color(38, 32, 54));
        setstar.setForeground(new java.awt.Color(255, 255, 255));
        setstar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/save.png"))); // NOI18N
        setstar.setText("Save");
        setstar.setFocusPainted(false);
        setstar.setFocusable(false);
        setstar.setRequestFocusEnabled(false);
        setstar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setstarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setstarMouseExited(evt);
            }
        });
        setstar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setstarActionPerformed(evt);
            }
        });
        jPanel1.add(setstar);
        setstar.setBounds(340, 72, 80, 25);

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
        month.setBounds(390, 140, 90, 29);

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
        year.setBounds(520, 140, 90, 29);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Table");
        reset.setFocusable(false);
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
        reset.setBounds(620, 450, 100, 20);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("Select a record from table to proceed.");
        jPanel1.add(error1);
        error1.setBounds(120, 40, 280, 40);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(102, 255, 102));
        error2.setText("saved!");
        jPanel1.add(error2);
        error2.setBounds(350, 50, 50, 20);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
        int c;

        String m = (String) month.getSelectedItem();
        String y = (String) year.getSelectedItem();
        String d = m + " " + y;

        try {

            pst = con.prepareStatement("select employee_id, substr(month_of_pa, "
                    + "1, instr(month_of_pa, \" \")) as month,"
                    + "substr(month_of_pa, instr(month_of_pa, \" \"))as year, task_scores,"
                    + "absences, tasks_completed from performance_analysis"
                    + " where month_of_pa = ? ");

            pst.setString(1, d);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) PA.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("Month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("task_scores"));
                    v2.add(rs.getString("absences"));
                    v2.add(rs.getString("task_scores"));
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

    private void searchempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchempActionPerformed
        // TODO add your handling code here:
        int c;

        try {
            int empid = Integer.parseInt(empid1.getText());
            try {

                pst = con.prepareStatement("select employee_id, substr(month_of_pa, "
                        + "1, instr(month_of_pa, \" \")) as month,"
                        + "substr(month_of_pa, instr(month_of_pa, \" \"))as year, task_scores,"
                        + "absences, tasks_completed from performance_analysis"
                        + " where employee_id = ?");
                pst.setInt(1, empid);
                rs = pst.executeQuery();

                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                DefaultTableModel dft = (DefaultTableModel) PA.getModel();
                dft.setRowCount(0);

                while (rs.next()) {
                    Vector v2 = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("Month"));
                        v2.add(rs.getString("year"));
                        v2.add(rs.getString("task_scores"));
                        v2.add(rs.getString("absences"));
                        v2.add(rs.getString("task_scores"));
                    }

                    dft.addRow(v2);

                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Employee_Salary.class
                        .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            empid1.setText("");
            empid1.grabFocus();
        }

    }//GEN-LAST:event_searchempActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void searchempMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchempMouseEntered
        // TODO add your handling code here:
        searchemp.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_searchempMouseEntered

    private void searchempMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchempMouseExited
        // TODO add your handling code here:
        searchemp.setBackground(new java.awt.Color(38, 32, 54));


    }//GEN-LAST:event_searchempMouseExited

    private void search2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseEntered
        // TODO add your handling code here:
        search2.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search2MouseEntered

    private void search2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseExited
        // TODO add your handling code here:
        search2.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search2MouseExited

    private void Generate_AnalysisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Generate_AnalysisMouseEntered
        Generate_Analysis.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_Generate_AnalysisMouseEntered

    private void Generate_AnalysisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Generate_AnalysisMouseExited
        // TODO add your handling code here:
        Generate_Analysis.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_Generate_AnalysisMouseExited

    private void Generate_AnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_AnalysisActionPerformed
        //Generate Analysis

        //Get employee working
        try {

            pst = con.prepareStatement("select employee_id from Employee"
                    + " where status = 'Working'");
            rs = pst.executeQuery();

            ResultSet rs1;
            ResultSet rs2;
            ResultSet rs3;
            ResultSet rs4;

            while (rs.next()) {
                //get empID
                int emp = Integer.parseInt(rs.getString("employee_id"));
                System.out.println(emp);

                //generate score rating
                pst = con.prepareStatement("select Sum(ifnull(rating,0)) as score from "
                        + "Employee_task join task using (task_id)\n"
                        + "where end_date = Date_format(sysdate(),'%M %Y') and employee_id = ?");
                pst.setInt(1, emp);
                rs1 = pst.executeQuery();

                int score = 0;
                if (rs1.next()) {
                    score = rs1.getInt("score");
                }
                System.out.println(score);

                //generate tasks completed
                pst = con.prepareStatement("select count(*) as completed from "
                        + "Employee_task join task using (task_id)\n"
                        + "where end_date = Date_format(sysdate(),'%M %Y') "
                        + "and hours is not null and employee_id = ?");
                pst.setInt(1, emp);
                rs2 = pst.executeQuery();

                int TC = 0;
                if (rs1.next()) {
                    TC = rs2.getInt("completed");
                }
                System.out.println(TC);

                pst = con.prepareStatement("select count(*) as absences from attendance "
                        + "where date = Date_format(sysdate(),'%M %Y') "
                        + "and attendance = 'Absent' and employee_id = ?");
                pst.setInt(1, emp);
                rs3 = pst.executeQuery();

                int AB = 0;
                if (rs1.next()) {
                    AB = rs3.getInt("completed");
                }
                System.out.println(AB);

                try {
                    pst = con.prepareStatement("insert into performance_analysis "
                            + "values (?, ?, ?, ?, Date_format(sysdate(),'%M %Y'))");
                    pst.setInt(1, emp);
                    pst.setInt(2, score);
                    pst.setInt(3, AB);
                    pst.setInt(4, TC);

                    pst.executeUpdate();

                    tableupdate();
                } catch (SQLIntegrityConstraintViolationException e) {
                    //update records for month if already present
                    String query = "update performance_analysis set task_scores = ?,"
                            + "absences = ?, tasks_completed= ? "
                            + "where Employee_ID = ? and month_of_pa = Date_format(sysdate(),'%M %Y') ";
                    pst = con.prepareStatement(query);
                    pst.setInt(4, emp);
                    pst.setInt(1, score);
                    pst.setInt(2, AB);
                    pst.setInt(3, TC);
                    pst.executeUpdate();
                    pst.close();
                }
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Generate_AnalysisActionPerformed

    private void setstarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setstarMouseEntered
        setstar.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_setstarMouseEntered

    private void setstarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setstarMouseExited
        setstar.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_setstarMouseExited

    private void setstarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setstarActionPerformed
        DefaultTableModel model = (DefaultTableModel) PA.getModel();
        int selectedIndex = PA.getSelectedRow();

        if (selectedIndex != -1) {
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            try {

                String query = "insert into staremployees values (?, Date_format(sysdate(),'%M %Y'));";
                pst = con.prepareStatement(query);
                pst.setInt(1, id);
                pst.executeUpdate();

                error2.setVisible(true);
                setStarName();
            } catch (SQLIntegrityConstraintViolationException e) {
                String query = "update staremployees set employee_id = ?\n"
                        + "where month = Date_format(sysdate(),'%M %Y');";
                try {
                    pst = con.prepareStatement(query);
                    pst.setInt(1, id);
                    pst.executeUpdate();

                    error2.setVisible(true);
                    setStarName();
                } catch (SQLException ex) {
                    Logger.getLogger(PerformanceAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }

        } else {
            error1.setVisible(true);
        }

    }//GEN-LAST:event_setstarActionPerformed

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
        tableupdate();
    }//GEN-LAST:event_resetActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed

    }//GEN-LAST:event_nameKeyPressed

    private void PAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAMouseClicked
        error1.setVisible(false);
        error2.setVisible(false);
        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) PA.getModel();
        int selectedIndex = PA.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        try {

            String query = "Select * from employee where employee_id = ? ";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                name.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_PAMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton Generate_Analysis;
    private javax.swing.JTable PA;
    private javax.swing.JLabel Sbdate;
    private javax.swing.JLabel empID2;
    private javax.swing.JTextField empid1;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField name;
    private javax.swing.JButton reset;
    private javax.swing.JButton search2;
    private javax.swing.JLabel searchbemp;
    private javax.swing.JLabel searchbemp1;
    private javax.swing.JButton searchemp;
    private javax.swing.JButton setstar;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
