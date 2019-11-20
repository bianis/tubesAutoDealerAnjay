/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class AdminEmp extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSales = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        tfNamaSls = new javax.swing.JTextField();
        tfUsernameSls = new javax.swing.JTextField();
        tfPassSls = new javax.swing.JTextField();
        tfTtlSls = new javax.swing.JTextField();
        tfNoHpSls = new javax.swing.JTextField();
        tfEmailSls = new javax.swing.JTextField();
        tfIdSls = new javax.swing.JTextField();
        tfKomisiSls = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfCariSls = new javax.swing.JTextField();
        cbCariKatSls = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnCariSls = new javax.swing.JButton();
        btnEditSls = new javax.swing.JButton();
        btnRefreshSls = new javax.swing.JButton();
        btnHapusSls = new javax.swing.JButton();
        btnTambahSls = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/navBack1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/empMngS.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbSales.setBackground(new java.awt.Color(153, 153, 153));
        tbSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbSales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbSales.setAutoscrolls(false);
        jScrollPane1.setViewportView(tbSales);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 4));

        jLabel5.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Sales");

        jLabel6.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Sales");

        jLabel7.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tempat / Tanggal Lahir");

        jLabel10.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No HP");

        jLabel11.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("Coolvetica Rg", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Komisi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNamaSls)
                    .addComponent(tfUsernameSls)
                    .addComponent(tfPassSls)
                    .addComponent(tfTtlSls)
                    .addComponent(tfNoHpSls)
                    .addComponent(tfEmailSls)
                    .addComponent(tfIdSls, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(tfKomisiSls))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamaSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsernameSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTtlSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoHpSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmailSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKomisiSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Sales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Coolvetica Rg", 2, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        cbCariKatSls.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nama", "Username", "Tempat/ Tanggal Lahir", "No HP", "Email" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Berdasarkan");

        btnCariSls.setBackground(new java.awt.Color(255, 56, 19));
        btnCariSls.setFont(new java.awt.Font("Coolvetica Rg", 1, 12)); // NOI18N
        btnCariSls.setForeground(new java.awt.Color(255, 255, 255));
        btnCariSls.setText("Cari");
        btnCariSls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariSlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCariSls)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbCariKatSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCariSls)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCariSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCariKatSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariSls))
                .addContainerGap())
        );

        btnEditSls.setBackground(new java.awt.Color(255, 56, 19));
        btnEditSls.setFont(new java.awt.Font("Coolvetica Rg", 1, 18)); // NOI18N
        btnEditSls.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSls.setText("Edit");
        btnEditSls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSlsActionPerformed(evt);
            }
        });

        btnRefreshSls.setBackground(new java.awt.Color(255, 255, 255));
        btnRefreshSls.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        btnRefreshSls.setForeground(new java.awt.Color(255, 56, 19));
        btnRefreshSls.setText("Refresh");
        btnRefreshSls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSlsActionPerformed(evt);
            }
        });

        btnHapusSls.setBackground(new java.awt.Color(255, 56, 19));
        btnHapusSls.setFont(new java.awt.Font("Coolvetica Rg", 1, 16)); // NOI18N
        btnHapusSls.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusSls.setText("Hapus");
        btnHapusSls.setPreferredSize(new java.awt.Dimension(80, 30));
        btnHapusSls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSlsActionPerformed(evt);
            }
        });

        btnTambahSls.setBackground(new java.awt.Color(255, 56, 19));
        btnTambahSls.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        btnTambahSls.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahSls.setText("Tambah");
        btnTambahSls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahSlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTambahSls, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEditSls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRefreshSls, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapusSls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefreshSls, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusSls, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditSls, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahSls, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public AdminEmp() {
        initComponents();
        setSize(800, 650);
        setVisible(true);
    }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Controller.ControllerAdminMenu();
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnEditSlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSlsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditSlsActionPerformed

    private void btnRefreshSlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSlsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshSlsActionPerformed

    private void btnHapusSlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSlsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusSlsActionPerformed

    private void btnTambahSlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahSlsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahSlsActionPerformed

    private void btnCariSlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariSlsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariSlsActionPerformed

        
    public JButton getBtnCariSls() {
        return btnCariSls;
    }

    public JButton getBtnEditSls() {
        return btnEditSls;
    }

    public JButton getBtnHapusSls() {
        return btnHapusSls;
    }

    public JButton getBtnRefreshSls() {
        return btnRefreshSls;
    }

    public JButton getBtnTambahSls() {
        return btnTambahSls;
    }

    public String getTfEmailSls() {
        return tfEmailSls.getText();
    }

    public String getTfIdSls() {
        return tfIdSls.getText();
    }

    public String getTfKomisiSls() {
        return tfKomisiSls.getText();
    }

    public String getTfNamaSls() {
        return tfNamaSls.getText();
    }

    public String getTfNoHpSls() {
        return tfNoHpSls.getText();
    }

    public String getTfPassSls() {
        return tfPassSls.getText();
    }

    public String getTfTtlSls() {
        return tfTtlSls.getText();
    }

    public String getTfUsernameSls() {
        return tfUsernameSls.getText();
    }

    public String getTfCariSls() {
        return tfCariSls.getText();
    }
    
    public void setTfCariSls(String x){
        tfCariSls.setText(x);
    }
    
    public void setTfEmailSls(String x) {
        tfEmailSls.setText(x);
    }

    public void setTfIdSls(String x) {
        tfIdSls.setText(x);
    }

    public void setTfKomisiSls(String x) {
        tfKomisiSls.setText(x);
    }

    public void setTfNamaSls(String x) {
        tfNamaSls.setText(x);
    }

    public void setTfNoHpSls(String x) {
        tfNoHpSls.setText(x);
    }

    public void setTfPassSls(String x) {
        tfPassSls.setText(x);
    }

    public void setTfTtlSls(String x) {
        tfTtlSls.setText(x);
    }

    public void setTfUsernameSls(String x) {
        tfUsernameSls.setText(x);
    }
    
    public JTable getTbSales() {
        return tbSales;
    }
    
    public void setTbCustomer(DefaultTableModel x) {
        tbSales.setModel(x);
    }
    
    public void reset(){
        setTfCariSls("");
        setTfIdSls("");
        setTfNamaSls("");
        setTfUsernameSls("");
        setTfPassSls("");
        setTfTtlSls("");
        setTfNoHpSls("");
        setTfEmailSls("");
        setTfKomisiSls("");
     }
    
    public int getSelectedSales(){
        return tbSales.getSelectedRow();
    }
    
    public void addMouseAdapter(MouseAdapter x){
        tbSales.addMouseListener(x);
    }
    
    public String getKategoriCariSales(){
        return cbCariKatSls.getSelectedItem().toString();
    }
    
    public void addActionListener(ActionListener x){
        btnTambahSls.addActionListener(x);
        btnEditSls.addActionListener(x);
        btnRefreshSls.addActionListener(x);
        btnHapusSls.addActionListener(x);
        btnCariSls.addActionListener(x);
    }
    
    public void showMessage(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariSls;
    private javax.swing.JButton btnEditSls;
    private javax.swing.JButton btnHapusSls;
    private javax.swing.JButton btnRefreshSls;
    private javax.swing.JButton btnTambahSls;
    private javax.swing.JComboBox<String> cbCariKatSls;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSales;
    private javax.swing.JTextField tfCariSls;
    private javax.swing.JTextField tfEmailSls;
    private javax.swing.JTextField tfIdSls;
    private javax.swing.JTextField tfKomisiSls;
    private javax.swing.JTextField tfNamaSls;
    private javax.swing.JTextField tfNoHpSls;
    private javax.swing.JTextField tfPassSls;
    private javax.swing.JTextField tfTtlSls;
    private javax.swing.JTextField tfUsernameSls;
    // End of variables declaration//GEN-END:variables
}
