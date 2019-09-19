package com.t3h.restaurantmanager.acttivity;

import android.content.Intent;
import android.view.View;

import com.t3h.restaurantmanager.R;
import com.t3h.restaurantmanager.api.ApiBuilder;
import com.t3h.restaurantmanager.api.ResponsiveRegister;
import com.t3h.restaurantmanager.base.BaseActivity;
import com.t3h.restaurantmanager.databinding.ActivityRegisterBinding;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {
    @Override
    protected void initAct() {
        init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    private void init() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.edtRegisterUser.getText().toString();
                String passWord = binding.edtRegisterPass.getText().toString();
                String name = binding.edtRegisterName.getText().toString();
                RequestBody userNameBody = RequestBody.create(MediaType.parse("text/plain"), userName);
                RequestBody passwordBody = RequestBody.create(MediaType.parse("text/plain"), passWord);
                RequestBody nameBody = RequestBody.create(MediaType.parse("text/plain"), name);
                ApiBuilder.getInstance().register(userNameBody, passwordBody, nameBody).enqueue(new Callback<ResponsiveRegister>() {
                    @Override
                    public void onResponse(Call<ResponsiveRegister> call, Response<ResponsiveRegister> response) {
                        if (response.body().getStatus() == 0) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsiveRegister> call, Throwable t) {

                    }
                });
            }
        });

    }
}




