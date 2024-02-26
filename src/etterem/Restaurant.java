
package etterem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


public class Restaurant {
    private ArrayList<Table> tables;
    private Menu menu;

    public Restaurant() {
        this(new ArrayList<>(), new Menu());
    }
    
    public Restaurant(ArrayList<Table> tables, Menu menu) {
        this.tables = tables;
        this.menu = menu;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public Menu getMenu() {
        return menu;
    }
    
    public boolean addTable(Table table) {
        if (this.tables.isEmpty() || !this.tables.contains(table)) {
            this.tables.add(table);
            return true;
        }
        return false;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public Optional<Table> getTableByName(String name) {
        name = name.toLowerCase();
        int i = 0;
        while(i < this.tables.size() && !this.tables.get(i).getTableName().toLowerCase().equals(name)) {
            i++;
        }
        
        return i >= this.tables.size() ? Optional.empty() : Optional.of(this.tables.get(i));
    }

    public void loadMenuItems() throws IOException {
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of("etelek.txt"));
        
        for (String line : lines) {
            this.menu.addMenuItem(new MenuItem(line));
        }
    }
    
    public void loadTables() throws IOException {
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of("rendeles.txt"));
        Table table = null;
        int headerCounter = 0;
        
        for (String line : lines) {
            line = line.strip();
            if (headerCounter++ == 0) {
                table = new Table(line);
            } else if (line.isBlank()) {
                this.addTable(table);
                headerCounter = 0;
            } else {
                Optional<MenuItem> menuItem = this.menu.getMenuItemByName(line);
                if (menuItem.isPresent()) {
                    table.addToOrder(menuItem.get());
                }
            }
            
        }
    }
    
    @Override
    public String toString() {
        return "Restaurant{" + "tables=" + tables + ", menu=" + menu + '}';
    }
    
    public String toString(int width) {
        String txt = "";
        for (Table table : this.tables) {
            txt += table.toString(width) + System.lineSeparator();
        }
        return txt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.tables);
        hash = 67 * hash + Objects.hashCode(this.menu);
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
        final Restaurant other = (Restaurant) obj;
        if (!Objects.equals(this.tables, other.tables)) {
            return false;
        }
        return Objects.equals(this.menu, other.menu);
    }
    
    
    
}
