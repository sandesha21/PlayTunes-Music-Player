package com.sandesh.android.playtunes;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class SongCurrentlyPlaying extends AppCompatActivity {

    private boolean pFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_currently_palying);

        ImageView image = findViewById(R.id.current_song_image);
        TextView totalDurationTV = findViewById(R.id.total_duration);

        ImageButton prevButton = findViewById(R.id.previous_song_button);
        final ImageButton playButton = findViewById(R.id.play_button);
        ImageButton nextButton = findViewById(R.id.next_song_button);

        Intent intent = getIntent();
        image.setImageResource(intent.getIntExtra("image", R.drawable.music));
        int totalDuration = intent.getIntExtra("duration", 5*60);
        String remainSeconds = totalDuration % 60 > 10?
                String.valueOf(totalDuration % 60) : String.format("0" + totalDuration % 60);
        String duration = (totalDuration / 60) + ":" + remainSeconds;
        totalDurationTV.setText(duration);


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pFlag) {
                    playButton.setImageResource(R.drawable.baseline_pause_circle_outline_black_24dp);
                    pFlag = false;
                } else {
                    playButton.setImageResource(R.drawable.baseline_play_circle_outline_black_24dp);
                    pFlag = true;
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}