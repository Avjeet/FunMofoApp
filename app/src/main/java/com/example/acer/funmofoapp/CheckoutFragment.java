package com.example.acer.funmofoapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.CheckoutItemAdapter;
import com.example.acer.funmofoapp.Data.CartProduct;
import com.example.acer.funmofoapp.Data.Product;

import java.util.ArrayList;

public class CheckoutFragment extends Fragment {

    private ArrayList<CartProduct> list;
    private CheckoutItemAdapter adapter;
    private RecyclerView rvcheckout;

    public CheckoutFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);
        rvcheckout=(RecyclerView)view.findViewById(R.id.rvCheckout);
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

        
        adapter=new CheckoutItemAdapter(list);
        rvcheckout.setAdapter(adapter);
        rvcheckout.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }
}
