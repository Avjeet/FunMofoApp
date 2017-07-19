package com.example.acer.funmofoapp;

import android.support.v4.app.Fragment;

/**
 * Created by ACER on 19-Jul-17.
 */

public class BaseFragment extends Fragment {
    /**
     * Could handle back press.
     * @return true if back press was handled
     */
    public boolean onBackPressed() {
        return false;
    }
}