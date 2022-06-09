package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
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

        words.add(new Word("red","wetetti",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow","chiwiita",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow","topiisa",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown","takaakkii",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray","topoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black","kukulli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white","kelilli",R.drawable.color_white,R.raw.color_white));


// creating object for array adapter

        WordAdapter Adapter = new WordAdapter(this,words,R.color.category_colors);
//  finding layout
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        //        creating object for list view so that we can create on any list item and can play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this , word.getAudioResourceId());
                mediaPlayer.start();
                //                 to check the completion of sound
                mediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
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