package com.example.acer.funmofoapp;

import java.util.ArrayList;
import java.util.List;

public class Item1 {

    private String tvorderdate,tvorderid,tvproductname,tvexpectedtime,tvprice;
    private int image;

    public Item1(String tvorderdate,String tvorderid,String tvproductname,String tvprice,String tvexpectedtime,int image)
    {
        this.tvorderdate=tvorderdate;
        this.tvorderid=tvorderid;
        this.tvproductname=tvproductname;
        this.tvprice=tvprice;
        this.tvexpectedtime=tvexpectedtime;
        this.image=image;
    }

    public String getTvorderdate() {
        return tvorderdate;
    }

    public String getTvorderid() {
        return tvorderid;
    }

    public String getTvproductname() {
        return tvproductname;
    }

    public String getTvprice() {
        return tvprice;
    }
    public String getTvexpectedtime() {
        return tvexpectedtime;
    }


    public int getImage() {
        return image;
    }

    public void setTvorderdate(String tvorderdate) {
        this.tvorderdate=tvorderdate;
    }

    public void setTvorderid(String tvorderid) {
        this.tvorderid=tvorderid;
    }

    public void setTvproductname(String tvproductname) {
        this.tvproductname=tvproductname;
    }

    public void setTvprice(String tvprice) {
        this.tvprice=tvprice;
    }

    public void setTvexpectedtime(String tvexpectedtime) {
        this.tvexpectedtime=tvexpectedtime;
    }

    public void setImage(int image) {
        this.image=image;
    }

    public static List<Item1> getList() {
        List<Item1> ilist = new ArrayList<>();
        ilist.add(new Item1("Placed On: 6 July,2017","Order Id:193739872900","Durex","Rs. 120",
                            "Expected Delivery Time : 20 mins",R.drawable.pic1));
        ilist.add(new Item1("Placed On: 6 July,2017","Order Id:193704842900","Skore","Rs. 100",
                            "Expected Delivery Time : 15 mins",R.drawable.pic10));
        return ilist;
    }
}
