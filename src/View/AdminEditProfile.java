/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class AdminEditProfile extends javax.swing.JFrame {

    /**
     * Creates new form AdminEditProfile
     */
    public AdminEditProfile() {
        initComponents();
    }

    public JButton getBtnHapusAdmin() {
        return btnHapusAdmin;
    }

    public JButton getBtnBackLogin() {
        return btnBackLogin;
    }

    public JButton getBtnSimpanData() {
        return btnSimpanData;
    }

    public String getTfEmail() {
        return tfEmail.getText();
    }

    public String getTfIdAdmin() {
        return tfIdAdmin.getText();
    }

    public String getTfNamaAdmin() {
        return tfNamaAdmin.getText();
    }

    public String getTfNoHp() {
        return tfNoHp.getText();
    }

    public String getTfPassword() {
        return tfPassword.getText();
    }

    public String getTfTtl() {
        return tfTtl.getText();
    }

    public String getTfUsername() {
        return tfUsername.getText();
    }

    public void setTfEmail(String x) {
        tfEmail.setText(x);
    }

    public void setTfIdAdmin(String x) {
        tfIdAdmin.setText(x);
    }

    public void setTfNamaAdmin(String x) {
        tfNamaAdmin.setText(x);
    }

    public void setTfNoHp(String x) {
        tfNoHp.setText(x);
    }

    public void setTfPassword(String x) {
        tfPassword.setText(x);
    }

    public void setTfTtl(String x) {
        tfTtl.setText(x);
    }

    public void setTfUsername(String x) {
        tfUsername.setText(x);
    }
    
    public void addActionListener(ActionListener x){
        btnSimpanData.addActionListener(x);
        btnBackLogin.addActionListener(x);
        btnHapusAdmin.addActionListener(x);
    }
    
    public void showMessage(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfIdAdmin = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        tfTtl = new javax.swing.JTextField();
        tfNoHp = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfNamaAdmin = new javax.swing.JTextField();
        btnSimpanData = new javax.swing.JButton();
        btnBackLogin = new javax.swing.JButton();
        btnHapusAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Admin");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tempat/ Tanggal Lahir");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No HP");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        tfIdAdmin.setEditable(false);
        tfIdAdmin.setBackground(new java.awt.Color(204, 204, 204));
        tfIdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdAdminActionPerformed(evt);
            }
        });

        tfUsername.setEditable(false);
        tfUsername.setBackground(new java.awt.Color(204, 204, 204));

        tfTtl.setEditable(false);
        tfTtl.setBackground(new java.awt.Color(204, 204, 204));

        tfEmail.setEditable(false);
        tfEmail.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama");

        btnSimpanData.setBackground(new java.awt.Color(247, 70, 46));
        btnSimpanData.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        btnSimpanData.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanData.setText("SIMPAN");
        btnSimpanData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanDataActionPerformed(evt);
            }
        });

        btnBackLogin.setBackground(new java.awt.Color(51, 51, 51));
        btnBackLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/navBack1.png"))); // NOI18N

        btnHapusAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnHapusAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHapusAdmin.setForeground(new java.awt.Color(247, 70, 46));
        btnHapusAdmin.setText("HAPUS");
        btnHapusAdmin.setPreferredSize(new java.awt.Dimension(77, 27));
        btnHapusAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIdAdmin)
                            .addComponent(tfUsername)
                            .addComponent(tfPassword)
                            .addComponent(tfTtl)
                            .addComponent(tfNoHp)
                            .addComponent(tfEmail)
                            .addComponent(tfNamaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addComponent(btnSimpanData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapusAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBackLogin)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSimpanData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapusAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdAdminActionPerformed

    private void btnSimpanDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanDataActionPerformed

    private void btnHapusAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackLogin;
    private javax.swing.JButton btnHapusAdmin;
    private javax.swing.JButton btnSimpanData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfIdAdmin;
    private javax.swing.JTextField tfNamaAdmin;
    private javax.swing.JTextField tfNoHp;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfTtl;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
