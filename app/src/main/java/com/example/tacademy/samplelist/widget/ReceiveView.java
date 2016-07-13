package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.ReceiveData;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class ReceiveView extends FrameLayout{
    public ReceiveView(Context context) {
        super(context);
        init();
    }
    TextView text;
    ImageView img;
    private void init(){
        inflate(getContext(), R.layout.view_receive, this);
        text = (TextView)findViewById(R.id.text_message);
        img = (ImageView)findViewById(R.id.image_photo);
    }
    ReceiveData rd;
    public void setData(ReceiveData rd){
        this.rd = rd;
        text.setText(rd.getMessage());
        img.setImageDrawable(rd.getPhoto());
    }
}
