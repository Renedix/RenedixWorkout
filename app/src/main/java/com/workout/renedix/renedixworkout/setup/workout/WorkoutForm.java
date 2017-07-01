package com.workout.renedix.renedixworkout.setup.workout;

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
import com.workout.renedix.renedixworkout.data.Pojo.Workout;
import com.workout.renedix.renedixworkout.databinding.ActivityWorkoutFormBinding;

public class WorkoutForm extends AppCompatActivity {

    public static final String WORKOUT_ID = "WORKOUT_ID";
    private String workoutId;
    private ActivityWorkoutFormBinding binding;
    private boolean insertMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_form);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //region Bindings
        Bundle b = getIntent().getExtras();
        workoutId = b.getString(WORKOUT_ID);
        Workout workout = null;

        if (!workoutId.equals("")){
            insertMode = false;
            workout = Database.getInstance().getWorkoutById(workoutId);
        }else{
            insertMode = true;
            workout = new Workout();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_workout_form);
        binding.setWorkout(workout);

        //endregion

        //region Events
        Button updateButton = (Button) findViewById(R.id.apply_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (insertMode){
                    Database.getInstance().insertWorkout(binding.getWorkout());
                }else{
                    Database.getInstance().updateWorkout(binding.getWorkout());
                }

                navigateToParent();
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Database.getInstance().deleteWorkout(binding.getWorkout());
                navigateToParent();
            }
        });

        //endregion

        //region Button Description Update
        if (insertMode){
            deleteButton.setVisibility(View.GONE);
            updateButton.setText("Add");
        }else{
            deleteButton.setVisibility(View.VISIBLE);
            updateButton.setText("Update");
        }
        //endregion
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
        NavUtils.navigateUpFromSameTask(this);
    }
}
