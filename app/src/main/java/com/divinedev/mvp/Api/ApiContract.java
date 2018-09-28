package com.divinedev.mvp.Api;


import java.util.List;

/**
 * This class and interface acts as communication channel between Model view and presenter
 *
 */
public class ApiContract {

    public interface ApiRepository{
        void ShowItems();


    }
    public interface ApiViews{
        void setAdapter(List<Item> list);
        void showToast(String message);
        void showProgress();
        void hideProgress();
    }

}
