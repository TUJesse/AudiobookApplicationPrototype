package com.example.prototype;

import android.content.Context;
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
    String title;
    String [] pageNumbers;
    TextView txtView;
    TextView pageNumberView;
    TextView titleView;
    ImageView imageView;
    ImageButton bookmarkButton;

    public BookBuilder(Builder builder){
        this.soundTest = builder.soundTest;
        this.sounds = builder.sounds;
        this.pages = builder.pages;
        this.images = builder.images;
        this.pageNumbers = builder.pageNumbers;
        this.txtView  = builder.txtView;
        this.pageNumberView = builder.pageNumberView;
        this.titleView = builder.titleView;
        this.title = builder.title;
        this.soundTest = builder.soundTest;
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
        String title;

        public Builder(String title, int numberOfPages, int [] sounds, int [] pages, int [] images, String[] pageNumbers){
            this.title = title;
            this.sounds = sounds;
            this.pages = pages;
            this.images = images;
            this.pageNumbers = pageNumbers;
        }

        public Builder setSoundTest(MediaPlayer soundTest) {
            this.soundTest = soundTest;
            return this;
        }

        public Builder setSounds(int[] sounds) {
            this.sounds = sounds;
            return this;
        }

        public Builder setPages(int[] pages) {
            this.pages = pages;
            return this;
        }

        public Builder setImages(int[] images) {
            this.images = images;
            return this;
        }

        public Builder setPageNumbers(int numberOfPages) {
            this.pageNumbers = new String[numberOfPages];
            return this;
        }

        public Builder setCurrent_index(int current_index) {
            this.current_index = current_index;
            return this;
        }

        public Builder setTxtView(TextView view) {
            this.txtView = (view);
            return this;
        }

        public Builder setPageNumberView(TextView pageNumberView) {
            this.pageNumberView = pageNumberView;
            return this;
        }

        public Builder setTitleView(String title) {
            this.titleView.setText(title);
            return this;
        }

        public Builder setImageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public BookBuilder build(){
            return new BookBuilder(this);
        }
    }
}
