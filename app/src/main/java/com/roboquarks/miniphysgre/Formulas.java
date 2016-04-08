package com.roboquarks.miniphysgre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.roboquarks.miniphysgre.atomic_physics.AtomicPhys;
import com.roboquarks.miniphysgre.electromagnetism.Electromagnetism;
import com.roboquarks.miniphysgre.laboratory_methods.LaboratoryMethods;
import com.roboquarks.miniphysgre.mathematics.Mathematics;
import com.roboquarks.miniphysgre.mechanics.Mechanics;
import com.roboquarks.miniphysgre.optics.Optics;
import com.roboquarks.miniphysgre.quantum_mechanics.QuantumMechanics;
import com.roboquarks.miniphysgre.special_relativity.SpecialRelativity;
import com.roboquarks.miniphysgre.specialized_topics.SpecializedTopics;
import com.roboquarks.miniphysgre.thermodynamics.Thermodynamics;

/**
 * Created by Hroney on 31.03.2016.
 */
public class Formulas extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gre_formulas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.formulas_menu, menu);
        return true;
    }

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
