package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subject {
    private String name;
    private List<Todo> todos = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();
    private List<WrongAnswerNote> wrongAnswers = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<WrongAnswerNote> getWrongAnswers(){return wrongAnswers;}

    public void addWrongAnswer(WrongAnswerNote note) {
        wrongAnswers.add(note);
    }

    public void removeWrongAnswer(int index) {
        wrongAnswers.remove(index);
    }
}