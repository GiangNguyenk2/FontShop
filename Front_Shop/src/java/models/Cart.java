/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Cart {

    private List<Item> items;

    public Cart() {
    }

    public Cart(List<Item> items) {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSize() {
        return items.size();
    }

    public int getQuantityById(int id,int colorID,int sizeID) {
        return getItemById(id,colorID,sizeID).getQuantity();
    }

    private Item getItemById(int id,int colorID,int sizeID) {
        for (Item i : items) {
            if (i.getProduct().getProID() == id && i.getColorID()==colorID && i.getSizeID()==sizeID) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t) {
        Item tt = getItemById(t.getProduct().getProID(), t.getColorID(), t.getSizeID());

        if (tt != null ) {
            Item m = getItemById(t.getProduct().getProID(), t.getColorID(), t.getSizeID());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id,int colorID,int sizeID ) {
        if (getItemById(id,colorID,sizeID) != null) {
            items.remove(getItemById(id,colorID,sizeID));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    public Cart(String txt) {
        items = new ArrayList<>();
        ProductDAO pdb = new ProductDAO();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("#");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int colorId = Integer.parseInt(n[1]);
                    int sizeId = Integer.parseInt(n[2]);
                    int quantity = Integer.parseInt(n[3]);
                    Product p = pdb.getProductByID(id);
                    Item t = new Item(p, colorId, sizeId, quantity, p.getProPrice());
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String txt = "1:1:1:1#1:2:3:1#1:1:1:1#1:1:1:1#1:1:1:1#1:1:1:1#5:9:2:1#5:9:1:1#5:9:3:1#5:9:4:1#5:4:2:1#5:4:1:1#5:4:4:1#31:1:2:1#31:1:3:1#31:1:4:1";
        Cart c = new Cart(txt);
        List<Item> li = c.getItems();
        for(Item i : li){
            System.out.println(i.getProduct().getProID() + "-" + i.getColorID() + "-" + i.getSizeID());
        }
        
    }
}
