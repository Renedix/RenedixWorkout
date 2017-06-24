package com.workout.renedix.renedixworkout.data;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.data.Pojo.Workout;
import com.workout.renedix.renedixworkout.data.dao.Dao;
import com.workout.renedix.renedixworkout.data.dao.LocalCardioExerciseDao;
import com.workout.renedix.renedixworkout.data.dao.LocalResistanceExerciseDao;
import com.workout.renedix.renedixworkout.data.dao.LocalWorkoutDao;

import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Database {
    private static final Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    //region Constructor
    private Database() {
        cardioExerciseDao = new LocalCardioExerciseDao();
        resistanceExerciseDao = new LocalResistanceExerciseDao();
        workoutDao = new LocalWorkoutDao();
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
    public void insertCardioExercise(CardioExercise exercise){
        cardioExerciseDao.add(exercise);
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
    //endregion

    //region Workout
    private Dao workoutDao;
    public List<Workout> getWorkouts(){
        return workoutDao.list();
    }

    public Workout getWorkoutById(String id){
        return (Workout) workoutDao.getById(Integer.parseInt(id));
    }
    //endregion

}
