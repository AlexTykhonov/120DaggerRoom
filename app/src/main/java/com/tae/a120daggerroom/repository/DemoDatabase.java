package com.tae.a120daggerroom.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tae.a120daggerroom.data.Person;
import com.tae.a120daggerroom.data.PersonDao;


@Database(entities = {Person.class}, version = DemoDatabase.VERSION)
public abstract class DemoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract PersonDao getPersonDao();

}
