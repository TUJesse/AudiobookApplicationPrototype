package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizPage extends AppCompatActivity implements View.OnClickListener {

    TextView princessRose,LrrHood,threeLittlePigs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        princessRose = (TextView)this.findViewById(R.id.princessRoseQuiz);
        LrrHood = (TextView)this.findViewById(R.id.littleRedRidingHoodQuiz);

        princessRose.setOnClickListener(this);
        LrrHood.setOnClickListener(this);

        /*princessRose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchQuiz();
            }
        });*/
    }




    void switchQuiz(){
        Intent intent = new Intent(this,PrincessRoseAndTheGoldenBirdQuiz.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        TextView clickedOption = (TextView) view;
        Intent intent = new Intent(this,PrincessRoseAndTheGoldenBirdQuiz.class);
        intent.putExtra("quizName", clickedOption.getText());
        this.startActivity(intent);
    }
}