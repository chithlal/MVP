package com.divinedev.mvp.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface instantiated in every Apicall
 * Retrofit api
 */
public interface ApiCall {
    @GET("YOUR URL")
    Call<List<Item>> LoadItems();

}
