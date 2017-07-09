package com.workout.renedix.renedixworkout.setup.workout;

import android.content.Intent;
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
            workout = Database.getInstance().getWorkoutById(workoutId);
        }else{
            workout = new Workout();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_workout_form);
        binding.setWorkout(workout);

        //endregion

        //region Events
        Button updateButton = (Button) findViewById(R.id.apply_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isInsertMode()){
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

        Button cardioButton = (Button) findViewById(R.id.cardioButton);
        cardioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddExerciseActivity.class);

                if (isInsertMode()){
                    // Insert workout before switching
                    workoutId = Integer.toString(Database.getInstance().insertWorkout(binding.getWorkout()));
                    binding.setWorkout(Database.getInstance().getWorkoutById(workoutId));
                }

                intent.putExtra(AddExerciseActivity.EXERCISE_TYPE, AddExerciseActivity.ExerciseTypes.CARDIO);
                intent.putExtra(AddExerciseActivity.WORKOUT_ID, Integer.toString(binding.getWorkout().id));

                v.getContext().startActivity(intent);
            }
        });

        Button resistanceButton = (Button) findViewById(R.id.resistanceButton);
        resistanceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddExerciseActivity.class);

                if (isInsertMode()) {
                    // Insert workout before switching
                    workoutId = Integer.toString(Database.getInstance().insertWorkout(binding.getWorkout()));
                    binding.setWorkout(Database.getInstance().getWorkoutById(workoutId));
                }

                intent.putExtra(AddExerciseActivity.EXERCISE_TYPE, AddExerciseActivity.ExerciseTypes.RESISTANCE);
                intent.putExtra(AddExerciseActivity.WORKOUT_ID, Integer.toString(binding.getWorkout().id));

                v.getContext().startActivity(intent);
            }
        });
        //endregion

    }


    @Override
    protected void onResume() {
        super.onResume();

        //region Change Cardio\Resistance description
        if (!isInsertMode()){

            Workout workout = binding.getWorkout();

            Button cardioButton = (Button) findViewById(R.id.cardioButton);
            Button resistanceButton = (Button) findViewById(R.id.resistanceButton);


            if (workout.cardioExercises.size()>0){
                cardioButton.setText("Cardio ("+workout.cardioExercises.size()+")");
            }else{
                cardioButton.setText("Cardio");
            }

            if (workout.resistanceExercises.size()>0){
                resistanceButton.setText("Resistance ("+workout.resistanceExercises.size()+")");
            }else{
                resistanceButton.setText("Resistance");
            }

        }
        //endregion

        //region Adjust visibility of delete button and Add description
        Button deleteButton = (Button) findViewById(R.id.delete_button);
        Button updateButton = (Button) findViewById(R.id.apply_button);
        if (isInsertMode()){
            deleteButton.setVisibility(View.GONE);
            updateButton.setText("Add");
        }else{
            deleteButton.setVisibility(View.VISIBLE);
            updateButton.setText("Update");
        }
        //endregion

    }

    private boolean isInsertMode(){
        return binding.getWorkout().id==0;
    }

    private void navigateToParent(){
        NavUtils.navigateUpFromSameTask(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
