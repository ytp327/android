package com.example.android.miwok;

public class Word {
    private String miwok;
    private String defualt;
    private int imageId;
    private boolean hasImageFlag;

    public Word(String m, String d){
        miwok = m; defualt = d;
        hasImageFlag = false;
    }

    // constructor overloading
    public Word(String m, String d, int i){
        miwok = m; defualt = d; imageId = i;
        hasImageFlag = true;
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
}
