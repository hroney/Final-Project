package com.roboquarks.miniphysgre.quantum_mechanics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 01.04.2016.
 */
public class QuantumRelations extends Fragment
{
    WebView webView;
    Fragment fragment;
    Button btnNextPage, btnPreviousPage;

    public QuantumRelations()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.container, container,
                false);

        return rootView;
    }

}
