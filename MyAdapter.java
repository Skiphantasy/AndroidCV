/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter {
    private Activity context;
    private ArrayAdapter<String> adapter;
    private String[] data;
    private ListView list;
    private ImageView imageView;
    private int[] images;
    private String[][] multi;


    public MyAdapter(Activity context, String[] data, String[][] multi, int[] images) {
        super(context, R.layout.my_adapter, data);
        this.multi = multi;
        this.context = context;
        this.images = images;
        this.data = data;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.my_adapter, null);
        TextView title = (TextView)item.findViewById(R.id.titlelist);
        title.setText(data[position]);
        imageView = item.findViewById(R.id.imglist);
        imageView.setImageResource(images[position]);
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, multi[position]);
        list = item.findViewById((R.id.listinside));
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return(item);
    }
}
