package com.t3h.restaurantmanager.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<BD extends ViewDataBinding> extends AppCompatActivity {
    protected BD binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                getLayoutId());
        initAct();
    }

    protected abstract void initAct();

    protected abstract int getLayoutId();
}
