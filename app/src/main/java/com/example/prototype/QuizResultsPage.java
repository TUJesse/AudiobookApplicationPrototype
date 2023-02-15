package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class QuizResultsPage extends AppCompatActivity {

    ImageButton menuBtn;
    RecyclerView recyclerView;
    QuizResultsAdapter quizResultsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results_page);

        menuBtn = (ImageButton)this.findViewById(R.id.menuButton);
        recyclerView = (RecyclerView)this.findViewById(R.id.recycler_view);

        setRecyclerView();
    }
    private void setRecyclerView(){
        Query query = Utility.getCollectionReferenceForQuizResults().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<QuizResults> options = new FirestoreRecyclerOptions.Builder<QuizResults>().setQuery(query,QuizResults.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        quizResultsAdapter = new QuizResultsAdapter(options,this);
        recyclerView.setAdapter(quizResultsAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        quizResultsAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        quizResultsAdapter.stopListening();
    }

    @Override
    protected void onResume(){
        super.onResume();
        quizResultsAdapter.notifyDataSetChanged();
    }
}