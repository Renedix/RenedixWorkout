package com.workout.renedix.renedixworkout.data;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.Pojo.ResistanceExercise;
import com.workout.renedix.renedixworkout.data.dao.Dao;
import com.workout.renedix.renedixworkout.data.dao.LocalCardioExerciseDao;
import com.workout.renedix.renedixworkout.data.dao.LocalResistanceExerciseDao;

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

}
