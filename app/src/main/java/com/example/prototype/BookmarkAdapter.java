package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public class BookmarkAdapter extends FirestoreRecyclerAdapter<Bookmark, BookmarkAdapter.BookmarkViewHolder> {

    Context context;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BookmarkAdapter(@androidx.annotation.NonNull FirestoreRecyclerOptions<Bookmark> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@androidx.annotation.NonNull BookmarkViewHolder holder, int position, @androidx.annotation.NonNull Bookmark bookmark) {
        holder.titleTextView.setText(bookmark.bookTitle);
        holder.pageTextView.setText(bookmark.pageNumber);
        holder.timestampTextView.setText(Utility.timestampToString(bookmark.timestamp));
    }

    @androidx.annotation.NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_bookmark_item,parent,false);
        return new BookmarkViewHolder(view);
    }

    class BookmarkViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView pageTextView;
        TextView timestampTextView;

        public BookmarkViewHolder(@NonNull View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.bookmark_title_text_view);
            pageTextView = itemView.findViewById(R.id.bookmark_page_text_view);
            timestampTextView = itemView.findViewById(R.id.bookmark_timestamp_text_view);
        }
    }
}
