/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class SUV extends Mobil{
    public String idSUV;

    public SUV(String idSUV, String merekMobil, String modelMobil, String tahunMobil, String deskripsiMobil, String warnaMobil, int hargaMobil, int stokMobil) {
        super(merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil);
        this.idSUV = idSUV;
    }

    public String getIdSUV() {
        return idSUV;
    }

    public void setIdSUV(String idSUV) {
        this.idSUV = idSUV;
    }

    
    
    
    
    
    
    
}
