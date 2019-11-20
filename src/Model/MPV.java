/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class MPV extends Mobil{
    public String idMPV;

    public MPV(String idMPV, String merekMobil, String modelMobil, String tahunMobil, String deskripsiMobil, String warnaMobil, int hargaMobil, int stokMobil) {
        super(merekMobil, modelMobil, tahunMobil, deskripsiMobil, warnaMobil, hargaMobil, stokMobil);
        this.idMPV = idMPV;
    }

    public String getIdMPV() {
        return idMPV;
    }

    public void setIdMPV(String idMPV) {
        this.idMPV = idMPV;
    }

        
    
}
