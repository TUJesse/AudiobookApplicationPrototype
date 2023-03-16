package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfile extends AppCompatActivity {

    Button bookmarkPageBtn, completedBooksPageBtn, quizResultsPageBtn;
    TextView email;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        bookmarkPageBtn = (Button)this.findViewById(R.id.bookmarkedBooks);
        completedBooksPageBtn = (Button)this.findViewById(R.id.booksCompleted);
        quizResultsPageBtn = (Button)this.findViewById(R.id.quizResults);
        email = (TextView)this.findViewById(R.id.userEmail);
        bottomNavigationView = (BottomNavigationView)this.findViewById(R.id.navBar);

        displayEmail();



        bookmarkPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToBookmarks();
            }
        });

        completedBooksPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpWindow(view);
            }
        });

        quizResultsPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToQuizResults();
            }
        });

       // getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();

        //set profile icon to selected
        bottomNavigationView.getMenu().findItem(R.id.profile).setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                    case R.id.home:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        Intent intent1 = new Intent(UserProfile.this, MainMenu.class);
                        startActivity(intent1);
                        finish();
                        //set to false so that even after switching activity this activity will keep profile highlighted
                        return false;
                    case R.id.quiz:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFragment).commit();
                        Intent intent2 = new Intent(UserProfile.this, QuizSelectionPage.class);
                        startActivity(intent2);
                        finish();
                        return false;
                    case R.id.logOutIcon:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,logOutFragment).commit();
                        logOutOfApp();
                        return false;
                }
                return false;
            }
        });


    }

    private void switchToBookmarks(){
        Intent switchActivityIntent = new Intent(this, BookmarkPage.class);
        startActivity(switchActivityIntent);
    }
    private void switchToCompletedBooks(){

    }
    private void switchToQuizResults(){
        Intent switchActivityIntent = new Intent(this, QuizResultsPage.class);
        startActivity(switchActivityIntent);
    }

    private void displayEmail(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
           email.setText("Your email is: " + currentUser.getEmail());
        } else {
            email.setText("You are not logged in");
        }
    }

    private void logOutOfApp(){
        FirebaseAuth.getInstance().signOut();
        Intent switchActivityIntent = new Intent(UserProfile.this, loginPage.class);
        startActivity(switchActivityIntent);
        finish();
    }

    public void popUpWindow(View view){

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupWindow = layoutInflater.inflate(R.layout.activity_pop_up_quiz,null);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        PopupWindow popupWindow = new PopupWindow(viewPopupWindow,(int)(width*.8),(int)(height*.6),true);
        //PopupWindow popupWindow = new PopupWindow(viewPopupWindow,900,900,true);

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

    }
}