package com.example.acer.funmofoapp.Data;

/**
 * Created by ACER on 15-Jul-17.
 */

public class Pr1 {
    public static final int card1=0;
    public static final int card2=1;
    private int imageID;
    private String productName,price;
    private int type;


    public Pr1(int imageID, String productName, String price, int type) {

        this.imageID = imageID;
        this.productName = productName;
        this.price = price;
        this.type=type;

    }
    public void setType(int type) {
        this.type = type;
    }

    public int getType() {

        return type;
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
