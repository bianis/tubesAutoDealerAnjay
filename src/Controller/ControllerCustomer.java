/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Koneksi;
import View.AdminCustomer;
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
public class ControllerCustomer extends MouseAdapter implements ActionListener{
    private AdminCustomer view;
    private Koneksi kn;
    
    public ControllerCustomer(){
        view = new AdminCustomer();
        kn = new Koneksi();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTableCustomer();
    }
    
    public void loadTableCustomer(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Customer", "Nama",
            "Tempat Tanggal Lahir", "Alamat", "No Ponsel", "Email", "Password"}, 0);
        ArrayList<Customer> customer = kn.getCustomer();
        for (Customer c : customer) {
            model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(),
                         c.getTtlCustomer(), c.getAlamatCustomer(), c.getNoHpCustomer(),
                         c.getEmailCustomer(), c.getPassCustomer()});
        }
        view.setTbCustomer(model);
    }

    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getTbCustomer())){
            int i           = view.getSelectedCustomer();
            String id       = view.getTbCustomer().getModel().getValueAt(i, 0).toString();
            String nama     = view.getTbCustomer().getModel().getValueAt(i, 1).toString();
            String ttl      = view.getTbCustomer().getModel().getValueAt(i, 2).toString();
            String alamat   = view.getTbCustomer().getModel().getValueAt(i, 3).toString();
            String no       = view.getTbCustomer().getModel().getValueAt(i, 4).toString();
            String email    = view.getTbCustomer().getModel().getValueAt(i, 5).toString();
            String pass     = view.getTbCustomer().getModel().getValueAt(i, 6).toString();
            
            view.setTfIdCust(id);
            view.setTfNamaCust(nama);
            view.setTfTempatCust(ttl);
            view.setTfAlamatCust(alamat);
            view.setTfNoHp(no);
            view.setTfEmailCust(email);
            view.setTfPassCust(pass);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnTambahCust())){
            btnTambahActionPerformed();
            loadTableCustomer();
        }else if (source.equals(view.getBtnHapusCust())){
            btnHapusActionPerformed();
            loadTableCustomer();
        }else if (source.equals(view.getBtnEditCust())){
            btnEditActionPerformed();
            loadTableCustomer();
        }else if (source.equals(view.getBtnRefreshCust())){
            view.reset();
            loadTableCustomer();
        }else if (source.equals(view.getBtnCariCustomer())){
            btnCariActionPerformed();
        }
    }
    
    public void btnTambahActionPerformed(){
        String id       = view.getTfIdCust();
        String nama     = view.getTfNamaCust();
        String ttl      = view.getTfTempatCust();
        String alamat   = view.getTfAlamatCust();
        String no       = view.getTfNoHp();
        String email    = view.getTfEmailCust();
        String pass     = view.getTfPassCust();
        if (id.isEmpty() || nama.isEmpty() || ttl.isEmpty() || 
            alamat.isEmpty() || no.isEmpty() || email.isEmpty() || pass.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (kn.cekDuplikatIDCustomer(id)){
                view.showMessage("ID Pelanggan Sudah Terdaftar", "Error", 0);
            }else{
                kn.addCustomer(new Customer(id,nama,ttl,alamat,no,email,pass));
                view.reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
            }
        }
    }
    
    public void btnHapusActionPerformed(){
        String id = view.getTfIdCust();
        if (id.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else { 
            kn.delCustomer(id);
            view.reset();
            view.showMessage("Data Berhasil Dihapus", "Success", 1);
        }
    }
    
    public void btnEditActionPerformed(){
        String id       = view.getTfIdCust();
        String nama     = view.getTfNamaCust();
        String ttl      = view.getTfTempatCust();
        String alamat   = view.getTfAlamatCust();
        String no       = view.getTfNoHp();
        String email    = view.getTfEmailCust();
        String pass     = view.getTfPassCust();
        if (id.isEmpty() || nama.isEmpty() || ttl.isEmpty() || 
            alamat.isEmpty() || no.isEmpty() || email.isEmpty() || pass.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (!kn.cekDuplikatIDCustomer(id)){
                view.showMessage("ID Tidak Ditemukan", "Error", 0);
            }else{
                kn.editCustomer(new Customer(id,nama,ttl,alamat,no,email,pass));
                view.reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
            }
        }
    }
    public void btnCariActionPerformed(){
        String cari = view.getTfCariCustomer();
        String pil = view.getKategoriCariCustomer();
        System.out.println(pil);
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Customer", "Nama",
            "Tempat Tanggal Lahir", "Alamat", "No Ponsel", "Email", "Password"}, 0);
        ArrayList<Customer> customer = kn.getCustomer();
        if (!cari.isEmpty()) {
            for (Customer c : customer) {
                if (pil == "ID"){
                    if (c.getIdCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                } else if(pil == "Tempat/ Tanggal Lahir"){
                    if (c.getTtlCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                } else if(pil == "Nama"){
                    if (c.getNamaCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                } else if (pil == "Alamat") {
                    if (c.getAlamatCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                } else if (pil == "No HP"){
                    if (c.getNoHpCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                } else if (pil == "Email") {
                    if (c.getEmailCustomer().contains(cari)) {
                        model.addRow(new Object[]{c.getIdCustomer(), c.getNamaCustomer(), c.getTtlCustomer(), 
                        c.getAlamatCustomer(), c.getNoHpCustomer(), c.getEmailCustomer(), c.getPassCustomer()});
                    }
                }
                    
            }
            view.setTbCustomer(model);
        } else {
            view.showMessage("Tolong Masukkan Keyword " + pil, "Error", 0);
        }
    }
}
