package com.t3h.restaurantmanager.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiBuilder {
    private static Api api;

    public static Api getInstance(){
        if (api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.10.107/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }

}
