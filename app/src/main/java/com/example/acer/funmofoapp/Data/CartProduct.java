package com.example.acer.funmofoapp.Data;

public class CartProduct {
    private int imageID;
    private String productName;
    private String price;


    public CartProduct(int imageID, String productName, String price) {
        this.imageID = imageID;
        this.productName = productName;
        this.price = price;

    }

    public int getImageID() {
        return imageID;
    }


    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }



    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}