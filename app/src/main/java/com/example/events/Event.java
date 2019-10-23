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

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName(){return name;}
    public String getDate(){return date;}
    public String getTime(){return time;}
    public String getLocation(){return location;}
    public String getDescription(){return description;}
}
