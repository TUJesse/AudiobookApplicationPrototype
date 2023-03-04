package com.example.prototype;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class BookDirector extends AppCompatActivity {

    public static BookBuilder getAndrocles(){

        int[] sounds = new int[] {R.raw.androcles_page_1, R.raw.androcles_page_2,
                R.raw.androcles_page_3};

        String [] pageNumbers = new String[3];

        int page1,page2,page3;

        page1 = (R.string.Androcles_and_the_Lion_P1);
        page2 = (R.string.Androcles_and_the_Lion_P2);
        page3 = (R.string.Androcles_and_the_Lion_P3);

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3};

        int[] images = new int[] {R.drawable.pg1, R.drawable.pg2, R.drawable.pg3};

        return new BookBuilder.Builder("Androcles And The Lion",3,sounds,pages,images,pageNumbers).build();
    }

    public static BookBuilder getRatElephant(){
       int[] sounds = new int[] {R.raw.rat_elephant_page_1, R.raw.rat_elephant_page_2,
                R.raw.rat_elephant_page_3};

       int[] images = new int[] {R.drawable.pg1, R.drawable.pg2, R.drawable.pg3};

        String [] pageNumbers = new String[3];

        int page1,page2,page3;

        page1 = (R.string.The_Rat_and_the_Elephant_p1);
        page2 = (R.string.The_Rat_and_the_Elephant_p2);
        page3 = (R.string.The_Rat_and_the_Elephant_p3);

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3};

        return new BookBuilder.Builder("The Rat And The Elephant",3,sounds,pages,images,pageNumbers).build();
    }
}
