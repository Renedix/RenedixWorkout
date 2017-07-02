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

    //region testData

    public void insertTestExercises(){
        populateTestCardio();
        //populateTestResistance();
    }

    private void populateTestCardio(){

        this.cardioExercises = new ArrayList<CardioExercise>();

        Random random = new Random();

        for(int i=0;i<5;i++){
            int randomIndex = random.nextInt(20);
            this.cardioExercises.add(new CardioExercise("Cardio Exercise "+randomIndex,"Cardio Exercise Description "+randomIndex));
        }

    }

    private void populateTestResistance(){

        this.resistanceExercises = new ArrayList<ResistanceExercise>();

        Random random = new Random();

        for(int i=0;i<5;i++){
            int randomIndex = random.nextInt(20);
            this.resistanceExercises.add(new ResistanceExercise("Resistance Exercise "+randomIndex,"Resistance Exercise Description "+randomIndex));
        }

    }

    //endregion

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

    // TODO Add dummy exercises to all workouts
    // TODO view all exercises for workout on Workout form and Workout Detail (fragment?)
    // TODO Allow users to add and remove cardio exercises
    // TODO Allow users to add and remove resistance exercises




}
