package com.workout.renedix.renedixworkout.data.Pojo;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class CardioExercise {
    private String label;
    private int id;
    private String description;

    public CardioExercise(int id,String label, String description) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
