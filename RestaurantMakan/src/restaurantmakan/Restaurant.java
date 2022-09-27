package restaurantmakan;

import java.util.Scanner;

public class Restaurant {
    Produk[] produk;
    Scanner scan = new Scanner(System.in);
    
    Restaurant(int idElement){
        produk = new Produk[idElement];
    }
    
    public void tambahMakanan(String namaMakanan, int harga, int stok){
        int id = Produk.getId();
        produk[id] = new Produk();

        produk[id].setNamaProduk(namaMakanan);
        produk[id].setHarga(harga);
        produk[id].setQty(stok);
        
        Produk.nextId();
    }
    
    public void inputMenambahMakanan(){
        String namaMakanan;
        int harga;
        int stok;
        System.out.print("Nama Makanan : ");
        namaMakanan = scan.next();
        System.out.print("Harga : ");
        harga  = scan.nextInt();
        System.out.print("Stok : ");
        stok = scan.nextInt();
        
        tambahMakanan(namaMakanan,harga,stok);
    }
    
    public void daftarMenuMakanan(){
        tambahMakanan("Batagor", 5000, 2);
        tambahMakanan("Roti Bakar", 12000, 10);
        tambahMakanan("Indomie+telor", 10000, 10);
        tambahMakanan("Kwetiaw", 12000, 10);
        tambahMakanan("Nasi Goreng", 12000, 10);
        tambahMakanan("Air Mineral", 3000, 10);
        tambahMakanan("Teh Manis", 4000, 10);
        tambahMakanan("Jus Alpukat", 8000, 10);
        tambahMakanan("Teh Botol", 5000, 10);
        tambahMakanan("Kopi", 3000, 0);
        tambahMakanan("Susu", 3000, 10);
    }
    
    public void pesanMakanan(){
        boolean done = true;
        boolean selesai = false;
        int totalBayar = 0;
        int hitung = 0;
        int pilihMakanan;
        int[] pesan = new int[3];
        printMakanan();
        while(done){
            System.out.print("Silahkan Pilih Menu : ");
            pilihMakanan = scan.nextInt();
            if(isStokEmpty(pilihMakanan - 1)){
                if(validasiPesanan(pilihMakanan - 1)){
                    hitung += 1;
                    pesan[hitung - 1] = pilihMakanan - 1;
                    produk[pilihMakanan - 1].setQty(produk[pilihMakanan - 1].getQty() - 1);
                    System.out.println("Stok saat ini : "+produk[pilihMakanan - 1].getQty());
                    if(hitung == 3){
                        break;
                    }
                    done = cekLanjutPemesanan();
                } else {
                    done = cekLanjutPemesanan();
                }
            } else {
                System.out.println("Produk tersebut habis");
            }
        }
        for(int i = 0; i < hitung; i++){
            pesananStruk(pesan[i]);
            totalBayar += produk[pesan[i]].getHarga();
        }
        
        while(!selesai){
            System.out.println("Total yang perlu anda bayar adalah = "+totalBayar);
            System.out.print("Masukkan Uang anda = ");
            int a = scan.nextInt();
            if(a >= totalBayar){
                selesai = true;
                int kembali = a - totalBayar;
                System.out.println("Kembalian anda adalah = "+ kembali);
            } else {
                System.out.println("Uang anda kurang");
            }
        }
    }
    
    public boolean validasiPesanan(int pilihMakanan){
        if(pilihMakanan < Produk.getId()){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean cekLanjutPemesanan(){
        String check;
        System.out.print("Apakah masih ingin memesan? [y/n] : ");
        check = scan.next();
        return "y".equals(check) || "Y".equals(check);
    }
    
    public void pesananStruk(int id){
        System.out.println("Anda Memilih pesanan ini : ");
        System.out.println("==========="+(id+1)+"==========");
        System.out.println("Nama_Produk : "+produk[id].getNamaProduk());
        System.out.println("Nama_Produk : "+produk[id].getHarga());
        System.out.println("");
    }
    
    public void menambahStokMakanan(){
        printMakanan();
        int id = 0;
        int stok = 0;
        System.out.print("Makanan/Minuman apa yang ingin ditambahkan : ");
        id = scan.nextInt();
        System.out.print("Berapa banyak stok : ");
        stok = scan.nextInt();
        produk[id-1].setQty(produk[id-1].getQty() + stok);
    }
    
    public boolean isStokEmpty(int id){
        if(produk[id].getQty() == 0){
            return false;
        } else {
            return true;
        }
    }
    
    public void printMakanan(){
        System.out.println("=================================");
        System.out.println("Selamat Datang di Restaurant kami");
        System.out.println("=================================");
        System.out.println("===============Menu==============");
        System.out.println("=================================");
        for(int i = 0;i < Produk.getId();i++){
            if(isStokEmpty(i)){
                System.out.println(i+1 + ". " + produk[i].getNamaProduk()+ "        = Rp " + produk[i].getHarga()+" Stok : "+produk[i].getQty());
            } else {
                System.out.println(i+1 +" "+produk[i].getNamaProduk()+ " Stok makanan/minuman ini sedang habis");
            }
        }
    }
}
