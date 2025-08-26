package com.example.LocationDetailsBackend.Dtos;

public class Element {
    private double lat;
    private double lon;
    private Tags tags;

    public Element(double lat, double lon, Tags tags) {
        this.lat = lat;
        this.lon = lon;
        this.tags = tags;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Element{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", tags=" + tags +
                '}';
    }
}
