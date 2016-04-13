package com.roboquarks.miniphysgre.theory.mathematics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.roboquarks.miniphysgre.R;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.ComplexVariables;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.CoordinateSystems;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.DifferentialEquations;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.PerimeterAreaVolume;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.PowerSeries;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.ProbabilityAndStatistics;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.ProgressionsAndSummations;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.RandomWalk;
import com.roboquarks.miniphysgre.theory.mathematics.fragments.VectorIntegralTransformations;

/**
 * Created by Hroney on 01.04.2016.
 */
public class MathematicsTest extends AppCompatActivity {
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
    WebViewFragment webViewFragment;
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
    String[] chapters = {"Coordinate Systems", "Vector Integral Transformations", "Progressions and Summations", "Complex Variables", "Probability and Statistics",
            "Differential Equations", "Power Series", "Perimeter, Area and Volume", "Random Walk"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas_list);

        /** Finding view from activities by their id */
        /*btnNextPage = (Button) findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button) findViewById(R.id.btnPreviousPage);*/
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        //webView = (WebView) findViewById(R.id.web_view_from_container);

        /** for fragments */
        //fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().add(R.id.content_frame, fragment).commit();

        /** Setting the background color for buttons */
        /*btnPreviousPage.setBackgroundColor(Color.BLUE);
        btnNextPage.setBackgroundColor(Color.BLUE);
        btnPreviousPage.setTextColor(Color.WHITE);
        btnNextPage.setTextColor(Color.WHITE);*/
        /** WebViews don't allow JavaScript by default.
         * To run a web application in the web view, you
         * need to explicitly enable JavaScript by adding
         * the following lines to the onCreate method: */

        /** Enable Javascript */
        //WebSettings webSettings = webView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        //webSettings.setBuiltInZoomControls(true);
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
                fragment = new CoordinateSystems();
                //webView.loadUrl("file:///android_asset/mathscribe/mathematics_coordinate_systems.html");
                //btnPreviousPage.setText("To contents");
                //btnNextPage.setText("Next");
                break;
            case 1:
                fragment = new VectorIntegralTransformations();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_vector_integral_transformations.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 2:
                fragment = new ProgressionsAndSummations();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_progressions_summations.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 3:
                fragment = new ComplexVariables();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_complex_variables.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 4:
                fragment = new ProbabilityAndStatistics();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_probability_statistics.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 5:
                fragment = new DifferentialEquations();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_differential_equations.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 6:
                fragment = new PowerSeries();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_power_series.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 7:
                fragment = new PerimeterAreaVolume();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_perimeter_area_volume.html");
                btnPreviousPage.setText("Previous");
                btnNextPage.setText("Next");
                break;
            case 8:
                fragment = new RandomWalk();
                webView.loadUrl("file:///android_asset/mathscribe/mathematics_random_walk.html");
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
        listView = (ListView) findViewById(R.id.gre_formulas_listView);

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
            fragment = new CoordinateSystems();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_coordinate_systems.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        } else if (position_id == 2) {
            fragment = new VectorIntegralTransformations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_vector_integral_transformations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 3) {
            fragment = new ProgressionsAndSummations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_progressions_summations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 4) {
            fragment = new ComplexVariables();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_complex_variables.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 5) {
            fragment = new ProbabilityAndStatistics();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_probability_statistics.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 6) {
            fragment = new DifferentialEquations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_differential_equations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 7) {
            fragment = new PowerSeries();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_power_series.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 8) {
            fragment = new PerimeterAreaVolume();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_perimeter_area_volume.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 9) {
            fragment = new RandomWalk();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_random_walk.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        }
    }

    public void toNextPage(View view) {
        if (position_id == 0) {
            fragment = new CoordinateSystems();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_coordinate_systems.html");
            btnPreviousPage.setText("To contents");
            btnNextPage.setText("Next");
        } else if (position_id == 1) {
            fragment = new VectorIntegralTransformations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_vector_integral_transformations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 2) {
            fragment = new ProgressionsAndSummations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_progressions_summations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 3) {
            fragment = new ComplexVariables();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_complex_variables.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 4) {
            fragment = new ProbabilityAndStatistics();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_probability_statistics.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 5) {
            fragment = new DifferentialEquations();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_differential_equations.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 6) {
            fragment = new PowerSeries();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_power_series.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 7) {
            fragment = new PerimeterAreaVolume();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_perimeter_area_volume.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("Next");
        } else if (position_id == 8) {
            fragment = new RandomWalk();
            webView.loadUrl("file:///android_asset/mathscribe/mathematics_random_walk.html");
            btnPreviousPage.setText("Previous");
            btnNextPage.setText("To contents");
        } else if (position_id == 9) {
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
