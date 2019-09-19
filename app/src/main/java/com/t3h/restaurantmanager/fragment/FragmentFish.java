package com.t3h.restaurantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.restaurantmanager.BaseFragmentFish;
import com.t3h.restaurantmanager.DetailActivity;
import com.t3h.restaurantmanager.Food;
import com.t3h.restaurantmanager.FoodAdapter;
import com.t3h.restaurantmanager.MyFoodAdapter;
import com.t3h.restaurantmanager.R;
import com.t3h.restaurantmanager.acttivity.MainActivity;
import com.t3h.restaurantmanager.api.ApiBuilder;
import com.t3h.restaurantmanager.api.FoodResponsive;
import com.t3h.restaurantmanager.base.BaseFragment;
import com.t3h.restaurantmanager.databinding.FragmentFishBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFish extends Fragment implements Callback<FoodResponsive>, MyFoodAdapter.ItemClickListener {
    private MyFoodAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Food>data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fish, container, false);
        ApiBuilder.getInstance().getFoods().enqueue(this);
        data=new ArrayList<>();
        adapter = new MyFoodAdapter(getContext());
        recyclerView = v.findViewById(R.id.lv_food);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemListener(this);
        return v;
    }

    @Override
    public void onResponse(Call<FoodResponsive> call, Response<FoodResponsive> response) {
        ArrayList<Food> data = (ArrayList<Food>) response.body().getFood();
        if (data != null) {
            adapter.setArr(data);
            this.data=data;
            Log.d("TAG", "onResponse: " + data.toString());
        } else {
            Toast.makeText(getContext(), "Nothing to show!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<FoodResponsive> call, Throwable t) {

    }

    @Override
    public void onClicked(int position) {
        Intent intent=new Intent(getContext(),DetailActivity.class);
        intent.putExtra("food",data.get(position));
        startActivity(intent);

    }

    @Override
    public void onLongClicked(int position) {

    }
}

