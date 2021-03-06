package com.roboquarks.miniphysgre.theory.quantum_mechanics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
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

        btnNextPage = (Button) rootView.findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button) rootView.findViewById(R.id.btnPreviousPage);
        /** Reference to the WebView view in the main_activity*/
        webView = (WebView) rootView.findViewById(R.id.web_view_from_container);

        /** WebViews don't allow JavaScript by default.
         * To run a web application in the web view, you
         * need to explicitly enable JavaScript by adding
         * the following lines to the onCreate method: */

        /** Enable Javascript */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/mathscribe/QuantumRelations.html");

        return rootView;
    }

}
