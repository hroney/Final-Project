package com.roboquarks.miniphysgre.theory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 08.04.2016.
 */
public class FormulasMenuAbout extends Fragment
{
    TextView textView;

    public FormulasMenuAbout()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.menu_formulas, container,
                false);

        textView = (TextView)rootView.findViewById(R.id.formulas_menu_textView);
        textView.setText("here I'm writing this poem to you because...Well, I don't know why, but it is awesome...Bla-bla-bla");
        return rootView;
    }
}
