package com.divinedev.mvp.Api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.divinedev.mvp.R;

import java.util.ArrayList;
import java.util.List;

public class ApiLoader extends AppCompatActivity implements ApiContract.ApiViews{
    RecyclerView recyclerView;
    ProgressBar progressBar;

    /**
     * The main activity class deals with view objects and listeners not with app logic
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_loader);
        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.progress_bar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Creating a instance of Presenter and calling the methods
        ApiPresenter apiPresenter=new ApiPresenter(this);
        apiPresenter.ShowItems();


    }


    /**
     * This override methods are from the contract interface that we are created
     * we can implement the view logic inside this method
     * @param list
     */
    @Override
    public void setAdapter(List<Item> list) {
        ApiAdapter apiAdapter = new ApiAdapter(getApplicationContext(),list);
        Toast.makeText(this, "AdapterAttached", Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(apiAdapter);
        

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("RETROFIT RESPO",message);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
