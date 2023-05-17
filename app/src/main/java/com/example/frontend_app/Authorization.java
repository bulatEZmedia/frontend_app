package com.example.frontend_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class Authorization extends AppCompatActivity {


    EditText editTextEmail;

    EditText editTextPassword;

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        button2 = findViewById(R.id.button2);

    }

    public void userSignIn(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        retrofit2.Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .authorization(email, password);
        Log.d("AUTHORIZATION", "user sign in calling");
        call.enqueue(new retrofit2.Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Log.d("t", s);
                    if(s.equals("1")) {
                        Intent intent = new Intent(Authorization.this, MainPage.class);
                        startActivity(intent);
                    } else {
                      Toast.makeText(Authorization.this, "иди нахуй", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Authorization.this, s, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Authorization.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v){
        if (v.getId() == R.id.button2) {
            userSignIn();
        }
    }

    public void signUp(View v){
        try {
            Intent intent = new Intent(Authorization.this, Register.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT).show();
        }
    }
}
