package com.workout.renedix.renedixworkout.data.dao;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.Pojo.CardioExerciseSession;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExerciseSession;
import com.workout.renedix.renedixworkout.data.Pojo.Workout;
import com.workout.renedix.renedixworkout.data.Pojo.WorkoutSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 7/8/2017.
 */

public class LocalWorkoutSessionDao implements Dao<WorkoutSession>{

    private ArrayList<WorkoutSession> workoutsSessions;

    public LocalWorkoutSessionDao(){
        workoutsSessions = new ArrayList<WorkoutSession>();

        //region Test Data
        //region cardioExerciseSesh
        CardioExercise cardioExercise = new CardioExercise();
            cardioExercise.id = 1;

        double cardioExerciseResistance = 1;
        double cardioExerciseIncline = 0;
        int cardioExerciseCalories = 100;
        Date cardioExerciseLogDate = new Date();

        int seconds = 1;
        int minutes = 2;
        int hours = 3;

        float distanceAmount = 1;
        CardioExerciseSession.DistanceUnit unit = CardioExerciseSession.DistanceUnit.MILES;

        CardioExerciseSession cardioSesh = new CardioExerciseSession(   cardioExercise,
                                                                        cardioExerciseResistance,
                                                                        cardioExerciseIncline,
                                                                        cardioExerciseCalories,
                                                                        cardioExerciseLogDate,
                                                                        seconds,minutes,hours,
                                                                        distanceAmount,unit);
        //endregion

        //region resistanceExerciseSesh
        ResistanceExercise resistanceExercise = new ResistanceExercise();
            resistanceExercise.id = 1;

        int repetitions = 10;
        double resistance = 25;
        ResistanceExerciseSession resistanceSesh = new ResistanceExerciseSession(resistanceExercise,repetitions,resistance, new Date());
            resistanceSesh.id = 1;
        //endregion

        //region WorkoutSession
        Workout workout = new Workout();
        workout.id = 1;

        WorkoutSession workoutSession = new WorkoutSession(workout,new Date());
        workoutSession.id = 1;

        workoutSession.cardioExercises.add(cardioSesh);
        workoutSession.resistanceExercises.add(resistanceSesh);
        //endregion
        //endregion
    }

    @Override
    public WorkoutSession getById(int id) {
        return null;
    }

    @Override
    public int add(WorkoutSession element) {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<WorkoutSession> list() {

        ArrayList<WorkoutSession> clonedList = new ArrayList<WorkoutSession>();

        for (WorkoutSession workoutSession: workoutsSessions) {
            clonedList.add(new WorkoutSession(workoutSession));
        }

        //Collections.sort(clonedList,new WorkoutComparator());

        return clonedList;

    }

    @Override
    public void update(WorkoutSession element) {

    }
}
