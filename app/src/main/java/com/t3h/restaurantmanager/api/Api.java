package com.t3h.restaurantmanager.api;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Api {
    @Multipart
    @POST("chat1902e/register.php")
    Call<ResponsiveRegister> register(
            @Part("user_name") RequestBody userNameBody,
            @Part("password") RequestBody password,
            @Part("name") RequestBody name);

    @Multipart
    @POST("chat1902e/login.php")
    Call<ResponsiveLogin> login(
            @Part("user_name") RequestBody userNameBody,
            @Part("password") RequestBody password);

    @GET("chat1902e/getfood.php")
    Call<FoodResponsive> getFoods();

}
