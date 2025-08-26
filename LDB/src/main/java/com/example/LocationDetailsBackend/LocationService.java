package com.example.LocationDetailsBackend;

import com.example.LocationDetailsBackend.Dtos.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LocationService {
    private static final double EARTH_RADIUS_KM = 6371.0;

    private final RestTemplate restTemplate = new RestTemplate();
    private Map<String, Object> eachLocation;

    public LocationSearchDtoResponse[] searchAllLocations(LocationSearchDtoRequest locationSearchDtoRequest){
        String address = "";
        for(String eachPart : locationSearchDtoRequest.getAddress().split("\\s+")){
            address = address + eachPart+"+";
        }
        address = address.substring(0,address.length()-1) + ",";
        address = address + "+"+locationSearchDtoRequest.getCity()+",";
        address = address+"+"+locationSearchDtoRequest.getCountry();

        String url = "https://nominatim.openstreetmap.org/search?q="+address+"&format=json";
        // System.out.println(url);
        LocationSearchDtoResponse[] responseArray = restTemplate.getForObject(url, LocationSearchDtoResponse[].class);
//        for(LocationSearchDtoResponse e : responseArray){
//            System.out.println(e.toString());
//        }
        return responseArray;
    }

    public LocationAndWeatherDtoResponse getLocationAndWeatherByLatAndLon(LocationAndWeatherDtoRequest locationAndWeatherDtoRequest){
        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat="+ locationAndWeatherDtoRequest.getLat()+"&lon="+ locationAndWeatherDtoRequest.getLon();
        LocationAndWeatherDtoResponse locationAndWeatherDtoResponse = restTemplate.getForObject(url, LocationAndWeatherDtoResponse.class);
        String url2 = "https://api.openweathermap.org/data/2.5/weather?lat="+locationAndWeatherDtoRequest.getLat()+"&lon="+locationAndWeatherDtoRequest.getLon()+"&appid=f695ee3debedce3bdbe46afca1b377f5";
        WeatherDtoResponse weatherDtoResponse = restTemplate.getForObject(url2,WeatherDtoResponse.class);
        locationAndWeatherDtoResponse.setClouds(weatherDtoResponse.getClouds().getAll());
        locationAndWeatherDtoResponse.setSunrise(weatherDtoResponse.getSys().getSunrise());
        locationAndWeatherDtoResponse.setSunset(weatherDtoResponse.getSys().getSunset());
        locationAndWeatherDtoResponse.setTemp(weatherDtoResponse.getMain().getTemp());
        locationAndWeatherDtoResponse.setTemp_max(weatherDtoResponse.getMain().getTemp_max());
        locationAndWeatherDtoResponse.setTemp_min(weatherDtoResponse.getMain().getTemp_min());
        return locationAndWeatherDtoResponse;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Compute differences
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));



        double value = EARTH_RADIUS_KM * c;
        value = Math.round(value * 100.0) / 100.0;
        return value;
    }

    public List<NearByLocationsDtoResponse> nearByLocations(NearByLocationsDtorequest nearByLocationsDtorequest){
        String lat = nearByLocationsDtorequest.getLat();
        String lon = nearByLocationsDtorequest.getLon();
        String url = "https://overpass-api.de/api/interpreter?data=[out:json];(node[\"amenity\"](around:700,"+lat+","+lon+"););out;";

        List<NearByLocationsDtoResponse> nearByLocationsDtoResponses = new ArrayList<>();

        NearByLocationsDto nearByLocationResponseArray  = restTemplate.getForObject(url,NearByLocationsDto.class);
        for(Element eachElement : nearByLocationResponseArray.getElements()){
            NearByLocationsDtoResponse nearByLocationsDtoResponse = new NearByLocationsDtoResponse();
            if (eachElement.getTags().getName() != null){
                nearByLocationsDtoResponse.setName(eachElement.getTags().getName());
                nearByLocationsDtoResponse.setDistance(calculateDistance(Double.valueOf(lat),Double.valueOf(lon),eachElement.getLat(),eachElement.getLon()));
                nearByLocationsDtoResponse.setAmenity(eachElement.getTags().getAmenity());
                nearByLocationsDtoResponse.setLat(eachElement.getLat());
                nearByLocationsDtoResponse.setLon(eachElement.getLon());
                nearByLocationsDtoResponses.add(nearByLocationsDtoResponse);
            }
        }

        Comparator<NearByLocationsDtoResponse> com = new Comparator<NearByLocationsDtoResponse>() {
            @Override
            public int compare(NearByLocationsDtoResponse o1, NearByLocationsDtoResponse o2) {
                if(o1.getDistance()>o2.getDistance()) {
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };
        return nearByLocationsDtoResponses;
    }
}
