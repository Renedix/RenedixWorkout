package com.workout.renedix.renedixworkout.setup.resistance;

import android.databinding.DataBindingUtil;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.workout.renedix.renedixworkout.R;
import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.databinding.ActivityResistanceExerciseFormBinding;

public class ResistanceExerciseForm extends AppCompatActivity {

    ActivityResistanceExerciseFormBinding binding;

    public static final String RESISTANT_EXERCISE_ID="RESISTANT_EXERCISE_ID";
    String resistanceExerciseId;
    boolean insertMode;

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
        ResistanceExercise exercise;

        if (!resistanceExerciseId.equals("")){
            insertMode = false;
            exercise = Database.getInstance().getResistanceExerciseById(resistanceExerciseId);
        }else{
            insertMode = true;
            exercise = new ResistanceExercise();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_resistance_exercise_form);
        binding.setResistanceExercise(exercise);
        //endregion

        //region Events
        Button updateButton = (Button) findViewById(R.id.apply_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (insertMode){
                    Database.getInstance().insertResistanceExercise(binding.getResistanceExercise());
                }else{
                    Database.getInstance().updateResistanceExercise(binding.getResistanceExercise());
                }

                navigateToParent();
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Database.getInstance().deleteCardioExercise(binding.getResistanceExercise());
                navigateToParent();
                //TODO Ensure to remove any references to this Exercise
            }
        });
        //endregion

        if (insertMode){
            deleteButton.setVisibility(View.GONE);
            updateButton.setText("Add");
        }else{
            deleteButton.setVisibility(View.VISIBLE);
            updateButton.setText("Update");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                navigateToParent();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navigateToParent(){
        this.finish();
    }
}
