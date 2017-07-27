package com.example.acer.funmofoapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Category;
import com.example.acer.funmofoapp.R;

import java.util.List;

/**
 * Created by ACER on 25-Jul-17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    public List<Category> itemList;
    private String tag;
    private View itemView;

    public CategoryAdapter(List<Category> itemList, String tag) {
        this.itemList = itemList;
        this.tag=tag;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView categoryname;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.image= (ImageView) itemView.findViewById(R.id.category_image);
            this.categoryname= (TextView) itemView.findViewById(R.id.category_text);
        }
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageResource(itemList.get(position).getImage());
        holder.categoryname.setText(itemList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
