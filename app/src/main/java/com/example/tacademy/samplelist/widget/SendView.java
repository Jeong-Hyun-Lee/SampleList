package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.SendData;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class SendView extends FrameLayout{
    public SendView(Context context) {
        super(context);
        init();
    }
    TextView text;
    ImageView img;
    private void init(){
        inflate(getContext(), R.layout.view_send, this);
        text = (TextView)findViewById(R.id.text_message);
        img = (ImageView)findViewById(R.id.image_photo);
    }
    SendData sd;
    public void setData(SendData sd){
        this.sd = sd;
        text.setText(sd.getMessage());
        img.setImageDrawable(sd.getPhoto());
    }
}
