package com.roboquarks.miniphysgre.theory.mathematics.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.roboquarks.miniphysgre.R;

/**
 * Created by Hroney on 02.04.2016.
 */
public class CoordinateSystems extends Fragment
{
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.gre_formulas_container, container,
                false);


        /** Reference to the WebView view in the main_activity*/
        webView = (WebView) rootView.findViewById(R.id.web_view_container);

        /** WebViews don't allow JavaScript by default.
         * To run a web application in the web view, you
         * need to explicitly enable JavaScript by adding
         * the following lines to the onCreate method: */

        /** Enable Javascript */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/mathscribe/mathematics_coordinate_systems.html");


        // Force links and redirects to open in the WebView instead of in a browser
        //webView.setWebViewClient(new WebViewClient());
        return rootView;
    }
}
