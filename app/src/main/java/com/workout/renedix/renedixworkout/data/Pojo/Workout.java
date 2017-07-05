package com.workout.renedix.renedixworkout.data.Pojo;

import com.workout.renedix.renedixworkout.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Workout {
    public int id;
    public String name;
    public String description;
    public List<CardioExercise> cardioExercises;
    public List<ResistanceExercise> resistanceExercises;


    public Workout(String name, String description){
        this.name = name;
        this.description = description;
        this.cardioExercises = new ArrayList<CardioExercise>();
        this.resistanceExercises = new ArrayList<ResistanceExercise>();
    }

    public Workout(){
        this.name="";
        this.description = "";
        this.cardioExercises = new ArrayList<CardioExercise>();
        this.resistanceExercises = new ArrayList<ResistanceExercise>();
    }

    public Workout(Workout workout){
        this.id = workout.id;
        this.name = new String(workout.name);
        this.description = new String(workout.description);

        this.cardioExercises = workout.cardioExercises;
        this.resistanceExercises = workout.resistanceExercises;
    }

    public void addCardioExercise(CardioExercise exercise){
        cardioExercises.add(exercise);
    }

    public void addResistanceExercise(ResistanceExercise exercise){
        resistanceExercises.add(exercise);
    }

    public boolean containsCardioExercise(CardioExercise exercise){

        for(CardioExercise cardioExercise: cardioExercises){
            if (cardioExercise.id == exercise.id){
                return true;
            }
        }
        return false;
    }

    public boolean containsResistanceExercise(ResistanceExercise exercise){

        for(ResistanceExercise resistanceExercise: resistanceExercises){
            if (resistanceExercise.id == exercise.id){
                return true;
            }
        }
        return false;
    }

    // TODO Add dummy exercises to all workouts
    // TODO view all exercises for workout on Workout form and Workout Detail (fragment?)
    // TODO Allow users to add and remove cardio exercises
    // TODO Allow users to add and remove resistance exercises




}
