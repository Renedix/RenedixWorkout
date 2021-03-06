package com.workout.renedix.renedixworkout.setup.cardio;

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
import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.databinding.ActivityCardioExerciseFormBinding;

import static android.support.v4.app.NavUtils.navigateUpFromSameTask;

public class CardioExerciseForm extends AppCompatActivity {

    public static final String CARDIO_EXERCISE_ID = "CARDIO_EXERCISE_ID";
    private String cardioExerciseId;

    ActivityCardioExerciseFormBinding binding;

    private boolean insertMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_form);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //region Bindings
        Bundle b = getIntent().getExtras();
        cardioExerciseId = b.getString(CARDIO_EXERCISE_ID);
        CardioExercise exercise = null;

        if (!cardioExerciseId.equals("")){
            insertMode = false;
            exercise = Database.getInstance().getCardioExerciseById(cardioExerciseId);
        }else{
            insertMode = true;
            exercise = new CardioExercise();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cardio_exercise_form);
        binding.setExercise(exercise);

        //endregion

        //region Events
        Button updateButton = (Button) findViewById(R.id.apply_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (insertMode){
                    Database.getInstance().insertCardioExercise(binding.getExercise());
                }else{
                    Database.getInstance().updateCardioExercise(binding.getExercise());
                }

                navigateToParent();
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Database.getInstance().deleteCardioExercise(binding.getExercise());
                navigateToParent();
                //TODO Ensure to remove any references to this Exercise
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

    private void navigateToParent(){
        this.finish();
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

}
