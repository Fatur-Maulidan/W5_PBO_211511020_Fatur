package restaurant;
public class Menu {
    private String nama_makanan;
    private double harga_makanan;
    private int stok;
    private static byte id = 0;
    
    public Menu(String nama_makanan, double harga_makanan, int stok){
        this.nama_makanan = nama_makanan;
        this.harga_makanan = harga_makanan;
        this.stok = stok;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public double getHarga_makanan() {
        return harga_makanan;
    }

    public int getStok() {
        return stok;
    }

    public static byte getId(){
        return id;
    }
        
    public static void nextId(){
        id += 1;
    }
}
