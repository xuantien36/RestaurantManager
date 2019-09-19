package com.t3h.restaurantmanager.acttivity;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.t3h.restaurantmanager.R;
import com.t3h.restaurantmanager.api.ApiBuilder;
import com.t3h.restaurantmanager.api.ResponsiveLogin;
import com.t3h.restaurantmanager.base.BaseActivity;
import com.t3h.restaurantmanager.databinding.ActivityLoginBinding;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    @Override
    protected void initAct() {
        init();

    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    private void init() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.edtUser.getText().toString();
                String passWord = binding.edtPass.getText().toString();
                RequestBody userBody = RequestBody.create(MediaType.parse("text/plain"), userName);
                RequestBody passBody = RequestBody.create(MediaType.parse("text/plain"), passWord);
                ApiBuilder.getInstance().login(userBody, passBody).enqueue(new Callback<ResponsiveLogin>() {
                    @Override
                    public void onResponse(Call<ResponsiveLogin> call, Response<ResponsiveLogin> response) {
                        if (response.body().getStatus() == 0) {

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponsiveLogin> call, Throwable t) {

                    }
                });
            }
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.edtUser.getText().toString();
                String passWord = binding.edtPass.getText().toString();

                RequestBody userBody = RequestBody.create(MediaType.parse("text/plain"), userName);
                RequestBody passBody = RequestBody.create(MediaType.parse("text/plain"), passWord);
                ApiBuilder.getInstance().login(userBody, passBody).enqueue(new Callback<ResponsiveLogin>() {


                    @Override
                    public void onResponse(Call<ResponsiveLogin> call, Response<ResponsiveLogin> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponsiveLogin> call, Throwable t) {

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


