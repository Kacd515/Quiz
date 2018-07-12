import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements ActionListener {

    //ma zawierac pytanie
    //ma zawierac 2 przyciski: tak i nie

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;

    //zmienna, która jest typu interfejsowego
    // co oznacza, że musi to tej zmiennej przekazać klasę
    // która będzie implementowała interfejs Question Generator
    // mówimy ogólnie o typie, ale nie mówi konkretnie o klasie
    //podajemy kategorie do, której będzie należeć klasa

    private QuestionGenerator questionGenerator;
    private int currentQuestion;
    private int numberOfPoints = 0;

    //lista pytań
    private List<Question> questionList = new ArrayList<>();

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustawiamy zmienna z 22 linijki na tą, która jest podana w argumencie metody
        this.questionGenerator = questionGenerator;
        //tutaj zakładamy, że już mamy obiekt jakiejś klasy
        //na etapie pisania kodu nie wiemy kompletnie jaka to będzie klasa
        //tylko wiemy, że musi implementować interfejs QuestionGenerator
        //wypełniamy listę pytaniami, które sa generowane za pomocą metody generateQuestions
        questionList = questionGenerator.generateQuestions();
    }

    public Game() {
        super("Miliarderzy"); // ustawia tytuł okna
        createDefaultComponents();
        //label ustawiamy na 1 pytanie, ktore zostalo wygenerowane przez questionGenerator
        //label - etykieta
        labelQuestion = new JLabel(questionList.get(0).getContent(), 0);
        add(labelQuestion); //dodajemy do frame nasza label
        add(buttonYes); //dodajemy do frame nasz przycisk
        add(buttonNo); //dodajemy przycisk nie
        setLayout(new GridLayout(3, 1)); //uklad naszego okna, 3 w pionie, 1 w poziomie
        // this wskazuje na obiekt, w którym jest,
        //na rzecz, którego w tym momencie wołany jest konstruktor
        //Listener ma byc obiekt Game, czyli okno

    }

    private void createDefaultComponents() {
        setSize(500, 500); // ustawia wielkość okna
        setVisible(true); // sprawia, że okno jest widoczne
        setDefaultCloseOperation(1); //sprawia, że działa przycisk exit

        //ustawia konkretną klasę, która będzie nam generowac pytania
        //za pomocą new NazwaKlasy możemy podmienić nasz generator za popmocą 1 linijki kodu!
        setQuestionGenerator(new FileGenerator());

        buttonYes = new JButton("Tak"); //tworzymy button z napisem tak
        buttonNo = new JButton("Nie"); //tworzymy button z napisem nie
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
    }

    public static void main(String[] args) {

        //odpalenie okna w wątku
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //stworzenie nowej zmiennej typu Game = nowego okna
                Game game = new Game();
            }
        });
    }

        //ta metoda jest wywołana gdy klikniemy na przycisk, albo yes albo no
    @Override
    public void actionPerformed(ActionEvent e) {
        //kolejne pytanie musi sie miescic w liscie
        if (currentQuestion <questionList.size()) {
            JButton clickedButton = (JButton) e.getSource();
            Question currentQuestion = questionList.get(this.currentQuestion);
            if (clickedButton == buttonYes && currentQuestion.isCorrect()) {
                numberOfPoints++;
            }
            if (clickedButton == buttonNo && !currentQuestion.isCorrect()) {
                numberOfPoints++;
            }
        }

        if (questionList.size() > currentQuestion + 1) {
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
        } else {
            JOptionPane.showMessageDialog(this, "Koniec quizu! Zdobyłeś " + numberOfPoints + " punktów");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }

        System.out.println("Kliknięto mnie!");
    }
}
