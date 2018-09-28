package com.divinedev.mvp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The service generator class returns an object of Retrofit client
 * Refer Retrofit 2 tutorials
 *
 */
public class ServiceGenerator {

    private static Retrofit retrofit;
    public static final String BASE_URL="YOUR API URL HERE";

    public static Retrofit getApiClient(){



    Retrofit.Builder retrofitBuilder  = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

     retrofit=retrofitBuilder.build();
     return retrofit;
    }



}
