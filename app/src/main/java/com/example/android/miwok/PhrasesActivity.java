package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        words.add(new Word("where are you going ?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("what is your name ?","tinna oyaasina",R.raw.phrase_what_is_your_name));
        words.add(new Word("my name is ","oyyasit",R.raw.phrase_my_name_is));
        words.add(new Word("i'm coming","aanam",R.raw.phrase_im_coming));
        words.add(new Word("how are you feeling ?","michaksas",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i'm feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("are you coming ?","aanas'aa",R.raw.phrase_are_you_coming));
        words.add(new Word("i'm coming","haa'aanam",R.raw.phrase_yes_im_coming));

// creating object for array adapter

        WordAdapter Adapter = new WordAdapter(this,words,R.color.category_phrases);
//  finding layout
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        //        creating object for list view so that we can create on any list item and can play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this , word.getAudioResourceId());
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