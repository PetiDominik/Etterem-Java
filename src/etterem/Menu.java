
package etterem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


public class Menu {
    private ArrayList<MenuItem> menu;
    
    public Menu() {
        this.menu = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }
    
    public boolean addMenuItem(MenuItem menuItem) {
        if (this.menu.isEmpty() || !this.menu.contains(menuItem)) {
            this.menu.add(menuItem);
            return true;
        }
        return false;
    }
    
    public Optional<MenuItem> getMenuItemByName(String name) {
        int i = 0;
        while(i < this.menu.size() && !this.menu.get(i).getName().equals(name)) {
            i++;
        }
        
        return i >= this.menu.size() ? Optional.empty() : Optional.of(this.menu.get(i));
    }

    @Override
    public String toString() {
        return "Menu{" + "menu=" + menu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.menu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        return Objects.equals(this.menu, other.menu);
    }
    
    
}
