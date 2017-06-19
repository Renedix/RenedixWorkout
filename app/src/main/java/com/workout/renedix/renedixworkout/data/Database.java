package com.workout.renedix.renedixworkout.data;

import com.workout.renedix.renedixworkout.data.Pojo.CardioExercise;
import com.workout.renedix.renedixworkout.data.dao.Dao;
import com.workout.renedix.renedixworkout.data.dao.LocalCardioExerciseDao;

import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public class Database {
    private static final Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Dao cardioExerciseDao;

    private Database() {
        cardioExerciseDao = new LocalCardioExerciseDao();
    }


    public List<CardioExercise> getCardioExercises(){
        return cardioExerciseDao.list();
    };

}
