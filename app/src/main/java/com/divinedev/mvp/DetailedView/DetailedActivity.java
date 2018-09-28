package com.divinedev.mvp.DetailedView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.divinedev.mvp.Api.Item;
import com.divinedev.mvp.R;

public class DetailedActivity extends AppCompatActivity implements DetailedContract.View {
    TextView id,name,phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        Item item=(Item)intent.getSerializableExtra("ITEM");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        id=findViewById(R.id.tv_detailed_id);
        name=findViewById(R.id.tv_detailed_name);
        email=findViewById(R.id.tv_detailed_mail);
        phone=findViewById(R.id.tv_detailed_phone);

        DetailedPresenter detailedPresenter = new DetailedPresenter(this);
        detailedPresenter.onItemReceived(item);

    }

    @Override
    public void ShowDetails(Item item) {
        id.setText(item.getItem_id());
        name.setText(item.getItem_name());
        email.setText(item.getItem_email());
        phone.setText(item.getItem_phone());

    }

    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
