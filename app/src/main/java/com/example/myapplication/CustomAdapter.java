package com.example.myapplication;

import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List sName,AddNo,vistDate;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<String> _sname, List<String> _addNo,List<String> date) {
        this.context = context;
        this.sName = _sname;
        this.AddNo = _addNo;
        this.vistDate = date;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return sName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.individual_list, null);
        TextView country = (TextView)           view.findViewById(R.id.textView);
        TextView addNo = (TextView)view.findViewById(R.id.addNo);
        TextView visitDate = (TextView) view.findViewById(R.id.visitDate);
        country.setText(sName.get(i).toString());
        addNo.setText(AddNo.get(i).toString());
        visitDate.setText(vistDate.get(i).toString());
        return view;
    }
    }

