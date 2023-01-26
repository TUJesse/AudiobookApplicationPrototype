package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BookDecider extends AppCompatActivity {
    String title, pageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_decider);

        title = getIntent().getStringExtra("bookTitle");
        pageNumber = getIntent().getStringExtra("page");

        if (title.equals("Princess Rose And The Golden Bird")){
            Intent intent = new Intent(this,BookTwoActivity.class);
            intent.putExtra("page",pageNumber);
            this.startActivity(intent);
        }
    }
}