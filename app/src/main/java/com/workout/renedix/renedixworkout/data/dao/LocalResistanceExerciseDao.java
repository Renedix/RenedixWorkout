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

        this.add(new ResistanceExercise("Bench","Chest, Bicep"));
        this.add(new ResistanceExercise("Pectoral Flys","Chest"));
        this.add(new ResistanceExercise("Hammer Curls","Bicep"));

        this.remove(2);

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
        element.id = getNextId();
        exercises.add(element);
    }

    private int getNextId(){
        int id = 0;
        for (ResistanceExercise exercise: exercises) {
            if (exercise.id>id){
                id = exercise.id;
            }
        }
        return id+1;
    }

    @Override
    public void remove(int id) {
        exercises.remove(this.getLocalById(id));
    }

    @Override
    public List<ResistanceExercise> list() {
        ArrayList<ResistanceExercise> clonedList = new ArrayList<ResistanceExercise>();

        for (ResistanceExercise exercise: exercises) {
            clonedList.add(new ResistanceExercise(exercise));
        }

        return clonedList;
    }


    public ResistanceExercise getLocalById(int id) {

        for (ResistanceExercise exercise: exercises) {
            if (id==exercise.id){
                return exercise;
            }
        }

        return null;
    }

    @Override
    public void update(ResistanceExercise element) {
        ResistanceExercise saved = this.getLocalById(element.id);

        saved.label = element.label;
        saved.description = element.description;
    }
}
