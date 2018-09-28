package com.divinedev.mvp.DetailedView;

import com.divinedev.mvp.Api.Item;

public class DetailedContract {
    public interface View{
         void ShowDetails(Item item);
        void ShowToast(String message);
    }
    public interface Logic{
        void onItemReceived(Item item);
    }
}
