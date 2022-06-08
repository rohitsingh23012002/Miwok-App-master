package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = N0_IMAGE_PROVIDED;

    private int mAudioResourceId ;

    private static final int N0_IMAGE_PROVIDED = -1;
    public Word(String defaultTranslation , String miwokTranslation , int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation , String miwokTranslation , int ImageResourceId , int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getdefaultTranslation()
    {
        return mDefaultTranslation;
    }
    public String getmiwokTranslation()
    {
        return mMiwokTranslation;
    }
    public int getImageResourceId()
    {
        return mImageResourceId;
    }
    public boolean hasImage()
    {
       return mImageResourceId != N0_IMAGE_PROVIDED;

    }
    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }
}
