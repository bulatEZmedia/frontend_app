package com.example.frontend_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPage extends AppCompatActivity {

    private ListView taskListView;
    private Task[] tasksArray;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getAllTasks();
    }

    private void getAllTasks(){

        Call<List<Task>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllTasks();
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> tasksBody = response.body();

                tasksArray = new Task[tasksBody.size()];

                Log.d("taskBody", tasksBody.toString());
                Toast.makeText(MainPage.this, "HAHAHHA", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < tasksBody.size(); ++i){
                    tasksArray[i] = tasksBody.get(i);
                }

                adapter = new TaskAdapter(MainPage.this, tasksArray);
                taskListView = (ListView) findViewById(R.id.taskListView);
                taskListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Log.d("TASK", "FAIL: " + t);
            }
        });
    }






}