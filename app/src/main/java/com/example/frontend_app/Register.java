package com.example.frontend_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;

public class Register extends AppCompatActivity {

    Button register, authorization;
    EditText editTextUsername;
    EditText editTextName;
    EditText editTextSurname;
    EditText editTextEmail;
    EditText editTextPassword;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        editTextUsername = findViewById(R.id.username);
        editTextName = findViewById(R.id.name);
        editTextSurname = findViewById(R.id.surname);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        Button register = findViewById(R.id.button3);
    }

    public void userSignUp() {
        String username = editTextUsername.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        retrofit2.Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(username, name, surname, email, password);

        Log.d("MAINACTIVITY2LOGTAG", call.request().body().toString());
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    if(s.equals("1")) {
                        Intent intent1 = new Intent(Register.this, MainPage.class);
                        startActivity(intent1);
                    } else {
                        Toast.makeText(Register.this, "иди нахуй", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Register.this, s, Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void signIn(View v) {

        try {
            Intent intent = new Intent(Register.this, Authorization.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View v){
            userSignUp();


        }

}

















