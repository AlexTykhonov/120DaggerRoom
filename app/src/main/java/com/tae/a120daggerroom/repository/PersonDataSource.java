package com.tae.a120daggerroom.repository;

import android.arch.lifecycle.LiveData;

import com.tae.a120daggerroom.data.Person;
import com.tae.a120daggerroom.data.PersonDao;

import java.util.List;

import javax.inject.Inject;


public class PersonDataSource implements PersonRepository {

    private PersonDao personDao;

    @Inject
    public PersonDataSource(PersonDao personDao) { this.personDao = personDao;
    }

    @Override
    public LiveData<Person> findById(int id) {
        return personDao.findById(id);
    }

    @Override
    public LiveData<List<Person>> findAll() {
        return personDao.findAll();
    }

    @Override
    public long insert(Person person) {
        return personDao.insert(person);
    }

    @Override
    public int delete(Person person) {
        return personDao.delete(person);
    }
}
