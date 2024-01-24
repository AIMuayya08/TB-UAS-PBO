class HitungDenda extends Peminjam implements Denda {
    private int batasWaktu = 7;
    private int dendaPerHari = 10000;

    public HitungDenda() {
        super(""); // Constructor superclass
    }

    @Override
    public int hitungDenda(int hariTerlambat) {
        return hariTerlambat > 0 ? hariTerlambat * dendaPerHari : 0;
    }

    
    public int hitungKeterlambatan(int jumlahHariPeminjaman) {
        int keterlambatan = Math.max(0, jumlahHariPeminjaman - batasWaktu);
        return keterlambatan;
    }
}