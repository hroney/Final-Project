package com.roboquarks.miniphysgre.mathematics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 02.04.2016.
 */
public class DifferentialEquations extends Fragment
{
    public DifferentialEquations()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.container, container,
                false);

        return rootView;
    }
}
