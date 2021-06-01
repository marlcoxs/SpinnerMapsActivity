package com.example.mapsactivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ParseoJson {

    @GET("https://simplemaps.com/static/data/country-cities/it/it.json")
    Call<List<Ciudad>> listarCiudades();
}