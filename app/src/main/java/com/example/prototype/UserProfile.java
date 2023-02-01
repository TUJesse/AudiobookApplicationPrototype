package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfile extends AppCompatActivity {

    Button bookmarkPageBtn, completedBooksPageBtn, quizResultsPageBtn;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        bookmarkPageBtn = (Button)this.findViewById(R.id.bookmarkedBooks);
        completedBooksPageBtn = (Button)this.findViewById(R.id.booksCompleted);
        quizResultsPageBtn = (Button)this.findViewById(R.id.quizResults);
        email = (TextView)this.findViewById(R.id.userEmail);

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

            }
        });

        quizResultsPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    }

    private void displayEmail(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
           email.setText("Your email is: " + currentUser.getEmail());
        } else {
            email.setText("You are not logged in");
        }
    }
}