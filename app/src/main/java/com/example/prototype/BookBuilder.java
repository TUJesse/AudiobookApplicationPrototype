package com.example.prototype;

import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookBuilder extends AppCompatActivity {
    MediaPlayer soundTest;
    int [] sounds;
    int [] pages;
    int [] images;
    String [] pageNumbers;
    int current_index = 0;
    TextView txtView;
    TextView pageNumberView;
    TextView titleView;
    ImageView imageView;
    ImageButton bookmarkButton;
    int page1,page2,page3,page4,page5;

    public BookBuilder(Builder builder){
        this.soundTest = builder.soundTest;
        this.sounds = builder.sounds;
        this.pages = builder.pages;
        this.images = builder.images;
        this.pageNumbers = builder.pageNumbers;
        this.txtView  = builder.txtView;
        this.pageNumberView = builder.pageNumberView;
        this.titleView = builder.titleView;
    }

    public static class Builder{
        MediaPlayer soundTest;
        int [] sounds;
        int [] pages;
        int [] images;
        String [] pageNumbers;
        int current_index = 0;
        TextView txtView;
        TextView pageNumberView;
        TextView titleView;
        ImageView imageView;
        int page1,page2,page3,page4,page5;

        public Builder(String title, int numberOfPages, int [] sounds, int [] pages, int [] images, String[] pageNumbers){
            this.titleView.setText(title);
            //this.pageNumbers = new String[numberOfPages];
            this.sounds = sounds;
            this.pages = pages;
            this.images = images;
            this.pageNumbers = pageNumbers;
        }

        public void setSoundTest(MediaPlayer soundTest) {
            this.soundTest = soundTest;
        }

        public void setSounds(int[] sounds) {
            this.sounds = sounds;
        }

        public void setPages(int[] pages) {
            this.pages = pages;
        }

        public void setImages(int[] images) {
            this.images = images;
        }

        public void setPageNumbers(int numberOfPages) {
            this.pageNumbers = new String[numberOfPages];
        }

        public void setCurrent_index(int current_index) {
            this.current_index = current_index;
        }

        public void setTxtView(TextView view) {
            this.txtView = (view);
        }

        public void setPageNumberView(TextView pageNumberView) {
            this.pageNumberView = pageNumberView;
        }

        public void setTitleView(String title) {
            this.titleView.setText(title);
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public BookBuilder build(){
            return new BookBuilder(this);
        }
    }
}
