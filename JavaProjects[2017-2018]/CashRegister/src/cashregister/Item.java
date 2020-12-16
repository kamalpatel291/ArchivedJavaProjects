/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author kamal
 */
public class Item {
    private String name;
    private double price,cPrice;
    private int qty;
    public Item(String name,double price){
        setPrice(price);
        setName(name);
        qty = 1;
        cPrice = price;
    }
    //don't call update price or will result in doubling the price-
    // due to updatePrice() method being called in updateQty() method.
    public void updateQty(){
        qty++;
        updatePrice();
    }
    public void updatePrice(){
       NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
       String fprice = nf.format(price+cPrice);
       fprice = fprice.replace("$", "");
       fprice = fprice.replaceAll(",","");
       price = Double.parseDouble(fprice);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getQty(){
        return qty;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}
