/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etterem;

import java.util.Objects;

/**
 *
 * A food for the menu.
 */
public class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this("%s|%d".formatted(name, price));
    }
    
    public MenuItem(String data) {
        String[] datas = data.split("\\|");
        this.name = datas[0];
        this.price = Integer.parseInt(datas[1]);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "%s|%d".formatted(this.name, this.price);
    }
    
    public String toString(int width) {
        String txt = "%s%" + (width - this.name.length() - 3) + "d Ft";
        return txt.formatted(this.name, this.price);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.price;
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
        final MenuItem other = (MenuItem) obj;
        if (this.price != other.price) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
    
}
