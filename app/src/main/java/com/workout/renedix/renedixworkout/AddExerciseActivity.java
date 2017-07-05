package com.workout.renedix.renedixworkout;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.data.Pojo.Workout;

public class AddExerciseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    public enum ExerciseTypes {CARDIO, RESISTANCE};

    private ArrayAdapter<ExerciseWrapper> arrayAdapter;
    private ListView exerciseList;

    private ExerciseTypes passedType;
    public static String EXERCISE_TYPE = "EXERCISE_TYPE";

    private String workoutId;
    public static String WORKOUT_ID = "WORKOUT_ID";

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO Onclick item on list
        ExerciseWrapper exercise = (ExerciseWrapper) parent.getItemAtPosition(position);

        Workout workout = Database.getInstance().getWorkoutById(workoutId);

        switch(passedType){
            case CARDIO:

                CardioExercise cardioExercise = Database.getInstance().getCardioExerciseById(Integer.toString(exercise.getId()));
                workout.addCardioExercise(cardioExercise);

                break;
            case RESISTANCE:

                ResistanceExercise resistanceExercise = Database.getInstance().getResistanceExerciseById(Integer.toString(exercise.getId()));
                workout.addResistanceExercise(resistanceExercise);

                break;
        }

        Database.getInstance().updateWorkout(workout);

        refreshList();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        this.arrayAdapter = new ArrayAdapter<ExerciseWrapper>(this,android.R.layout.simple_list_item_1);

        this.exerciseList = (ListView) findViewById(R.id.exerciseList);
        this.exerciseList.setAdapter(arrayAdapter);

        this.exerciseList.setOnItemClickListener(this);


        passedType = (ExerciseTypes) getIntent().getSerializableExtra(EXERCISE_TYPE);

        workoutId = getIntent().getStringExtra(WORKOUT_ID);

        // TODO Add back button
        // TODO Do not remove items, gray them out.
    }


    private void refreshList(){
        arrayAdapter.clear();

        Workout workout = Database.getInstance().getWorkoutById(workoutId);

        switch(passedType){
            case CARDIO:

                for(CardioExercise exercise: Database.getInstance().getCardioExercises()){
                    if (!workout.containsCardioExercise(exercise)){
                        arrayAdapter.add(new ExerciseWrapper(exercise));
                    }
                }


                break;
            case RESISTANCE:

                for(ResistanceExercise exercise: Database.getInstance().getResistanceExercises()){
                    if (!workout.containsResistanceExercise(exercise)) {
                        arrayAdapter.add(new ExerciseWrapper(exercise));
                    }
                }

                break;
        }

        arrayAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onResume() {
        super.onResume();

        refreshList();

    }

    private class ExerciseWrapper {
        private String name;
        private int id;
        public ExerciseWrapper(CardioExercise exercise){
            this.name = exercise.label;
            this.id = exercise.id;
        }

        public ExerciseWrapper(ResistanceExercise exercise){
            this.name = exercise.label;
            this.id = exercise.id;
        }

        public int getId(){return id;}

        @Override
        public String toString(){
            return name;
        }
    }
}
