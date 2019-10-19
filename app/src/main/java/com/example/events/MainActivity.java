package com.example.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference data= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b1,b2;
        final EditText e1,e2,e3,e4,e5;

        b1=(Button)findViewById(R.id.button_submit);
        b2=(Button)findViewById(R.id.button_next);

        e1=(EditText)findViewById(R.id.event_name);
        e2=(EditText)findViewById(R.id.event_date);
        e3=(EditText)findViewById(R.id.event_time);
        e4=(EditText)findViewById(R.id.event_location);
        e5=(EditText)findViewById(R.id.event_description);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String event_name = null,event_time=null,event_date=null,event_location=null,event_desc=null;

                try{
                    event_name=e1.getText().toString();
                }

                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                }

                try {
                    event_date=e2.getText().toString();
                }

                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter date", Toast.LENGTH_SHORT).show();

                }

                try {
                    event_time=e3.getText().toString();
                }

                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter time", Toast.LENGTH_SHORT).show();

                }

                try {
                    event_location=e4.getText().toString();
                }

                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter location", Toast.LENGTH_SHORT).show();

                }

                try {
                    event_desc=e5.getText().toString();
                }

                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please enter description", Toast.LENGTH_SHORT).show();

                }

                Event e=new Event(event_name,event_date,event_time,event_location,event_desc);
                data.child("events").push().setValue(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Event Added Successfully", Toast.LENGTH_SHORT).show();
                        }

                        else
                        {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,EventList.class);
                startActivity(i);
            }
        });
    }
}
