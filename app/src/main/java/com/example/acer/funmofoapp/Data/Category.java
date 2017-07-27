package com.example.acer.funmofoapp.Data;

/**
 * Created by ACER on 25-Jul-17.
 */

public class Category {
    private int image;
    private String name;

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {

        return image;
    }

    public String getName() {
        return name;
    }

    public Category(int image, String name) {

        this.image = image;
        this.name = name;
    }
}
