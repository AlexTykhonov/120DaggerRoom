package com.tae.a120daggerroom.repository;

import android.arch.lifecycle.LiveData;

import com.tae.a120daggerroom.data.Person;

import java.util.List;


public interface PersonRepository {

    LiveData<Person> findById(int id);

    LiveData<List<Person>> findAll();

    long insert(Person person);

    int delete(Person person);

}
