package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

//atrybuty *******************************************************

public class Main extends JFrame implements ActionListener {

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;


    //zmienna, która jest typu interfejsowego
    //co oznacza, że musi do tej zmiennej przekazać klasę
    //która będzie implementowała intrfejs QuestionGenerator.
    //Mówi ogólnie o typie, ale nie mówi konkretnie o klasie
    //podajemy kategorie do której będzie należeć klasa
    private QuestionGenerator questionGenerator;
    private int currentQuestion = 0;
    private int score = 0;

    //koniec atrybutów ********************************************************************

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
        questionList = questionGenerator.generateQuestions();
    }

    private List<Question> questionList = new ArrayList<>();

    //konstruktor **********************************************************
    public Main() { //konstruktor
        super("Milionerzy"); //ustawia tytuł
        createDefaultComponents();
        labelQuestion = new JLabel(questionList.get(0).getContent(), 0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);
        setLayout(new GridLayout(3, 1));
        //Listenerem ma być obiek Main, czyli okno
    }

    private void createDefaultComponents() {
        setSize(500, 500); //ustawia wielkość okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sprawia, że działa przycisk exit
        setVisible(true); //pokazuje okno
        setQuestionGenerator(new FileGenerator());
        buttonYes = new JButton("TAK");
        buttonNo = new JButton("NIE");
        buttonYes.addActionListener(this); //wskazuje na obiekt w którym jest (Main)
        buttonNo.addActionListener(this);
    }
    //koniec konstruktora*********************************************************************

    @Override //implementacja metody actionPerformed z interfejsu
    public void actionPerformed(ActionEvent e) {
        if (currentQuestion < questionList.size()) {
            JButton clickedButton = (JButton) e.getSource();
            Question currentQuestion = questionList.get(this.currentQuestion);
            if (clickedButton == buttonYes
                    && currentQuestion.isCorrect()) {
                score++;
            }
            if (clickedButton == buttonNo
                    && !currentQuestion.isCorrect()) {
                score++;
            }
        }
        if (currentQuestion + 1 < questionList.size()) {
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
        } else {
            JOptionPane.showMessageDialog(this, "Koniec quizu, Twój wynik to: " + score + " punkty.");
            buttonYes.setEnabled(false);
            buttonNo.setEnabled(false);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Main main = new Main();
                }
            });

    }
}

