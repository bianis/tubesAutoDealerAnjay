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
public class Admin extends Pegawai{
    
    private float gajiPokok;

    public Admin(String id, String nama, String username, String pass, String ttl, String noHp, String email, Float gaji) {
        super(id, nama, username, pass, ttl, noHp, email);
    }
    
    public float getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(float gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    
}
