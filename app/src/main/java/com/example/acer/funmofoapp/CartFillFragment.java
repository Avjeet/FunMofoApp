package com.example.acer.funmofoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.acer.funmofoapp.Adapters.WishlistViewItemAdapter;
import com.example.acer.funmofoapp.Data.CartProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFillFragment extends BaseFragment {
    private RecyclerView rvCart;
    private ArrayList<CartProduct> list;
    private WishlistViewItemAdapter cartAdapter;
    private Button btnproceed;

    public CartFillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_fill, container, false);
        rvCart= (RecyclerView) view.findViewById(R.id.rvCart);
        btnproceed=(Button)view.findViewById(R.id.btn_proceed);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=new ArrayList<>();


        list.add(new CartProduct(R.drawable.pic10,
                "Skore","Rs. 80"));
        list.add(new CartProduct(R.drawable.pic2,
                "Manforce","Rs. 90"));

        cartAdapter=new WishlistViewItemAdapter(list,"cart");
        rvCart.setAdapter(cartAdapter);
        rvCart.setLayoutManager(new LinearLayoutManager(getActivity()));

        btnproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager mgr=getActivity().getSupportFragmentManager();
                FragmentTransaction trans=mgr.beginTransaction();
                trans.replace(R.id.fragment,new CheckoutFragment());
                trans.commit();
            }
        });
    }

    @Override
    public boolean onBackPressed() {
//        Intent i1=new Intent(getContext(),MainActivity.class);
//        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(i1);
        return false;
    }

}
