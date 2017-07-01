package com.workout.renedix.renedixworkout.setup.workout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.workout.renedix.renedixworkout.R;

public class WorkoutForm extends AppCompatActivity {

    public static final String WORKOUT_ID = "WORKOUT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_form);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // TODO Form Bindings
        // TODO Update Button
        // TODO Insert Button
        // TODO Delete Button

    }
}
