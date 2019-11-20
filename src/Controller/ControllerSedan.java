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
public class ControllerSedan extends MouseAdapter implements ActionListener {
    
    private AdminSedan view;
    private Koneksi db;

    public ControllerSedan() {
        view = new AdminSedan();
        db = new Koneksi();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTableMobil();
    }
    
    public void loadTableMobil(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Merek", "Model", "Tahun", "Deskripsi", "Warna", "Harga", "Stok"}, 0);
        ArrayList<Sedan> sedan = db.getSedan();
        for (Sedan sed : sedan) {
            model.addRow(new Object[]{sed.getIdSedan(), sed.getMerekMobil(), sed.getModelMobil(), sed.getTahunMobil(), sed.getDeskripsiMobil(), sed.getWarnaMobil(), sed.getHargaMobil(), sed.getStokMobil()});
        }
        view.setTbSedan(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())){
            btnAddActionPerformed();
            loadTableMobil();
        }else if (source.equals(view.getBtnDelete())){
            btnDeleteActionPerformed();
            loadTableMobil();
        }else if (source.equals(view.getBtnEdit())){
            btnEditActionPerformed();
            loadTableMobil();
        }else if (source.equals(view.getBtnReset())){
            view.reset();
            loadTableMobil();
        }else if (source.equals(view.getBtnSearch())){
            btnSearchActionPerformed();
        }else if (source.equals(view.getBtnBackTo())){
            new ControllerAdminMenu();
            view.setVisible(false);
        }
    }
    
    public void btnAddActionPerformed(){
        String idMobil          = view.getIDMobil();
        String merekMobil       = view.getMerekMobil();
        String modelMobil       = view.getModelMobil();
        String tahunMobil       = view.getTahunMobil();
        String deskripsiMobil   = view.getDeskripsiMobil();
        String warnaMobil       = view.getWarnaMobil();
        int hargaMobil          = view.getHargaMobil();
        int stokMobil           = view.getStok();
        if (idMobil.isEmpty() || merekMobil.isEmpty() || modelMobil.isEmpty() || tahunMobil.isEmpty() || deskripsiMobil.isEmpty() || warnaMobil.isEmpty() || hargaMobil == 0 ){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (db.cekDuplikatIDSed(idMobil)){
                view.showMessage("ID Sudah Ada", "Error", 0);
            }else{
                db.addSedan(new Sedan(idMobil, merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil));
                view.reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
            }
        }
    }
    
    
    public void btnDeleteActionPerformed(){
        String idMobil = view.getIDMobil();
        db.deleteSedan(idMobil);
        view.reset();
        view.showMessage("Data Berhasil Dihapus", "Success", 1);
    }
    
    
     public void btnEditActionPerformed(){
        String idMobil          = view.getIDMobil();
        String merekMobil       = view.getMerekMobil();
        String modelMobil       = view.getModelMobil();
        String tahunMobil       = view.getTahunMobil();
        String deskripsiMobil   = view.getDeskripsiMobil();
        String warnaMobil       = view.getWarnaMobil();
        int hargaMobil          = view.getHargaMobil();
        int stokMobil           = view.getStok();
        if (idMobil.isEmpty() || merekMobil.isEmpty() || modelMobil.isEmpty() || tahunMobil.isEmpty() || deskripsiMobil.isEmpty() || warnaMobil.isEmpty() || hargaMobil == 0){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (!db.cekDuplikatIDSed(idMobil)){
                view.showMessage("ID Sedan Tidak Ditemukan", "Error", 0);
            }else{
                db.editSedan(new Sedan(idMobil, merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil));
                view.reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
            }
        }
    }
    
    public void btnSearchActionPerformed(){
        String cari = view.getTfSearch();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Merek", "Model", "Tahun", "Deskripsi", "Warna", "Harga","Stok"}, 0);
        ArrayList<Sedan> sedan = db.getSedan();
        for (Sedan sed : sedan) {
            if (sed.getIdSedan().contains(cari) || sed.getMerekMobil().contains(cari) || sed.getModelMobil().contains(cari) || sed.getTahunMobil().contains(cari) || sed.getWarnaMobil().contains(cari)){
                model.addRow(new Object[]{sed.getIdSedan(), sed.getMerekMobil(), sed.getModelMobil(), sed.getTahunMobil(), sed.getDeskripsiMobil(), sed.getWarnaMobil(), sed.getHargaMobil(), sed.getStokMobil()});
            }
        }
        view.setTbSedan(model);
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getTbSedan())){
            int i = view.getSelectedMobil();
            String idMobil          = view.getTbSedan().getModel().getValueAt(i, 0).toString();
            String merekMobil       = view.getTbSedan().getModel().getValueAt(i, 1).toString();
            String modelMobil       = view.getTbSedan().getModel().getValueAt(i, 2).toString();
            String tahunMobil       = view.getTbSedan().getModel().getValueAt(i, 3).toString();
            String deskripsiMobil   = view.getTbSedan().getModel().getValueAt(i, 4).toString();
            String warnaMobil       = view.getTbSedan().getModel().getValueAt(i, 5).toString();
            int hargaMobil          = Integer.parseInt(view.getTbSedan().getModel().getValueAt(i, 6).toString());
            int stokMobil           = Integer.parseInt(view.getTbSedan().getModel().getValueAt(i, 7).toString());
            
            view.setIDMobil(idMobil);
            view.setMerekMobil(merekMobil);
            view.setModelMobil(modelMobil);
            view.setTahunMobil(tahunMobil);
            view.setDeskripsiMobil(deskripsiMobil);
            view.setWarnaMobil(warnaMobil);
            view.setHargaMobil(hargaMobil);
            view.setStok(stokMobil);
            
            
        }
    }
    
}
