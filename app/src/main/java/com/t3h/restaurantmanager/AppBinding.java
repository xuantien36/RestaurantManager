package com.t3h.restaurantmanager;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

public class AppBinding {
    @BindingAdapter("thumb")
    public static void setThumb(ImageView im,String img){
        Glide.with(im)
                .load(img).error(R.drawable.ic_launcher_foreground)
                .into(im);


    }
}
