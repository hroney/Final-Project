package com.roboquarks.miniphysgre.theory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.roboquarks.miniphysgre.R;
import com.roboquarks.miniphysgre.theory.atomic_physics.AtomicPhys;
import com.roboquarks.miniphysgre.theory.electromagnetism.Electromagnetism;
import com.roboquarks.miniphysgre.theory.laboratory_methods.LaboratoryMethods;
import com.roboquarks.miniphysgre.theory.mathematics.Mathematics;
import com.roboquarks.miniphysgre.theory.mechanics.Mechanics;
import com.roboquarks.miniphysgre.theory.optics.Optics;
import com.roboquarks.miniphysgre.theory.quantum_mechanics.QuantumMechanics;
import com.roboquarks.miniphysgre.theory.special_relativity.SpecialRelativity;
import com.roboquarks.miniphysgre.theory.specialized_topics.SpecializedTopics;
import com.roboquarks.miniphysgre.theory.thermodynamics.Thermodynamics;

/**
 * Created by Hroney on 31.03.2016.
 */
public class Formulas extends AppCompatActivity
{
    LinearLayout llLeftPart, llRightPart;
    RelativeLayout relativeLayout;
    TextView textView;
    /** Defining global variables to work with fragments */
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas);
        /** Finding the layouts by id */
        /** for portrait mode */
        llLeftPart = (LinearLayout) findViewById(R.id.formulas_left_part);
        llRightPart = (LinearLayout) findViewById(R.id.formulas_right_part);
        relativeLayout = (RelativeLayout)findViewById(R.id.formulas_menu_content_frame);
        /** Finding the textView from menu_formulas_about by id */
        textView = (TextView)findViewById(R.id.formulas_menu_textView);
    }

    /** Methods for menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.formulas_menu, menu);
        return true;
    }

    /** Method for switching between menu parts */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            /** Finding the menu item from formulas_menu by id */
            case R.id.formulas_menu_settings:
                settingsMenuItem();
                break;
            case R.id.formulas_menu_about:
                aboutMenuItem();
                break;
            case R.id.formulas_menu_literature:
                literatureMenuItem();
                break;
            case R.id.formulas_menu_tips:
                tipsMenuItem();
                break;
        }

        return true;
    }

    private void settingsMenuItem()
    {

    }

    /** method for the "About" from the formulas menu */
    private void aboutMenuItem()
    {
        fragment = new FormulasMenuAbout();
        /** Initialising the fragment manager */
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.formulas_menu_content_frame, fragment).commit();
        /** Setting the visibility for the fragment */
        llLeftPart.setVisibility(View.GONE);
        llRightPart.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.VISIBLE);
        /** Setting the description of the application */
        textView.setText("here I'm writing this poem to you because...Well, I don't know why, but it is awesome...Bla-bla-bla");
    }

    private void literatureMenuItem()
    {
        textView.setText("");
    }

    private void tipsMenuItem()
    {
        textView.setText("");
    }
    /** the end for menu methods */

    /** Defining a methods for buttons */
    public void toMathematics(View view)
    {
        Intent intent = new Intent(Formulas.this, Mathematics.class);
        startActivity(intent);
    }

    public void toMechanics(View view)
    {
        Intent intent = new Intent(Formulas.this, Mechanics.class);
        startActivity(intent);
    }

    public void toElectromagnetism(View view)
    {
        Intent intent = new Intent(Formulas.this, Electromagnetism.class);
        startActivity(intent);
    }
    public void toOpticsAndWaves(View view)
    {
        Intent intent = new Intent(Formulas.this, Optics.class);
        startActivity(intent);
    }

    public void toThermodynamics(View view)
    {
        Intent intent = new Intent(Formulas.this, Thermodynamics.class);
        startActivity(intent);
    }

    public void toAtomicAndNuclearPhysics(View view)
    {
        Intent intent = new Intent(Formulas.this, AtomicPhys.class);
        startActivity(intent);
    }

    public void toQuantumMechanics(View view)
    {
        Intent intent = new Intent(Formulas.this, QuantumMechanics.class);
        startActivity(intent);
    }

    public void toSpecialRelativity(View view)
    {
        Intent intent = new Intent(Formulas.this, SpecialRelativity.class);
        startActivity(intent);
    }

    public void toLaboratoryMethods(View view)
    {
        Intent intent = new Intent(Formulas.this, LaboratoryMethods.class);
        startActivity(intent);
    }

    public void toSpecializedTopics(View view)
    {
        Intent intent = new Intent(Formulas.this, SpecializedTopics.class);
        startActivity(intent);
    }
    /** The end of the methods definition */
}
