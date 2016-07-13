package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends RelativeLayout {
    public PersonView(Context context) {
        this(context,null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private ImageView photoView;
    private TextView nameView, ageView;

    void init(){
        LayoutInflater i = LayoutInflater.from(getContext());
        i.inflate(R.layout.view_person,this);
//        inflate(getContext(), R.layout.view_person,this);
        photoView = (ImageView)findViewById(R.id.image_view);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.imageClick(PersonView.this, person);
            }
        });
    }

    private Person person;
    public void setPerson(Person person){
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText(""+person.getAge());
        photoView.setImageDrawable(person.getPhoto());
    }
    public Person getPerson(){
        return person;
    }
    public interface OnImageClickListener{
        public void imageClick(PersonView view, Person person);
    }
    OnImageClickListener mlistener;
    public void setOnClickListener(OnImageClickListener listener){
        this.mlistener = listener;
    }
}
