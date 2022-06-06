package com.example.android.miwok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Calling on click listener for numbers

        TextView number = (TextView) findViewById(R.id.numbers);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(i);
            }
        });

        //        Calling on click listener for colors

        TextView color = (TextView) findViewById(R.id.colors);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });
        //        Calling on click listener for family
        TextView family = (TextView) findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(i);
            }
        });
        //        Calling on click listener for phrases

        TextView phrase = (TextView) findViewById(R.id.phrases);

        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(i);
            }
        });

    }
//    public void openNumberList(View view)
//    {
//        Intent i = new Intent(this,NumbersActivity.class);
//        startActivity(i);
//    }


}



