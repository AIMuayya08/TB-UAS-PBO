import java.util.Date;

class DataPinjam {
    private Date tanggalPinjam;
    private Date tanggalKembali;

    public DataPinjam(Date tanggalPinjam, Date tanggalKembali) {
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }
}