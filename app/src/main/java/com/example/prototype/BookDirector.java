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

        return new BookBuilder.Builder("Androcles And The Lion", pages.length, sounds,pages,images,pageNumbers).build();
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

        return new BookBuilder.Builder("The Rat And The Elephant",pages.length,sounds,pages,images,pageNumbers).build();
    }



    public static BookBuilder getCinderella(){
        int [] sounds = new int[] {R.raw.cinderella_page_1, R.raw.cinderella_page_2,
                R.raw.cinderella_page_3, R.raw.cinderella_page_4,R.raw.cinderella_page_5,
                R.raw.cinderella_page_6, R.raw.cinderella_page_7,R.raw.cinderella_page_8};

       int [] images = new int[] {R.drawable.pg1, R.drawable.pg2, R.drawable.pg3, R.drawable.pg4,
                R.drawable.princess_rose_img_one,R.drawable.princess_rose_img_two,
                R.drawable.princess_rose_img_three,R.drawable.princess_rose_img_four};

       String [] pageNumbers = new String[8];

        int page1,page2,page3,page4,page5,page6,page7,page8;

        page1 = (R.string.Cinderella_p1);
        page2 = (R.string.Cinderella_p2);
        page3 = (R.string.Cinderella_p3);
        page4 = (R.string.Cinderella_p4);
        page5 = (R.string.Cinderella_p5);
        page6 = (R.string.Cinderella_p6);
        page7 = (R.string.Cinderella_p7);
        page8 = (R.string.Cinderella_p8);

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int [] pages = new int[] {page1, page2, page3, page4, page5, page6, page7, page8};

        return new BookBuilder.Builder("Cinderella",pages.length,sounds,pages,images,pageNumbers).build();
    }



    public static BookBuilder getGoldilocks(){

        int [] sounds = new int[] {R.raw.goldilocks_page_1, R.raw.goldilocks_page_2,
                R.raw.goldilocks_page_3, R.raw.goldilocks_page_4,R.raw.goldilocks_page_5};

        int [] images = new int[]{R.drawable.pg1, R.drawable.pg2, R.drawable.pg3, R.drawable.pg4,
                R.drawable.princess_rose_img_one};

        int page1,page2,page3,page4,page5;

        page1 = (R.string.Goldilocks_p1);
        page2 = (R.string.Goldilocks_p2);
        page3 = (R.string.Goldilocks_p3);
        page4 = (R.string.Goldilocks_p4);
        page5 = (R.string.Goldilocks_p5);

        String [] pageNumbers = new String[5];

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3, page4, page5};

        return new BookBuilder.Builder("Goldilocks",pages.length,sounds,pages,images,pageNumbers).build();
    }



    public static BookBuilder getLittleRedRidingHood(){

        int [] sounds = new int[] {R.raw.little_red_riding_hood_page1, R.raw.little_red_riding_hood_page2,
                R.raw.little_red_riding_hood_page3, R.raw.little_red_riding_hood_page3};

        int [] images = new int[] {R.drawable.pg1, R.drawable.pg2, R.drawable.pg3, R.drawable.pg4};

        int page1,page2,page3,page4;

        page1 = (R.string.little_red_riding_hood_p1);
        page2 = (R.string.little_red_riding_hood_p2);
        page3 = (R.string.little_red_riding_hood_p3);
        page4 = (R.string.little_red_riding_hood_p4);

        String [] pageNumbers = new String[4];

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3, page4};

        return new BookBuilder.Builder("Little Red Riding Hood",pages.length,sounds,pages,images,pageNumbers).build();

    }



    public static BookBuilder getTheFoxAndTheCrow(){

        int [] sounds = new int[] {R.raw.fox_crow_page_1, R.raw.fox_crow_page_2,
                R.raw.fox_crow_page_3, R.raw.fox_crow_page_4,R.raw.fox_crow_page_5};

        int [] images = new int[] {R.drawable.pg1, R.drawable.pg2, R.drawable.pg3, R.drawable.pg4,
                R.drawable.princess_rose_img_one};

        int page1,page2,page3,page4,page5;

        page1 = (R.string.The_Fox_and_the_Crow_p1);
        page2 = (R.string.The_Fox_and_the_Crow_p2);
        page3 = (R.string.The_Fox_and_the_Crow_p3);
        page4 = (R.string.The_Fox_and_the_Crow_p4);
        page5 = (R.string.The_Fox_and_the_Crow_p5);

        String [] pageNumbers = new String[5];

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3, page4, page5};

        return new BookBuilder.Builder("The Fox And The Crow",pages.length,sounds,pages,images,pageNumbers).build();

    }



    public static BookBuilder getPrincessRoseAndTheGoldenBird(){

        int [] sounds = new int[] {R.raw.princess_rose_and_the_golden_bird1, R.raw.princess_rose_and_the_golden_bird2,
                R.raw.princess_rose_and_the_golden_bird3, R.raw.princess_rose_and_the_golden_bird4, R.raw.princess_rose_and_the_golden_bird5};

        int [] images = new int[]{R.drawable.princess_rose_img_one, R.drawable.princess_rose_img_two, R.drawable.princess_rose_img_three,
                R.drawable.princess_rose_img_four, R.drawable.princess_rose_img_five};

        int page1,page2,page3,page4,page5;

        page1 = (R.string.Princess_rose_and_the_golden_bird_p1);
        page2 = (R.string.Princess_rose_and_the_golden_bird_p2);
        page3 = (R.string.Princess_rose_and_the_golden_bird_p3);
        page4 = (R.string.Princess_rose_and_the_golden_bird_p4);
        page5 = (R.string.Princess_rose_and_the_golden_bird_p5);

        String [] pageNumbers = new String[5];

        for (int i = 0; i < pageNumbers.length; i ++){
            pageNumbers[i] = "page "+ (i+1);
        }

        int[] pages = new int[] {page1, page2, page3, page4, page5};

        return new BookBuilder.Builder("Princess Rose And The Golden Bird",pages.length,sounds,pages,images,pageNumbers).build();

    }
}
