package com.example.prototype;

import android.app.Activity;
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

public class QuizResultsAdapter extends FirestoreRecyclerAdapter<QuizResults, QuizResultsAdapter.QuizResultViewHolder> {

    Context context;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public QuizResultsAdapter(@androidx.annotation.NonNull FirestoreRecyclerOptions<QuizResults> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@androidx.annotation.NonNull QuizResultViewHolder holder, int position, @androidx.annotation.NonNull QuizResults quizResults) {
        holder.titleTextView.setText(quizResults.getTitle());
        holder.scoreTextView.setText(quizResults.getScore());
        holder.timestampTextView.setText(Utility.timestampToString(quizResults.getTimestamp()));

        holder.itemView.setOnClickListener((view) ->{
            String docId = this.getSnapshots().getSnapshot(position).getId();
            showPopupMenu(view, quizResults.getTitle(), docId);
        });
    }

    @androidx.annotation.NonNull
    @Override
    public QuizResultViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_quiz_result_item,parent,false);
        return new QuizResultViewHolder(view);
    }

    class QuizResultViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView scoreTextView;
        TextView timestampTextView;

        public QuizResultViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.quiz_title_text_view);
            scoreTextView = itemView.findViewById(R.id.quiz_score_text_view);
            timestampTextView = itemView.findViewById(R.id.quiz_timestamp_text_view);
        }
    }
    private void showPopupMenu(View view, String title, String docID){
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_quiz_results, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.retakeQuiz){
                    Intent intent = new Intent(context,Quiz.class);
                    intent.putExtra("quizName",title);
                    deleteQuizResultFromFirebase(docID);
                    context.startActivity(intent);

                } else if (menuItem.getItemId() == R.id.deleteQuiz){
                    deleteQuizResultFromFirebase(docID);
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void deleteQuizResultFromFirebase(String docID){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForQuizResults().document(docID);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(context,"Quiz result deleted successfully");
                }else {
                    Utility.showToast(context,"Quiz result deletion failed");

                }
            }
        });
    }
}
