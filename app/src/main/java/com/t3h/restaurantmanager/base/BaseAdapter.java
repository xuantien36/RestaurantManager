package com.t3h.restaurantmanager.base;

import android.content.Context;import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.restaurantmanager.BR;

import java.util.ArrayList;

public class BaseAdapter<T extends BaseModel> extends RecyclerView.Adapter<BaseAdapter.BaseHolder> {

    private ArrayList<T> data;
    private LayoutInflater inflater;
    private int layoutId;
    private BaseItemListener listener;

    public BaseAdapter(Context context, @LayoutRes int layoutId) {
        inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(BaseItemListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                layoutId, viewGroup, false);
        return new BaseHolder(binding);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseHolder baseHolder, int i) {
        T item = data.get(i);
        baseHolder.binding.setVariable(BR.item, item);
        baseHolder.binding.setVariable(BR.listener, listener);
        baseHolder.binding.executePendingBindings();
    }

    public class BaseHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public BaseHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface BaseItemListener{
    }
}
