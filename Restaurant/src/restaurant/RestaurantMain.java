package restaurant;
public class RestaurantMain {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant();
        restaurant.tambahMenuMakanan("Gehu", 1000, 20);
        restaurant.tampilMenuMakanan();
        restaurant.mengurangiStokMakanan(0);
        restaurant.tampilMenuMakanan();
        restaurant.menambahkanStokMakanan(0, 100);
        restaurant.tampilMenuMakanan();
    }
}
