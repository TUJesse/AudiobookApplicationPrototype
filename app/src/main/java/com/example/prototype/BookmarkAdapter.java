package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

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
        holder.titleTextView.setText(bookmark.getBookTitle());
        holder.pageTextView.setText(bookmark.getPageNumber());
        holder.timestampTextView.setText(Utility.timestampToString(bookmark.getTimestamp()));

        holder.itemView.setOnClickListener((view) ->{
            String docId = this.getSnapshots().getSnapshot(position).getId();
            showPopupMenu(view, bookmark.getBookTitle(), docId, bookmark.getPageNumber());
        });
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

    private void showPopupMenu(View view, String Book, String docID, String pageNumber){
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_bookmark, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.goToBookmarkedPage){
                        Intent intent = new Intent(context,Book.class);
                        intent.putExtra("page",pageNumber);
                        intent.putExtra("bookTitle",Book);
                        context.startActivity(intent);

                } else if (menuItem.getItemId() == R.id.deleteBookmark){
                    deleteBookmarkFromFirebase(docID);
                }
                return true;
            }
        });
        popupMenu.show();

    }

    private void deleteBookmarkFromFirebase(String docID){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForBookmarks().document(docID);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(context,"Bookmark deleted successfully");
                }else {
                    Utility.showToast(context,"Bookmark deletion failed");

                }
            }
        });
    }
}
