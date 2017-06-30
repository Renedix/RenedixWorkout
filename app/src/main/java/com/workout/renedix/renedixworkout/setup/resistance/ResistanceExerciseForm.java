package com.workout.renedix.renedixworkout.setup.resistance;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.workout.renedix.renedixworkout.R;
import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.databinding.ActivityResistanceExerciseFormBinding;

public class ResistanceExerciseForm extends AppCompatActivity {

    public static final String RESISTANT_EXERCISE_ID="RESISTANT_EXERCISE_ID";
    String resistanceExerciseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistance_exercise_form);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //region Bindings
        Bundle b = getIntent().getExtras();
        resistanceExerciseId = b.getString(RESISTANT_EXERCISE_ID);

        ActivityResistanceExerciseFormBinding binding;

        ResistanceExercise exercise = Database.getInstance().getResistanceExerciseById(resistanceExerciseId);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_resistance_exercise_form);
        binding.setResistanceExercise(exercise);

        //endregion

        //TODO Add Resistance Exercise to Form
        //TODO Update Button, delete button ExerciseForm
        //TODO Changing Apply button with update\add
        //TODO Hide delete button when in insert mode
    }
}
