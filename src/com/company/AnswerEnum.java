package com.company;

import java.sql.SQLOutput;

public enum AnswerEnum {
    TAK(true), YES(true),
    NIE(false), NO(false),
    tak(true), nie(false),
    yes(true), no(false);

    private boolean isCorrect;

    AnswerEnum(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

//    public static void main(String[] args) {
//        //valueOf zwraca zmienną typu AnswerEnum, na której możemy
//        //wywołać dodatkowe metody
//        System.out.println(AnswerEnum.valueOf("NO").name());
//        System.out.println(AnswerEnum.valueOf("no").isCorrect());
//        System.out.println(AnswerEnum.valueOf("YES").isCorrect());
//        System.out.println(AnswerEnum.valueOf("asd").isCorrect());
//    }
}
