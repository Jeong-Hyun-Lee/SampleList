package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        listView = (ListView) findViewById(R.id.list_view2);
//        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(mAdapter);
        Button b = (Button) findViewById(R.id.btn_delete);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int position = listView.getCheckedItemPosition();
                    String s = (String) listView.getItemAtPosition(position);
                    mAdapter.remove(s);

                } else if (listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
                    SparseBooleanArray array = listView.getCheckedItemPositions();
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; i < array.size(); i++) {
                        int position = array.keyAt(i);
                        if (array.get(position)) {
                            String s = (String) listView.getItemAtPosition(position);
                            list.add(s);
                        }
                    }
                    for (String s : list) {
                        mAdapter.remove(s);
                    }
                    listView.clearChoices();
                }
            }
        });
        init();
    }

    void init() {
        String[] item = getResources().getStringArray(R.array.items);
        mAdapter.addAll(item);
    }
}
