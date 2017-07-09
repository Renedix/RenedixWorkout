package com.workout.renedix.renedixworkout.data.Pojo;

import java.util.Date;

/**
 * Created by RENEDIX-LAPTOP on 7/5/2017.
 */

public class ResistanceExerciseSession {

    public int id;
    public ResistanceExercise exercise;
    public int repetitions;
    public double resistance;
    public Date logDate;

    /*  Resistance
    *   -> Repetitions
    *   -> Resistance
    * */

    public ResistanceExerciseSession(ResistanceExercise exercise, int repetitions, double resistance, Date logDate){
        this.id = id;
        this.exercise = exercise;
        this.repetitions = repetitions;
        this.resistance = resistance;
        this.logDate = logDate;
    }

    public ResistanceExerciseSession(ResistanceExerciseSession resistanceExerciseSession){
        this.id = resistanceExerciseSession.id;
        this.exercise = resistanceExerciseSession.exercise;
        this.repetitions = resistanceExerciseSession.repetitions;
        this.resistance = resistanceExerciseSession.resistance;
        this.logDate = resistanceExerciseSession.logDate;
    }

}
