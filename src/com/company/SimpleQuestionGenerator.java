package com.company;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("2+2=4?", true));
        questionList.add(new Question("Is dog a fish?", false));
        questionList.add(new Question("Is Java OOP language?", true));
        return questionList;
    }
}
