package com.kienxs.weatherapp.dto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {
    private String name; 
    private Coord coord;  
    private MainData main; 
    private List<Weather> weather;
    private Wind wind;
}

@Data
class Coord{
    private double lat;
    private double lon;
}

@Data
class MainData{
    private double temp;
    private double feels_like;
    private int humidity;
    private int pressure;
}   

@Data
class Weather{
    private String description;
    private String main;
    private String icon;
}

@Data
class Wind {
    private double speed;     
}