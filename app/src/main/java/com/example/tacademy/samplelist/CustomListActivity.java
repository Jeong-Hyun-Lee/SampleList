package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {
    ListView listView;
    PersonAdapter mAdapter;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView)findViewById(R.id.list_view3);
        mAdapter = new PersonAdapter();
        listView.setAdapter(mAdapter);
        imgView = (ImageView)findViewById(R.id.img_listview);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setVisibility(View.GONE);
            }
        });
        mAdapter.setOnClickListImageListener(new PersonAdapter.OnClickListImageListener() {
            @Override
            public void listImageListener(PersonAdapter adapter, PersonView view, Person person) {
                imgView.setImageDrawable(person.getPhoto());
                imgView.setVisibility(View.VISIBLE);
            }
        });
        init();
    }
    int[] d={R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7};
    private void init(){
        Random r = new Random();
        for(int i =0 ; i<20; i++){
            Person p = new Person();
            p.setName("name "+i);
            int age = 20+r.nextInt(30);
            p.setAge(age);
            p.setPhoto(ContextCompat.getDrawable(this,d[i % d.length]));
            mAdapter.add(p);
        }
    }
}
