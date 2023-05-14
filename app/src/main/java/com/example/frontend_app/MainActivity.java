package com.example.frontend_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {

    TextView lastnameF;
    String username, name, surname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        lastnameF = (TextView) findViewById(R.id.register);
    }
}

    /*public void sendPOST(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        EditText name = (EditText) findViewById(R.id.name);
        EditText surname = (EditText) findViewById(R.id.surname);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        this.username = username.getText().toString();
        this.name = name.getText().toString();
        this.surname = surname.getText().toString();
        this.email = email.getText().toString();
        this.password = password.getText().toString();

        // создаем singleton объект клиента
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://172.20.10.2:8000/register").newBuilder();
        urlBuilder.addQueryParameter("username", this.username);
        urlBuilder.addQueryParameter("name", this.name);
        urlBuilder.addQueryParameter("surname", this.surname);
        urlBuilder.addQueryParameter("email", this.email);
        urlBuilder.addQueryParameter("password", this.password);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url("http://172.20.10.2:8000/register")
                .cacheControl(new CacheControl.Builder().maxStale(30, TimeUnit.DAYS).build())
                .build();
        // выполняем запрос
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // читаем данные в отдельном потоке
                    final String responseData = response.body().string();

                    // выполняем операции по обновлению UI
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lastnameF.setText(responseData);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

     */

