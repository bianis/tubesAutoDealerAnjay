/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bian
 */
public class Pemesanan {
    public String idPemesanan;
    public String tglPemesanan;
    public String idCustomer; 
    public String idMobil;
    public String status;

    public Pemesanan(String idPemesanan, String tglPemesanan, String idCustomer, String idMobil, String status) {
        this.idPemesanan = idPemesanan;
        this.tglPemesanan = tglPemesanan;
        this.idCustomer = idCustomer;
        this.idMobil = idMobil;
        this.status = status;
    }

    

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(String idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getTglPemesanan() {
        return tglPemesanan;
    }

    public void setTglPemesanan(String tglPemesanan) {
        this.tglPemesanan = tglPemesanan;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
