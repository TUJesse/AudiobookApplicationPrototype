package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button bookOne = (Button)this.findViewById(R.id.bookOne);
        Button bookTwo = (Button)this.findViewById(R.id.bookTwo);
        Button ttsBook = (Button)this.findViewById(R.id.ttsBook);

        bookOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchBookOne();
            }
        });

        bookTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchBookTwo();
            }
        });

    ttsBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTtsBook();
            }
        });
    }

    private void switchBookOne(){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchBookTwo(){
        Intent switchActivityIntent = new Intent(this, BookTwoActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchTtsBook(){
        Intent switchActivityIntent = new Intent(this, TextToSpeechPage.class);
        startActivity(switchActivityIntent);
    }
}