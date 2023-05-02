package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    TextView emailAddress;
    TextView password;
    ProgressBar progressBar;
    TextView directToRegister;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailAddress = (TextView) findViewById(R.id.emailAddress);
        password = (TextView) findViewById(R.id.password);
        directToRegister = (TextView) findViewById(R.id.registerText);
        loginButton = (Button) findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        directToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerRedirect();
            }
        });
    }

    public void registerRedirect(){
        Intent switchActivityIntent = new Intent(this, RegisterPage.class);
        startActivity(switchActivityIntent);
        finish();
    }

    public void login(){
        String email = emailAddress.getText().toString();
        String pass = password.getText().toString();

        boolean isValid = validation(email, pass);
        if (!isValid){
            return;
        }
        loginAccountInFirebase(email, pass);
    }

    public void loginAccountInFirebase(String email, String pass){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    if (firebaseAuth.getCurrentUser().isEmailVerified()){
                        mainMenuRedirect();
                        finish();
                    } else {
                        Utility.showToast(loginPage.this, "Unverified email, please verify by clicking link emailed to you");

                    }
                } else{
                    Utility.showToast(loginPage.this, task.getException().getLocalizedMessage());
                }
            }
        });
    }

    private void mainMenuRedirect(){
        Intent switchActivityIntent = new Intent(this, MainMenu.class);
        startActivity(switchActivityIntent);
    }

    boolean validation(String email, String pass){
        if (email != null && pass != null){
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailAddress.setError("Invalid email");
                return false;
            }
            if (pass.length() < 5){
                password.setError("Password length must be greater than 5");
                return false;
            }
        }
        return true;
    }
}