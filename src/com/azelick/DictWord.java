package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
public class DictWord {
    private String word;
    private DictWord next;

    private DictWord(String str)
    {
        word = new String(str);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public DictWord getNext()
    {
        return next;
    }
}
