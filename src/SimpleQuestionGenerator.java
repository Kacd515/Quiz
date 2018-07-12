//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
////klasa, która implementuje interfejs. Dzieki temu może być traktowana jako tym SimpleQuestionGenerator ale też jako
////typ QuestionGenerator
//public class SimpleQuestionGenerator implements QuestionGenerator {
//
//    //implementacja tej metody
//    @Override
//    public List<Question> generateQuestions() {
//        List<Question> questionList = new ArrayList<>();
//
//        String fileName = "c://questions.txt";
//        List<String> list = new ArrayList<>();
//
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//
//            list = stream.collect(Collectors.toList());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (i < 3) {
//                questionList.add(new Question(list.get(i), true));
//            } else {
//                questionList.add(new Question(list.get(i), false));
//
//            }
//        }
//        System.out.println(questionList);
//        return questionList;
//    }
//}