package com.kienxs.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kienxs.weatherapp.dto.ForecastResponse;
import com.kienxs.weatherapp.dto.WeatherResponse;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    
    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeatherInfo(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public ForecastResponse getForecastInfo(String city) {
        String url = String.format("https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", city, apiKey);
        return restTemplate.getForObject(url, ForecastResponse.class);
    }

    public java.util.List<com.kienxs.weatherapp.dto.CitySuggestion> searchCities(String query) {
        // Gọi Geocoding API của OpenWeather, limit=5 để lấy 5 kết quả tốt nhất
        String url = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=5&appid=%s", query, apiKey);
        
        // Vì API trả về một mảng JSON -> mảng CitySuggestion[]
        com.kienxs.weatherapp.dto.CitySuggestion[] response = restTemplate.getForObject(url, com.kienxs.weatherapp.dto.CitySuggestion[].class);
        
        if (response != null) {
            return java.util.Arrays.asList(response);
        }
        return java.util.Collections.emptyList();
    }
}
