/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Sedan extends Mobil{
    public String idSedan;

    public Sedan(String idSedan, String merekMobil, String modelMobil, String tahunMobil, String deskripsiMobil, String warnaMobil, int hargaMobil, int stokMobil) {
        super(merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil);
        this.idSedan = idSedan;
    }

    public String getIdSedan() {
        return idSedan;
    }

    public void setIdSedan(String idSedan) {
        this.idSedan = idSedan;
    }
    
    
    
    
    
    
}
