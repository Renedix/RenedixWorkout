package com.workout.renedix.renedixworkout.setup.workout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.workout.renedix.renedixworkout.R;
import com.workout.renedix.renedixworkout.data.Database;
import com.workout.renedix.renedixworkout.data.Pojo.Workout;

import java.util.List;

import static android.support.v4.app.NavUtils.navigateUpFromSameTask;

public class WorkoutListFragment extends Fragment {

    SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_workout_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutForm.class);

                intent.putExtra(WorkoutForm.WORKOUT_ID, "");

                view.getContext().startActivity(intent);
            }
        });

        View recyclerView = v.findViewById(R.id.workout_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        simpleItemRecyclerViewAdapter.refreshData();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter();
        recyclerView.setAdapter(simpleItemRecyclerViewAdapter);
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private List<Workout> mValues;

        public SimpleItemRecyclerViewAdapter() {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.workout_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mContentView.setText(mValues.get(position).name);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, WorkoutForm.class);
                    intent.putExtra(WorkoutForm.WORKOUT_ID, Integer.toString(holder.mItem.id));

                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public void refreshData() {
            mValues = Database.getInstance().getWorkouts();
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mContentView;
            public Workout mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
