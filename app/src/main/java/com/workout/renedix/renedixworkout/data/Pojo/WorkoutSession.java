package com.workout.renedix.renedixworkout.data.Pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 7/5/2017.
 */

public class WorkoutSession {

    public int id;
    public Workout workout;
    public List<CardioExerciseSession> cardioExercises;
    public List<ResistanceExerciseSession> resistanceExercises;
    public Date workoutDate;


    public WorkoutSession(Workout workout, Date workoutDate){
        this.workoutDate = workoutDate;
        this.workout = workout;
        this.cardioExercises = new ArrayList<CardioExerciseSession>();
        this.resistanceExercises = new ArrayList<ResistanceExerciseSession>();
    }

    public WorkoutSession(WorkoutSession workoutSession){
        this.id = workoutSession.id;
        this.workout = workoutSession.workout;
        this.workoutDate = workoutSession.workoutDate;

        cardioExercises = new ArrayList<CardioExerciseSession>();
        for(CardioExerciseSession cardioExerciseSession: cardioExercises){
            // copy
            cardioExercises.add(new CardioExerciseSession(cardioExerciseSession));
        }

        resistanceExercises = new ArrayList<ResistanceExerciseSession>();
        for(ResistanceExerciseSession resistanceExerciseSession: resistanceExercises){
            //oopy
            resistanceExercises.add(new ResistanceExerciseSession(resistanceExerciseSession));
        }


    }






}
