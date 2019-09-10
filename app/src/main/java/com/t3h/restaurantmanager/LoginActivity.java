package com.t3h.restaurantmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.t3h.restaurantmanager.api.ApiBuilder;
import com.t3h.restaurantmanager.api.ResponsiveLogin;
import com.t3h.restaurantmanager.api.ResponsiveRegister;
import com.t3h.restaurantmanager.databinding.ActivityLoginBinding;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();


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
                        }

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


