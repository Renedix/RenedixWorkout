package com.workout.renedix.renedixworkout.data.Pojo;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class CardioExercise {
    public String label;
    public int id;
    public String description;

    public CardioExercise(int id,String label, String description) {
        this.label = label;
        this.id = id;
        this.description= description;
    }
}
