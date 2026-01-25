package com.sandesh.android.playtunes;


import android.content.Context;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SongAdapter extends ArrayAdapter<Song> {

    // Constructor
    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songList) {
        super(context, 0, songList);
    }

    // Overridden methods
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }

        Song currentSong = getItem(position);

        ImageView image = convertView.findViewById(R.id.list_song_image);
        TextView songName = convertView.findViewById(R.id.list_song_name);
        TextView singerName = convertView.findViewById(R.id.list_singer_name);

        songName.setText(currentSong.getSongName());
        singerName.setText(currentSong.getSinger());

        if (currentSong.hasImage()) {
            image.setImageResource(currentSong.getImgResId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.drawable.music);
            image.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}