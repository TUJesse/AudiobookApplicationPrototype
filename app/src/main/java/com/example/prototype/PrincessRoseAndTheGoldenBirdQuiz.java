package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincessRoseAndTheGoldenBirdQuiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView, questionTextView;
    Button ansA,ansB,ansC,ansD,submitButton;

    int score = 0;
    int totalQuestions = QuestionAnswer.questions.length;
    int index = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princess_rose_and_the_golden_bird_quiz);

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
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[index])){
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
            questionTextView.setText(QuestionAnswer.questions[index]);
            ansA.setText(QuestionAnswer.answers[index][0]);
            ansB.setText(QuestionAnswer.answers[index][1]);
            ansC.setText(QuestionAnswer.answers[index][2]);
            ansD.setText(QuestionAnswer.answers[index][3]);
        }
    }

    private void finishQuiz(){
        new AlertDialog.Builder(this).setMessage("Score is "+ score + " out of "+ totalQuestions).
                setPositiveButton("restart",(dialogInterface, i) -> restart()).setCancelable(false).
                setNegativeButton("return to quiz page",(dialogInterface, i) -> quizPage()).setCancelable(false).show();
    }

    private void quizPage(){
        Intent intent = new Intent(this,QuizPage.class);
        startActivity(intent);
    }

    private void restart(){
        score = 0;
        index = 0;
        loadQuestions();
        totalQuestionsTextView.setText("Question " + (index+1) + " Out of " + totalQuestions);
    }
}