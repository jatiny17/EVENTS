package com.example.events;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Activity context, ArrayList<Event> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_display, parent, false);
        }

        Event current=getItem(position);

        TextView t1,t2,t3,t4;

        t1=(TextView)listItemView.findViewById(R.id.name);
        t2=(TextView)listItemView.findViewById(R.id.date);
        t3=(TextView)listItemView.findViewById(R.id.time);
        t4=(TextView)listItemView.findViewById(R.id.location);

        t1.setText(current.getName());
        t2.setText(current.getDate());
        t3.setText(current.getTime());
        t4.setText(current.getLocation());

        return listItemView;
    }
}
