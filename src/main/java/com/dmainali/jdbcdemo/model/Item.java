package com.dmainali.jdbcdemo.model;

public class Item {

    int id;
    String itemName;
    String category;
    int quantity;
    Double price;

    public Item (){}

    public  Item ( int id, String itemName, String category, int quantity,Double price){
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Item ID: "+ id + "ItemName:" + itemName +"Quantity: " + quantity + "Price: " + price;
    }
}
