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

import java.util.ArrayList;

public class MyFoodAdapter extends RecyclerView.Adapter<MyFoodAdapter.FoodHolder> {
    private ArrayList<Food> arr;
    private LayoutInflater inflater;
    private ItemClickListener listener;

    public void setOnItemListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public MyFoodAdapter(Context context) {
        inflater = LayoutInflater.from(context);

    }

    public void setArr(ArrayList<Food> arr) {
        this.arr = arr;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_myfood, parent, false);
        return new FoodHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, final int position) {
        Food food = arr.get(position);
        holder.bindData(food);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClicked(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onLongClicked(position);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return arr == null ? 0 : arr.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder {
        private ImageView imgNews;
        private TextView tvName;
        private TextView tvDesc;

        public FoodHolder(@NonNull View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.im_food);
            tvName = itemView.findViewById(R.id.tv_giasp);
//            tvDesc = itemView.findViewById(R.id.tv_desc);
        }

        public void bindData(Food item) {
            tvName.setText("Giá:" +item.getPrice());
//            tvDesc.setText(item.getDesc());
            Glide.with(imgNews).load(item.getPicture()).into(imgNews);


        }
    }
    public interface ItemClickListener {
        void onClicked(int position);
        void onLongClicked(int position);

    }

}
