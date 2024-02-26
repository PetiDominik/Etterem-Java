
package etterem;

import java.io.IOException;


public class EtteremCUI {
    public static void main(String[] args) throws IOException {
        Restaurant restaurant = new Restaurant();
        
        restaurant.loadMenuItems();
        restaurant.loadTables();
        
        System.out.println(restaurant.toString(30));
    }
}
