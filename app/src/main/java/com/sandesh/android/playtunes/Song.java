package com.sandesh.android.playtunes;

import androidx.annotation.NonNull;

public class Song {

    private String songname;
    private String singer;
    private int time;
    private final static int NO_IMAGE_PROVIDED = -1;
    private int imgResId = NO_IMAGE_PROVIDED;

    // Putting Constructors here
    public Song(String songname, String singer, int time, int imgResId) {
        this.songname = songname;
        this.singer = singer;
        this.time = time;
        this.imgResId = imgResId;
    }

    public String getSongName() {
        return songname;
    }

    public String getSinger() {
        return singer;
    }

    public int getDuration() {
        return time;
    }

    public int getImgResId() {
        return imgResId;
    }

    // Other methods
    public boolean hasImage() {
        return imgResId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Song{" + "songname='" + songname + '\'' + ", singer='" + singer + '\'' + ", duration=" + time + ", imgResId=" + imgResId + '}';
    }
}
