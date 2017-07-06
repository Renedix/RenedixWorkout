package com.workout.renedix.renedixworkout.data.Pojo;

import java.util.Date;

/**
 * Created by RENEDIX-LAPTOP on 7/5/2017.
 */

public class CardioExerciseSession {

    public int id;
    public CardioExercise exercise;
    public Duration duration;
    public Distance distance;
    public double resistance;
    public double incline;
    public int calories;
    public Date logDate;

    public enum DistanceUnit {MILES,KILOMETER};
    private class Distance{
        public DistanceUnit unit;
        public float amount;
        public Distance(float amount, DistanceUnit unit){
            this.unit = unit;
            this.amount = amount;
        }
    }
    private class Duration{
        private int seconds;
        private int minutes;
        private int hours;
        public Duration(int seconds, int minutes, int hours){
            this.seconds = seconds;
            this.minutes = minutes;
            this.hours = hours;
        }
    }

}
