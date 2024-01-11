public class IntelligenceMember {
    private String nama;
    private String kodeAnggota;
    private String tingkatKeahlian;
    private String misi;

    public IntelligenceMember(String nama, String kodeAnggota, String tingkatKeahlian) {
        this.nama = nama;
        this.kodeAnggota = kodeAnggota;
        this.tingkatKeahlian = tingkatKeahlian;
        this.misi = "";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKodeAnggota() {
        return kodeAnggota;
    }

    public void setKodeAnggota(String kodeAnggota) {
        this.kodeAnggota = kodeAnggota;
    }

    public String getTingkatKeahlian() {
        return tingkatKeahlian;
    }

    public void setTingkatKeahlian(String tingkatKeahlian) {
        this.tingkatKeahlian = tingkatKeahlian;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nKode Anggota: " + kodeAnggota + "\nTingkat Keahlian: " + tingkatKeahlian + "\nMisi: " + misi;
    }
}
