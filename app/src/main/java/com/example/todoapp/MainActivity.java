package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;
    private TextView TodoTextView;
    private static final String TODO_INDEX = "com.example.android_todo_app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null){
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todos);

        setContentView(R.layout.activity_main);

        TodoTextView = (TextView) findViewById(R.id.textViewTodo);


        TodoTextView.setText(mTodos[mTodoIndex]);

        
        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if (mTodoIndex < mTodos.length - 1) {
                            mTodoIndex += 1;
                        } else {
                            mTodoIndex = 0;
                        }

                        TodoTextView.setText(mTodos[mTodoIndex]);
                    }
                });

    }



    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mTodoIndex = savedInstanceState.getInt(TODO_INDEX);
        TodoTextView.setText(mTodos[mTodoIndex]);
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TODO_INDEX, mTodoIndex);
        super.onSaveInstanceState(savedInstanceState);
    }

}