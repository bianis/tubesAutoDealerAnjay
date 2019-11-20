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
public class ControllerSUV extends MouseAdapter implements ActionListener {
    
    private AdminSUV view;
    private Koneksi db;

    public ControllerSUV() {
        view = new AdminSUV();
        db = new Koneksi();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTableMobil();
    }
    
    public void loadTableMobil(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Merek", "Model", "Tahun", "Deskripsi", "Warna", "Harga", "Stok"}, 0);
        ArrayList<SUV> suv = db.getSUV();
        for (SUV su : suv) {
            model.addRow(new Object[]{su.getIdSUV(), su.getMerekMobil(), su.getModelMobil(), su.getTahunMobil(), su.getDeskripsiMobil(), su.getWarnaMobil(), su.getHargaMobil(), su.getStokMobil()});
        }
        view.setTbSUV(model);
    }
//sampe sini
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
            if (db.cekDuplikatIDSUV(idMobil)){
                view.showMessage("ID Sudah Ada", "Error", 0);
            }else{
                db.addSUV(new SUV(idMobil, merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil));
                view.reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
            }
        }
    }
    
    
    public void btnDeleteActionPerformed(){
        String idMobil = view.getIDMobil();
        db.deleteSUV(idMobil);
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
            if (!db.cekDuplikatIDSUV(idMobil)){
                view.showMessage("ID SUV Tidak Ditemukan", "Error", 0);
            }else{
                db.editSUV(new SUV(idMobil, merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil));
                view.reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
            }
        }
    }
    
    public void btnSearchActionPerformed(){
        String cari = view.getTfSearch();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Merek", "Model", "Tahun", "Deskripsi", "Warna", "Harga","Stok"}, 0);
        ArrayList<SUV> suv = db.getSUV();
        for (SUV su : suv) {
            if (su.getIdSUV().contains(cari) || su.getMerekMobil().contains(cari) || su.getModelMobil().contains(cari) || su.getTahunMobil().contains(cari) || su.getWarnaMobil().contains(cari)){
                model.addRow(new Object[]{su.getIdSUV(), su.getMerekMobil(), su.getModelMobil(), su.getTahunMobil(), su.getDeskripsiMobil(), su.getWarnaMobil(), su.getHargaMobil(), su.getStokMobil()});
            }
        }
        view.setTbSUV(model);
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getTbSUV())){
            int i = view.getSelectedMobil();
            String idMobil          = view.getTbSUV().getModel().getValueAt(i, 0).toString();
            String merekMobil       = view.getTbSUV().getModel().getValueAt(i, 1).toString();
            String modelMobil       = view.getTbSUV().getModel().getValueAt(i, 2).toString();
            String tahunMobil       = view.getTbSUV().getModel().getValueAt(i, 3).toString();
            String deskripsiMobil   = view.getTbSUV().getModel().getValueAt(i, 4).toString();
            String warnaMobil       = view.getTbSUV().getModel().getValueAt(i, 5).toString();
            int hargaMobil          = Integer.parseInt(view.getTbSUV().getModel().getValueAt(i, 6).toString());
            int stokMobil           = Integer.parseInt(view.getTbSUV().getModel().getValueAt(i, 7).toString());
            
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
