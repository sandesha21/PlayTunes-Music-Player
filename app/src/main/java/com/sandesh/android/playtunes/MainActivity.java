package com.sandesh.android.playtunes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<Song> songsList;
    private boolean pFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsList = new ArrayList<Song>();
        songsList.add(new Song("Finally Found Someone", "Bryan Adams and Barbra Streisand", 5*60 + 23, R.drawable.ifinallyfoundsomeone));
        songsList.add(new Song("Everything", "Michael Bublé", 3*60 + 51, R.drawable.everythingmichaelbuble));
        songsList.add(new Song("Summer of 69", "Bryan Adam", 4*60 + 13, R.drawable.summerof69bryanadams));
        songsList.add(new Song("Close To You", "Karen Carpenter", 5*60 + 13, R.drawable.closetoyoukarencarpenter));
        songsList.add(new Song("Everything I Do I Do It For You!", "Bryan Adams", 5*60 + 23, R.drawable.everythingidoidoitforyoubrayanadams));
        songsList.add(new Song("Love Was Made For Us", "Cleo", 4*60 + 35, R.drawable.lovewasmadeforuscloe));
        songsList.add(new Song("The Power Of Love", "Celine Dion", 2*60 + 23, R.drawable.thepoweroflovecelinedion));


        ListView songsLV = findViewById(R.id.home_songs);
        RelativeLayout lowerNowPlayingBar = findViewById(R.id.bar);
        final ImageButton playButton = findViewById(R.id.play_button);
        final ImageButton nextButton = findViewById(R.id.next_button);

        SongAdapter adapter = new SongAdapter(this, songsList);
        songsLV.setAdapter(adapter);

        songsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song clickedSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, SongCurrentlyPlaying.class);
                intent.putExtra("home_song_name", clickedSong.getSongName());
                intent.putExtra("home_singer_name", clickedSong.getSinger());
                intent.putExtra("duration", clickedSong.getDuration());
                intent.putExtra("image", clickedSong.getImgResId());
                startActivity(intent);
            }
        });
        lowerNowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pFlag) {
                    playButton.setImageResource(R.drawable.baseline_pause_circle_outline_white_48dp);
                    pFlag = false;
                } else {
                    playButton.setImageResource(R.drawable.baseline_play_circle_outline_white_48dp);
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