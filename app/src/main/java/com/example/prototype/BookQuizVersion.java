package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import java.util.Objects;

public class BookQuizVersion extends AppCompatActivity {

    LayoutInflater layoutInflater;

    View viewPopupWindow;

    DisplayMetrics dm;
    PopupWindow popupWindow;

    TextView totalQuestionsTextView, questionTextView;
    Button ansA,ansB,ansC,ansD,submitButton;

    int score = 0;
    int totalQuestions;
    int index = 0;
    String selectedAnswer = "";
    String Title;

    ImageButton playButton;
    ImageButton pauseButton;
    ImageButton stopButton;
    ImageButton backButton;
    ImageButton nextButton;

    MediaPlayer soundTest;
    int current_index = 0;
    TextView txtView;
    TextView titleView;
    TextView pageNumberView;
    ImageView imageView;
    ImageButton bookmarkButton;

    BookBuilder Audiobook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_quiz_version);

        if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.Androcles_and_the_Lion_Title))){
            Audiobook = new BookDirector().getAndrocles();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.The_Rat_and_the_Elephant_Title))){
            Audiobook = new BookDirector().getRatElephant();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.Cinderella_title))){
            Audiobook = new BookDirector().getCinderella();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.Goldilocks_title))){
            Audiobook = new BookDirector().getGoldilocks();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.little_red_riding_hood_Title))){
            Audiobook = new BookDirector().getLittleRedRidingHood();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.The_Fox_and_the_Crow_Title))){
            Audiobook = new BookDirector().getTheFoxAndTheCrow();
        }else if (getIntent().getStringExtra("bookTitle").equals(getString(R.string.princess_rose_and_the_golden_bird_Title))){
            Audiobook = new BookDirector().getPrincessRoseAndTheGoldenBird();
        }

        Title = getIntent().getStringExtra("bookTitle");
        totalQuestions = QuestionAnswer.questionsDecider(getIntent().getStringExtra("bookTitle")).length;

        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        viewPopupWindow = layoutInflater.inflate(R.layout.activity_pop_up_quiz,null);

        dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        popupWindow = new PopupWindow(viewPopupWindow,(int)(width*.9),(int)(height*.7),true);


        for (int i = 0; i < Audiobook.pageNumbers.length; i ++){

            if (Objects.equals(Audiobook.pageNumbers[i], getIntent().getStringExtra("page"))){
                current_index = i;
            }
        }

        txtView = (TextView)this.findViewById(R.id.textDisplayBook);
        pageNumberView = (TextView)this.findViewById(R.id.bookPageNumber);
        titleView = (TextView)this.findViewById(R.id.bookTitle);
        imageView = (ImageView)this.findViewById(R.id.imageView1);



        pageNumberView.setText(Audiobook.pageNumbers[current_index]);
        txtView.setText(Audiobook.pages[current_index]);
        soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
        titleView.setText(Audiobook.title);
        imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[current_index]));
        bookmarkButton = (ImageButton) this.findViewById(R.id.addBookmarkButton);
         playButton = (ImageButton) this.findViewById(R.id.playButtonBook);
         pauseButton = (ImageButton)this.findViewById(R.id.pauseButtonBook);
         stopButton = (ImageButton)this.findViewById(R.id.stopButtonBook);
         backButton = (ImageButton)this.findViewById(R.id.backButtonBook);
         nextButton = (ImageButton)this.findViewById(R.id.nextButtonBook);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play2();

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundTest.pause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundTest.stop();
                soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playForForwardButton(view);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playBackButton(view);

            }
        });

        soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                View view = playButton.getRootView();
                play(view);

            }

        });

        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookmark();
            }
        });

    }

    @Override
    public void onBackPressed() {
        soundTest.stop();
        super.onBackPressed();
        this.finish();

        Intent switchActivityIntent = new Intent(this, MainMenu.class);
        startActivity(switchActivityIntent);

    }

    private void play(View view){
        if (current_index < Audiobook.sounds.length - 1) {
            popUpWindow(view);
            //current_index++;

            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
            txtView.setText(Audiobook.pages[current_index]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[current_index]));
            pageNumberView.setText(Audiobook.pageNumbers[current_index]);
//            popUpWindow(view);
            //soundTest.start();


            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    play(view);

                }

            });

        } else {
            popUpWindow(view);
            //current_index = 0;


            //soundTest.stop();
            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[0]);
            txtView.setText(Audiobook.pages[0]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[0]));
            pageNumberView.setText(Audiobook.pageNumbers[0]);
//            popUpWindow(view);
        }
//        soundTest.start();


    }

    private void playForForwardButton(View view){

        soundTest.stop();
        if (current_index < Audiobook.sounds.length-1) {
            popUpWindow(view);
            //current_index++;

            txtView.setText(Audiobook.pages[current_index]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[current_index]));
            pageNumberView.setText(Audiobook.pageNumbers[current_index]);
            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
            //soundTest.start();

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    //playForForwardButton(view);
                    play(view);
                }

            });


        } else {
            popUpWindow(view);
            //current_index = 0;

            txtView.setText(Audiobook.pages[0]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[0]));
            pageNumberView.setText(Audiobook.pageNumbers[0]);
            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[0]);
//            popUpWindow(view);
        }

//        soundTest.start();


    }

    private void playBackButton(View view){
        soundTest.stop();
        if (current_index > 0) {
            current_index--;
            txtView.setText(Audiobook.pages[current_index]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[current_index]));
            pageNumberView.setText(Audiobook.pageNumbers[current_index]);

            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
            soundTest.start();


            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    play(view);


                }

            });

        } else {

            current_index = 0;
            //soundTest = MediaPlayer.create(Book.this, Audiobook.sounds[current_index]);
            txtView.setText(Audiobook.pages[current_index]);
            imageView.setImageDrawable(getResources().getDrawable(Audiobook.images[current_index]));
            pageNumberView.setText(Audiobook.pageNumbers[current_index]);
            soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);


            /*soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playBackButton();
                    current_index++;

                }

            });*/
        }
//        soundTest.start();
    }

    private void play2() {
        soundTest.start();
    }

    void saveBookmark (){
        String bookTitle = titleView.getText().toString();
        String pageNumber = pageNumberView.getText().toString();

        Bookmark bookmark = new Bookmark();
        bookmark.setBookTitle(bookTitle);
        bookmark.setPageNumber(pageNumber);
        bookmark.setTimestamp(Timestamp.now());

        saveBookmarkToFirebase(bookmark);
    }

    void saveBookmarkToFirebase(Bookmark bookmark){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForBookmarks().document();

        documentReference.set(bookmark).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(BookQuizVersion.this,"Bookmark added successfully");
                }else {
                    Utility.showToast(BookQuizVersion.this,"Bookmark failed");

                }
            }
        });
    }

    private void startQuiz(){
        new AlertDialog.Builder(this).setMessage("Do you wish to take the quiz").
                setPositiveButton("Take Quiz",(dialogInterface, i) -> takeQuiz()).setCancelable(false).
                setNegativeButton("Maybe Later",(dialogInterface, i) -> restartBook()).setCancelable(false).show();
    }

    private void takeQuiz(){
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("bookTitle", titleView.getText().toString());
        this.startActivity(intent);
    }

    private void restartBook(){
        score = 0;
        current_index = 0;
    }

    public void popUpWindow(View view){

        totalQuestionsTextView = viewPopupWindow.findViewById(R.id.total_question);
        questionTextView = viewPopupWindow.findViewById(R.id.question);
        ansA = viewPopupWindow.findViewById(R.id.answer_A);
        ansB = viewPopupWindow.findViewById(R.id.answer_B);
        ansC = viewPopupWindow.findViewById(R.id.answer_C);
        ansD = viewPopupWindow.findViewById(R.id.answer_D);
        submitButton = viewPopupWindow.findViewById(R.id.submit_question);

        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });
        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });
        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });
        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(view);
            }
        });

        loadQuestions();
        current_index++;

        //_____________________________________________________________________________________________________________________________________________________________________________
        //show popup window
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        setButtonsUnClickable();
        popupWindow.setAnimationStyle(androidx.appcompat.R.style.Animation_AppCompat_DropDownUp);

    }

    private void setButtonsUnClickable(){
        playButton.setClickable(false);
        pauseButton.setClickable(false);
        stopButton.setClickable(false);
        backButton.setClickable(false);
        nextButton.setClickable(false);
        bookmarkButton.setClickable(false);
    }

    private void setButtonsClickable(){
        playButton.setClickable(true);
        pauseButton.setClickable(true);
        stopButton.setClickable(true);
        backButton.setClickable(true);
        nextButton.setClickable(true);
        bookmarkButton.setClickable(true);
    }

    public void clicked(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit_question){
            if (selectedAnswer.equals(QuestionAnswer.correctAnswerDecider(getIntent().getStringExtra("bookTitle"))[current_index-1])){
                score++;
            }
            //index++;
           /* viewPopupWindow.clearFocus();
            bookmarkButton.getRootView().requestFocus();*/

            popupWindow.dismiss();
            loadQuestions();

            if (current_index < totalQuestions){
            soundTest.start();
            }




        } else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
        setButtonsClickable();

    }

    private void loadQuestions(){

        if (current_index == totalQuestions){
            finishQuiz();
            return;
        } else {
            totalQuestionsTextView.setText("Question " + (current_index+1) + " Out of " + totalQuestions);
            questionTextView.setText(QuestionAnswer.questionsDecider(getIntent().getStringExtra("bookTitle"))[current_index]);
            ansA.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("bookTitle"))[current_index][0]);
            ansB.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("bookTitle"))[current_index][1]);
            ansC.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("bookTitle"))[current_index][2]);
            ansD.setText(QuestionAnswer.answerDecider(getIntent().getStringExtra("bookTitle"))[current_index][3]);
        }
    }

    private void finishQuiz(){
        new AlertDialog.Builder(this).setMessage("Score is "+ score + " out of "+ totalQuestions).
                setPositiveButton("restart",(dialogInterface, i) -> restart()).setCancelable(false).
                setNegativeButton("save results and exit",(dialogInterface, i) -> saveQuizScore()).setCancelable(false).show();
    }

    private void MainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    private void restart(){
        soundTest.stop();
        score = 0;
        current_index = 0;
        soundTest = MediaPlayer.create(BookQuizVersion.this, Audiobook.sounds[current_index]);
        //loadQuestions();
        totalQuestionsTextView.setText("Question " + (index+1) + " Out of " + totalQuestions);
    }

    void saveQuizScore (){
        soundTest.stop();
        String quizTitle = Title;
        String quizScore = score + " out of "+ totalQuestions;

        QuizResults quizResults = new QuizResults();
        quizResults.setTitle(quizTitle);
        quizResults.setScore(quizScore);
        quizResults.setTimestamp(Timestamp.now());

        saveQuizScoreToFirebase(quizResults);

        MainMenu();
    }

    void saveQuizScoreToFirebase(QuizResults quizResults){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForQuizResults().document();

        documentReference.set(quizResults).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Utility.showToast(getBaseContext(),"result saved successfully");
                }else {
                    Utility.showToast(getBaseContext(),"result didn't save");

                }
            }
        });
    }

}