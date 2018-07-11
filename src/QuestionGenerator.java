import java.util.List;

//interfejs
//sluzy do pomocy w odwolywaniu sie do klas zawierajacych pytania
public interface QuestionGenerator {
    //metoda ktora ma zwracac liste pytan
    //w "jakis" sposob
    List<Question> generateQuestions();
}
