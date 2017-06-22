package com.workout.renedix.renedixworkout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.databinding.ActivityCardioExerciseFormBinding;

public class CardioExerciseForm extends AppCompatActivity {

    public static final String CARDIO_EXERCISE_ID = "CARDIO_EXERCISE_ID";
    private String cardioExerciseId;
    private CardioExercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_form);

        Bundle b = getIntent().getExtras();

        cardioExerciseId = b.getString(CARDIO_EXERCISE_ID);
        exercise = Database.getInstance().getCardioExerciseById(cardioExerciseId);

        ActivityCardioExerciseFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_cardio_exercise_form);
        binding.setExercise(exercise);

    }
}
