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
public abstract class Mobil {
    private String merekMobil;
    private String modelMobil;
    private String tahunMobil;
    private String deskripsiMobil;
    private String warnaMobil;
    private int hargaMobil;
    private int stokMobil;

    public Mobil(String merekMobil, String modelMobil, String tahunMobil, String deskripsiMobil, String warnaMobil, int hargaMobil, int stokMobil) {
        this.merekMobil = merekMobil;
        this.modelMobil = modelMobil;
        this.tahunMobil = tahunMobil;
        this.deskripsiMobil = deskripsiMobil;
        this.warnaMobil = warnaMobil;
        this.hargaMobil = hargaMobil;
        this.stokMobil = stokMobil;
    }

    
    
    public String getMerekMobil() {
        return merekMobil;
    }

    public void setMerekMobil(String merekMobil) {
        this.merekMobil = merekMobil;
    }

    public String getModelMobil() {
        return modelMobil;
    }

    public void setModelMobil(String modelMobil) {
        this.modelMobil = modelMobil;
    }

    public String getTahunMobil() {
        return tahunMobil;
    }

    public void setTahunMobil(String tahunMobil) {
        this.tahunMobil = tahunMobil;
    }

    public String getDeskripsiMobil() {
        return deskripsiMobil;
    }

    public void setDeskripsiMobil(String deskripsiMobil) {
        this.deskripsiMobil = deskripsiMobil;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public void setWarnaMobil(String warnaMobil) {
        this.warnaMobil = warnaMobil;
    }

    public int getHargaMobil() {
        return hargaMobil;
    }

    public void setHargaMobil(int hargaMobil) {
        this.hargaMobil = hargaMobil;
    }

    public int getStokMobil() {
        return stokMobil;
    }

    public void setStokMobil(int stokMobil) {
        this.stokMobil = stokMobil;
    }

    
}
