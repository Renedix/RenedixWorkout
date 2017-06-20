package com.workout.renedix.renedixworkout.data.dao;

import java.util.List;

/**
 * Created by RENEDIX-LAPTOP on 6/19/2017.
 */

public interface Dao<E> {

    public E getById(int id);

    public void add(E element);

    public void remove(int id);

    public List<E> list();

    public void update(E element);
}
