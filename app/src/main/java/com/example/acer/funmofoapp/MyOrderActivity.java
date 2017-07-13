package com.example.acer.funmofoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.acer.funmofoapp.Adapters.DeliveredOrderItemAdapter;
import com.example.acer.funmofoapp.Adapters.OngoingOrderItemAdapter;
import com.example.acer.funmofoapp.Data.Item1;
import com.example.acer.funmofoapp.Data.Item2;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView rv_ongoing_orders,rv_delivered_orders;
    private ArrayList<Item1> ilist;
    private ArrayList<Item2> ilist1;
    private OngoingOrderItemAdapter ongoingadapter;
    private DeliveredOrderItemAdapter deliveradapter;
    private ImageView ivback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        rv_ongoing_orders=(RecyclerView)findViewById(R.id.recycler_ongoing_orders);
        rv_delivered_orders=(RecyclerView)findViewById(R.id.recycler_delivered_orders);
        ivback=(ImageView)findViewById(R.id.iv_back4);

        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MyOrderActivity.this,MainActivity.class);
                i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i1);
                finish();
            }
        });

        ilist = new ArrayList<>();
        ilist.add(new Item1("Placed On: 6 July,2017","Order Id:193739872900","Durex","Rs. 120",
                "Expected Delivery Time : 20 mins", R.drawable.pic1));
        ilist.add(new Item1("Placed On: 6 July,2017","Order Id:193704842900","Skore","Rs. 100",
                "Expected Delivery Time : 15 mins",R.drawable.pic10));

        ilist1=new ArrayList<>();
        ilist1.add(new Item2("Placed On: 20 June,2017","Order Id:1345739872900","My.Size","Rs. 110",
                R.drawable.pic8));
        ilist1.add(new Item2("Placed On: 10 May,2017","Order Id:189704842900","Skins","Rs. 90",
                R.drawable.pic6));

        ongoingadapter=new OngoingOrderItemAdapter(ilist);
        rv_ongoing_orders.setAdapter(ongoingadapter);
        rv_ongoing_orders.setLayoutManager(new LinearLayoutManager(this));

        deliveradapter=new DeliveredOrderItemAdapter(ilist1);
        rv_delivered_orders.setAdapter(deliveradapter);
        rv_delivered_orders.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i1=new Intent(MyOrderActivity.this,MainActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i1);
        finish();
    }
}
