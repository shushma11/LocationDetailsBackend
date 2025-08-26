package com.example.LocationDetailsBackend.Dtos;

public class WeatherDtoResponse {
    private WeatherMain main;
    private WeatherSys sys;
    private WeatherClouds clouds;

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }

    public WeatherClouds getClouds() {
        return clouds;
    }

    public void setClouds(WeatherClouds clouds) {
        this.clouds = clouds;
    }
}
