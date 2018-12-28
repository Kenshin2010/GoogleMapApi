package com.example.antsoft.googlemapapi.test;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antsoft.googlemapapi.R;

import java.util.ArrayList;

public class GridviewAdapter extends BaseAdapter {
    private ArrayList<String> listCountry;
    private ArrayList<Integer> listFlag;
    private Activity activity;

    public GridviewAdapter(Activity activity, ArrayList<String> listCountry, ArrayList<Integer> listFlag) {
        super();
        this.listCountry = listCountry;
        this.listFlag = listFlag;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listCountry.size();
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return listCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder {
        public ImageView imgViewFlag;
        public TextView txtViewTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();

        if (convertView == null) {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.gridview_row, parent, false);
            convertView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 350));
            view.txtViewTitle = (TextView) convertView.findViewById(R.id.grid_item_label);
            view.imgViewFlag = (ImageView) convertView.findViewById(R.id.grid_item_image);

            convertView.setTag(view);
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        view.txtViewTitle.setText(listCountry.get(position));
        view.imgViewFlag.setImageResource(listFlag.get(position));

        return convertView;
    }
}