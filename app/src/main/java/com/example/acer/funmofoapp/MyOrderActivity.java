package com.example.acer.funmofoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView rv_ongoing_orders,rv_delivered_orders;
    private List<Item1> ilist;
    private List<Item2> ilist1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        rv_ongoing_orders=(RecyclerView)findViewById(R.id.recycler_ongoing_orders);
        rv_delivered_orders=(RecyclerView)findViewById(R.id.recycler_delivered_orders);

        ilist=Item1.getList();
        ilist1=Item2.getList();

        rv_ongoing_orders.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View myview=getLayoutInflater().inflate(R.layout.list_item1,parent,false);
                ItemViewHolder1 viewHolder=new ItemViewHolder1(myview);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ItemViewHolder1 viewHolder= (ItemViewHolder1) holder;
                viewHolder.tvorderdate.setText(String.valueOf(ilist.get(position).getTvorderdate()));
                viewHolder.tvorderid.setText(String.valueOf(ilist.get(position).getTvorderid()));
                viewHolder.tvproductname.setText(String.valueOf(ilist.get(position).getTvproductname()));
                viewHolder.tvexpectedtime.setText(String.valueOf(ilist.get(position).getTvexpectedtime()));
                viewHolder.tvprice.setText(String.valueOf(ilist.get(position).getTvprice()));
                viewHolder.image.setImageResource(ilist.get(position).getImage());
            }

            @Override
            public int getItemCount() {
                return ilist.size();
            }
        });
        rv_ongoing_orders.setLayoutManager(new LinearLayoutManager(this));


        rv_delivered_orders.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View myview=getLayoutInflater().inflate(R.layout.list_item2,parent,false);
                ItemViewHolder2 viewHolder=new ItemViewHolder2(myview);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ItemViewHolder2 viewHolder= (ItemViewHolder2) holder;
                viewHolder.tvorderdate1.setText(String.valueOf(ilist1.get(position).getTvorderdate1()));
                viewHolder.tvorderid1.setText(String.valueOf(ilist1.get(position).getTvorderid1()));
                viewHolder.tvproductname1.setText(String.valueOf(ilist1.get(position).getTvproductname1()));
                viewHolder.tvprice1.setText(String.valueOf(ilist1.get(position).getTvprice1()));
                viewHolder.image1.setImageResource(ilist1.get(position).getImage1());
            }

            @Override
            public int getItemCount() {
                return ilist1.size();
            }
        });
        rv_delivered_orders.setLayoutManager(new LinearLayoutManager(this));
    }
}
