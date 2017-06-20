package com.workout.renedix.renedixworkout.data.Pojo;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class ResistanceExercise {
    public int id;
    public String label;
    public String description;

    public ResistanceExercise(String label, String description){
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public ResistanceExercise(ResistanceExercise exercise){
        this.id = exercise.id;
        this.label = new String(exercise.label);
        this.description = new String(exercise.description);
    }
}
