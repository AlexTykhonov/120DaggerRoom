package com.tae.a120daggerroom.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM Person WHERE id=:id")
    LiveData<Person> findById(int id);

    @Query("SELECT * FROM (Person)")
    LiveData<List<Person>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Person product);

    @Delete
    int delete(Person product);

}
