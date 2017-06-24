package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class LocalCardioExerciseDao implements Dao<CardioExercise> {

    class CardioExerciseComparator implements Comparator<CardioExercise> {
        @Override
        public int compare(CardioExercise o1, CardioExercise o2) {
            return o1.label.compareTo(o2.label);
        }

    }

    private List<CardioExercise> exercises;
    public LocalCardioExerciseDao(){
        exercises = new ArrayList<>();

        // Poulate exercises
        this.add(new CardioExercise("Cycling","1d2"));
        this.add(new CardioExercise("Running","s23"));
        this.add(new CardioExercise("Treadmill","a 2"));
        this.add(new CardioExercise("Rowing","112"));
        this.add(new CardioExercise("Step Master","qwdq qwdqw"));

    }

    @Override
    public CardioExercise getById(int id) {

        CardioExercise targetExercise = null;

        for (CardioExercise exercise:list()) {
            if (exercise.id==id){
                targetExercise = exercise;
            }
        }

        return targetExercise;
    }

    @Override
    public void add(CardioExercise element) {
        element.id = getNextId();
        exercises.add(element);
    }

    private int getNextId(){
        int id = 0;
        for (CardioExercise exercise: exercises) {
            if (exercise.id>id){
                id = exercise.id;
            }
        }
        return id+1;
    }


    @Override
    public void remove(int id) {
        exercises.remove(getLocalById(id));
    }

    @Override
    public List<CardioExercise> list() {
        ArrayList<CardioExercise> clonedList = new ArrayList<CardioExercise>();

        for (CardioExercise exercise: exercises) {
            clonedList.add(new CardioExercise(exercise));
        }

        Collections.sort(clonedList,new CardioExerciseComparator());

        return clonedList;
    }

    @Override
    public void update(CardioExercise element) {
        CardioExercise stored = this.getLocalById(element.id);

        stored.label = element.label;
        stored.description = element.description;
    }

    private CardioExercise getLocalById(int id){

        for (CardioExercise exercise:exercises) {
            if (exercise.id==id){
                return exercise;
            }
        }

        return null;
    }

}
