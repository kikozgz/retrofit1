package com.example.retrofit1;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("nombre")
    private String cityName;
    @SerializedName("estadoCielo")
    private String skyState;
    @SerializedName("temperatura")
    private String temperature;

    // Constructor, getters y setters
}