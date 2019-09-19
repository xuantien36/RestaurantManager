package com.t3h.restaurantmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.restaurantmanager.databinding.ItemFoodBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    private List<Food> data;
    private LayoutInflater inflater;
    private Context context;


    public List<Food> getData() {
        return data;
    }

    public FoodAdapter(Context context, List<Food> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;

    }

    public void setData(List<Food> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = ItemFoodBinding.inflate(inflater,
                parent, false);
        return new FoodHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        holder.binding.setItem(data.get(position));

    }
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder {
        private ItemFoodBinding binding;

        public FoodHolder(@NonNull ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

}
