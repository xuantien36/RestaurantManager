package com.t3h.restaurantmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.t3h.restaurantmanager.dao.AppDatabase;

public class DetailActivity extends AppCompatActivity {
    private ImageView imFood;
    //    private TextView tvName;
//    private TextView tvMota;
    private TextView tvGia;
    private FloatingActionButton fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detail);
        imFood = findViewById(R.id.im_food_detail);
//        tvName = findViewById(R.id.tv_name);
//        tvMota = findViewById(R.id.tv_mota);
        tvGia = findViewById(R.id.tv_gia);
        Intent intent = getIntent();
        final Food food = (Food) intent.getSerializableExtra("food");
        Glide.with(this).load(food.getPicture()).into(imFood);
        tvGia.setText("Giá:" + food.getPrice());
        fav = findViewById(R.id.fab);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fav.setImageDrawable(getResources().getDrawable(R.drawable.ic_grade_black_24dp));
                        long id= Long.parseLong(food.getId());
                        AppDatabase.getInstance(DetailActivity.this).getFoodDao().updateFavorite(id);

                    }
                });

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
