package com.eaccid.txttranslator.model;

import com.eaccid.txttranslator.model.translator.lingualeo_impl.connection.LingualeoResponse;
import com.eaccid.txttranslator.model.translator.translator.TextTranslation;

import java.util.List;

public class LeoWordTranslation implements TextTranslation {

    private LingualeoResponse lingualeoResponse;
    private List<String> translates;
    private String transcription;
    private  String soundUrl;
    private String picUrl;
    private String word;

    @Override
    public String getWord() {
        return word;
    }

    public LeoWordTranslation(LingualeoResponse lingualeoResponse) {
        initLingualeoResponse(lingualeoResponse);
        loadTranslateData();
    }

    @Override
    public String getTranscription() {
        return transcription;
    }

    @Override
    public List<String> getTranslates() {
        return translates;
    }

    @Override
    public String getSoundUrl() {
        return soundUrl;
    }

    @Override
    public String getPicUrl() {
        return picUrl;
    }

    @Override
    public boolean isEmpty() {
        return lingualeoResponse.isEmpty();
    }

    @Override
    public String toString() {
        return lingualeoResponse.toString();
    }

    private void initLingualeoResponse(LingualeoResponse lingualeoResponse) {

        this.lingualeoResponse = lingualeoResponse == null ? new LingualeoResponse() : lingualeoResponse;

    }

    private void loadTranslateData() {

        word = lingualeoResponse.getString("word");
        translates = lingualeoResponse.getListString("value");
        transcription = lingualeoResponse.getString("transcription");
        soundUrl = lingualeoResponse.getString("sound_url");
        picUrl = lingualeoResponse.getString("pic_url");

    }

}
