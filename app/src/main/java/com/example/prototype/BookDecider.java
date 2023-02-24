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
        } else if (title.equals("Little Red Riding Hood")){
            Intent intent = new Intent(this,LittleRedRidingHoodBook.class);
            intent.putExtra("page",pageNumber);
            this.startActivity(intent);
        }else if (title.equals("Cinderella")){
            Intent intent = new Intent(this,Cinderella.class);
            intent.putExtra("page",pageNumber);
            this.startActivity(intent);
        }else if (title.equals("Goldilocks")){
            Intent intent = new Intent(this,Goldilocks.class);
            intent.putExtra("page",pageNumber);
            this.startActivity(intent);
        }else if (title.equals("The Fox And The Crow")){
            Intent intent = new Intent(this,TheFoxAndTheCrow.class);
            intent.putExtra("page",pageNumber);
            this.startActivity(intent);
        }
    }
}