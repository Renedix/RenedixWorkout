package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.Workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class LocalWorkoutDao implements Dao<Workout> {

    class WorkoutComparator implements Comparator<Workout> {
        @Override
        public int compare(Workout o1, Workout o2) {
            return o1.name.compareTo(o2.name);
        }

    }

    private ArrayList<Workout> workouts;

    public LocalWorkoutDao(){
        workouts = new ArrayList<Workout>();

        for(int i =0;i<5;i++){
            this.add(new Workout("Workout name "+i,"Workout description "+i));
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
        element.id = getNextId();
        workouts.add(element);
    }

    private int getNextId(){
        int id = 0;
        for (Workout workout: workouts) {
            if (workout.id>id){
                id = workout.id;
            }
        }
        return id+1;
    }

    @Override
    public void remove(int id) {
        workouts.remove(this.getLocalById(id));
    }

    @Override
    public List<Workout> list() {
        ArrayList<Workout> clonedList = new ArrayList<Workout>();

        for (Workout exercise: workouts) {
            clonedList.add(new Workout(exercise));
        }

        Collections.sort(clonedList,new WorkoutComparator());

        return clonedList;
    }

    public Workout getLocalById(int id) {

        for (Workout workout: workouts) {
            if (id==workout.id){
                return workout;
            }
        }

        return null;
    }

    @Override
    public void update(Workout element) {
        Workout workout = this.getLocalById(element.id);

        workout.description = element.description;
        workout.name = element.name;
    }
}
