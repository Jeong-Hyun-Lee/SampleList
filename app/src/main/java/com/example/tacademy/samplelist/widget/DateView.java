package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.DateData;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class DateView extends FrameLayout{
    public DateView(Context context) {
        super(context);
        init();
    }
    TextView text;
    ImageView img;
    private void init(){
        inflate(getContext(), R.layout.view_date, this);
        text = (TextView)findViewById(R.id.text_message);
        img = (ImageView)findViewById(R.id.image_photo);
    }
    DateData dd;
    public void setData(DateData dd){
        this.dd = dd;
        text.setText(dd.getMessage());
    }
}
