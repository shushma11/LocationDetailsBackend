package com.example.LocationDetailsBackend;

import com.example.LocationDetailsBackend.Dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/filter")
    public LocationSearchDtoResponse[] searchLocation(
            @RequestBody LocationSearchDtoRequest locationSearchDtoRequest
    ){
        return locationService.searchAllLocations(locationSearchDtoRequest);
    }

    @PostMapping("/detail")
    public List<NearByLocationsDtoResponse> nearBySearchLocation(
            @RequestBody NearByLocationsDtorequest nearByLocationsDtorequest
            ){
        return locationService.nearByLocations(nearByLocationsDtorequest);
    }

    @PostMapping("/locationAndWeather")
    public LocationAndWeatherDtoResponse getLocationAndWeatherByLatAndLon(
            @RequestBody LocationAndWeatherDtoRequest locationAndWeatherDtoRequest
    ){
        return locationService.getLocationAndWeatherByLatAndLon(locationAndWeatherDtoRequest);
    }


}
