package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subject {
    private String name;
    private List<Todo> todos = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

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


}