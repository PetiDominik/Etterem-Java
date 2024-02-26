
package etterem;

import java.util.ArrayList;
import java.util.Objects;


public class Table {
    private String tableName;
    private ArrayList<MenuItem> orders;

    public Table(String tableName) {
        this.tableName = tableName;
        this.orders = new ArrayList<>();
    }
    
    public String getTableName() {
        return this.tableName;
    }

    public ArrayList<MenuItem> getOrders() {
        return orders;
    }
    
    public void addToOrder(MenuItem menuItem) {
        if (this.orders.isEmpty() || !this.orders.contains(menuItem)) {
            this.orders.add(menuItem);
        }
    }
    
    public int getPriceSum() {
        int sum = 0;
        
        for (MenuItem order : this.orders) {
            sum += order.getPrice();
        }
        return sum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.tableName);
        hash = 29 * hash + Objects.hashCode(this.orders);
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
        final Table other = (Table) obj;
        if (!Objects.equals(this.tableName, other.tableName)) {
            return false;
        }
        return Objects.equals(this.orders, other.orders);
    }

    @Override
    public String toString() {
        return "Table{" + "tableName=" + tableName + ", orders=" + orders + '}';
    }
    
    public String toString(int width) {
        String sep = System.lineSeparator();
        String txt = this.tableName + sep;
        txt += this.lineFrom('-', width) + sep;
        for (MenuItem order : this.orders) {
            txt += order.toString(width) + sep;
        }
        txt += this.lineFrom('=', width) + sep;
        String subTxt = "Összesen:%" + (width - 12) + "d Ft";
        txt += subTxt.formatted(this.getPriceSum()) + sep;
        return txt;
    }
    
    public String lineFrom(char character, int width) {
        String txt = "";
        for (int i = 0; i < width; i++) {
            txt += character;
        }
        return txt;
    }
    
}
