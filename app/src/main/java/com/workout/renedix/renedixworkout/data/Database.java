package com.workout.renedix.renedixworkout.data;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.data.Pojo.Workout;
import com.workout.renedix.renedixworkout.data.dao.Dao;
import com.workout.renedix.renedixworkout.data.dao.LocalCardioExerciseDao;
import com.workout.renedix.renedixworkout.data.dao.LocalResistanceExerciseDao;
import com.workout.renedix.renedixworkout.data.dao.LocalWorkoutDao;
import com.workout.renedix.renedixworkout.data.dao.LocalWorkoutSessionDao;

import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Database {
    private static Database ourInstance;

    public static Database getInstance() {
        if (ourInstance==null){
            ourInstance = new Database();
        }
        return ourInstance;
    }

    //region Constructor
    private Database() {
        cardioExerciseDao = new LocalCardioExerciseDao();
        resistanceExerciseDao = new LocalResistanceExerciseDao();
        workoutDao = new LocalWorkoutDao();
        workoutSessionDao = new LocalWorkoutSessionDao();
    }
    //endregion

    // region CardioExercise
    private Dao cardioExerciseDao;
    public List<CardioExercise> getCardioExercises(){
        return cardioExerciseDao.list();
    };
    public CardioExercise getCardioExerciseById(String id){
        return (CardioExercise) cardioExerciseDao.getById(Integer.parseInt(id));
    }
    public void updateCardioExercise(CardioExercise exercise){
        cardioExerciseDao.update(exercise);
    }
    public void deleteCardioExercise(CardioExercise exercise){
        cardioExerciseDao.remove(exercise.id);
    }
    public int insertCardioExercise(CardioExercise exercise){
        return cardioExerciseDao.add(exercise);
    }
    //endregion

    //region ResistanceExercise
    private Dao resistanceExerciseDao;
    public List<ResistanceExercise> getResistanceExercises(){
        return resistanceExerciseDao.list();
    }
    public ResistanceExercise getResistanceExerciseById(String id){
        return (ResistanceExercise) resistanceExerciseDao.getById(Integer.parseInt(id));
    }
    public int insertResistanceExercise(ResistanceExercise exercise){
        return resistanceExerciseDao.add(exercise);
    }
    public void updateResistanceExercise(ResistanceExercise exercise){
        resistanceExerciseDao.update(exercise);
    }
    public void deleteCardioExercise(ResistanceExercise exercise){
        resistanceExerciseDao.remove(exercise.id);
    }
    //endregion

    //region Workout
    private Dao workoutDao;
    public List<Workout> getWorkouts(){
        return workoutDao.list();
    }

    public Workout getWorkoutById(String id){
        return (Workout) workoutDao.getById(Integer.parseInt(id));
    }
    public int insertWorkout(Workout workout){
        return workoutDao.add(workout);
    }
    public void updateWorkout(Workout workout){
        workoutDao.update(workout);
    }
    public void deleteWorkout(Workout workout){
        workoutDao.remove(workout.id);
    }
    //endregion

    //region WorkoutSession
    Dao workoutSessionDao;
    //TODO Add WorkoutSession DAO
    //TODO Add dummy data for WorkoutSession
    //TODO Display Workout History
    //TODO Display Exercise History
    //TODO Allow users to create workout
    //endregion

}
