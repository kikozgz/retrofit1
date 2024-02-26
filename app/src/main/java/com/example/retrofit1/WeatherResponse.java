package com.example.retrofit1;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("nombre")
    private String cityName;
    @SerializedName("prediccion")
    private WeatherPrediction prediction;

    // Constructor, getters y setters
    public WeatherResponse(String cityName, WeatherPrediction prediction) {
        this.cityName = cityName;
        this.prediction = prediction;
    }


    @Override
    public String toString() {
        if (prediction != null) {
            return "Ciudad: " + cityName + "\n" +
                    "Detalles de la predicción meteorológica:\n" + prediction.toString();
        } else {
            return "Ciudad: " + cityName + "\n" +
                    "No hay datos de predicción meteorológica disponibles";
        }
    }


}

class WeatherPrediction {
    @SerializedName("estadoCielo")
    private String skyState;
    @SerializedName("temperatura")
    private String temperature;

    // Constructor, getters y setters

    @Override
    public String toString() {
        return "Estado del cielo: " + skyState + "\n" +
                "Temperatura: " + temperature;
    }
}
