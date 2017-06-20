package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.Workout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class LocalWorkoutDao implements Dao<Workout> {

    private ArrayList<Workout> workouts;

    public LocalWorkoutDao(){
        workouts = new ArrayList<Workout>();

        for(int i =0;i<5;i++){
            workouts.add(new Workout(i,"Workout name "+i,"Workout description "+i));
        }
    }

    @Override
    public Workout getById(int id) {
        for (Workout workout:workouts) {
            if (workout.id == id){
                return workout;
            }
        }
        return null;
    }

    @Override
    public void add(Workout element) {
        workouts.add(element);
    }

    @Override
    public void remove(Workout element) {
        workouts.remove(element);
    }

    @Override
    public List<Workout> list() {
        return workouts;
    }

    @Override
    public void update(Workout element) {
        Workout workout = this.getById(element.id);

        workout.description = element.description;
        workout.name = element.name;
    }
}
