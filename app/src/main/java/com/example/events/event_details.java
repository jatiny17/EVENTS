package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class event_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        handleIntent();
    }

    private void handleIntent() {

        Intent i=getIntent();

        TextView t1,t2,t3,t4,t5;

        t1=(TextView)findViewById(R.id.name_detail);
        t2=(TextView)findViewById(R.id.date_detail);
        t3=(TextView)findViewById(R.id.time_detail);
        t4=(TextView)findViewById(R.id.location_detail);
        t5=(TextView)findViewById(R.id.description_detail);

        t1.setText(i.getStringExtra("Name"));
        t2.setText(i.getStringExtra("Date"));
        t3.setText(i.getStringExtra("Time"));
        t4.setText(i.getStringExtra("Location"));
        t5.setText(i.getStringExtra("Description"));

    }

}
