package com.roboquarks.miniphysgre.quantum_mechanics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.roboquarks.miniphysgre.R;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.DiracNotation;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.HarmonicOscillator;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.Operators;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.PerturbationTheory;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.QuantumRelations;
import com.roboquarks.miniphysgre.quantum_mechanics.fragments.RelativisticWaveEquations;

/**
 * Created by Hroney on 31.03.2016.
 */
public class QuantumMechanics extends AppCompatActivity
{
    /** the id of the fragment in the listview*/
    int position_id;
    /** Identifying important variables for operations with an .xml */
    WebView webView;
    Button btnNextPage, btnPreviousPage;
    FrameLayout frameLayout;
    /** Defining the fragment and the fragment manager */
    Fragment fragment;
    FragmentManager fragmentManager;
    /** Defining the listView and Adapter to list variables */
    ListView listView;
    ArrayAdapter<String> adapter;
    /** Names of the chapters (groups) */
    String[] chapters = {"Quantum Uncertainty Relations" , "Operators, Wavefunctions and Expectation Value",
            "Dirac Notation", "Harmonic Oscillator", "Perturbation Theory", "Relativistic Wave Equations"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas_quantummechanics);

        /** Finding view from activities by their id */
        btnNextPage = (Button) findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button) findViewById(R.id.btnPreviousPage);
        frameLayout = (FrameLayout)findViewById(R.id.content_frame);
        webView = (WebView) findViewById(R.id.web_view_from_container);
        /** WebViews don't allow JavaScript by default.
         * To run a web application in the web view, you
         * need to explicitly enable JavaScript by adding
         * the following lines to the onCreate method: */

        /** Enable Javascript */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        /** Initialising custom method */
        Init();
    }

    /**Beginning of the custom methods*/
    /** Swaps fragments in the main content view */
    private void selectItem(int position)
    {
        /** updating the main content by replacing the fragments */
        switch(position)
        {
            case 0:
                fragment = new QuantumRelations();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_uncertainty_relations.html");
                btnPreviousPage.setText("To contents");
                btnNextPage.setText("Next");
                break;
            case 1:
                fragment = new Operators();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_operators.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 2:
                fragment = new DiracNotation();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_dirac_notation.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 3:
                fragment = new HarmonicOscillator();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_harmonic_oscillator.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 4:
                fragment = new PerturbationTheory();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_perturbation_theory.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 5:
                fragment = new RelativisticWaveEquations();
                webView.loadUrl("file:///android_asset/mathscribe/quantmech_relativistic_wave_equation.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("To contents");
                break;
            default:
                break;
        }

        position_id = position + 1;

        /** Changing the visibility of our container,
         * Back Button and List with chapters */
        frameLayout.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        /** Initialising the fragment manager */
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

    }

    /** Custom clickListener for  listView */
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /** Main custom method */
    private void Init()
    {
        /** Finding the ListView */
        listView = (ListView)findViewById(R.id.quantum_listView);

        /** Creating the adapter */
        adapter = new ArrayAdapter<String>(this, R.layout.part_of_list, chapters);
        listView.setAdapter(adapter);
        /** Set the list's click listener */
        listView.setOnItemClickListener(new ListItemClickListener());


        /** android.R.layout.simple_list_item_1 - it is the system layout-file, which is similar to TextView */
    }

    /** Methods for switching between fragments */
    public void toPreviousPage(View view)
    {
        /** adopting the id of the fragment's position */
        position_id = position_id - 1;

        if (position_id == 0)
        {
            /** Changing the visibility of our container,
             * Back Button and List with chapters */
            frameLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
        else if (position_id == 1)
        {
            fragment = new QuantumRelations();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_uncertainty_relations.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        }
        else if (position_id == 2) {
            fragment = new Operators();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_operators.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 3) {
            fragment = new DiracNotation();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_dirac_notation.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 4) {
            fragment = new HarmonicOscillator();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_harmonic_oscillator.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 5) {
            fragment = new PerturbationTheory();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_perturbation_theory.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 6) {
            fragment = new RelativisticWaveEquations();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_relativistic_wave_equation.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        }
    }

    public void toNextPage(View view)
    {
        if (position_id == 0)
        {
            fragment = new QuantumRelations();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_uncertainty_relations.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        }
        else if (position_id == 1)
        {
            fragment = new Operators();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_operators.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 2) {
            fragment = new DiracNotation();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_dirac_notation.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 3) {
            fragment = new HarmonicOscillator();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_harmonic_oscillator.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 4) {
            fragment = new PerturbationTheory();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_perturbation_theory.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        }
        else if (position_id == 5) {
            fragment = new RelativisticWaveEquations();
            webView.loadUrl("file:///android_asset/mathscribe/quantmech_relativistic_wave_equation.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        }
        else if (position_id == 6)
        {
            /** Changing the visibility of our container,
             * Back Button and List with chapters */
            frameLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
        /** adopting the id of the fragment's position */
        position_id = position_id + 1;
    }
    /** End of the custom methods */
}
