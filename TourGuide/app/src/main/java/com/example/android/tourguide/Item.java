package com.example.android.tourguide;

public class Item {
    private String name;
    private String description;
    private String location;
    private int imageId;

    public Item(String n, String d, String l, int a){
        name = n; description = d;
        location = l; imageId = a;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }
}
