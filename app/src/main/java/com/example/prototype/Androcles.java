package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.util.Objects;

public class Androcles extends AppCompatActivity {

    MediaPlayer soundTest;
    int [] sounds;
    int [] pages;
    int [] images;
    String [] pageNumbers = new String[3];
    int current_index = 0;
    TextView txtView;
    TextView pageNumberView;
    TextView titleView;
    ImageView imageView;
    ImageButton bookmarkButton;
    int page1,page2,page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androcles);

        page1 = (R.string.Androcles_and_the_Lion_P1);
        page2 = (R.string.Androcles_and_the_Lion_P2);
        page3 = (R.string.Androcles_and_the_Lion_P3);

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);

            if (Objects.equals(pageNumbers[i], getIntent().getStringExtra("page"))){
                current_index = i;
            }
        }

        pages = new int[] {page1, page2, page3};

        txtView = (TextView) findViewById(R.id.textDisplayBook);
        pageNumberView = (TextView)this.findViewById(R.id.bookPageNumber);
        titleView = (TextView)this.findViewById(R.id.bookTitle);
        imageView = (ImageView)this.findViewById(R.id.imageView1);

        sounds = new int[] {R.raw.androcles_page_1, R.raw.androcles_page_2,
                R.raw.androcles_page_3};
    }
}