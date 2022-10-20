package com.fatiheminkarahan.ilerisayitahminoyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = (Button)findViewById(R.id.buttonStart);
        bilgibttn = (Button)findViewById(R.id.buttonBilgi);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, game.class);
                startActivity(intent);
                finish();
            }
        });

        bilgibttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bilgi.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private Button bttn;
    private Button bilgibttn;
}