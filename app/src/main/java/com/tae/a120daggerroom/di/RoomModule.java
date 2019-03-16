package com.tae.a120daggerroom.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.tae.a120daggerroom.data.PersonDao;
import com.tae.a120daggerroom.repository.DemoDatabase;
import com.tae.a120daggerroom.repository.PersonDataSource;
import com.tae.a120daggerroom.repository.PersonRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private DemoDatabase demoDatabase;

    public RoomModule(Application mApplication) {
        demoDatabase = Room.databaseBuilder(mApplication, DemoDatabase.class, "person").build();
    }

    @Singleton
    @Provides
    DemoDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    PersonDao providesPersonDao(DemoDatabase demoDatabase) {
        return demoDatabase.getPersonDao();
    }

    @Singleton
    @Provides
    PersonRepository personRepository(PersonDao personDao) {
        return new PersonDataSource(personDao);
    }

}
