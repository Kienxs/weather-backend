package com.kienxs.weatherapp.dto;

import lombok.Data;

@Data
public class CitySuggestion {
    private String name;
    private String country;
    private String state; // Có thể null với một số quốc gia
}