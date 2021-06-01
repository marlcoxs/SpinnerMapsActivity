package com.example.mapsactivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeticionRetrofit {
    public static void pedirJSON (IRellenarSpinner referencia_llamante)
    {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://simplemaps.com/").addConverterFactory(GsonConverterFactory.create()).build();
        ParseoJson servicio_peticion=retrofit.create(ParseoJson.class);
        Call<List<Ciudad>> lista_ciudades=servicio_peticion.listarCiudades();
        lista_ciudades.enqueue(new Callback<List<Ciudad>>() {
            @Override
            public void onResponse(Call<List<Ciudad>> call, Response<List<Ciudad>> response) {
                List<Ciudad> lista_ciudades=response.body();
                Log.d("PARSEO: ", lista_ciudades.toString());
                referencia_llamante.rellenarSpinner(lista_ciudades);
            }

            @Override
            public void onFailure(Call<List<Ciudad>> call, Throwable t) {
                Log.d("ERROR: ", t.getLocalizedMessage());
            }
        });
    }
    public interface IRellenarSpinner
    {
        public void rellenarSpinner(List<Ciudad> ciudades);
    }
}