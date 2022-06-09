package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    //                 to check the completion of sound
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one","litti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","tolookasu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


// creating object for array adapter

       WordAdapter Adapter = new WordAdapter(this,words,R.color.category_numbers);
//  finding layout
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
//        creating object for list view so that we can create on any list item and can play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this , word.getAudioResourceId());
                mediaPlayer.start();
                //                 to check the completion of sound
                mediaPlayer.setOnCompletionListener(mCompletionListener);


            }
        });




//        LinearLayout rootview = (LinearLayout) findViewById(R.id.rootview);
//        int index=0;
//        while (index<words.size())
//        {
////            creating object for textview
//            TextView wordView = new TextView(this);
////            setting text
//            wordView.setText(words.get(index));
////            adding view to linear layout
//            rootview.addView(wordView);
//            index++;
//        }



    }
    @Override
    protected void onStop() {

        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}