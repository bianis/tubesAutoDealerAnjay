package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Koneksi {
    private Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    private ArrayList<Customer> customer = new ArrayList<>();
    private ArrayList<Sales>    sales   = new ArrayList<>();
    private ArrayList<Admin>    admin   = new ArrayList<>();
    private ArrayList<Sedan>    sedan   = new ArrayList<>();
    private ArrayList<SUV>      suv     = new ArrayList<>();
    private ArrayList<Mobil>    mobil   = new ArrayList<>();
    private ArrayList<MPV>      mpv     = new ArrayList<>();
    private ArrayList<Pemesanan>    pemesanan = new ArrayList<>();
    
    public Koneksi(){
        loadCustomer();
        loadSales();
        loadAdmin();
        loadSedan();
        loadSUV();
        loadMPV();
        loadPemesanan();
    }
    
    //Koneksi session
    
    public void connect(){
        String url = "jdbc:mysql://localhost/db_autodealer";
            String user = "root";
            String pass = "";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.out.println("Not Connected");
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
            System.out.println("Disonnected");
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    //Customer Model
    
    public ArrayList<Customer> getCustomer() {
        return customer;
    }
    
    public void loadCustomer() {
        connect();
        try {
            String query = "SELECT * FROM customer";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                customer.add(new Customer(
                        rs.getString("idCustomer"), 
                        rs.getString("namaCustomer"), 
                        rs.getString("ttlCustomer"), 
                        rs.getString("alamatCustomer"),
                        rs.getString("noHpCustomer"),
                        rs.getString("emailCustomer"),
                        rs.getString("passCustomer")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
    
    public void addCustomer(Customer c) {
        connect();
        String query = "INSERT INTO customer VALUES (";
        query += "'" + c.getIdCustomer()+   "',";
        query += "'" + c.getNamaCustomer()+ "',";
        query += "'" + c.getTtlCustomer()+  "',";
        query += "'" + c.getAlamatCustomer()+ "',";
        query += "'" + c.getNoHpCustomer()+   "',";
        query += "'" + c.getEmailCustomer()+  "',";
        query += "'" + c.getPassCustomer()+ "'";
        query += ")";
        if (manipulate(query)) customer.add(c);
        disconnect();
    }
    
    public boolean cekDuplikatIDCustomer(String ID){
        boolean cek = false;
        for (Customer c : customer) {
            if (c.getIdCustomer().equals(ID)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public void delCustomer(String id) {
        connect();
        String query = "DELETE FROM customer WHERE "
                + "idCustomer= '" + id + "'";
        if (manipulate(query)){
            for (Customer c : customer) {
                if (c.getIdCustomer().equals(id)){
                    customer.remove(c);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editCustomer(Customer c) {
        connect();
        String query = "UPDATE customer SET";
        query += " idCustomer       ='" + c.getIdCustomer() + "',";
        query += " namaCustomer     ='" + c.getNamaCustomer()+ "',";
        query += " ttlCustomer      ='" + c.getTtlCustomer()+ "',";
        query += " alamatCustomer   ='" + c.getAlamatCustomer()+ "',";
        query += " noHpCustomer     ='" + c.getNoHpCustomer()+ "',";
        query += " emailCustomer    ='" + c.getEmailCustomer()+ "',";
        query += " passCustomer     ='" + c.getPassCustomer()+ "'";
        query += " WHERE idCustomer ='" + c.getIdCustomer()+ "'";
        if (manipulate(query)){
            for (Customer cs : customer) {
                if (cs.getIdCustomer().equals(c.getIdCustomer())){
                    cs.setNamaCustomer(c.getNamaCustomer());
                    cs.setTtlCustomer(c.getTtlCustomer());
                    cs.setAlamatCustomer(c.getAlamatCustomer());
                    cs.setNoHpCustomer(c.getNoHpCustomer());
                    cs.setEmailCustomer(c.getEmailCustomer());
                    cs.setPassCustomer(c.getPassCustomer());
                    break;
                }
            }
        }
        disconnect();
    }
    
    //Sales Model
    
    public ArrayList<Sales> getSales(){
        return sales;
    }
    
    public void loadSales(){
        connect();
        try {
            String query = "SELECT * FROM sales";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                sales.add(new Sales(
                        rs.getString("id"), 
                        rs.getString("nama"), 
                        rs.getString("username"), 
                        rs.getString("pass"),
                        rs.getString("ttl"),
                        rs.getString("noHp"),
                        rs.getString("email"),
                        rs.getFloat("komisi")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
    
    public boolean cekDuplikatIDSales(String x){
        boolean cek = false;
        for (Sales s : sales) {
            if (s.getId().equals(x)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekDuplikatUsenameSales(String x){
        boolean cek = false;
        for (Sales s : sales) {
            if (s.getUsername().equals(x)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekIdSales (String x){
        boolean cek = false;
        if ((x.startsWith("SLS", 0)) && (x.length()==7)) {
            cek = true;
        }return cek;
    }
    
    public void addSales(Sales s) {
        connect();
        int i = (int) s.getKomisi();
        String query = "INSERT INTO sales VALUES (";
        query += "'" + s.getId()+   "',";
        query += "'" + s.getNama()+ "',";
        query += "'" + s.getUsername()+  "',";
        query += "'" + s.getPass()+ "',";
        query += "'" + s.getTtl()+   "',";
        query += "'" + s.getNoHp()+  "',";
        query += "'" + s.getEmail()+  "',";
        query += "'" + i+ "'";
        query += ")";
        if (manipulate(query)) sales.add(s);
        disconnect();
    }
    
    public void delSales(String x) {
        connect();
        String query = "DELETE FROM sales WHERE "
                + "id= '" + x + "'";
        if (manipulate(query)){
            for (Sales s : sales) {
                if (s.getId().equals(x)){
                    sales.remove(s);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editSales(Sales s) {
    connect();
        String query = "UPDATE sales SET";
        query += " nama     ='" + s.getNama()+ "',";
        query += " username ='" + s.getUsername()+ "',";
        query += " pass     ='" + s.getPass()+ "',";
        query += " ttl      ='" + s.getTtl()+ "',";
        query += " noHp     ='" + s.getNoHp()+ "',";
        query += " email    ='" + s.getEmail()+ "'";
        query += " WHERE id ='" + s.getId()+"'";
        if (manipulate(query)){
            for (Sales cs : sales) {
                if (cs.getId().equals(s.getId())){
                    cs.setNama(s.getNama());
                    cs.setUsername(s.getUsername());
                    cs.setPass(s.getPass());
                    cs.setTtl(s.getTtl());
                    cs.setNoHp(s.getNoHp());
                    cs.setEmail(s.getEmail());
                    break;
                }
            }
        }
        disconnect();
    }
    
    //Login dan Edit
    
    public boolean cekUserLogin(String u, String p){
        boolean cek = false;
        for (Admin a : admin) {
            if (a.getUsername().equals(u) && a.getPass().equals(p)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public String cariNama(String u){
        String nama = null;
        for(Admin a : admin){
            if (a.getUsername().equals(u)) {
                nama = a.getNama();
            }
        } return nama;
    }
    
    public String cariIdAdmin(String u){
        String id = null;
        for(Admin a : admin){
            if (a.getUsername().equals(u)) {
                id = a.getId();
            }
        } return id;
    }
    
    public String cariTtlAdmin(String id){
        String x = null;
        for(Admin a : admin){
            if(a.getId().equals(id)){
                x = a.getTtl();
            }
        } return x; 
    }
        
    public String cariNoAdmin(String id){
        String x = null;
        for(Admin a : admin){
            if(a.getId().equals(id)){
                x = a.getNoHp();
            }
        } return x; 
    }
    
    public String cariEmailAdmin(String id){
        String x = null;
        for(Admin a : admin){
            if(a.getId().equals(id)){
                x = a.getEmail();
            }
        } return x; 
    }
    
    public void loadAdmin() {
        connect();
        try {
            String query = "SELECT * FROM admin";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                admin.add(new Admin(
                        rs.getString("idPegawai"), 
                        rs.getString("nama"), 
                        rs.getString("Username"), 
                        rs.getString("Password"),
                        rs.getString("ttlPegawai"),
                        rs.getString("noHpPegawai"),
                        rs.getString("emailPegawai"),
                        rs.getFloat("gaji")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
    
    public void editAdmin(Admin a) {
    connect();
        String query = "UPDATE admin SET";
        query += " nama     ='" + a.getNama()+ "',";
        query += " Password     ='" + a.getPass()+ "',";
        query += " noHpPegawai     ='" + a.getNoHp()+ "'";
        query += " WHERE idPegawai ='" + a.getId()+"'";
        if (manipulate(query)){
            for (Admin cs : admin) {
                if (cs.getId().equals(a.getId())){
                    cs.setNama(a.getNama());
                    cs.setUsername(a.getUsername());
                    cs.setPass(a.getPass());
                    cs.setTtl(a.getTtl());
                    cs.setNoHp(a.getNoHp());
                    cs.setEmail(a.getEmail());
                    cs.setGajiPokok(a.getGajiPokok());
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void delAdmin(String x) {
        connect();
        String query = "DELETE FROM admin WHERE "
                + "idPegawai= '" + x + "'";
        if (manipulate(query)){
            for (Admin a : admin) {
                if (a.getId().equals(x)){
                    admin.remove(a);
                    break;
                }
            }
        }
        disconnect();
    }
    
    
    // Sedan Model
    
    public ArrayList<Sedan> getSedan() {
        return sedan;
    }
    
    public void loadSedan() {
        connect();
        try {
            String query = "SELECT * FROM sedan";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                sedan.add(new Sedan(rs.getString("idSedan"), 
                        rs.getString("merekMobil"), 
                        rs.getString("modelMobil"), 
                        rs.getString("tahunMobil"),
                        rs.getString("deskripsiMobil"),
                        rs.getString("warnaMobil"),
                        Integer.parseInt(rs.getString("hargaMobil")),
                        Integer.parseInt(rs.getString("stokMobil"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
    
    public void addSedan(Sedan s) {
        connect();
        String query = "INSERT INTO sedan VALUES (";
        query += "'" + s.getIdSedan() + "',";
        query += "'" + s.getMerekMobil() + "',";
        query += "'" + s.getModelMobil() + "',";
        query += "'" + s.getTahunMobil() + "',";
        query += "'" + s.getDeskripsiMobil() + "',";
        query += "'" + s.getWarnaMobil() + "',";
        query += "'" + s.getHargaMobil() + "',";
        query += "'" + s.getStokMobil()+ "'";
        query += ")";
        if (manipulate(query)) sedan.add(s);
        //add ke mobil juga
        String query2 = "INSERT INTO mobil VALUES (";
        query2 += "'" + s.getIdSedan() + "',";
        query2 += "'" + s.getMerekMobil() + "',";
        query2 += "'" + s.getModelMobil() + "',";
        query2 += "'" + s.getTahunMobil() + "',";
        query2 += "'" + s.getDeskripsiMobil() + "',";
        query2 += "'" + s.getWarnaMobil() + "',";
        query2 += "'" + s.getHargaMobil() + "',";
        query2 += "'" + s.getStokMobil()+ "'";
        query2 += ")";
        if (manipulate(query2)) mobil.add(s);
        disconnect();
    }
    
    public void deleteSedan(String id) {
        connect();
        String query = "DELETE FROM sedan WHERE idSedan='" + id + "'";
        if (manipulate(query)){
            for (Sedan sed : sedan) {
                if (sed.getIdSedan().equals(id)){
                    sedan.remove(sed);
                    break;
                }
            }
        }
        //mobil juga
        String query2 = "DELETE FROM mobil WHERE idMobil='" + id + "'";
        if (manipulate(query2)){
            for (Sedan sed : sedan) {
                if (sed.getIdSedan().equals(id)){
                    mobil.remove(sed);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editSedan(Sedan s) {
        connect();
        String query = "UPDATE sedan SET";
        query += " merekMobil='" + s.getMerekMobil() + "',";
        query += " modelMobil='" + s.getModelMobil() + "',";
        query += " tahunMobil='" + s.getModelMobil() + "',";
        query += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query += " hargaMobil='" + s.getHargaMobil()+ "',";
        query += " stokMobil='" + s.getStokMobil()+ "'";
        query += " WHERE idSedan='" + s.getIdSedan()+ "'";
        if (manipulate(query)){
            for (Sedan sed : sedan) {
                if (sed.getIdSedan().equals(s.getIdSedan())){
                    sed.setMerekMobil(s.getMerekMobil());
                    sed.setModelMobil(s.getModelMobil());
                    sed.setTahunMobil(s.getTahunMobil());
                    sed.setDeskripsiMobil(s.getDeskripsiMobil());
                    sed.setWarnaMobil(s.getWarnaMobil());
                    sed.setHargaMobil(s.getHargaMobil());
                    sed.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        String query2 = "UPDATE mobil SET";
        query2 += " merekMobil='" + s.getMerekMobil() + "',";
        query2 += " modelMobil='" + s.getModelMobil() + "',";
        query2 += " tahunMobil='" + s.getModelMobil() + "',";
        query2 += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query2 += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query2 += " hargaMobil='" + s.getHargaMobil()+ "',";
        query2 += " stokMobil='" + s.getStokMobil()+ "'";
        query2 += " WHERE idMobil='" + s.getIdSedan()+ "'";
        if (manipulate(query2)){
            for (Sedan sed : sedan) {
                if (sed.getIdSedan().equals(s.getIdSedan())){
                    sed.setMerekMobil(s.getMerekMobil());
                    sed.setModelMobil(s.getModelMobil());
                    sed.setTahunMobil(s.getTahunMobil());
                    sed.setDeskripsiMobil(s.getDeskripsiMobil());
                    sed.setWarnaMobil(s.getWarnaMobil());
                    sed.setHargaMobil(s.getHargaMobil());
                    sed.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        disconnect();
    }
    //ganti nama method
    public boolean cekDuplikatIDSed(String id){
        boolean cek = false;
        for (Sedan sed : sedan) {
            if (sed.getIdSedan().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    
    // SUV Model
    
    public ArrayList<SUV> getSUV() {
        return suv;
    }
    
    public void loadSUV() {
        connect();
        try {
            String query = "SELECT * FROM suv";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                suv.add(new SUV(rs.getString("idSUV"), 
                        rs.getString("merekMobil"), 
                        rs.getString("modelMobil"), 
                        rs.getString("tahunMobil"),
                        rs.getString("deskripsiMobil"),
                        rs.getString("warnaMobil"),
                        Integer.parseInt(rs.getString("hargaMobil")),
                        Integer.parseInt(rs.getString("stokMobil"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
   
    public void addSUV(SUV s) {
        connect();
        String query = "INSERT INTO suv VALUES (";
        query += "'" + s.getIdSUV() + "',";
        query += "'" + s.getMerekMobil() + "',";
        query += "'" + s.getModelMobil() + "',";
        query += "'" + s.getTahunMobil() + "',";
        query += "'" + s.getDeskripsiMobil() + "',";
        query += "'" + s.getWarnaMobil() + "',";
        query += "'" + s.getHargaMobil() + "',";
        query += "'" + s.getStokMobil()+ "'";
        query += ")";
        if (manipulate(query)) suv.add(s);
        //add ke mobil juga
        String query2 = "INSERT INTO mobil VALUES (";
        query2 += "'" + s.getIdSUV() + "',";
        query2 += "'" + s.getMerekMobil() + "',";
        query2 += "'" + s.getModelMobil() + "',";
        query2 += "'" + s.getTahunMobil() + "',";
        query2 += "'" + s.getDeskripsiMobil() + "',";
        query2 += "'" + s.getWarnaMobil() + "',";
        query2 += "'" + s.getHargaMobil() + "',";
        query2 += "'" + s.getStokMobil()+ "'";
        query2 += ")";
        if (manipulate(query2)) mobil.add(s);
        disconnect();
    }
    
    public void deleteSUV(String id) {
        connect();
        String query = "DELETE FROM suv WHERE idSUV='" + id + "'";
        if (manipulate(query)){
            for (SUV su : suv) {
                if (su.getIdSUV().equals(id)){
                    suv.remove(su);
                    break;
                }
            }
        }
        //mobil juga
        String query2 = "DELETE FROM mobil WHERE idMobil='" + id + "'";
        if (manipulate(query2)){
            for (SUV su : suv) {
                if (su.getIdSUV().equals(id)){
                    mobil.remove(su);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editSUV(SUV s) {
        connect();
        String query = "UPDATE suv SET";
        query += " merekMobil='" + s.getMerekMobil() + "',";
        query += " modelMobil='" + s.getModelMobil() + "',";
        query += " tahunMobil='" + s.getTahunMobil()+ "',";
        query += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query += " hargaMobil='" + s.getHargaMobil()+ "',";
        query += " stokMobil='" + s.getStokMobil()+ "'";
        query += " WHERE idSUV='" + s.getIdSUV()+ "'";
        if (manipulate(query)){
            for (SUV su : suv) {
                if (su.getIdSUV().equals(s.getIdSUV())){
                    su.setMerekMobil(s.getMerekMobil());
                    su.setModelMobil(s.getModelMobil());
                    su.setTahunMobil(s.getTahunMobil());
                    su.setDeskripsiMobil(s.getDeskripsiMobil());
                    su.setWarnaMobil(s.getWarnaMobil());
                    su.setHargaMobil(s.getHargaMobil());
                    su.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        String query2 = "UPDATE mobil SET";
        query2 += " merekMobil='" + s.getMerekMobil() + "',";
        query2 += " modelMobil='" + s.getModelMobil() + "',";
        query2 += " tahunMobil='" + s.getModelMobil() + "',";
        query2 += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query2 += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query2 += " hargaMobil='" + s.getHargaMobil()+ "',";
        query2 += " stokMobil='" + s.getStokMobil()+ "'";
        query2 += " WHERE idMobil='" + s.getIdSUV()+ "'";
        if (manipulate(query2)){
            for (SUV su : suv) {
                if (su.getIdSUV().equals(s.getIdSUV())){
                    su.setMerekMobil(s.getMerekMobil());
                    su.setModelMobil(s.getModelMobil());
                    su.setTahunMobil(s.getTahunMobil());
                    su.setDeskripsiMobil(s.getDeskripsiMobil());
                    su.setWarnaMobil(s.getWarnaMobil());
                    su.setHargaMobil(s.getHargaMobil());
                    su.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        disconnect();
    }
    //ganti nama method
    public boolean cekDuplikatIDSUV(String id){
        boolean cek = false;
        for (SUV su : suv) {
            if (su.getIdSUV().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    
    // MPV Model
    
    public ArrayList<MPV> getMPV() {
        return mpv;
    }
    
    public void loadMPV() {
        connect();
        try {
            String query = "SELECT * FROM mpv";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                mpv.add(new MPV(rs.getString("idMPV"), 
                        rs.getString("merekMobil"), 
                        rs.getString("modelMobil"), 
                        rs.getString("tahunMobil"),
                        rs.getString("deskripsiMobil"),
                        rs.getString("warnaMobil"),
                        Integer.parseInt(rs.getString("hargaMobil")),
                        Integer.parseInt(rs.getString("stokMobil"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
 
    public void addMPV(MPV s) {
        connect();
        String query = "INSERT INTO mpv VALUES (";
        query += "'" + s.getIdMPV() + "',";
        query += "'" + s.getMerekMobil() + "',";
        query += "'" + s.getModelMobil() + "',";
        query += "'" + s.getTahunMobil() + "',";
        query += "'" + s.getDeskripsiMobil() + "',";
        query += "'" + s.getWarnaMobil() + "',";
        query += "'" + s.getHargaMobil() + "',";
        query += "'" + s.getStokMobil()+ "'";
        query += ")";
        if (manipulate(query)) mpv.add(s);
        //add ke mobil juga
        String query2 = "INSERT INTO mobil VALUES (";
        query2 += "'" + s.getIdMPV() + "',";
        query2 += "'" + s.getMerekMobil() + "',";
        query2 += "'" + s.getModelMobil() + "',";
        query2 += "'" + s.getTahunMobil() + "',";
        query2 += "'" + s.getDeskripsiMobil() + "',";
        query2 += "'" + s.getWarnaMobil() + "',";
        query2 += "'" + s.getHargaMobil() + "',";
        query2 += "'" + s.getStokMobil()+ "'";
        query2 += ")";
        if (manipulate(query2)) mobil.add(s);
        disconnect();
    }
    
    public void deleteMPV(String id) {
        connect();
        String query = "DELETE FROM mpv WHERE idMPV='" + id + "'";
        if (manipulate(query)){
            for (MPV su : mpv) {
                if (su.getIdMPV().equals(id)){
                    mpv.remove(su);
                    break;
                }
            }
        }
        //mobil juga
        String query2 = "DELETE FROM mobil WHERE idMobil='" + id + "'";
        if (manipulate(query2)){
            for (MPV su : mpv) {
                if (su.getIdMPV().equals(id)){
                    mobil.remove(su);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editMPV(MPV s) {
        connect();
        String query = "UPDATE mpv SET";
        query += " merekMobil='" + s.getMerekMobil() + "',";
        query += " modelMobil='" + s.getModelMobil() + "',";
        query += " tahunMobil='" + s.getModelMobil() + "',";
        query += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query += " hargaMobil='" + s.getHargaMobil()+ "',";
        query += " stokMobil='" + s.getStokMobil()+ "'";
        query += " WHERE idMPV='" + s.getIdMPV()+ "'";
        if (manipulate(query)){
            for (MPV su : mpv) {
                if (su.getIdMPV().equals(s.getIdMPV())){
                    su.setMerekMobil(s.getMerekMobil());
                    su.setModelMobil(s.getModelMobil());
                    su.setTahunMobil(s.getTahunMobil());
                    su.setDeskripsiMobil(s.getDeskripsiMobil());
                    su.setWarnaMobil(s.getWarnaMobil());
                    su.setHargaMobil(s.getHargaMobil());
                    su.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        String query2 = "UPDATE mobil SET";
        query2 += " merekMobil='" + s.getMerekMobil() + "',";
        query2 += " modelMobil='" + s.getModelMobil() + "',";
        query2 += " tahunMobil='" + s.getModelMobil() + "',";
        query2 += " deskripsiMobil='" + s.getDeskripsiMobil() + "',";
        query2 += " warnaMobil='" + s.getWarnaMobil()+ "',";
        query2 += " hargaMobil='" + s.getHargaMobil()+ "',";
        query2 += " stokMobil='" + s.getStokMobil()+ "'";
        query2 += " WHERE idMobil='" + s.getIdMPV()+ "'";
        if (manipulate(query2)){
            for (MPV su : mpv) {
                if (su.getIdMPV().equals(s.getIdMPV())){
                    su.setMerekMobil(s.getMerekMobil());
                    su.setModelMobil(s.getModelMobil());
                    su.setTahunMobil(s.getTahunMobil());
                    su.setDeskripsiMobil(s.getDeskripsiMobil());
                    su.setWarnaMobil(s.getWarnaMobil());
                    su.setHargaMobil(s.getHargaMobil());
                    su.setStokMobil(s.getStokMobil());
                    break;
                }
            }
        }
        disconnect();
    }
    //ganti nama method
    public boolean cekDuplikatIDMPV(String id){
        boolean cek = false;
        for (MPV mp : mpv) {
            if (mp.getIdMPV().equals(id)){
                cek = true;
                break;
            }
        }
        return cek;
    }

    // Pemesanan Model
    
    public ArrayList<Pemesanan> getPemesanan() {
        return pemesanan;
    }
    
    public void loadPemesanan() {
        connect();
        try {
            String query = "SELECT * FROM pemesanan";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                pemesanan.add(new Pemesanan(
                        rs.getString("idPemesanan"), 
                        rs.getString("tglPemesanan"), 
                        rs.getString("idCustomer"), 
                        rs.getString("idMobil"),
                        rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       disconnect();
    }
    
    public int cekStock(String idMobil){
        int stock = 0;
        for (Sedan s : sedan) {
            if (s.getIdSedan().equals(idMobil)){
                stock = s.getStokMobil();
                break;
            }
        }
        
        return stock;
    }
    
    public void kurangiStokSedan(Sedan s){
        connect();
        int newstock = s.getStokMobil() - 1;
        s.setStokMobil(newstock);
        
        
    }
    
    public void addPemesanan(Pemesanan p) {
        connect();
        String query = "INSERT INTO pemesanan VALUES (";
        query += "'" + p.getIdPemesanan()+   "',";
        query += "'" + p.getTglPemesanan()+  "',";
        query += "'" + p.getIdCustomer()+ "',";
        query += "'" + p.getIdMobil()+ "',";
        query += "'" + p.getStatus()+ "'";
        query += ")";
        if (manipulate(query)) pemesanan.add(p);
        disconnect();
        
    }
    
    public boolean cekDuplikatIDPemesanan(String ID){
        boolean cek = false;
        for (Pemesanan p : pemesanan) {
            if (p.getIdPemesanan().equals(ID)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public void delPemesanan(String id) {
        connect();
        String query = "DELETE FROM pemesanan WHERE "
                + "idPemesanan= '" + id + "'";
        if (manipulate(query)){
            for (Pemesanan p : pemesanan) {
                if (p.getIdPemesanan().equals(id)){
                    pemesanan.remove(p);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void editPemesanan(Pemesanan p) {
        connect();
        String query = "UPDATE pemesanan SET";
        query += " idPemesanan          ='" + p.getIdPemesanan() + "',";
        query += " tglPemesanan         ='" + p.getTglPemesanan()+ "',";
        query += " idCustomer           ='" + p.getIdCustomer()+ "',";
        query += " idMobil              ='" + p.getIdMobil()+ "',";
        query += " status               ='" + p.getStatus()+ "'";
        query += " WHERE idPemesanan    ='" + p.getIdPemesanan()+ "'";
        if (manipulate(query)){
            for (Pemesanan pe : pemesanan) {
                if (pe.getIdPemesanan().equals(p.getIdPemesanan())){
                    pe.setTglPemesanan(p.getTglPemesanan());
                    pe.setIdCustomer(p.getIdCustomer());
                    pe.setIdMobil(p.getIdMobil());
                    pe.setStatus(p.getStatus());
                    break;
                }
            }
        }
        disconnect();
    }
    
}
