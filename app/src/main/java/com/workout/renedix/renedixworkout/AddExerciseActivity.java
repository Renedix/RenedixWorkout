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

public class AddExerciseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    public enum ExerciseTypes {CARDIO, RESISTANCE};

    private ArrayAdapter<ExerciseWrapper> arrayAdapter;
    private ListView exerciseList;

    private ExerciseTypes passedType;
    public static String EXERCISE_TYPE = "EXERCISE_TYPE";

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO Onclick item on list
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


        // TODO Add back button
        // TODO Filter items based on passed Exercise Id - they cannot add the same item twice.
    }




    @Override
    protected void onResume() {
        super.onResume();

        arrayAdapter.clear();

        switch(passedType){
            case CARDIO:

                for(CardioExercise exercise: Database.getInstance().getCardioExercises()){
                    arrayAdapter.add(new ExerciseWrapper(exercise));
                }


                break;
            case RESISTANCE:

                for(ResistanceExercise exercise: Database.getInstance().getResistanceExercises()){
                    arrayAdapter.add(new ExerciseWrapper(exercise));
                }

                break;
        }

        arrayAdapter.notifyDataSetChanged();

    }

    private class ExerciseWrapper {
        private String name;
        public ExerciseWrapper(CardioExercise exercise){
            this.name = exercise.label;
        }

        public ExerciseWrapper(ResistanceExercise exercise){
            this.name = exercise.label;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}
