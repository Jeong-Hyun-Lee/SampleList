package com.example.tacademy.samplelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tacademy.samplelist.data.ChattingData;
import com.example.tacademy.samplelist.data.DateData;
import com.example.tacademy.samplelist.data.ReceiveData;
import com.example.tacademy.samplelist.data.SendData;
import com.example.tacademy.samplelist.widget.DateView;
import com.example.tacademy.samplelist.widget.ReceiveView;
import com.example.tacademy.samplelist.widget.SendView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class ChattingAdapter extends BaseAdapter {
    List<ChattingData> items =new ArrayList<>();

    private final static int VIEW_TYPE_COUNT = 3;
    private final static int VIEW_TYPE_SEND = 0;
    private final static int VIEW_TYPE_RECEIVE = 1;
    private final static int VIEW_TYPE_DATE = 2;

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof SendData){
            return VIEW_TYPE_SEND;
        }else if(data instanceof ReceiveData){
            return VIEW_TYPE_RECEIVE;
        }else{
            return VIEW_TYPE_DATE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)){
            case VIEW_TYPE_SEND:{
                SendView view;
                if(convertView == null || !(convertView instanceof SendView)){
                    view = new SendView(parent.getContext());
                }else{
                    view = (SendView) convertView;
                }
                view.setData((SendData) items.get(position));
                return view;}
            case VIEW_TYPE_RECEIVE:{
                ReceiveView view;
                if(convertView == null || !(convertView instanceof ReceiveView)){
                    view = new ReceiveView(parent.getContext());
                }else{
                    view = (ReceiveView) convertView;
                }
                view.setData((ReceiveData) items.get(position));

                return view;
            }

            case VIEW_TYPE_DATE:
            default:
            {
                DateView view;
                if (convertView == null || !(convertView instanceof DateView)) {
                    view = new DateView(parent.getContext());
                } else {
                    view = (DateView)convertView;
                }
                view.setData((DateData)items.get(position));

                return view;
            }
        }
    }
}
