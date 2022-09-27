package restaurantmakan;
public class Produk {
    private String namaProduk;
    private double harga;
    private int qty;
    private static int id = 0;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public static int getId(){
        return id;
    }
    
    public static void nextId(){
        id += 1;
    }
}
