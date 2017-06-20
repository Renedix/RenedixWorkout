package com.workout.renedix.renedixworkout.data.Pojo;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class CardioExercise {
    public String label;
    public int id;
    public String description;

    public CardioExercise(String label, String description) {
        this.label = label;
        this.id = id;
        this.description= description;
    }

    public CardioExercise(CardioExercise cardioExercise){
        this.id = cardioExercise.id;
        this.label = new String(cardioExercise.label);
        this.description = new String(cardioExercise.label);
    }
}
