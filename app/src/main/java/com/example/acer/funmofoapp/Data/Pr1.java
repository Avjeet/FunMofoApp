package com.example.acer.funmofoapp.Data;


public class Pr1 {
    public static final int card1=0;
    public static final int card2=1;
    private int imageID;
    private String productName,price;

    public Pr1(int imageID, String productName, String price) {

        this.imageID = imageID;
        this.productName = productName;
        this.price = price;


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

    public int getImageID() {

        return imageID;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

}
