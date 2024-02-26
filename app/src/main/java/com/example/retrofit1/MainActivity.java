package com.example.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView textViewWeather;
    private AemetAPI aemetAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWeather = findViewById(R.id.text_view_weather);

        // Crear una instancia de la interfaz de la API de AEMET
        aemetAPI = RetrofitClient.getClient("https://opendata.aemet.es/").create(AemetAPI.class);

        // Clave API de AEMET
        String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmamdvbWV6QGllc2NvbWVyY2lvLmNvbSIsImp0aSI6IjVlN2E0ZjkwLWE5ODYtNDE4YS04M2E5LWUxYjk3M2Q1YmM3ZCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNzA4OTYzMzE0LCJ1c2VySWQiOiI1ZTdhNGY5MC1hOTg2LTQxOGEtODNhOS1lMWI5NzNkNWJjN2QiLCJyb2xlIjoiIn0.ynSqaqC7mk5NYVNr0YMTggllV_uLiI8dezIPQu_acEk";

        // Realizar la solicitud para obtener los datos meteorológicos
        Call<WeatherResponse> call = aemetAPI.getWeather("26089", "hoy", "consulta", apiKey);

        // Agregar registro para imprimir la URL de la solicitud
        Log.d("Solicitud HTTP", call.request().url().toString());

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (!response.isSuccessful()) {
                    textViewWeather.setText("Code: " + response.code());
                    return;
                }

                WeatherResponse weatherResponse = response.body();
                if (weatherResponse != null) {
                    textViewWeather.setText(weatherResponse.toString());
                } else {
                    textViewWeather.setText("No se pudo obtener la respuesta");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                textViewWeather.setText(t.getMessage());
            }
        });
    }
}