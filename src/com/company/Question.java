package com.company;

import java.util.List;

public class Question {
    private String content;
    private boolean isCorrect;

    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override // podpowiedź dla kompilatora
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}


