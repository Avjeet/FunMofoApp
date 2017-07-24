package com.example.acer.funmofoapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Product;
import com.example.acer.funmofoapp.PreviewActivity;
import com.example.acer.funmofoapp.R;

import java.util.List;

public class ProductViewItemAdapter extends RecyclerView.Adapter<ProductViewItemAdapter.MyViewHolder> {

    public List<Product> itemList;
    Product p;
    private String tag;
    private View itemView;
    private Context context;


    public ProductViewItemAdapter(List<Product> list,String tag){
        this.itemList=list;
        this.tag= tag;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView productImageView;
        public TextView nameTextView,priceTextView,oldPriceTextView;
        public LinearLayout itemLayout;
        private Product currentProduct;


        public MyViewHolder(final View itemView) {
            super(itemView);
            this.productImageView=(ImageView)itemView.findViewById(R.id.product_img);
            this.nameTextView=(TextView) itemView.findViewById(R.id.product_name);
            this.priceTextView=(TextView) itemView.findViewById(R.id.product_price);
            this.oldPriceTextView=(TextView) itemView.findViewById(R.id.product_price_old);
            this.itemLayout=(LinearLayout) itemView.findViewById(R.id.item_layout);

            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int currentPos = (int)view.getTag();
                    currentProduct=itemList.get(currentPos);

                    Intent detailActivityIntent = new Intent(context, PreviewActivity.class);
                    ActivityOptionsCompat optionCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,itemView.findViewById(R.id.product_img),"productImage");

                    Bundle data = new Bundle();
                    data.putString("name",currentProduct.getProductName());
                    data.putString("price",currentProduct.getPrice());
                    data.putString("old price",currentProduct.getOldPrice());
                    data.putInt("imageID",currentProduct.getImageID());
                    detailActivityIntent.putExtras(data);
                    context.startActivity(detailActivityIntent,optionCompat.toBundle());
//
//                    itemList.add(currentPos,p);
//                    notifyItemInserted(currentPos);
//                    notifyItemRangeChanged(currentPos,itemList.size());
//                    if (tag=="top")
//                    {
//                        itemList.add(0,p);
//                        notifyItemInserted(0);
//                        notifyItemRangeChanged(0,itemList.size());
//                    }

                }
            });
        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        if(tag=="recent"){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recently_viewed_item,parent,false);
        }else{
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_product_list_item,parent,false);

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



    /*    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag=="top")
                {
                    itemList.add(0,p);
                    notifyItemInserted(0);
                    notifyItemRangeChanged(0,itemList.size());
                }

            }
        });*/

        holder.itemLayout.setTag(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}


