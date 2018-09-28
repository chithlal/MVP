package com.divinedev.mvp.Api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Model class
 * Dummy class that stores individual items
 *
 * Implementing Serializable interface so that we can pass the instance
 * of this class thorough intents
 *
 * **** Create some setters and getters to manipulate data
 */

public class Item implements Serializable {

    // @SerializedName("id") Helps to find the json object id directly in retrofit
    @SerializedName("id")
    private final String item_id;
    @SerializedName("name")
    private final String item_name;
    @SerializedName("phone")
    private final String item_phone;
    @SerializedName("email")
    private final String item_email;

    public String getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_phone() {
        return item_phone;
    }

    public String getItem_email() {
        return item_email;
    }

    public Item(String item_id, String item_name, String item_phone, String item_email) {

        this.item_id = item_id;
        this.item_name = item_name;
        this.item_phone = item_phone;
        this.item_email = item_email;
    }


}
