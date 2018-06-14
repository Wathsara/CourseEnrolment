/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

/**
 *
 * @author wathsara
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class PayCardSocPost extends javax.swing.JFrame {

    /**
     * Creates new form PayCardSocPost
     */
    String url = "jdbc:mysql://localhost:3360/course?useSSL=false";
    String username = "root";
    String password = "";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement pst = null;
    Db d = new Db();
    String email;
    public PayCardSocPost() {
        initComponents();
    }

    void loadDetails(PaymentGetSet pc) {
        if (pc.getSemester() == "1st Semester") {
            txtID.setText(Integer.toString(pc.getId()));
            txtSemester.setText(pc.getSemester());
            txtAcademicYear.setText(Integer.toString(pc.getAcademicYear()));
            
            try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socPostSemOne WHERE StudentID = ? AND AcademicYear=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setInt(1, pc.getId());
                pst.setInt(2, pc.getAcademicYear());

                rs = pst.executeQuery();
                while (rs.next()) {
                    txtName.setText(rs.getString("FullName"));
                    lblSub1.setText(rs.getString("Sub1"));
                    lblSub2.setText(rs.getString("Sub2"));
                    lblSub3.setText(rs.getString("Sub3"));
                    lblSub4.setText(rs.getString("Sub4"));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            txtID.setText(Integer.toString(pc.getId()));
            txtSemester.setText(pc.getSemester());
            txtAcademicYear.setText(Integer.toString(pc.getAcademicYear()));
            System.out.println("hi");
            try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socPostSemTwo WHERE StudentID = ? AND AcademicYear=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setInt(1, pc.getId());
                pst.setInt(2, pc.getAcademicYear());

                rs = pst.executeQuery();
                while (rs.next()) {
                    txtName.setText(rs.getString("FullName"));
                    lblSub1.setText(rs.getString("Sub1"));
                    lblSub2.setText(rs.getString("Sub2"));
                    lblSub3.setText(rs.getString("Sub3"));
                    lblSub4.setText(rs.getString("Sub4"));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        
        try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socSubject WHERE SubjectName=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setString(1, lblSub1.getText());
                rs = pst.executeQuery();
                while (rs.next()) {
                    txtSub1.setText(Integer.toString(rs.getInt("SubjectFee")));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socSubject WHERE SubjectName=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setString(1, lblSub2.getText());
                rs = pst.executeQuery();
                while (rs.next()) {
                    txtSub2.setText(Integer.toString(rs.getInt("SubjectFee")));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socSubject WHERE SubjectName=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setString(1, lblSub2.getText());
                rs = pst.executeQuery();
                while (rs.next()) {
                    txtSub3.setText(Integer.toString(rs.getInt("SubjectFee")));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        try {

                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM socSubject WHERE SubjectName=?";
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
                pst.setString(1, lblSub4.getText());
                rs = pst.executeQuery();
                while (rs.next()) {
                    txtSub4.setText(Integer.toString(rs.getInt("SubjectFee")));

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        int s1 = Integer.parseInt(txtSub1.getText());
        int s2 = Integer.parseInt(txtSub2.getText());
        int s3 = Integer.parseInt(txtSub3.getText());
        int s4 = Integer.parseInt(txtSub4.getText());
        int s = Integer.parseInt(txtSemFee.getText());
        int ttl = s1+s2+s3+s4+s;
        txtTotal.setText(Integer.toString(ttl));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAcademicYear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSemester = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSemFee = new javax.swing.JTextField();
        txtSub1 = new javax.swing.JTextField();
        txtSub2 = new javax.swing.JTextField();
        txtSub3 = new javax.swing.JTextField();
        txtSub4 = new javax.swing.JTextField();
        lblsem = new javax.swing.JLabel();
        lblSub1 = new javax.swing.JLabel();
        lblSub2 = new javax.swing.JLabel();
        lblSub3 = new javax.swing.JLabel();
        lblSub4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment Details");

        jPanel2.setBackground(new java.awt.Color(211, 84, 0));

        jLabel1.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PayCard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));

        jLabel2.setForeground(new java.awt.Color(236, 244, 247));
        jLabel2.setText("Student ID");

        jLabel3.setForeground(new java.awt.Color(236, 244, 247));
        jLabel3.setText("Student Name");

        txtID.setEditable(false);

        txtName.setEditable(false);

        jLabel4.setForeground(new java.awt.Color(236, 244, 247));
        jLabel4.setText("Academic Year");

        txtAcademicYear.setEditable(false);

        jLabel5.setForeground(new java.awt.Color(236, 244, 247));
        jLabel5.setText("Semester");

        txtSemester.setEditable(false);

        jLabel6.setForeground(new java.awt.Color(236, 244, 247));
        jLabel6.setText("Discription");

        jLabel7.setForeground(new java.awt.Color(236, 244, 247));
        jLabel7.setText("Charges");

        txtSemFee.setEditable(false);
        txtSemFee.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtSemFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSemFee.setText("20000");

        txtSub1.setEditable(false);
        txtSub1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtSub1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtSub2.setEditable(false);
        txtSub2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtSub2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtSub3.setEditable(false);
        txtSub3.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtSub3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtSub4.setEditable(false);
        txtSub4.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtSub4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblsem.setForeground(new java.awt.Color(236, 244, 247));
        lblsem.setText("Semester Fee");

        lblSub1.setForeground(new java.awt.Color(236, 244, 247));
        lblSub1.setText("Subject 1");

        lblSub2.setForeground(new java.awt.Color(236, 244, 247));
        lblSub2.setText("Subject 2");

        lblSub3.setForeground(new java.awt.Color(236, 244, 247));
        lblSub3.setText("Subject 3");

        lblSub4.setForeground(new java.awt.Color(236, 244, 247));
        lblSub4.setText("Subject 4");

        jLabel13.setForeground(new java.awt.Color(236, 244, 247));
        jLabel13.setText("Total Charges");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(16, 118, 190));
        jButton1.setForeground(new java.awt.Color(247, 248, 248));
        jButton1.setText("Payment Recieves");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(lblsem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSub1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSub2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSub3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSub4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAcademicYear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSemester)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSub4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSub3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSub2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSub1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSemFee)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAcademicYear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSemFee, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSub2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSub3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSub4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPostIntake WHERE StudentID = ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txtID.getText()));
            rs = pst.executeQuery();
            while (rs.next()) {
                email=rs.getString("Email");

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        Payment p = new Payment();
        p.setId(Integer.parseInt(txtID.getText()));
        p.setName(txtName.getText());
        p.setSemester(txtSemester.getText());
        p.setPay(Double.parseDouble(txtTotal.getText()));
        p.setAcademicYear(Integer.parseInt(txtAcademicYear.getText()));

        boolean x = d.sobPostPayments(p);

        if(x){
            PaymentSobPost psob = new PaymentSobPost();
            SendEmail se = new SendEmail();
            JOptionPane.showMessageDialog(this, "Payment Succesfully Inserted");

            this.dispose();
            psob.loadSobPostPayments();
            String a1=txtName.getText();
            String a2=txtAcademicYear.getText();
            String a3=txtSemester.getText();
            String a4 = email;
            String a5 = lblsem.getText();
            String a6 = lblSub1.getText();
            String a7 = lblSub2.getText();
            String a8 = lblSub3.getText();
            String a9 = lblSub4.getText();
            String a10 = txtSemFee.getText();
            String a11 = txtSub1.getText();
            String a12 = txtSub2.getText();
            String a13 = txtSub3.getText();
            String a14 = txtSub4.getText();
            String a15 = txtTotal.getText();

            psob.setVisible(true);
            se.paymentmail(a1, a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15);

        }else{

            JOptionPane.showMessageDialog(this, "Already Paid for the Selected Semester in Academic year ");
            this.dispose();

        }

    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socPostIntake WHERE StudentID = ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txtID.getText()));
            rs = pst.executeQuery();
            while (rs.next()) {
                email=rs.getString("Email");

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        Payment p = new Payment();
        p.setId(Integer.parseInt(txtID.getText()));
        p.setName(txtName.getText());
        p.setSemester(txtSemester.getText());
        p.setPay(Double.parseDouble(txtTotal.getText()));
        p.setAcademicYear(Integer.parseInt(txtAcademicYear.getText()));

        boolean x = d.socPostPayments(p);

        if(x){
            PaymentSocPost psob = new PaymentSocPost();
            SendEmail se = new SendEmail();
            JOptionPane.showMessageDialog(this, "Payment Succesfully Inserted");

            this.dispose();
            psob.loadSocPostPayments();
            String a1=txtName.getText();
            String a2=txtAcademicYear.getText();
            String a3=txtSemester.getText();
            String a4 = email;
            String a5 = lblsem.getText();
            String a6 = lblSub1.getText();
            String a7 = lblSub2.getText();
            String a8 = lblSub3.getText();
            String a9 = lblSub4.getText();
            String a10 = txtSemFee.getText();
            String a11 = txtSub1.getText();
            String a12 = txtSub2.getText();
            String a13 = txtSub3.getText();
            String a14 = txtSub4.getText();
            String a15 = txtTotal.getText();

            psob.setVisible(true);
            se.paymentmail(a1, a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15);

        }else{

            JOptionPane.showMessageDialog(this, "Already Paid for the Selected Semester in Academic year..");
            this.dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PayCardSocPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayCardSocPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayCardSocPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayCardSocPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayCardSocPost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSub1;
    private javax.swing.JLabel lblSub2;
    private javax.swing.JLabel lblSub3;
    private javax.swing.JLabel lblSub4;
    private javax.swing.JLabel lblsem;
    private javax.swing.JTextField txtAcademicYear;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSemFee;
    private javax.swing.JTextField txtSemester;
    private javax.swing.JTextField txtSub1;
    private javax.swing.JTextField txtSub2;
    private javax.swing.JTextField txtSub3;
    private javax.swing.JTextField txtSub4;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
