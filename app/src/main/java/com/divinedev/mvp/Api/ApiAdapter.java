package com.divinedev.mvp.Api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divinedev.mvp.DetailedView.DetailedActivity;
import com.divinedev.mvp.R;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {
    private final Context context;
    private final List<Item> itemList;

    public ApiAdapter(Context context, List<Item> itemList){

        this.context = context;
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder apiViewHolder, int i) {

        final Item item=itemList.get(i);
        apiViewHolder.name.setText(item.getItem_name());
        apiViewHolder.id.setText(item.getItem_id());
       apiViewHolder. name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context,DetailedActivity.class);
                it.putExtra("ITEM",item);
                context.startActivity(it);
            }
        });

    }

    @Override
    public int getItemCount() {
        //Returns the count of item
        return itemList.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {
       TextView id,name;
        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_item_id);
            name = itemView.findViewById(R.id.tv_item_name);


        }
    }
}
