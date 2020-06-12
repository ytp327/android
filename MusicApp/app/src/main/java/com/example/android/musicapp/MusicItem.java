package com.example.android.musicapp;

public class MusicItem {

    private String mMusicName;
    private String mArtistName;
    private String mAlbumName;
    private int mImageResourceId;
    public MusicItem(String musicName, String artistName, String albumName, int imageResourceId)
    {
        mMusicName = musicName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mImageResourceId = imageResourceId;
    }
    public String getMusicName (){
        return mMusicName;
    }
    public String getArtistName (){
        return mArtistName;
    }
    public String getAlbumName (){
        return mAlbumName;
    }
    public int getImageResourceId (){
        return mImageResourceId;
    }
}
