package com.workout.renedix.renedixworkout.data.Pojo;

import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Workout {
    public int id;
    public String name;
    public String description;
    public List<Integer> cardioExerciseIds;
    public List<Integer> resistanceExerciseIds;


    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Workout(){
        this.name="";
        this.description = "";
    }

    public Workout(Workout workout){
        this.id = workout.id;
        this.name = new String(workout.name);
        this.description = new String(workout.description);
    }



    // TODO cardioExerciseIds
    // TODO resistanceExerciseIds
    // TODO Add dummy exercises to all workouts
    // TODO view all exercises for workout on Workout form and Workout Detail (fragment?)
    // TODO Allow users to add and remove cardio exercises
    // TODO Allow users to add and remove resistance exercises




}
