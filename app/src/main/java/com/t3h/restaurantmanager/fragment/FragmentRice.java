package com.t3h.restaurantmanager.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.restaurantmanager.Food;
import com.t3h.restaurantmanager.MyFoodAdapter;
import com.t3h.restaurantmanager.R;
import com.t3h.restaurantmanager.dao.AppDatabase;

import java.util.ArrayList;

public class FragmentRice extends Fragment {
    private ArrayList<Food> data;
    private RecyclerView recyclerView;
    private MyFoodAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_rice, container, false);
        data = new ArrayList<>();
        adapter = new MyFoodAdapter(getContext());
        recyclerView = v.findViewById(R.id.lv_favorite);
        recyclerView.setAdapter(adapter);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    private void initData() {
        data= (ArrayList<Food>) AppDatabase.getInstance(getContext()).getFoodDao().getAll();
        if (data != null) {
            adapter.setArr(data);
            Log.e("abc",data.toString());

        }

    }
}

