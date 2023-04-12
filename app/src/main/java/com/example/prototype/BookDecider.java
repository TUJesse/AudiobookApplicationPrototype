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

        Intent intent = new Intent(this,Book.class);
        intent.putExtra("page",pageNumber);
        intent.putExtra("bookTitle",getString(R.string.The_Rat_and_the_Elephant_Title));
        this.startActivity(intent);

    }
}