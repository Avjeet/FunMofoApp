package com.example.acer.funmofoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {
    private Button btnAdd;


    public WishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        // Inflate the layout for this fragment
        btnAdd= (Button) view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mgr=getActivity().getSupportFragmentManager();
                FragmentTransaction trans=mgr.beginTransaction();
                trans.replace(R.id.fragment,new HomeFragment());
                trans.commit();
            }
        });
        return view;
    }

}
