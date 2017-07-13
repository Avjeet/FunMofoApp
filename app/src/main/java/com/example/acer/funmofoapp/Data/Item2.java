package com.example.acer.funmofoapp.Data;

import com.example.acer.funmofoapp.R;

import java.util.ArrayList;
import java.util.List;

public class Item2 {

    private String tvorderdate1,tvorderid1,tvproductname1,tvprice1;
    private int image1;

    public Item2(String tvorderdate1, String tvorderid1, String tvproductname1, String tvprice1, int image1)
    {
        this.tvorderdate1=tvorderdate1;
        this.tvorderid1=tvorderid1;
        this.tvproductname1=tvproductname1;
        this.tvprice1=tvprice1;
        this.image1=image1;
    }

    public String getTvorderdate1() {
        return tvorderdate1;
    }

    public String getTvorderid1() {
        return tvorderid1;
    }

    public String getTvproductname1() {
        return tvproductname1;
    }

    public String getTvprice1() {
        return tvprice1;
    }

    public int getImage1() {
        return image1;
    }

    public void setTvorderdate1(String tvorderdate1) {
        this.tvorderdate1=tvorderdate1;
    }

    public void setTvorderid1(String tvorderid1) {
        this.tvorderid1=tvorderid1;
    }

    public void setTvproductname1(String tvproductname1) {
        this.tvproductname1=tvproductname1;
    }

    public void setTvprice1(String tvprice1) {
        this.tvprice1=tvprice1;
    }

    public void setImage1(int image1) {
        this.image1=image1;
    }



}
