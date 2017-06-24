package com.workout.renedix.renedixworkout.form;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.workout.renedix.renedixworkout.R;
import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.databinding.ActivityCardioExerciseFormBinding;

import static android.support.v4.app.NavUtils.navigateUpFromSameTask;

public class CardioExerciseForm extends AppCompatActivity {

    public static final String CARDIO_EXERCISE_ID = "CARDIO_EXERCISE_ID";
    private String cardioExerciseId;
    private CardioExercise exercise;

    private boolean insertMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_form);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Bundle b = getIntent().getExtras();

        cardioExerciseId = b.getString(CARDIO_EXERCISE_ID);

        if (cardioExerciseId!=null){
            insertMode = false;
            exercise = Database.getInstance().getCardioExerciseById(cardioExerciseId);
        }else{
            insertMode = true;
            exercise = new CardioExercise("","");
        }

        ActivityCardioExerciseFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_cardio_exercise_form);
        binding.setExercise(exercise);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
