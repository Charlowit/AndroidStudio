package com.cescristorey.caculadorapracticadesdecero.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cescristorey.caculadorapracticadesdecero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_cientifica extends Fragment {


    public fragment_cientifica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment_cientifica, container, false);
    }

}
