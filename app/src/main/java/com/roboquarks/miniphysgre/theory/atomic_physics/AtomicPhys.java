package com.roboquarks.miniphysgre.theory.atomic_physics;

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
import com.roboquarks.miniphysgre.theory.atomic_physics.fragments.AngularMomentum;
import com.roboquarks.miniphysgre.theory.atomic_physics.fragments.HydrogenicAtoms;
import com.roboquarks.miniphysgre.theory.atomic_physics.fragments.MagneticMoments;
import com.roboquarks.miniphysgre.theory.atomic_physics.fragments.NuclearPhysics;

/**
 * Created by Hroney on 06.04.2016.
 */
public class AtomicPhys extends AppCompatActivity {
    /**
     * the id of the fragment in the listview
     */
    int position_id;
    /**
     * Identifying important variables for operations with an .xml
     */
    WebView webView;
    Button btnNextPage, btnPreviousPage;
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
    String[] chapters = {"Hydrogenic Atoms", "Angular Momentum", "Magnetic moments", "High Energy and Nuclear Physics"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas_atomic_physics);

        /** Finding view from activities by their id */
        btnNextPage = (Button) findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button) findViewById(R.id.btnPreviousPage);
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

    /**Beginning of the custom methods*/
    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        /** updating the main content by replacing the fragments */
        switch (position) {
            case 0:
                fragment = new HydrogenicAtoms();
                webView.loadUrl("file:///android_asset/mathscribe/QuantumRelations.html");
                btnPreviousPage.setText("To contents");
                btnNextPage.setText("Next");
                break;
            case 1:
                fragment = new AngularMomentum();
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 2:
                fragment = new MagneticMoments();
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 3:
                fragment = new NuclearPhysics();
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
        listView = (ListView) findViewById(R.id.atomic_physics_listView);

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
            fragment = new HydrogenicAtoms();
            webView.loadUrl("file:///android_asset/mathscribe/QuantumRelations.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        } else if (position_id == 2) {
            fragment = new AngularMomentum();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 3) {
            fragment = new MagneticMoments();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 4) {
            fragment = new NuclearPhysics();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        }
    }

    public void toNextPage(View view) {
        if (position_id == 0) {
            fragment = new HydrogenicAtoms();
            webView.loadUrl("file:///android_asset/mathscribe/QuantumRelations.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        } else if (position_id == 1) {
            fragment = new AngularMomentum();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 2) {
            fragment = new MagneticMoments();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 3) {
            fragment = new NuclearPhysics();
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        } else if (position_id == 4) {
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

