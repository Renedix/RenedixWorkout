package com.workout.renedix.renedixworkout.data.Pojo;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Workout {
    public int id;
    public String name;
    public String description;

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


}
