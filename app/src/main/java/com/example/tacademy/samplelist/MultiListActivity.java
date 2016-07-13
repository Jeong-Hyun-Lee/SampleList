package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.tacademy.samplelist.data.DateData;
import com.example.tacademy.samplelist.data.ReceiveData;
import com.example.tacademy.samplelist.data.SendData;

public class MultiListActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    ChattingAdapter mAdapter;
    RadioGroup messageType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list);
        editText = (EditText)findViewById(R.id.edit_message);
        messageType = (RadioGroup)findViewById(R.id.group_view_type);
        listView = (ListView)findViewById(R.id.listView4);
        mAdapter = new ChattingAdapter();

        listView.setAdapter(mAdapter);
        Button b = (Button)findViewById(R.id.btn_insert);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = editText.getText().toString();
                if(!TextUtils.isEmpty(t)){
                    switch (messageType.getCheckedRadioButtonId()){
                        case R.id.radio_send:
                            SendData sd;
                            sd= new SendData();
                            sd.setMessage(t);
                            sd.setPhoto(ContextCompat.getDrawable(MultiListActivity.this,R.drawable.sample_0));
                            mAdapter.add(sd);
                            break;
                        case R.id.radio_receive:
                            ReceiveData rd;
                            rd= new ReceiveData();
                            rd.setMessage(t);
                            rd.setPhoto(ContextCompat.getDrawable(MultiListActivity.this,R.drawable.sample_1));
                            mAdapter.add(rd);
                            break;
                        case R.id.radio_date:
                            DateData dd;
                            dd= new DateData();
                            dd.setMessage(t);
                            mAdapter.add(dd);
                            break;
                    }
                }
            }
        });
    }
}
