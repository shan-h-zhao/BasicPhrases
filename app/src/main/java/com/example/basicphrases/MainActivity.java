package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner dropdown;

    public void playPhrase(View view) {

        Button buttonPressed = (Button) view;
        String buttonTag = buttonPressed.getTag().toString() + dropdown.getSelectedItem().toString().toLowerCase();
        Log.i("Button Pressed", buttonTag);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonTag, "raw", getPackageName()));
        mediaPlayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"German", "Italian", "Spanish"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

    }
}