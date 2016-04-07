package com.roboquarks.miniphysgre.mechanics;

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
import com.roboquarks.miniphysgre.mechanics.fragments.HamiltonianMechanics;
import com.roboquarks.miniphysgre.mechanics.fragments.LagrangianMechanics;
import com.roboquarks.miniphysgre.mechanics.fragments.NewtonianMechanics;

/**
 * Created by Hroney on 31.03.2016.
 */
public class Mechanics extends AppCompatActivity
{
    /**
     * the id of the fragment in the listview
     */
    int position_id;
    /**
     * Identifying important variables for operations with an .xml
     */
    WebView webView;
    Button btnBackMechanics;
    FrameLayout frameLayout;
    /**
     * Defining the fragment and the fragment manager
     */
    Fragment fragment;
    FragmentManager fragmentManager;
    /**
     * Defining the listView and Adapter to list variables
     */
    ListView listView;
    ArrayAdapter<String> adapter;
    /**
     * Names of the chapters (groups)
     */
    String[] chapters = {"Newtonian Mechanics" , "Lagrangian Mechanics", "Hamiltonian Mechanics"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas_mechanics);

        /** Finding view from activities by their id */
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
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

    /** Beginning of the custom methods */
    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        /** updating the main content by replacing the fragments */
        switch (position) {
            case 0:
                fragment = new NewtonianMechanics();
                break;
            case 1:
                fragment = new LagrangianMechanics();
                break;
            case 2:
                fragment = new HamiltonianMechanics();
                break;
            default:
                break;
        }

        position_id = position + 1;/** i'm not sure, but, may be, I nd to put here position_id = position + 1 ?*/

        /** Changing the visibility of our container,
         * Back Button and List with chapters */
        frameLayout.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        /** Initialising the fragment manager */
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

    }

    /**
     * Custom clickListener for  listView
     */
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /**
     * Main custom method
     */
    private void Init() {
        /** Finding the ListView */
        listView = (ListView) findViewById(R.id.mechanics_listView);

        /** Creating the adapter */
        adapter = new ArrayAdapter<String>(this, R.layout.part_of_list, chapters);
        listView.setAdapter(adapter);
        /** Set the list's click listener */
        listView.setOnItemClickListener(new ListItemClickListener());


        /** android.R.layout.simple_list_item_1 - it is the system layout-file, which is similar to TextView */
    }

    /**
     * Methods for switching between fragments
     */
    public void toPreviousPage(View view) {
        /** adopting the id of the fragment's position */
        position_id = position_id - 1;

        if (position_id == 0) {
            /** Changing the visibility of our container,
             * Back Button and List with chapters */
            frameLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        } else if (position_id == 1) {
            fragment = new NewtonianMechanics();
        } else if (position_id == 2) {
            fragment = new LagrangianMechanics();
        } else if (position_id == 3) {
            fragment = new HamiltonianMechanics();
        }
    }

    public void toNextPage(View view) {
        if (position_id == 0) {
            fragment = new NewtonianMechanics();
        } else if (position_id == 1) {
            fragment = new LagrangianMechanics();
        } else if (position_id == 2) {
            fragment = new HamiltonianMechanics();
        } else if (position_id == 3) {
            /** Changing the visibility of our container,
             * Back Button and List with chapters */
            frameLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
        /** adopting the id of the fragment's position */
        position_id = position_id + 1;
    }
    /** The end of custom Methods */
}
