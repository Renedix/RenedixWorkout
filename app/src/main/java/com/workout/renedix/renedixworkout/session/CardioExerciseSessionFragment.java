package com.workout.renedix.renedixworkout.session;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.workout.renedix.renedixworkout.R;

/**
 * Created by RENEDIX-LAPTOP on 7/9/2017.
 */

public class CardioExerciseSessionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cardio_exercise_session_form, container, false);
    }
}
