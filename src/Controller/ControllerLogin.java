/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Koneksi;
import View.AdminEditProfile;
import View.AdminHome;
import View.AdminLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */
public class ControllerLogin implements ActionListener {
    private AdminLogin view;
    private AdminEditProfile view2;
    private Koneksi kn;
    private String idAdmin;
    private String user;
    private String pass;
    
    
    public ControllerLogin(){
        kn = new Koneksi();
        view = new AdminLogin();
        view2 = new AdminEditProfile();
        view.addActionListener(this);
        view2.addActionListener(this);
        view.setVisible(true);
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())){
            btnLoginActionPerformed();
        } else if (source.equals(view.getBtnEdit())) {
            btnEditActionPerformed();
        } else if (source.equals(view2.getBtnBackLogin())){
            btnBackActionPerformed();
        } else if (source.equals(view2.getBtnSimpanData())){
            btnSimpanActionPerformed();
            btnBackActionPerformed();
        } else if (source.equals(view2.getBtnHapusAdmin())){
            btnHapusActionPerformed();
            btnBackActionPerformed();
        }
    }
    
    public void btnBackActionPerformed(){
            view2.setVisible(false);
            view.setVisible(true);
            view.setTfUsername("");
            view.setTfPassword("");
            user = null;
            pass = null;
            idAdmin = null;
    }
    
    public void btnLoginActionPerformed(){
        user = view.getTfUsername();
        pass = view.getTfPassword();
        String nama;
        if(user.isEmpty() || pass.isEmpty()){
            view.showMessage("Masukkan Username dan Password", "Error", 0);
        }else{
            if(kn.cekUserLogin(user, pass)){
                nama = kn.cariNama(user);
                idAdmin = kn.cariIdAdmin(user);
                System.out.println(idAdmin);
                view.showMessage("Selamat Datang " + nama, "Login Succeded", 1);
                new AdminHome();
                view.setVisible(false);
            } else {
                view.showMessage("Username Atau Password Salah", "Login Failed", 2);
            }
        }
    }
    
    public void btnEditActionPerformed(){
        user = view.getTfUsername();
        pass = view.getTfPassword();
        String nama;
        if(user.isEmpty() || pass.isEmpty()){
            view.showMessage("Masukkan Username dan Password", "Error", 0);
        }else{
            if(kn.cekUserLogin(user, pass)){
                nama = kn.cariNama(user);
                idAdmin = kn.cariIdAdmin(user);
                System.out.println(idAdmin);
                view.showMessage("Selamat Datang " + nama, "Login Succeded", 1);
                view2.setVisible(true);
                view.setVisible(false);
                String ttl, no, email, gaji;
                ttl = kn.cariTtlAdmin(idAdmin);
                email = kn.cariEmailAdmin(idAdmin);
                no = kn.cariNoAdmin(idAdmin);
                view2.setTfNamaAdmin(nama);
                view2.setTfIdAdmin(idAdmin);
                view2.setTfUsername(user);
                view2.setTfPassword(pass);
                view2.setTfNoHp(no);
                view2.setTfTtl(ttl);
                view2.setTfEmail(email);
            } else {
                view.showMessage("Username Atau Password Salah", "Login Failed", 2);
            }
        }
    }
    
    public void btnSimpanActionPerformed(){
        String id       = view2.getTfIdAdmin();
        String nama     = view2.getTfNamaAdmin();
        String user     = view2.getTfUsername();
        String pass     = view2.getTfPassword();
        String ttl      = view2.getTfTtl();
        String no       = view2.getTfNoHp();
        String email    = view2.getTfEmail();
        Float gaji    = (float) 0;
        kn.editAdmin(new Admin(id,nama,user,pass,ttl,no,email,gaji));
        view.showMessage("Data Berhasil Diubah", "Success", 1);
    }
    
    public void btnHapusActionPerformed(){
        kn.delAdmin(idAdmin);
        view.showMessage("Data Admin " + idAdmin +" Berhasil Dihapus !", "Success", 1);
    }
    
    public String getIdAdmin() {
        return idAdmin;
    }
}
