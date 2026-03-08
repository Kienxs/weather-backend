package com.kienxs.weatherapp.controller;

import org.springframework.web.bind.annotation.*;

import com.kienxs.weatherapp.dto.ForecastResponse;
import com.kienxs.weatherapp.dto.WeatherResponse;
import com.kienxs.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*") // Run All
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherResponse getWeatherByCity(@RequestParam String city) {
        return weatherService.getWeatherInfo(city);
    }

    @GetMapping("/forecast")
    public ForecastResponse getForecastByCity(@RequestParam String city) {
        return weatherService.getForecastInfo(city);
    }

    @GetMapping("/search")
    public java.util.List<com.kienxs.weatherapp.dto.CitySuggestion> searchCities(@RequestParam String query) {
        return weatherService.searchCities(query);
    }
}