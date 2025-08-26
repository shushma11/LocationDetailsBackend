package com.example.LocationDetailsBackend.Dtos;

public class Tags {
    private String name;
    private String amenity;

    public Tags(String name, String amenity) {
        this.name = name;
        this.amenity = amenity;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
