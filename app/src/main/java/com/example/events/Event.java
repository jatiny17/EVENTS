package com.example.events;

public class Event {

    private String name,location,time,date,description;

    public Event()
    {
        name="";
        location="";
        time="";
        date="";
        description="";
    }

    public Event(String name,String date,String time,String location,String description)
    {
        this.name=name;
        this.location=location;
        this.date=date;
        this.time=time;
        this.description=description;
    }

    public String getName(){return name;}
    public String getDate(){return date;}
    public String getTime(){return time;}
    public String getLocation(){return location;}
    public String getDescription(){return description;}
}
