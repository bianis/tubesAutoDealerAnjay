/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author user
 */
public class Sales extends Pegawai{
    private float komisi;

    public Sales(String id, String nama, String username, String pass, String ttl, String noHp, String email, float komisi) {
        super(id, nama, username, pass, ttl, noHp, email);
        this.komisi = komisi;
    }
    
    public float getKomisi() {
        return komisi;
    }

    public void setKomisi(float komisi) {
        this.komisi = komisi;
    }
     
}
