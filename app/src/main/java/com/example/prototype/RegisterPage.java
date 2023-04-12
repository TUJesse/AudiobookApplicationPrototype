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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {
    TextView emailAddress;
    TextView password;
    TextView confirmPassword;
    ProgressBar progressBar;
    TextView directToLogin;

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        emailAddress = (TextView) findViewById(R.id.emailAddress);
        password = (TextView) findViewById(R.id.password);
        confirmPassword = (TextView) findViewById(R.id.confirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        directToLogin = (TextView) findViewById(R.id.textViewLogin);

        registerButton = (Button) findViewById(R.id.registerBtn);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailAddress.getText().toString();
                String pass = password.getText().toString();
                String confirmPass = confirmPassword.getText().toString();

                boolean isValid = validation(email, pass, confirmPass);
                if (!isValid){
                    return;
                }
                createAccountInFirebase(email, pass);
            }
        });

        directToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRedirect();
            }
        });
    }

    boolean validation(String email, String pass, String confirmPass){
        if (email != null && pass != null && confirmPass != null){
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailAddress.setError("Invalid email");
                return false;
            }
            if (pass.length() < 5){
                password.setError("Password length must be greater than 5");
                return false;
            }
            if (!pass.equals(confirmPass)){
                confirmPassword.setError("Passwords do not match");
                return false;
            }
        }
        return true;
    }

    void createAccountInFirebase (String email, String password){
        changeLoading(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Utility.showToast(RegisterPage.this,"Account registered successfully, please Check email to verify");
                    //Toast.makeText(RegisterPage.this,"Account registered successfully, please Check email to verify", Toast.LENGTH_SHORT).show();
                    firebaseAuth.getCurrentUser().sendEmailVerification();
                    firebaseAuth.signOut();
                    //finish();
                }else {
                    Utility.showToast(RegisterPage.this, task.getException().getLocalizedMessage());
                    //Toast.makeText(RegisterPage.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    void changeLoading(boolean isLoading){
        if (isLoading){
            progressBar.setVisibility(View.VISIBLE);
            registerButton.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            registerButton.setVisibility(View.VISIBLE);
        }
    }

    private void loginRedirect(){
        Intent switchActivityIntent = new Intent(this, loginPage.class);
        startActivity(switchActivityIntent);
        finish();
    }
}