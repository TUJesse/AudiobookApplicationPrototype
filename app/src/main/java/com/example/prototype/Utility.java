package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility extends AppCompatActivity {

    static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getCollectionReferenceForBookmarks(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
       return FirebaseFirestore.getInstance().collection("bookmarks").document(currentUser.getUid()).collection("my_bookmarks");
    }

    static CollectionReference getCollectionReferenceForQuizResults(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("quizResults").document(currentUser.getUid()).collection("my_quizResults");
    }

    static String timestampToString(Timestamp timestamp){
       return new SimpleDateFormat("MM/dd/yyyy").format(timestamp.toDate());
    }

}
