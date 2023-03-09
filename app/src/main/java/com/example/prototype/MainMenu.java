package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {

//    Button logOut,quizzes;
//    ImageButton menuBtn;
//    Button profilePage;
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    QuizFragment quizFragment = new QuizFragment();
    LogOutFragment logOutFragment = new LogOutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button bookOne = (Button)this.findViewById(R.id.bookOne);
        ImageButton bookTwo = (ImageButton)this.findViewById(R.id.bookTwo);
        ImageButton lrrh = (ImageButton)this.findViewById(R.id.littleRedRidingHood);
        ImageButton cinderella = (ImageButton)this.findViewById(R.id.Cinderella);
        ImageButton goldilocks = (ImageButton)this.findViewById(R.id.Goldilocks);
        ImageButton theFoxAndTheCrow = (ImageButton)this.findViewById(R.id.TheFoxAndTheCrow);
        ImageButton androcles = (ImageButton)this.findViewById(R.id.Androcles);
        ImageButton ratElephant = (ImageButton)this.findViewById(R.id.RatElephant);
//        Button ttsBook = (Button)this.findViewById(R.id.ttsBook);
//        logOut = (Button)this.findViewById(R.id.logOut);
//        menuBtn = (ImageButton)this.findViewById(R.id.menuButton);
//        profilePage = (Button)this.findViewById(R.id.profilePage);
//        quizzes = (Button)this.findViewById(R.id.quizButton);
        bottomNavigationView = (BottomNavigationView)this.findViewById(R.id.navBar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                    case R.id.quiz:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFragment).commit();
                        return true;
                    case R.id.logOutIcon:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,logOutFragment).commit();
                        return true;
                }
                return false;
            }
        });


        bookOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bookTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchBookTwo();
            }
        });

//    ttsBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchTtsBook();
//            }
//        });
//
//    logOut.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            logOutOfApp();
//        }
//    });
//
//    menuBtn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            showMenu();
//        }
//    });
//
//        profilePage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchToProfilePage();
//            }
//        });
//
        lrrh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchLittleRedRidingHood();
            }
        });
//
//        quizzes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchQuizzes();
//            }
//        });

        cinderella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchCinderella();
            }
        });

        goldilocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchGoldilocks();
            }
        });

        theFoxAndTheCrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTheFoxAndTheCrow();
            }
        });

        androcles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchAndrocles();
            }
        });

        ratElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchRatElephant();
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

    private void switchBookTwo(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.princess_rose_and_the_golden_bird_Title));
        startActivity(switchActivityIntent);
    }
    private void switchTtsBook(){
        Intent switchActivityIntent = new Intent(this, TextToSpeechPage.class);
        startActivity(switchActivityIntent);
    }

    private void switchLittleRedRidingHood(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.little_red_riding_hood_Title));
        startActivity(switchActivityIntent);;
    }

    private void switchQuizzes(){
        Intent switchActivityIntent = new Intent(this, QuizSelectionPage.class);
        startActivity(switchActivityIntent);
    }

    private void switchCinderella(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.Cinderella_title));
        startActivity(switchActivityIntent);
    }

    private void switchGoldilocks(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.Goldilocks_title));
        startActivity(switchActivityIntent);
    }

    private void switchTheFoxAndTheCrow(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.The_Fox_and_the_Crow_Title));
        startActivity(switchActivityIntent);
        }

    private void switchAndrocles(){
            Intent switchActivityIntent = new Intent(this, Book.class);
            switchActivityIntent.putExtra("bookTitle",getString(R.string.Androcles_and_the_Lion_Title));
            startActivity(switchActivityIntent);
        }

    private void switchRatElephant(){
        Intent switchActivityIntent = new Intent(this, Book.class);
        switchActivityIntent.putExtra("bookTitle",getString(R.string.The_Rat_and_the_Elephant_Title));
        startActivity(switchActivityIntent);
            }


}