package com.example.android.miwok;

public class Word {
    private String miwok;
    private String defualt;
    private int imageId;
    private int audioId;
    private boolean hasImageFlag;

    public Word(String m, String d, int a){
        miwok = m; defualt = d;
        hasImageFlag = false; audioId = a;
    }

    // constructor overloading
    public Word(String m, String d, int i, int a){
        miwok = m; defualt = d; imageId = i;
        hasImageFlag = true; audioId = a;
    }

    public String getDefualt() {
        return defualt;
    }

    public String getMiwok() {
        return miwok;
    }

    public int getImage() {
        return imageId;
    }

    public boolean hasImage(){ return hasImageFlag;}

    public int getAudioId(){ return audioId;}
}
