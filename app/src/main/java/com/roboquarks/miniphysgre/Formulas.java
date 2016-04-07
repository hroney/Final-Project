package com.roboquarks.miniphysgre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    /** Defining a methods for buttons */
    public void toMathematics(View view)
    {
        Intent intent = new Intent(Formulas.this, Mathematics.class);
        startActivity(intent);
        finish();
    }

    public void toMechanics(View view)
    {
        Intent intent = new Intent(Formulas.this, Mechanics.class);
        startActivity(intent);
        finish();
    }

    public void toElectromagnetism(View view)
    {
        Intent intent = new Intent(Formulas.this, Electromagnetism.class);
        startActivity(intent);
        finish();
    }
    public void toOpticsAndWaves(View view)
    {
        Intent intent = new Intent(Formulas.this, Optics.class);
        startActivity(intent);
        finish();
    }

    public void toThermodynamics(View view)
    {
        Intent intent = new Intent(Formulas.this, Thermodynamics.class);
        startActivity(intent);
        finish();
    }

    public void toAtomicAndNuclearPhysics(View view)
    {
        Intent intent = new Intent(Formulas.this, AtomicPhys.class);
        startActivity(intent);
        finish();
    }

    public void toQuantumMechanics(View view)
    {
        Intent intent = new Intent(Formulas.this, QuantumMechanics.class);
        startActivity(intent);
        finish();
    }

    public void toSpecialRelativity(View view)
    {
        Intent intent = new Intent(Formulas.this, SpecialRelativity.class);
        startActivity(intent);
        finish();
    }

    public void toLaboratoryMethods(View view)
    {
        Intent intent = new Intent(Formulas.this, LaboratoryMethods.class);
        startActivity(intent);
        finish();
    }

    public void toSpecializedTopics(View view)
    {
        Intent intent = new Intent(Formulas.this, SpecializedTopics.class);
        startActivity(intent);
        finish();
    }
    /** The end of the methods definition */
}
