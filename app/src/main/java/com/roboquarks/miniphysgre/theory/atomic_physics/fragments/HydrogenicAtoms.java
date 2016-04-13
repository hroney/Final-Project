package com.roboquarks.miniphysgre.theory.atomic_physics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 06.04.2016.
 */
public class HydrogenicAtoms extends Fragment
{
    public HydrogenicAtoms()
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
