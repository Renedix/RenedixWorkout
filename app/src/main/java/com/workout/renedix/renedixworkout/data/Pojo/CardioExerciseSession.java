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

    public CardioExerciseSession(CardioExercise cardioExercise, double resistance, double incline, int calories, Date logDate,int seconds, int minutes, int hours, float distanceAmount, CardioExerciseSession.DistanceUnit unit){
        this.exercise = cardioExercise;
        this.resistance = resistance;
        this.incline = incline;
        this.calories = calories;
        this.logDate = logDate;
        this.duration = new Duration(seconds, minutes, hours);
        this.distance = new Distance(distanceAmount,unit);
    }

    public CardioExerciseSession(CardioExerciseSession session){
        this.id = session.id;
        this.exercise = session.exercise;
        this.resistance = session.resistance;
        this.incline = session.incline;
        this.calories = session.calories;
        this.logDate = session.logDate;

        this.distance = new Distance(session.distance);
        this.duration = new Duration(session.duration);
    }




    public enum DistanceUnit {MILES,KILOMETER};
    private class Distance{
        public DistanceUnit unit;
        public float amount;
        public Distance(float amount, DistanceUnit unit){
            this.unit = unit;
            this.amount = amount;
        }
        public Distance(Distance distance){
            this.unit = distance.unit;
            this.amount = distance.amount;
        }
    }
    private class Duration{
        public int seconds;
        public int minutes;
        public int hours;
        public Duration(int seconds, int minutes, int hours){
            this.seconds = seconds;
            this.minutes = minutes;
            this.hours = hours;
        }

        public Duration(Duration duration){
            this.seconds = duration.seconds;
            this.minutes = duration.minutes;
            this.hours = duration.hours;
        }
    }

}
