package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        editText = (EditText)findViewById(R.id.edit_list);
        listView = (ListView)findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(SimpleListActivity.this,item,Toast.LENGTH_SHORT).show();
            }
        });
        Button b =(Button)findViewById(R.id.btn_list);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text= editText.getText().toString();
                if(!TextUtils.isEmpty(text)){
                    mAdapter.add(text);
                    editText.setText("");
                    listView.smoothScrollToPosition(mAdapter.getCount()-1);
                }
            }
        });
        init();

    }
    void init(){
        String[] text = getResources().getStringArray(R.array.items);
        mAdapter.addAll(text);
    }
}
