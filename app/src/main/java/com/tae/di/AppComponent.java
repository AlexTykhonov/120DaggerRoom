package com.tae.di;

import android.app.Application;

import com.tae.a120daggerroom.data.PersonDao;
import com.tae.a120daggerroom.repository.DemoDatabase;
import com.tae.a120daggerroom.repository.PersonRepository;
import com.tae.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    PersonDao personDao();

    DemoDatabase demoDatabase();

    PersonRepository personRepository();

    Application application();

}
