package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class LocalResistanceExerciseDao implements Dao<ResistanceExercise> {

    private ArrayList<ResistanceExercise> exercises;

    public LocalResistanceExerciseDao(){
        exercises = new ArrayList<ResistanceExercise>();

        for(int i=0;i<5;i++){
            exercises.add(new ResistanceExercise(i,"Resistance Exercise Label "+i,"Resistance Exercise Description "+i));
        }
    }

    @Override
    public ResistanceExercise getById(int id) {

        for (ResistanceExercise exercise: exercises) {
            if (id==exercise.id){
                return exercise;
            }

        }

        return null;
    }

    @Override
    public void add(ResistanceExercise element) {
        exercises.add(element);
    }

    @Override
    public void remove(ResistanceExercise element) {
        exercises.remove(element);
    }

    @Override
    public List<ResistanceExercise> list() {
        return exercises;
    }

    @Override
    public void update(ResistanceExercise element) {
        ResistanceExercise saved = this.getById(element.id);

        saved.label = element.label;
        saved.description = element.description;
    }
}
