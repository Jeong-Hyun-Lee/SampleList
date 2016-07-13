package com.example.tacademy.samplelist;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

public class MainActivity extends AppCompatActivity {
    PersonView personView,personView2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personView = (PersonView)findViewById(R.id.viewperson);
        personView2 = (PersonView)findViewById(R.id.viewperson2);
        init();
    }
    void init(){
        Drawable d = getResources().getDrawable(R.drawable.sample_0);
        Drawable d2 = getResources().getDrawable(R.drawable.sample_1);
        Person person = new Person("이정현",25,d);
        Person person2 = new Person("곽견훈",25,d2);
        img = (ImageView)findViewById(R.id.center_img);
        personView.setPerson(person);
        personView.setOnClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void imageClick(PersonView view, Person person) {
                img.setImageDrawable(person.getPhoto());
                img.setVisibility(View.VISIBLE);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.GONE);
            }
        });
        personView2.setPerson(person2);
        personView2.setOnClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void imageClick(PersonView view, Person person) {
                img.setImageDrawable(person.getPhoto());
                img.setVisibility(View.VISIBLE);
            }
        });
    }
}
