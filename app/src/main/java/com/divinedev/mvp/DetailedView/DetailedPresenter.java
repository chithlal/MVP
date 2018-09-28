package com.divinedev.mvp.DetailedView;

import com.divinedev.mvp.Api.Item;

public class DetailedPresenter implements DetailedContract.Logic {
    private DetailedContract.View detailedView;

    public DetailedPresenter(DetailedContract.View detailedView) {
        this.detailedView = detailedView;
    }


    @Override
    public void onItemReceived(Item item) {

        detailedView.ShowDetails(item);
        detailedView.ShowToast(item.getItem_name());
    }
}
