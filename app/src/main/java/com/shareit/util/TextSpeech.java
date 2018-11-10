package com.shareit.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

public class TextSpeech {
    private TextToSpeech mTTs;
    private Context mContext;
    public TextSpeech(Context context){
        mContext = context;
    }
    public void speak(String str) {
        mTTs = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
//                    int result = mTTs.setLanguage(Locale.ENGLISH);
                    int result = mTTs.setLanguage(new Locale("vi_VN"));

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        mTTs.speak(str, TextToSpeech.QUEUE_ADD, null);
    }
}