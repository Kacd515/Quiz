//klasa question, która jest odpowiedzialna za przechowywanie konkretnego pytania.
//Pytanie ma tylko opcje tak albo nie
public class Question {

    //tresc pytania
    private String content;

    // czy tak jest poprawne
    private boolean isCorrect;

    //konstruktor 2 parametrowy
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    //getter otrzymuje dane
    public String getContent() {
        return content;
    }

    //setter zmienia tresc pytania
    public void setContent(String content) {
        this.content = content;
    }


    // getter dla booleana
    public boolean isCorrect() {
        return isCorrect;
    }

    //setter dla booleana
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override //podpopwiedz dla kompilatora
    //wyswietla czytelna tresc pytania, wygenerowal InteliJ
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
