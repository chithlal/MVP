package com.divinedev.mvp.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is the presenter module in MVP
 * All the app logic can be implemented here in any interface methods
 * We do all the complex stuff here.
 */

public class ApiPresenter implements ApiContract.ApiRepository {
    private  List<Item> item=new ArrayList<>();
    private ApiContract.ApiViews apiViews;

    /**
     *  Constructor binds our activity class to the interface object so that we can call the callback methods
      */


    public ApiPresenter(ApiContract.ApiViews apiViews){


        this.apiViews = apiViews;
    }

    /**
     * Notifying the activity or view that the data has been loaded to the adapter
     */
    @Override
    public void ShowItems() {
        apiViews.showProgress();
        getList();

    }

    /**
     * Network operations(Retrofit)
     * @return
     */
    private List<Item> getList(){

        final ApiCall apiCall=ServiceGenerator.getApiClient().create(ApiCall.class);
        Call<List<Item>> call=apiCall.LoadItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                item =response.body();

                apiViews.showToast("Items Loaded");
                //passing the list of items to the activity
                apiViews.setAdapter(item);
                apiViews.hideProgress();//Hiding the progress bar

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                apiViews.showToast(t.getMessage());//Showing some error messages
                apiViews.hideProgress();


            }
        });
        return item;

    }
}
