import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends JFrame {

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;

    public Game() {
        super("Miliarderzy"); // ustawia tytuł okna
        setSize(500, 500); // ustawia wielkość okna
        setVisible(true); // sprawia, że okno jest widoczne
        setDefaultCloseOperation(1); //sprawia, że działa przycisk exit
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
        labelQuestion = new JLabel("Czy 2+2=4?", 0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);
        setLayout(new GridLayout(3,1));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game();
            }
        });

            List<Question> questionList = new ArrayList<>();

            questionList.add(new Question("Czy 2+2=4?", true));
            questionList.add(new Question("Czy Polska leży w Europie?", true));
            questionList.add(new Question("Czy Czy Java jest super?", true));
            questionList.add(new Question("Czy Chopin urodził się w Warszawie", false));
            questionList.add(new Question("Tak czy Nie??", false));

            int numberOfPoints = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Miliarderzy: Odpowiadaj TAK bądź NIE na pytania");

            for (Question question: questionList) {
                System.out.println(question.getContent());
                String answer = scanner.next();
                if ((answer.equals("tak") && question.isCorrect()) || (answer.equals("nie") && !question.isCorrect())) {
                    numberOfPoints++;
                }
            }
            System.out.println("Zdobyłeś " +numberOfPoints+" punktów");

        }
    }
