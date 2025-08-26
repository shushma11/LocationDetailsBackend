package com.example.LocationDetailsBackend.Dtos;

public class LocationSearchDtoResponse {
    private String place_id;
    private String display_name;
    private String name;
    private String type;
    private String lat;
    private String lon;


    public LocationSearchDtoResponse(String place_id, String name, String display_name, String type, String lat, String lon) {
        this.place_id = place_id;
        this.name = name;
        this.display_name = display_name;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LocationSearchDtoResponse{" +
                "place_id='" + place_id + '\'' +
                ", display_name='" + display_name + '\'' +
                ", name='" + name + '\'' +
                ", addresstype='" + type + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
