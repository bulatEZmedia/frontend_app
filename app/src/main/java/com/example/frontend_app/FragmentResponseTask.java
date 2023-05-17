package com.example.frontend_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentResponseTask extends Fragment {


    EditText editTextOffer;

    Button send;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText editTextOffer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_response_task, container, false);

        EditText editTextOffer =(EditText) view.findViewById(R.id.offer);

        Button send = view.findViewById(R.id.sendOffer);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResponseTask(view);
            }
        });
        return view;
    }
    public void ResponseTask(View view){
        String offer = editTextOffer.getText().toString();

        Bundle bundle = this.getArguments();
        Task task = new Gson().fromJson(bundle.getString("task"), Task.class);

        retrofit2.Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .responseTask(offer, task.id);

        call.enqueue(new retrofit2.Callback<ResponseBody>(){

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = response.body().toString();
                Toast.makeText(getActivity(), "иди нахуй", Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}