package com.example.acer.funmofoapp.Data;

public class CartProduct {
    private int imageID, imPlus, imMinus, imClose;
    private String productName;
    private String price;


    public CartProduct(int imageID, int imPlus, int imMinus, int imClose, String productName, String price) {
        this.imageID = imageID;
        this.imPlus = imPlus;
        this.imMinus = imMinus;
        this.imClose = imClose;
        this.productName = productName;
        this.price = price;

    }

    public int getImageID() {
        return imageID;
    }

    public int getImPlus() {
        return imPlus;
    }

    public int getImMinus() {
        return imMinus;
    }

    public int getImClose() {
        return imClose;
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

    public void setImPlus(int imPlus) {
        this.imPlus = imPlus;
    }

    public void setImMinus(int imMinus) {
        this.imMinus = imMinus;
    }

    public void setImClose(int imClose) {
        this.imClose = imClose;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}