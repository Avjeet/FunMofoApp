package com.example.acer.funmofoapp.Data;

/**
 * Created by AVJEET on 08-07-2017.
 */

public class Product {
    private int imageID;
    private String productName;
    private String price;
    private String oldPrice;

    public Product(int imageID,String name,String price,String oldPrice){
        this.imageID=imageID;
        this.productName=name;
        this.price=price;
        this.oldPrice=oldPrice;
    }
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }
}
