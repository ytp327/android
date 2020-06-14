package com.example.android.miwok;

public class Word {
    private String miwok;
    private String defualt;
    private int imageId;

    public Word(String m, String d){
        miwok = m; defualt = d;
    }

    // constructor overloading
    public Word(String m, String d, int i){
        miwok = m; defualt = d; imageId = i;
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
}
