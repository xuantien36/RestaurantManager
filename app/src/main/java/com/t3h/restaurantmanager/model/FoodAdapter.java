package com.t3h.restaurantmanager.model;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.bumptech.glide.Glide;
import com.t3h.restaurantmanager.Food;
import com.t3h.restaurantmanager.base.BaseAdapter;

public class FoodAdapter extends BaseAdapter<Food> {
    Context context;

    public FoodAdapter(Context context, int layoutId) {
        super(context, layoutId);
        this.context = context;
    }

}


