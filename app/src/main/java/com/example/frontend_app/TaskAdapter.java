package com.example.frontend_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, Task[] arr) {
        super(context, R.layout.task_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView)).setText(task.name);
        ((TextView) convertView.findViewById(R.id.textView2)).setText("Уровень:" + String.valueOf(task.levelCount));
        ((TextView) convertView.findViewById(R.id.textView3)).setText("Описание: " + String.valueOf(task.description));
        ((TextView) convertView.findViewById(R.id.textView4)).setText(String.valueOf(task.location));
        return convertView;
    }
}
