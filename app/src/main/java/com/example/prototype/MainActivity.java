package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;


public class MainActivity extends AppCompatActivity {
    MediaPlayer soundTest;
    int [] sounds;
    int [] pages;
    int current_index = 0;
    TextView txtView;
    int page1;
    int page2;
    int page3;
    int page4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page1 = (R.string.text_for_sound);
        page2 = (R.string.text_for_sound2);
        page3 = (R.string.text_for_sound3);
        page4 = (R.string.text_for_sound4);


        pages = new int[] {page1, page2, page3, page4};

        txtView = (TextView) findViewById(R.id.textDisplay);
        sounds = new int[] {R.raw.welcome_sound, R.raw.gettysburg10, R.raw.preamble10, R.raw.taunt};

        soundTest = MediaPlayer.create(this, sounds[current_index]);
        txtView.setText(pages[current_index]);
        Button playButton = (Button)this.findViewById(R.id.playButton);
        Button pauseButton = (Button)this.findViewById(R.id.pauseButton);
        Button stopButton = (Button)this.findViewById(R.id.stopButton);
        Button backButton = (Button)this.findViewById(R.id.backButton);
        Button nextButton = (Button)this.findViewById(R.id.nextButton);

        //onBackPressed();
        //soundTest.setOnCompletionListener(this);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //soundTest.start();

                //for (int i = current_index; i < sounds.length - 1; i++) {
                    play2();
                //}
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
                soundTest = MediaPlayer.create(MainActivity.this,sounds[current_index]);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                soundTest.stop();
//                if (current_index < sounds.length-1) {
//                    current_index++;
//                } else {
//                    current_index = 0;
//                }
//                soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
//                soundTest.start();
                playForForwardButton();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*soundTest.stop();
                if (current_index > 0) {
                    current_index--;
                } else {
                    current_index = sounds.length - 1;
                }
                soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
                soundTest.start();*/
                playBackButton();

            }
        });
        //for (int i = current_index; i < sounds.length - 1; i++){

        soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                play();
               // soundTest.start();

            }

        });
        //}




        }

    @Override
    public void onBackPressed() {
        soundTest.stop();
        super.onBackPressed();
        this.finish();

        Intent switchActivityIntent = new Intent(this, MainMenu.class);
        startActivity(switchActivityIntent);

    }

        private void play(){
            //for (int i = current_index; i < sounds.length - 1; i++) {
                if (current_index < sounds.length - 1) {
                    //soundTest.stop();
                    current_index++;

                    soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
                    txtView.setText(pages[current_index]);

                    soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            play();
                            // soundTest.start();

                        }

                    });

                    //soundTest.start();
                } else {
                    current_index = 0;

//                        soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
//                        soundTest.start();
                    soundTest.stop();
                    soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
                    txtView.setText(pages[current_index]);
                }
                soundTest.start();


        }

    private void playForForwardButton(){

        soundTest.stop();
        if (current_index < sounds.length-1) {
            current_index++;

            txtView.setText(pages[current_index]);
            soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                   playForForwardButton();
                    // soundTest.start();

                }

            });


        } else {
            current_index = 0;
        }

        soundTest.start();


    }

    private void playBackButton(){
        soundTest.stop();
        if (current_index > 0) {
            current_index--;
            txtView.setText(pages[current_index]);

            soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playBackButton();


                }

            });

        } else {
            //current_index = 0;

            soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);
            txtView.setText(pages[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    playBackButton();
                    current_index++;

                }

            });



        }
        soundTest.start();
    }

    private void play2() {
        soundTest.start();

       /* if (current_index < sounds.length - 1) {
            current_index++;


            soundTest = MediaPlayer.create(MainActivity.this, sounds[current_index]);

            soundTest.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    play2();
                    // soundTest.start();

                }

            });

        }*/
    }


}