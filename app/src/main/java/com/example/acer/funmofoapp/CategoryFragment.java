package com.example.acer.funmofoapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.CategoryAdapter;
import com.example.acer.funmofoapp.Data.Category;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private ArrayList<Category> list, list2, list3;
    private CategoryAdapter adapter1, adapter2, adapter3;
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
        list.add(new Category(R.drawable.pic1,
                "Durex"));
        list.add(new Category(R.drawable.pic10,
                "Skore"));
        list.add(new Category(R.drawable.pic2,
                "Manforce"));
        list.add(new Category(R.drawable.pic4,
                "Assorted"));
        list.add(new Category(R.drawable.pic6,
                "Manforce"));
        list.add(new Category(R.drawable.pic7,
                "Skins"));


        adapter1=new CategoryAdapter(list,"category");
        rv1.setAdapter(adapter1);
        rv1.setLayoutManager(new GridLayoutManager(getActivity(),3));



        list2=new ArrayList<>();
        list2.add(new Category(R.drawable.spic1,
                "Petals"));
        list2.add(new Category(R.drawable.spic2,
                "Stayfree"));
        list2.add(new Category(R.drawable.spic3,
                "Hello Kity"));
        adapter2=new CategoryAdapter(list2,"category2");
        rv2.setAdapter(adapter2);
        rv2.setLayoutManager(new GridLayoutManager(getActivity(),3));



        list3=new ArrayList<>();
        list3.add(new Category(R.drawable.apic1,
                "Lifeboy"));
        list3.add(new Category(R.drawable.apic2,
                "Purell"));
        list3.add(new Category(R.drawable.apic3,
                "Cleanup"));
        adapter3=new CategoryAdapter(list3,"category3");
        rv3.setAdapter(adapter3);
        rv3.setLayoutManager(new GridLayoutManager(getActivity(),3));






    }
}
