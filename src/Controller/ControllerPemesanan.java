/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bian
 */
public class ControllerPemesanan extends MouseAdapter implements ActionListener {
    
    private AdminPemesanan view;
    private Koneksi db;

    public ControllerPemesanan() {
        view = new AdminPemesanan();
        db   = new Koneksi();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTablePemesanan();
    }
    
    public void loadTablePemesanan(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Pemesanan", "Tanggal", "ID Customer", "ID Mobil", "Status"}, 0);
        ArrayList<Pemesanan> pemesanan = db.getPemesanan();
        for (Pemesanan p : pemesanan) {
            model.addRow(new Object[]{p.getIdPemesanan(), p.getTglPemesanan(), p.getIdCustomer(), p.getIdMobil(), p.getStatus()});
        }
        view.setTbPemesanan(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())){
            btnAddActionPerformed();
            loadTablePemesanan();
        }else if (source.equals(view.getBtnDelete())){
            btnDeleteActionPerformed();
            loadTablePemesanan();
        }else if (source.equals(view.getBtnUpdate())){
            btnEditActionPerformed();
            loadTablePemesanan();
        }else if (source.equals(view.getBtnReset())){
            view.reset();
            loadTablePemesanan();
        }/*else if (source.equals(view.getBtnSearch())){
            btnSearchActionPerformed();
        }*/else if (source.equals(view.getBtnBack())){
            new ControllerAdminMenu();
            view.setVisible(false);
        }
    }
    
    public void btnAddActionPerformed(){
        String idPemesanan      = view.getIDPemesanan();
        String tglPemesanan     = view.getTanggal();
        String idCustomer       = view.getTfIDCustomer();
        String idMobil          = view.getTfIDMobil();
        String status           = view.getStatus();
        if (idPemesanan.isEmpty() || tglPemesanan.isEmpty() || idCustomer.isEmpty() || idMobil.isEmpty() || status.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (db.cekDuplikatIDPemesanan(idPemesanan)){
                view.showMessage("ID Sudah Ada", "Error", 0);
            }else if(db.cekStock(idMobil) == 0){
                view.showMessage("Stok mobil telah habis", "Error", 0);
            }else{
                db.addPemesanan(new Pemesanan(idPemesanan, tglPemesanan, idCustomer, idMobil, status));
                view.reset();
                view.showMessage("Pemesanan Berhasil Ditambah", "Success", 1);
            }
        }
    }
    
    
    public void btnDeleteActionPerformed(){
        String idMobil = view.getIDPemesanan();
        db.delPemesanan(idMobil);
        view.reset();
        view.showMessage("Pemesanan Berhasil Dihapus", "Success", 1);
    }
    
    
     public void btnEditActionPerformed(){
        String idPemesanan  = view.getIDPemesanan();
        String tglPemesanan = view.getTanggal();
        String idCustomer   = view.getTfIDCustomer();
        String idMobil      = view.getTfIDMobil();
        String status       = view.getStatus();
        if (idPemesanan.isEmpty() || tglPemesanan.isEmpty() || idCustomer.isEmpty() || idMobil.isEmpty() || status.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (!db.cekDuplikatIDPemesanan(idPemesanan)){
                view.showMessage("ID Pemesanan Tidak Ditemukan", "Error", 0);
            }else{
                db.editPemesanan(new Pemesanan(idPemesanan, tglPemesanan, idCustomer, idMobil, status));
                view.reset();
                view.showMessage("Data Pemesanan Berhasil Diubah", "Success", 1);
            }
        }
    }
    
    /*public void btnSearchActionPerformed(){
        String cari = view.getTfSearch();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Merek", "Model", "Tahun", "Deskripsi", "Warna", "Harga","Stok"}, 0);
        ArrayList<Sedan> sedan = db.getSedan();
        for (Sedan sed : sedan) {
            if (sed.getIdSedan().contains(cari) || sed.getMerekMobil().contains(cari) || sed.getModelMobil().contains(cari) || sed.getTahunMobil().contains(cari) || sed.getWarnaMobil().contains(cari)){
                model.addRow(new Object[]{sed.getIdSedan(), sed.getMerekMobil(), sed.getModelMobil(), sed.getTahunMobil(), sed.getDeskripsiMobil(), sed.getWarnaMobil(), sed.getHargaMobil(), sed.getStokMobil()});
            }
        }
        view.setTbSedan(model);
    }*/
    
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getTbPemesanan())){
            int i = view.getSelectedPemesanan();
            String idPemesanan  = view.getTbPemesanan().getModel().getValueAt(i, 0).toString();
            String tglPemesanan = view.getTbPemesanan().getModel().getValueAt(i, 1).toString();
            String idCustomer   = view.getTbPemesanan().getModel().getValueAt(i, 2).toString();
            String idMobil      = view.getTbPemesanan().getModel().getValueAt(i, 3).toString();
            String status       = view.getTbPemesanan().getModel().getValueAt(i, 4).toString();
            
            view.setIDPemesanan(idPemesanan);
            view.setTanggal(tglPemesanan);
            view.setIDCustomer(idCustomer);
            view.setIDMobil(idMobil);
            view.setStatus(status);
            
        }
    }
    
}
