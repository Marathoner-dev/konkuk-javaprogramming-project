package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects; // 추가

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

    public List<WrongAnswerNote> getWrongAnswers() {
        return wrongAnswers;
    }

    public void addWrongAnswer(WrongAnswerNote note) {
        wrongAnswers.add(note);
    }

    public void removeWrongAnswer(int index) {
        wrongAnswers.remove(index);
    }

    // 아래 두 메서드 추가 (과목명 중복 방지용)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}