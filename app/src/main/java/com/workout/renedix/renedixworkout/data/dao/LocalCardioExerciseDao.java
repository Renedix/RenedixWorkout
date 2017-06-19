package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class LocalCardioExerciseDao implements Dao<CardioExercise> {

    private List<CardioExercise> exercises;
    public LocalCardioExerciseDao(){
        exercises = new ArrayList<>();

        // Poulate exercises
        for(int i=0;i<10;i++){
            exercises.add(new CardioExercise(i,"Exercise number"+i, "Description "+i));
        }

    }

    @Override
    public CardioExercise getById(int id) {

        CardioExercise targetExercise = null;

        for (CardioExercise exercise:exercises) {
            if (exercise.getId()==id){
                targetExercise = exercise;
            }
        }

        return targetExercise;
    }

    @Override
    public void add(CardioExercise element) {
        exercises.add(element);
    }

    @Override
    public void remove(CardioExercise element) {
        exercises.remove(element);
    }

    @Override
    public List<CardioExercise> list() {
        return exercises;
    }

    @Override
    public void update(CardioExercise element) {
        CardioExercise stored = this.getById(element.getId());

        stored.setLabel(element.getLabel());
        stored.setDescription(element.getLabel());
    }
}
