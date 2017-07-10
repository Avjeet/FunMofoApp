package com.example.acer.funmofoapp;

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

    public static List<Item2> getList() {
        List<Item2> ilist = new ArrayList<>();
        ilist.add(new Item2("Placed On: 20 June,2017","Order Id:1345739872900","My.Size","Rs. 110",
                             R.drawable.pic8));
        ilist.add(new Item2("Placed On: 10 May,2017","Order Id:189704842900","Skins","Rs. 90",
                            R.drawable.pic6));
        return ilist;
    }
}
