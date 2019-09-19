package com.t3h.restaurantmanager.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.t3h.restaurantmanager.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodResponsive {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Food> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Food> getFood() {
        return data;
    }

    public void setFood(List<Food> data) {
        this.data = data;

    }

    @Override
    public String toString() {
        return "FoodResponsive{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}