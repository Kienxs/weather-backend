package com.kienxs.weatherapp.dto;

import lombok.Data;
import java.util.List;

@Data
public class ForecastResponse {
    private List<ForecastItem> list; 
}

@Data
class ForecastItem {
    private String dt_txt; 
    private MainData main; 
    private List<Weather> weather; 
}