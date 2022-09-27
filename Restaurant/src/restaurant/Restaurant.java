package restaurant;

//import static restaurant.Restaurant.id;

public class Restaurant {
    Menu[] menu = new Menu[10];
    
    public void tambahMenuMakanan(String nama_makanan, double harga_makanan, int stok){
        byte id = Menu.getId();
        menu[id] = new Menu(nama_makanan,harga_makanan,stok); 
        Menu.nextId();
    }
    
    public void mengurangiStokMakanan(int pilih){
        menu[pilih] = new Menu(menu[pilih].getNama_makanan(),menu[pilih].getHarga_makanan(),menu[pilih].getStok() - 1);
    }
    
    public void menambahkanStokMakanan(int pilih, int stok){
         menu[pilih] = new Menu(menu[pilih].getNama_makanan(),menu[pilih].getHarga_makanan(),menu[pilih].getStok() + stok);
    }

    public boolean isOutOfStock(int id){
        if(menu[id].getStok() == 0){
            return true;
        } else{
            return false;
        }
    }
    
    public void tampilMenuMakanan(){
        for(int i = 0; i <= Menu.getId() - 1; i++){
            if(!isOutOfStock(i)){
                System.out.println(menu[i].getNama_makanan() + "[" + menu[i].getStok() + "]" + "\tRp. " + menu[i].getHarga_makanan());
            }
        }
    }
    
//    public void mengurangiStokMakanan(Menu menu, int stok){
//        this.menu[id].stok = menu.stok - stok;
//    }
//    
//    public void menambahkanStokMakanan(Menu menu, int stok){
//        this.menu[id].stok = menu.stok + stok;
//    }
//    

}
