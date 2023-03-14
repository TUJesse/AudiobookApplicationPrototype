package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class QuizSelectionPage extends AppCompatActivity implements View.OnClickListener {

    TextView princessRose,LrrHood,threeLittlePigs;
    BottomNavigationView bottomNavigationView;

    /*HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    QuizFragment quizFragment = new QuizFragment();
    LogOutFragment logOutFragment = new LogOutFragment();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection_page);

        princessRose = (TextView)this.findViewById(R.id.princessRoseQuiz);
        LrrHood = (TextView)this.findViewById(R.id.littleRedRidingHoodQuiz);
        bottomNavigationView = (BottomNavigationView)this.findViewById(R.id.navBar);

        princessRose.setOnClickListener(this);
        LrrHood.setOnClickListener(this);

        /*princessRose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchQuiz();
            }
        });*/

        //getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();

        //set profile icon to selected
        bottomNavigationView.getMenu().findItem(R.id.quiz).setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        Intent intent1 = new Intent(QuizSelectionPage.this, MainMenu.class);
                        startActivity(intent1);
                        return false;
                    case R.id.profile:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        Intent intent2 = new Intent(QuizSelectionPage.this, UserProfile.class);
                        startActivity(intent2);
                        //set to false so that even after switching activity this activity will keep profile highlighted
                        return false;
                    case R.id.quiz:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFragment).commit();
                        return true;
                    case R.id.logOutIcon:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,logOutFragment).commit();
                        return false;
                }
                return false;
            }
        });
    }




    void switchQuiz(){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        TextView clickedOption = (TextView) view;
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("quizName", clickedOption.getText());
        this.startActivity(intent);
    }
}