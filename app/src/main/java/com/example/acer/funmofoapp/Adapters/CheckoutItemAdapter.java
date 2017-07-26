package com.example.acer.funmofoapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.CartProduct;
import com.example.acer.funmofoapp.Data.Product;
import com.example.acer.funmofoapp.R;

import java.util.List;

public class CheckoutItemAdapter extends RecyclerView.Adapter<CheckoutItemAdapter.ItemViewHolder> {

    private View myview;
    List<CartProduct> checkoutlist;

    public CheckoutItemAdapter(List<CartProduct> checkoutlist)
    {
        this.checkoutlist=checkoutlist;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_item,parent,false);
        return new ItemViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.productimage.setImageResource(checkoutlist.get(position).getImageID());
        holder.tvname.setText(checkoutlist.get(position).getProductName());
        holder.tvprice.setText(checkoutlist.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return checkoutlist.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView productimage;
        public TextView tvname,tvprice;

        public ItemViewHolder(View itemView) {
            super(itemView);

            productimage=(ImageView)itemView.findViewById(R.id.product_image);
            tvname=(TextView)itemView.findViewById(R.id.product_checkout_name);
            tvprice=(TextView)itemView.findViewById(R.id.product_checkout_price);
        }
    }
}
