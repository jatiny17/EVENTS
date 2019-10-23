package com.example.events;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EventList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        final ArrayList<Event> arrayList=new ArrayList<Event>();
//
//        arrayList.add(new Event("name","10-10-2009","12:00 am","asdfghjk","asdfghjk"));
//        arrayList.add(new Event("name","10-10-2009","12:00 am","asdfghjk","asdfghjk"));
//        arrayList.add(new Event("name","10-10-2009","12:00 am","asdfghjk","asdfghjk"));
//        arrayList.add(new Event("name","10-10-2009","12:00 am","asdfghjk","asdfghjk"));
//
//        RecyclerView recyclerView=findViewById(R.id.recycle_view);
//        final Recycler_adapter recycler_adapter=new Recycler_adapter(arrayList, this);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(recycler_adapter);

//
        final EventAdapter eventAdapter=new EventAdapter(this,arrayList);

        ListView lv=(ListView)findViewById(R.id.listView);

        lv.setAdapter(eventAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Event e=arrayList.get(i);

                Intent intent=new Intent(EventList.this,event_details.class);
                intent.putExtra("Name",e.getName());
                intent.putExtra("Time",e.getTime());
                intent.putExtra("Date",e.getDate());
                intent.putExtra("Location",e.getLocation());
                intent.putExtra("Description",e.getDescription());

                startActivity(intent);

//                Toast.makeText(EventList.this, e.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference data= FirebaseDatabase.getInstance().getReference();

        data.child("events").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Event e=dataSnapshot.getValue(Event.class);
                arrayList.add(e);
//                recycler_adapter.notifyDataSetChanged();
                  eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
