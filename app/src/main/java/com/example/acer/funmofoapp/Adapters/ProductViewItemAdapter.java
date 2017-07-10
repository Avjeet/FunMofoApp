package com.example.acer.funmofoapp.Adapters;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Product;
import com.example.acer.funmofoapp.R;

import java.util.List;

/**
 * Created by AVJEET on 08-07-2017.
 */

public class ProductViewItemAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Product> itemList;
    private String tag;
    private View itemView;

    public ProductViewItemAdapter(List<Product> list,String tag){
        this.itemList=list;
        this.tag= tag;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(tag=="recent"){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recently_viewed_item,parent,false);
        }else{
            itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.top_product_list_item,parent,false);
        }

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameTextView.setText(itemList.get(position).getProductName());
        holder.priceTextView.setText(itemList.get(position).getPrice());
        holder.productImageView.setImageResource(itemList.get(position).getImageID());
        if(itemList.get(position).getOldPrice()!=null){
            holder.oldPriceTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.oldPriceTextView.setText(itemList.get(position).getOldPrice());
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}

class MyViewHolder extends RecyclerView.ViewHolder{
    public ImageView productImageView;
    public TextView nameTextView,priceTextView,oldPriceTextView;


    public MyViewHolder(View itemView) {
        super(itemView);
        this.productImageView=(ImageView)itemView.findViewById(R.id.product_img);
        this.nameTextView=(TextView) itemView.findViewById(R.id.product_name);
        this.priceTextView=(TextView) itemView.findViewById(R.id.product_price);
        this.oldPriceTextView=(TextView) itemView.findViewById(R.id.product_price_old);
    }
}
