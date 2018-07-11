import java.util.ArrayList;
import java.util.List;

//klasa, która implementuje interfejs. Dzieki temu może być traktowana jako tym SimpleQuestionGenerator ale też jako
//typ QuestionGenerator
public class SimpleQuestionGenerator implements QuestionGenerator {

    //implementacja tej metody
    @Override
    public List<Question> generateQuestions() {
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy 2+2=4?", true));
        questionList.add(new Question("Czy Polska leży w Europie?", true));
        questionList.add(new Question("Czy Czy Java jest super?", true));
        questionList.add(new Question("Czy Chopin urodził się w Warszawie", false));
        questionList.add(new Question("Tak czy Nie??", false));
        return questionList;
    }
}