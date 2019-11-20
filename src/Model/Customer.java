package Model;

public class Customer {
    private String idCustomer;
    private String namaCustomer;
    private String ttlCustomer;
    private String alamatCustomer;
    private String noHpCustomer;
    private String emailCustomer;
    private String passCustomer;

    public Customer(String idCustomer, String namaCustomer, String ttlCustomer, String alamatCustomer, String noHpCustomer, String emailCustomer, String passCustomer) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.ttlCustomer = ttlCustomer;
        this.alamatCustomer = alamatCustomer;
        this.noHpCustomer = noHpCustomer;
        this.emailCustomer = emailCustomer;
        this.passCustomer = passCustomer;
    }


    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public void setTtlCustomer(String ttlCustomer) {
        this.ttlCustomer = ttlCustomer;
    }

    public void setAlamatCustomer(String alamatCustomer) {
        this.alamatCustomer = alamatCustomer;
    }

    public void setNoHpCustomer(String noHpCustomer) {
        this.noHpCustomer = noHpCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public void setPassCustomer(String passCustomer) {
        this.passCustomer = passCustomer;
    }  

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public String getTtlCustomer() {
        return ttlCustomer;
    }

    public String getAlamatCustomer() {
        return alamatCustomer;
    }

    public String getNoHpCustomer() {
        return noHpCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public String getPassCustomer() {
        return passCustomer;
    }
    
}