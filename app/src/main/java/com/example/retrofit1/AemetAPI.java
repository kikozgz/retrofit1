package com.example.retrofit1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AemetAPI {
    @GET("opendata/api/prediccion/especifica/municipio/diaria/{codigoINE}/")
    Call<WeatherResponse> getWeather(
            @Path("codigoINE") String codigoINE,
            @Query("fecha") String fecha,
            @Query("modo") String modo,
            @Query("api_key") String apiKey
    );
}