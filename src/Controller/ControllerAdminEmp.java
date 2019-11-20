/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Koneksi;
import Model.Sales;
import View.AdminEmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ControllerAdminEmp extends MouseAdapter implements ActionListener  {
   private AdminEmp view;
   private Koneksi kn;
   
   public ControllerAdminEmp(){
       view = new AdminEmp();
       kn = new Koneksi();
       view.addActionListener(this);
       view.addMouseAdapter(this);
       view.setVisible(true);
       loadTableSales();
   }
    
   public void loadTableSales(){
       DefaultTableModel model = new DefaultTableModel(new String[]{"ID Sales", "Nama",
            "Username", "Password", "Tempat/ Tanggal Lahir      ", "No HP", "Email", "Komisi"}, 0);
        ArrayList<Sales> sales = kn.getSales();
        for (Sales s : sales) {
            model.addRow(new Object[]{s.getId(), s.getNama(), s.getUsername(), s.getPass(), s.getTtl(), s.getNoHp(), s.getEmail(), s.getKomisi()});
        }
        view.setTbCustomer(model);
   }
   
   @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getTbSales())){
            int i            = view.getSelectedSales();
            String id        = view.getTbSales().getModel().getValueAt(i, 0).toString();
            String nama      = view.getTbSales().getModel().getValueAt(i, 1).toString();
            String username  = view.getTbSales().getModel().getValueAt(i, 2).toString();
            String password  = view.getTbSales().getModel().getValueAt(i, 3).toString();
            String ttl       = view.getTbSales().getModel().getValueAt(i, 4).toString();
            String no        = view.getTbSales().getModel().getValueAt(i, 5).toString();
            String email     = view.getTbSales().getModel().getValueAt(i, 6).toString();
            String Komisi    = view.getTbSales().getModel().getValueAt(i, 7).toString();
            
            view.setTfIdSls(id);
            view.setTfNamaSls(nama);
            view.setTfUsernameSls(username);
            view.setTfPassSls(password);
            view.setTfTtlSls(ttl);
            view.setTfNoHpSls(no);
            view.setTfEmailSls(email);
            view.setTfKomisiSls(Komisi);
        }
    }
   
   @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnTambahSls())){
            btnTambahActionPerformed();
            loadTableSales();
        }else if (source.equals(view.getBtnHapusSls())){
            btnHapusActionPerformed();
            loadTableSales();
        }else if (source.equals(view.getBtnEditSls())){
            btnEditActionPerformed();
            loadTableSales();
        }else if (source.equals(view.getBtnRefreshSls())){
            view.reset();
            loadTableSales();
        }else if (source.equals(view.getBtnCariSls())){
            btnCariActionPerformed();
        }
    }
    
    public void btnTambahActionPerformed(){
        String id       = view.getTfIdSls();
        String nama     = view.getTfNamaSls();
        String username = view.getTfUsernameSls();
        String pass     = view.getTfPassSls();
        String ttl      = view.getTfTtlSls();
        String noHp     = view.getTfNoHpSls();
        String email    = view.getTfEmailSls();
        Float komisi    = (float) 0;
        if (!view.getTfKomisiSls().isEmpty()) {
            komisi    = Float.parseFloat(view.getTfKomisiSls());
        }
        if (id.isEmpty() || nama.isEmpty() || ttl.isEmpty() || 
            username.isEmpty() || noHp.isEmpty() || email.isEmpty() || pass.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (kn.cekDuplikatIDSales(id)){
                view.showMessage("ID Sales Sudah Terdaftar", "Error", 0);
            }else if (kn.cekDuplikatUsenameSales(username)){
                view.showMessage("Username Sudah Terdaftar", "Error", 1);
            } else if (!kn.cekIdSales(id)) {
                view.showMessage("ID tidak valid", "Error", 2);
            }
            else{
                kn.addSales(new Sales(id,nama,username,pass,ttl,noHp,email,komisi));
                view.reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 3);
            }
        }
    }
    public void btnHapusActionPerformed(){
        String id = view.getTfIdSls();
        if (id.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else { 
            kn.delSales(id);
            view.reset();
            view.showMessage("Data Berhasil Dihapus", "Success", 1);
        }
    }
    
    public void btnEditActionPerformed(){
        String id       = view.getTfIdSls();
        String nama     = view.getTfNamaSls();
        String user     = view.getTfUsernameSls();
        String pass     = view.getTfPassSls();
        String ttl      = view.getTfTtlSls();
        String no       = view.getTfNoHpSls();
        String email    = view.getTfEmailSls();
        Float komisi    = (float) 0;
        if (!view.getTfKomisiSls().isEmpty()) {
            komisi    = Float.parseFloat(view.getTfKomisiSls());
        }
        if (id.isEmpty() || nama.isEmpty() || user.isEmpty() || 
            pass.isEmpty() || no.isEmpty() || email.isEmpty() || ttl.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (!kn.cekDuplikatIDSales(id)){
                view.showMessage("ID Tidak Ditemukan", "Error", 0);
            }else{
                kn.editSales(new Sales(id,nama,user,pass,ttl,no,email,komisi));
                view.reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
            }
        }
    }
    
    public void btnCariActionPerformed(){
        String cari = view.getTfCariSls();
        String pil = view.getKategoriCariSales();
        System.out.println(pil);
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Sales", "Nama",
            "Username", "Password", "Tempat/ Tanggal Lahir", "No HP", "Email", "Komisi"}, 0);
        ArrayList<Sales> sales = kn.getSales();
        if (!cari.isEmpty()) {
            for (Sales c : sales) {
                if (pil == "ID"){
                    if (c.getId().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                } else if(pil == "Tempat/ Tanggal Lahir"){
                    if (c.getTtl().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                } else if(pil == "Nama"){
                    if (c.getNama().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                } else if (pil == "Username") {
                    if (c.getUsername().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                } else if (pil == "No HP"){
                    if (c.getNoHp().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                } else if (pil == "Email") {
                    if (c.getEmail().contains(cari)) {
                        model.addRow(new Object[]{c.getId(), c.getNama(), c.getUsername(), 
                        c.getPass(), c.getTtl(), c.getNoHp(),c.getEmail(), c.getKomisi()});
                    }
                }
                    
            }
            view.setTbCustomer(model);
        } else {
            view.showMessage("Tolong Masukkan Keyword " + pil, "Error", 0);
        }
    }
}
