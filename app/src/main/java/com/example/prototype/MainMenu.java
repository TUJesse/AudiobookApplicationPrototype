package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {

    Button logOut,quizzes;
    ImageButton menuBtn;
    Button profilePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button bookOne = (Button)this.findViewById(R.id.bookOne);
        Button bookTwo = (Button)this.findViewById(R.id.bookTwo);
        Button lrrh = (Button)this.findViewById(R.id.littleRedRidingHood);
        Button ttsBook = (Button)this.findViewById(R.id.ttsBook);
        logOut = (Button)this.findViewById(R.id.logOut);
        menuBtn = (ImageButton)this.findViewById(R.id.menuButton);
        profilePage = (Button)this.findViewById(R.id.profilePage);
        quizzes = (Button)this.findViewById(R.id.quizButton);


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

    logOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            logOutOfApp();
        }
    });

    menuBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showMenu();
        }
    });

        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToProfilePage();
            }
        });

        lrrh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchLittleRedRidingHood();
            }
        });

        quizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchQuizzes();
            }
        });
    }

    private void showMenu(){

    }

    private void switchBookmarkPage(){
        Intent switchActivityIntent = new Intent(this, BookmarkPage.class);
        startActivity(switchActivityIntent);
    }
    private void switchToProfilePage(){
            Intent switchActivityIntent = new Intent(this, UserProfile.class);
            startActivity(switchActivityIntent);
        }

    private void logOutOfApp(){
        FirebaseAuth.getInstance().signOut();
        Intent switchActivityIntent = new Intent(this, loginPage.class);
        startActivity(switchActivityIntent);
        finish();
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

    private void switchLittleRedRidingHood(){
        Intent switchActivityIntent = new Intent(this, LittleRedRidingHoodBook.class);
        startActivity(switchActivityIntent);
    }

private void switchQuizzes(){
        Intent switchActivityIntent = new Intent(this, QuizSelectionPage.class);
        startActivity(switchActivityIntent);
    }


}