package com.roboquarks.miniphysgre.mechanics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 02.04.2016.
 */
public class NewtonianMechanics extends Fragment
{
    public NewtonianMechanics()
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
