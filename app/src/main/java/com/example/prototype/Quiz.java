package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView, questionTextView;
    Button ansA,ansB,ansC,ansD,submitButton;

    int score = 0;
    //int totalQuestions = QuestionAnswer.questions.length;
    int totalQuestions;
    int index = 0;
    String selectedAnswer = "";
    String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Title = getIntent().getStringExtra("quizName");
        totalQuestions = QuestionAnswer.questionsDecider(getIntent().getStringExtra("quizName")).length;

        totalQuestionsTextView = this.findViewById(R.id.total_question);
        questionTextView = this.findViewById(R.id.question);
        ansA = this.findViewById(R.id.answer_A);
        ansB = this.findViewById(R.id.answer_B);
        ansC = this.findViewById(R.id.answer_C);
        ansD = this.findViewById(R.id.answer_D);
        submitButton = this.findViewById(R.id.submit_question);

        totalQuestionsTextView.setOnClickListener(this);
        questionTextView.setOnClickListener(this);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        loadQuestions();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit_question){
            if (selectedAnswer.equals(QuestionAnswer.correctAnswerDecider(getIntent().getStringExtra("quizName"))[index])){
                score++;
            }
            index++;
            loadQuestions();

        } else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    private void loadQuestions(){

        if (index == totalQuestions){
            finishQuiz();
            return;
        } else {
            totalQuestionsTextView.setText("Question " + (index+1) + " Out of " + totalQuestions);
            questionTextView.setText(QuestionAnswer.questionsDecider(getIntent().getStringExtra("quizName"))[index]);
            ansA.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("quizName"))[index][0]);
            ansB.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("quizName"))[index][1]);
            ansC.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("quizName"))[index][2]);
            ansD.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("quizName"))[index][3]);
        }
    }

    private void finishQuiz(){
        new AlertDialog.Builder(this).setMessage("Score is "+ score + " out of "+ totalQuestions).
                setPositiveButton("restart",(dialogInterface, i) -> restart()).setCancelable(false).
                setNegativeButton("save results and exit",(dialogInterface, i) -> saveQuizScore()).setCancelable(false).show();
    }

    private void quizPage(){
        Intent intent = new Intent(this, QuizSelectionPage.class);
        startActivity(intent);
        finish();
    }

    private void restart(){
        score = 0;
        index = 0;
        loadQuestions();
        totalQuestionsTextView.setText("Question " + (index+1) + " Out of " + totalQuestions);
    }

    void saveQuizScore (){
        String quizTitle = Title;
        String quizScore = score + " out of "+ totalQuestions;

        QuizResults quizResults = new QuizResults();
        quizResults.setTitle(quizTitle);
        quizResults.setScore(quizScore);
        quizResults.setTimestamp(Timestamp.now());

        saveQuizScoreToFirebase(quizResults);

        quizPage();
    }

    void saveQuizScoreToFirebase(QuizResults quizResults){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForQuizResults().document();

        documentReference.set(quizResults).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(Quiz.this,"result saved successfully");
                }else {
                    Utility.showToast(Quiz.this,"result didn't save");

                }
            }
        });
    }
}