package com.tae.a120daggerroom.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tae.a120daggerroom.R;
import com.tae.a120daggerroom.data.Person;
import com.tae.a120daggerroom.repository.PersonRepository;
import com.tae.a120daggerroom.di.AppModule;
import com.tae.a120daggerroom.di.DaggerAppComponent;
import com.tae.a120daggerroom.di.RoomModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public PersonRepository personRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        personRepository.findAll().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> persons) {
                Toast.makeText(MainActivity.this, String.format("Person size: %s", persons.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
