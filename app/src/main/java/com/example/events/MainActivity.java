package com.example.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference data= FirebaseDatabase.getInstance().getReference();
    Event e;

    private AwesomeValidation awesomeValidation;

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

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(MainActivity.this, R.id.event_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(MainActivity.this, R.id.event_date, "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", R.string.dateerror);
//        awesomeValidation.addValidation(MainActivity.this, R.id.event_time, "\\b((1[0-2]|0?[0-9]):([0-5][0-9]) ([AaPp][Mm]))", R.string.timeerror);

//      awesomeValidation.addValidation(MainActivity.this,R.id.event_location,,R.string.locationerror);
//      awesomeValidation.addValidation(MainActivity.this,R.id.event_description,,R.string.descerror);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String event_name = null,event_time=null,event_date=null,event_location=null,event_desc=null;

                event_name=e1.getText().toString();
                event_date=e2.getText().toString();
                event_time=e3.getText().toString();
                event_location=e4.getText().toString();
                event_desc=e5.getText().toString();

                if(!TextUtils.isEmpty(event_name)&&!TextUtils.isEmpty(event_date)&&!TextUtils.isEmpty(event_time)&&!TextUtils.isEmpty(event_location)&&!TextUtils.isEmpty(event_desc)) {

                    if (awesomeValidation.validate())
                    {

                        e = new Event(event_name, event_date, event_time, event_location, event_desc);
                        data.child("events").push().setValue(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Event Added Successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }

                else
                {
                    Toast.makeText(MainActivity.this, "Fields should not be empty", Toast.LENGTH_SHORT).show();
                }
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
