package com.example.friends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> episode = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click = findViewById(R.id.randomeps);
        final TextView t = findViewById(R.id.eps);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputReader = getAssets().open("friends.txt");
                    BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputReader));

                    boolean hasNexLine = true;

                    while (hasNexLine) {
                        String line = buffReader.readLine();
                        episode.add(line);
                        hasNexLine = line != null;
                    }
                    Random r = new Random();
                    String s = episode.get(r.nextInt(episode.size()));

                    t.setText(s);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
