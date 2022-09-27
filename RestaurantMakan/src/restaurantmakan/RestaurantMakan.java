package restaurantmakan;
import java.util.Scanner;
public class RestaurantMakan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int element = 20;
        Restaurant res = new Restaurant(element);
        int pilihan;
        boolean y = true;
        res.daftarMenuMakanan();
        
        while(y){
            System.out.println("==================================");
            System.out.println("1. Menambahkan Daftar Makanan");
            System.out.println("2. Pesan Makanan");
            System.out.println("3. Menambah Stok Makanan");
            System.out.println("");
            System.out.print("Silahkan pilih pilihan diatas terlebih dahulu : " );
            pilihan = scan.nextInt();
            switch (pilihan){
                case 1:
                    res.inputMenambahMakanan();
                    break;
                case 2:
                    res.pesanMakanan();
                    break;
                case 3:
                    res.menambahStokMakanan();
                    break;
                default:
                    System.out.println("Tidak ada pilihan");
                    break;
            }
        }
    }
}
