package project;



public class WrongAnswerNote {
    private String question;
    private String myAnswer;
    private String correctAnswer;
    private String explanation;

    public WrongAnswerNote(String question, String myAnswer,
                           String correctAnswer, String explanation) {
        this.question = question;
        this.myAnswer = myAnswer;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }

    public String getQuestion() {
        return question;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
