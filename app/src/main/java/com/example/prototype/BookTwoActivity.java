package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.util.Objects;

public class BookTwoActivity extends AppCompatActivity {
    MediaPlayer soundTest;
    int [] sounds;
    int [] pages;
    String [] pageNumbers = new String[5];
    int current_index = 0;
    TextView txtView;
    TextView pageNumberView;
    TextView titleView;
    ImageButton bookmarkButton;
    int page1;
    int page2;
    int page3;
    int page4;
    int page5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_two);

        page1 = (R.string.Princess_rose_and_the_golden_bird_p1);
        page2 = (R.string.Princess_rose_and_the_golden_bird_p2);
        page3 = (R.string.Princess_rose_and_the_golden_bird_p3);
        page4 = (R.string.Princess_rose_and_the_golden_bird_p4);
        page5 = (R.string.Princess_rose_and_the_golden_bird_p5);

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);

            if (Objects.equals(pageNumbers[i], getIntent().getStringExtra("page"))){
                current_index = i;
            }
        }

        pages = new int[] {page1, page2, page3, page4, page5};

        txtView = (TextView) findViewById(R.id.textDisplayBook2);
        pageNumberView = (TextView)this.findViewById(R.id.bookTwoPageNumber);
        titleView = (TextView)this.findViewById(R.id.bookTwoTitle);
        sounds = new int[] {R.raw.princess_rose_and_the_golden_bird1, R.raw.princess_rose_and_the_golden_bird2,
                R.raw.princess_rose_and_the_golden_bird3, R.raw.princess_rose_and_the_golden_bird4, R.raw.princess_rose_and_the_golden_bird5};

        pageNumberView.setText(pageNumbers[current_index]);
        soundTest = MediaPlayer.create(this, sounds[current_index]);
        txtView.setText(pages[current_index]);
        bookmarkButton = (ImageButton) this.findViewById(R.id.addBookmarkButton);
        Button playButton = (Button)this.findViewById(R.id.playButtonBook2);
        Button pauseButton = (Button)this.findViewById(R.id.pauseButtonBook2);
        Button stopButton = (Button)this.findViewById(R.id.stopButtonBook2);
        Button backButton = (Button)this.findViewById(R.id.backButtonBook2);
        Button nextButton = (Button)this.findViewById(R.id.nextButtonBook2);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play2();

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundTest.pause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundTest.stop();
                soundTest = MediaPlayer.create(BookTwoActivity.this,sounds[current_index]);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playForForwardButton();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playBackButton();

            }
        });

        soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                play();

            }

        });

        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookmark();
            }
        });
    }

    @Override
    public void onBackPressed() {
        soundTest.stop();
        super.onBackPressed();
        this.finish();

        Intent switchActivityIntent = new Intent(this, MainMenu.class);
        startActivity(switchActivityIntent);

    }

    private void play(){
        if (current_index < sounds.length - 1) {
            current_index++;

            soundTest = MediaPlayer.create(BookTwoActivity.this, sounds[current_index]);
            txtView.setText(pages[current_index]);
            pageNumberView.setText(pageNumbers[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    play();

                }

            });

        } else {
            current_index = 0;


            soundTest.stop();
            soundTest = MediaPlayer.create(BookTwoActivity.this, sounds[current_index]);
            txtView.setText(pages[current_index]);
            pageNumberView.setText(pageNumbers[current_index]);
        }
        soundTest.start();


    }

    private void playForForwardButton(){

        soundTest.stop();
        if (current_index < sounds.length-1) {
            current_index++;

            txtView.setText(pages[current_index]);
            pageNumberView.setText(pageNumbers[current_index]);
            soundTest = MediaPlayer.create(BookTwoActivity.this, sounds[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playForForwardButton();
                }

            });


        } else {
            current_index = 0;
        }

        soundTest.start();


    }

    private void playBackButton(){
        soundTest.stop();
        if (current_index > 0) {
            current_index--;
            txtView.setText(pages[current_index]);
            pageNumberView.setText(pageNumbers[current_index]);

            soundTest = MediaPlayer.create(BookTwoActivity.this, sounds[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playBackButton();


                }

            });

        } else {

            soundTest = MediaPlayer.create(BookTwoActivity.this, sounds[current_index]);
            txtView.setText(pages[current_index]);
            pageNumberView.setText(pageNumbers[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playBackButton();
                    current_index++;

                }

            });
        }
        soundTest.start();
    }

    private void play2() {
        soundTest.start();
    }

    void saveBookmark (){
        String bookTitle = titleView.getText().toString();
        String pageNumber = pageNumberView.getText().toString();

        Bookmark bookmark = new Bookmark();
        bookmark.setBookTitle(bookTitle);
        bookmark.setPageNumber(pageNumber);
        bookmark.setTimestamp(Timestamp.now());

        saveBookmarkToFirebase(bookmark);
    }

    void saveBookmarkToFirebase(Bookmark bookmark){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForBookmarks().document();

        documentReference.set(bookmark).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(BookTwoActivity.this,"Bookmark added successfully");
                }else {
                    Utility.showToast(BookTwoActivity.this,"Bookmark failed");

                }
            }
        });
    }


}