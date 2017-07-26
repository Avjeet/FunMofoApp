package com.example.acer.funmofoapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.WishlistViewItemAdapter;
import com.example.acer.funmofoapp.Data.CartProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private ArrayList<CartProduct> list, list2, list3;
    private WishlistViewItemAdapter adapter1, adapter2, adapter3;
    private RecyclerView rv1, rv2, rv3;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        rv1= (RecyclerView) view.findViewById(R.id.rll1);
        rv2= (RecyclerView) view.findViewById(R.id.rll2);
        rv3= (RecyclerView) view.findViewById(R.id.rll3);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=new ArrayList<>();
        list.add(new CartProduct(R.drawable.pic1,
                "Durex","Rs. 60"));
        list.add(new CartProduct(R.drawable.pic10,
                "Skore","Rs. 80"));
        list.add(new CartProduct(R.drawable.pic2,
                "Manforce","Rs. 90"));
        list.add(new CartProduct(R.drawable.pic4,
                "Assorted","Rs. 90"));
        list.add(new CartProduct(R.drawable.pic6,
                "Manforce","Rs. 70"));
        list.add(new CartProduct(R.drawable.pic7,
                "Skins","Rs. 90"));


        adapter1=new WishlistViewItemAdapter(list,"category");
        rv1.setAdapter(adapter1);
        rv1.setLayoutManager(new GridLayoutManager(getActivity(),3));



        list2=new ArrayList<>();
        list2.add(new CartProduct(R.drawable.spic1,
                "Petals","Rs. 60"));
        list2.add(new CartProduct(R.drawable.spic2,
                "Stayfree","Rs. 80"));
        list2.add(new CartProduct(R.drawable.spic3,
                "Hello Kity","Rs. 90"));
        adapter2=new WishlistViewItemAdapter(list2,"category2");
        rv2.setAdapter(adapter2);
        rv2.setLayoutManager(new GridLayoutManager(getActivity(),3));



        list3=new ArrayList<>();
        list3.add(new CartProduct(R.drawable.apic1,
                "Lifeboy","Rs. 60"));
        list3.add(new CartProduct(R.drawable.apic2,
                "Purell","Rs. 80"));
        list3.add(new CartProduct(R.drawable.apic3,
                "Cleanup","Rs. 90"));
        adapter3=new WishlistViewItemAdapter(list3,"category3");
        rv3.setAdapter(adapter3);
        rv3.setLayoutManager(new GridLayoutManager(getActivity(),3));






    }
}
