package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class BookmarkPage extends AppCompatActivity {
    ImageButton menuBtn;
    RecyclerView recyclerView;
    BookmarkAdapter bookmarkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_page);

        menuBtn = (ImageButton)this.findViewById(R.id.menuButton);
        recyclerView = (RecyclerView)this.findViewById(R.id.recycler_view);

        setRecyclerView();

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
                //setRecyclerView();
            }
        });
    }

    private void showMenu(){

    }

    private void setRecyclerView(){
        Query query = Utility.getCollectionReferenceForBookmarks().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Bookmark> options = new FirestoreRecyclerOptions.Builder<Bookmark>().setQuery(query,Bookmark.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookmarkAdapter = new BookmarkAdapter(options,this);
        recyclerView.setAdapter(bookmarkAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        bookmarkAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        bookmarkAdapter.stopListening();
    }

    @Override
    protected void onResume(){
        super.onResume();
        bookmarkAdapter.notifyDataSetChanged();
    }
}