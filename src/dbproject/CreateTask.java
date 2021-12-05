/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

//import com.mysql.cj.exceptions.CJException;
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
public class CreateTask extends javax.swing.JFrame {

    int empid;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public CreateTask(int empid) {
        initComponents();
        this.empid = empid;

        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();

        Task.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Task.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Task.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Task");
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

    private void setfieldsEmpty() {
        taskid.setText("");
        taskdet.setText("");
        taskname.setText("");

        startdate1.setForeground(new java.awt.Color(204, 204, 204));
        enddate1.setForeground(new java.awt.Color(204, 204, 204));
        startdate2.setForeground(new java.awt.Color(204, 204, 204));
        enddate2.setForeground(new java.awt.Color(204, 204, 204));
        startdate3.setForeground(new java.awt.Color(204, 204, 204));
        enddate3.setForeground(new java.awt.Color(204, 204, 204));

        startdate1.setText("Day");
        enddate1.setText("Day");
        startdate2.setText("Month");
        enddate2.setText("Month");
        startdate3.setText("Year");
        enddate3.setText("Year");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Select Status", "Closed", "Open", "Canceled"}));
        taskname.requestFocus();

    }

    private boolean checkfields() { //check if required fields are there
        if (taskname.getText().equals("") || taskdet.getText().equals("")
                || startdate1.getText().equals("") || startdate2.getText().equals("") || startdate3.getText().equals("")
                || enddate1.getText().equals("") || enddate2.getText().equals("") || enddate3.getText().equals("")) {
            error1.setVisible(true);

            if (taskname.getText().trim().isEmpty()) {
                taskname.grabFocus();
                return true;
            } else if (taskdet.getText().trim().isEmpty()) {
                taskdet.grabFocus();
                return true;
            } else if (startdate1.getText().trim().isEmpty()) {
                startdate1.grabFocus();
                return true;
            } else if (startdate2.getText().trim().isEmpty()) {
                startdate2.grabFocus();
                return true;
            } else if (startdate3.getText().trim().isEmpty()) {
                startdate3.grabFocus();
                return true;
            } else if (enddate1.getText().trim().isEmpty()) {
                enddate1.grabFocus();
                return true;
            } else if (enddate2.getText().trim().isEmpty()) {
                enddate2.grabFocus();
                return true;
            } else if (enddate3.getText().trim().isEmpty()) {
                enddate3.grabFocus();
                return true;
            }
        }

        return false;

    }

    private boolean incorrectStatus(String st) {
        if (st.equals("Select Status")) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskdet = new javax.swing.JTextArea();
        taskid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Task = new javax.swing.JTable();
        status = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        startdate3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        enddate3 = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Rate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        taskname = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        Assign = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        startdate1 = new javax.swing.JTextField();
        startdate2 = new javax.swing.JTextField();
        enddate1 = new javax.swing.JTextField();
        enddate2 = new javax.swing.JTextField();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        taskdet.setColumns(20);
        taskdet.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        taskdet.setRows(5);
        jScrollPane1.setViewportView(taskdet);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 271, 80);

        taskid.setEditable(false);
        taskid.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        taskid.setFocusable(false);
        taskid.setRequestFocusEnabled(false);
        taskid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskidActionPerformed(evt);
            }
        });
        jPanel2.add(taskid);
        taskid.setBounds(20, 80, 271, 32);

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
        ));
        Task.setFocusable(false);
        Task.setGridColor(new java.awt.Color(52, 45, 71));
        Task.setSelectionBackground(new java.awt.Color(130, 120, 158));
        Task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Task);
        Task.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N

        Task.setForeground(new java.awt.Color(52, 45, 71));

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(313, 75, 430, 340);

        status.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Closed", "Open", "Canceled" }));
        status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusMouseClicked(evt);
            }
        });
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status);
        status.setBounds(20, 390, 271, 29);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setText("Tasks");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 337, 43);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 45, 71));
        jLabel4.setText("Task ID:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 60, 160, 19);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 45, 71));
        jLabel5.setText("*Task Details:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 170, 163, 22);

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 45, 71));
        jLabel10.setText("*Start Date: ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 270, 160, 19);

        startdate3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        startdate3.setForeground(new java.awt.Color(204, 204, 204));
        startdate3.setText("Year");
        startdate3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startdate3FocusGained(evt);
            }
        });
        startdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdate3ActionPerformed(evt);
            }
        });
        startdate3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startdate3KeyTyped(evt);
            }
        });
        jPanel2.add(startdate3);
        startdate3.setBounds(210, 290, 80, 32);

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 45, 71));
        jLabel11.setText("*End Date:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 320, 160, 19);

        enddate3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        enddate3.setForeground(new java.awt.Color(204, 204, 204));
        enddate3.setText("Year");
        enddate3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enddate3FocusGained(evt);
            }
        });
        enddate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddate3ActionPerformed(evt);
            }
        });
        enddate3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enddate3KeyTyped(evt);
            }
        });
        jPanel2.add(enddate3);
        enddate3.setBounds(210, 340, 80, 32);

        add.setBackground(new java.awt.Color(38, 32, 54));
        add.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/add.png"))); // NOI18N
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
        jPanel2.add(add);
        add.setBounds(20, 440, 72, 30);

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
        jPanel2.add(Update);
        Update.setBounds(105, 440, 87, 30);

        Rate.setBackground(new java.awt.Color(38, 32, 54));
        Rate.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        Rate.setForeground(new java.awt.Color(255, 255, 255));
        Rate.setText("Rate Employee");
        Rate.setFocusable(false);
        Rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RateMouseExited(evt);
            }
        });
        Rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateActionPerformed(evt);
            }
        });
        jPanel2.add(Rate);
        Rate.setBounds(520, 440, 180, 30);

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 45, 71));
        jLabel12.setText("*Task Name:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 120, 160, 19);

        taskname.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasknameActionPerformed(evt);
            }
        });
        jPanel2.add(taskname);
        taskname.setBounds(20, 140, 271, 32);

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
        jPanel2.add(delete);
        delete.setBounds(205, 440, 86, 30);

        Assign.setBackground(new java.awt.Color(38, 32, 54));
        Assign.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setText("Assign Task to Employees");
        Assign.setFocusable(false);
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
        jPanel2.add(Assign);
        Assign.setBounds(312, 440, 180, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("*enter required fields to proceed");
        jPanel2.add(error1);
        error1.setBounds(40, 418, 200, 30);

        startdate1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        startdate1.setForeground(new java.awt.Color(204, 204, 204));
        startdate1.setText("Day");
        startdate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startdate1FocusGained(evt);
            }
        });
        startdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdate1ActionPerformed(evt);
            }
        });
        startdate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startdate1KeyTyped(evt);
            }
        });
        jPanel2.add(startdate1);
        startdate1.setBounds(20, 290, 70, 32);

        startdate2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        startdate2.setForeground(new java.awt.Color(204, 204, 204));
        startdate2.setText("Month");
        startdate2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startdate2FocusGained(evt);
            }
        });
        startdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdate2ActionPerformed(evt);
            }
        });
        startdate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startdate2KeyTyped(evt);
            }
        });
        jPanel2.add(startdate2);
        startdate2.setBounds(100, 290, 100, 32);

        enddate1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        enddate1.setForeground(new java.awt.Color(204, 204, 204));
        enddate1.setText("Day");
        enddate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enddate1FocusGained(evt);
            }
        });
        enddate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddate1ActionPerformed(evt);
            }
        });
        enddate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enddate1KeyTyped(evt);
            }
        });
        jPanel2.add(enddate1);
        enddate1.setBounds(20, 340, 70, 32);

        enddate2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        enddate2.setForeground(new java.awt.Color(204, 204, 204));
        enddate2.setText("Month");
        enddate2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enddate2FocusGained(evt);
            }
        });
        enddate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddate2ActionPerformed(evt);
            }
        });
        enddate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enddate2KeyTyped(evt);
            }
        });
        jPanel2.add(enddate2);
        enddate2.setBounds(100, 340, 100, 32);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("Choose a status");
        jPanel2.add(error2);
        error2.setBounds(20, 360, 200, 40);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Select a Task from table to proceed");
        jPanel2.add(error3);
        error3.setBounds(400, 410, 340, 40);

        error4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("Only Completed task can be rated.");
        jPanel2.add(error4);
        error4.setBounds(520, 410, 230, 40);

        error5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error5.setForeground(new java.awt.Color(255, 0, 51));
        error5.setText("Canceled or closed task can not be assigned.");
        jPanel2.add(error5);
        error5.setBounds(310, 410, 380, 40);

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
        jPanel2.add(jLabel3);
        jLabel3.setBounds(630, 10, 130, 40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void enddate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enddate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enddate3ActionPerformed

    private void startdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startdate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startdate3ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void taskidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskidActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //req fields are there
        if (!checkfields()) {

            String tname = taskname.getText();
            String tdetail = taskdet.getText();
            String sdate = startdate1.getText() + " " + startdate2.getText() + " " + startdate3.getText();
            String edate = enddate1.getText() + " " + enddate2.getText() + " " + enddate3.getText();
            String stat = (String) status.getSelectedItem();

            try {
                String query = "insert into Task(task_name, task_details, start_date, "
                        + "end_date, status) values(?,?,STR_TO_DATE(?,'%d %m %Y'),"
                        + "STR_TO_DATE(?,'%d %m %Y'),?)";
                pst = con.prepareStatement(query);
                pst.setString(1, tname);
                pst.setString(2, tdetail);
                pst.setString(3, sdate);
                pst.setString(4, edate);
                pst.setString(5, stat);
                pst.execute();
                pst.close();

                //Table updates after insertion
                tableupdate();

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }

            //fields are set empty again
            setfieldsEmpty();
            error1.setVisible(false);
        }
    }//GEN-LAST:event_addActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //req fields are there
        if (!checkfields()) {

            String tname = taskname.getText();
            String tdetail = taskdet.getText();
            String sdate = startdate1.getText() + " " + startdate2.getText() + " " + startdate3.getText();
            String edate = enddate1.getText() + " " + enddate2.getText() + " " + enddate3.getText();
            String stat = (String) status.getSelectedItem();

            if (!incorrectStatus(stat)) {
                int id = Integer.parseInt(taskid.getText());

                try {

                    String query = "update Task set task_name = ?, task_details = ?,"
                            + " status = ?, start_date = STR_TO_DATE(?,'%d %m %Y'), "
                            + "end_date = STR_TO_DATE(?,'%d %m %Y') where task_ID = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, tname);
                    pst.setString(2, tdetail);
                    pst.setString(3, stat);
                    pst.setString(4, sdate);
                    pst.setString(5, edate);
                    pst.setInt(6, id);
                    pst.executeUpdate();
                    pst.close();

                    //Table updated after edits
                    tableupdate();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }

                //fields set empty
                setfieldsEmpty();
                error1.setVisible(false);
            } else {
                error2.setVisible(true);
                //reset combo box
                status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
                    "Select Status", "Complete", "Pending", "Not Assigned", "Canceled"}));
            }

        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void RateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateActionPerformed
        if (Task.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) Task.getModel();
            int selectedIndex = Task.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String st = (String) status.getSelectedItem();

            //only completed tasks can be rated
            //if (st.equals("Complete")) {
                new RateEmployee(id, empid).setVisible(true);
                this.setVisible(false);
//            } else {
//                error4.setVisible(true);
//            }

        } else {
            error3.setVisible(true);
        }
    }//GEN-LAST:event_RateActionPerformed

    private void tasknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tasknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tasknameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        //getting selected record
        DefaultTableModel model = (DefaultTableModel) Task.getModel();
        int selectedIndex = Task.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {

                pst = con.prepareStatement("delete from task where task_id = ?");
                pst.setInt(1, id);
                pst.executeUpdate();

                tableupdate();

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }

        //fields set empty
        setfieldsEmpty();
    }//GEN-LAST:event_deleteActionPerformed

    private void AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignActionPerformed
        String st = (String) status.getSelectedItem();
        if (Task.getSelectedRow() != -1 && !st.equals("Closed") && !st.equals("Canceled")) {
            DefaultTableModel model = (DefaultTableModel) Task.getModel();
            int selectedIndex = Task.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            new TaskAssignment(id, empid).setVisible(true);
            this.setVisible(false);
        } else if (st.equals("Closed") || st.equals("Cancelled")) {
            error5.setVisible(true);
        } else {
            error3.setVisible(true);
        }

    }//GEN-LAST:event_AssignActionPerformed

    private void startdate3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startdate3KeyTyped
        startdate3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_startdate3KeyTyped

    private void enddate3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enddate3KeyTyped
        enddate3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_enddate3KeyTyped

    private void startdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startdate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startdate2ActionPerformed

    private void startdate2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startdate2KeyTyped
        startdate2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_startdate2KeyTyped

    private void enddate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enddate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enddate1ActionPerformed

    private void enddate1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enddate1KeyTyped
        enddate1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_enddate1KeyTyped

    private void enddate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enddate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enddate2ActionPerformed

    private void enddate2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enddate2KeyTyped
        enddate2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_enddate2KeyTyped

    private void startdate2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startdate2FocusGained
        startdate2.setText("");
    }//GEN-LAST:event_startdate2FocusGained

    private void startdate3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startdate3FocusGained
        startdate3.setText("");
    }//GEN-LAST:event_startdate3FocusGained

    private void enddate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enddate1FocusGained
        enddate1.setText("");
    }//GEN-LAST:event_enddate1FocusGained

    private void enddate2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enddate2FocusGained
        enddate2.setText("");
    }//GEN-LAST:event_enddate2FocusGained

    private void enddate3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enddate3FocusGained
        enddate3.setText("");
    }//GEN-LAST:event_enddate3FocusGained

    private void TaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaskMouseClicked
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Task.getModel();
        int selectedIndex = Task.getSelectedRow();

        startdate1.setForeground(new java.awt.Color(0, 0, 0));
        startdate2.setForeground(new java.awt.Color(0, 0, 0));
        startdate3.setForeground(new java.awt.Color(0, 0, 0));

        enddate1.setForeground(new java.awt.Color(0, 0, 0));
        enddate2.setForeground(new java.awt.Color(0, 0, 0));
        enddate3.setForeground(new java.awt.Color(0, 0, 0));

        taskid.setText(model.getValueAt(selectedIndex, 0).toString());
        int tid = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        taskname.setText(model.getValueAt(selectedIndex, 1).toString());
        String Sdate = model.getValueAt(selectedIndex, 2).toString();
        startdate3.setText(Sdate.substring(0, 4));
        startdate2.setText(Sdate.substring(5, 7));
        startdate1.setText(Sdate.substring(8));

        String Edate = model.getValueAt(selectedIndex, 3).toString();
        enddate3.setText(Edate.substring(0, 4));
        enddate2.setText(Edate.substring(5, 7));
        enddate1.setText(Edate.substring(8));

        status.setSelectedItem(model.getValueAt(selectedIndex, 4).toString());

        //bring other fields from table
        try {
            pst = con.prepareStatement("select task_details from Task where task_ID = ?");
            pst.setInt(1, tid);
            rs = pst.executeQuery();

            if (rs.next()) {
                taskdet.setText(rs.getString("task_details"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TaskMouseClicked

    private void statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusMouseClicked
        error2.setVisible(false);
    }//GEN-LAST:event_statusMouseClicked

    private void startdate1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startdate1KeyTyped
        startdate1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_startdate1KeyTyped

    private void startdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startdate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startdate1ActionPerformed

    private void startdate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startdate1FocusGained
        startdate1.setText("");
    }//GEN-LAST:event_startdate1FocusGained

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        add.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_addMouseEntered

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_UpdateMouseEntered

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_deleteMouseEntered

    private void AssignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseEntered
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_AssignMouseEntered

    private void RateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RateMouseEntered
        // TODO add your handling code here:
        Rate.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_RateMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        add.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_addMouseExited

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_UpdateMouseExited

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_deleteMouseExited

    private void AssignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseExited
        // TODO add your handling code here:
        Assign.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_AssignMouseExited

    private void RateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RateMouseExited
        // TODO add your handling code here:
        Rate.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_RateMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        DashboardMgr db = new DashboardMgr(empid);
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTask(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assign;
    private javax.swing.JButton Rate;
    private javax.swing.JTable Task;
    private javax.swing.JButton Update;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JTextField enddate1;
    private javax.swing.JTextField enddate2;
    private javax.swing.JTextField enddate3;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField startdate1;
    private javax.swing.JTextField startdate2;
    private javax.swing.JTextField startdate3;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextArea taskdet;
    private javax.swing.JTextField taskid;
    private javax.swing.JTextField taskname;
    // End of variables declaration//GEN-END:variables
}
