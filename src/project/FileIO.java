package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    private List<Subject> subjects = new ArrayList<>();
    private File file = new File("res/data.txt");
    public void save() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));

            for (Subject subject : subjects) {
                writer.print(subject.getName());
                writer.print("|" + subject.getTodos().size());

                for (Todo todo : subject.getTodos()) {
                    writer.print("|" + todo.getDeadLine());
                    writer.print("|" + todo.getTodoName());
                    writer.print("|" + Boolean.TRUE.equals(todo.getState()));
                }

                writer.print("|" + subject.getExams().size());

                for (Exam exam : subject.getExams()) {
                    writer.print("|" + exam.getTheDay());
                    writer.print("|" + exam.getExamName());
                }

                writer.println();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("저장 중 오류 발생");
        }
    }

    public void load() {
        if (!file.exists()) {
            return;
        }

        try {
            Scanner scanner = new Scanner(file);

            subjects.clear();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|", -1);
                int index = 0;

                String subjectName = data[index++];
                Subject subject = new Subject(subjectName);


                int todoCount = Integer.parseInt(data[index++]);

                for (int i = 0; i < todoCount; i++) {
                    String deadline = data[index++];
                    String todoName = data[index++];
                    boolean state = Boolean.parseBoolean(data[index++]);

                    Todo todo = new Todo(deadline, todoName);
                    todo.setState(state);

                    subject.getTodos().add(todo);
                }

                int examCount = Integer.parseInt(data[index++]);

                for (int i = 0; i < examCount; i++) {
                    String examDate = data[index++];
                    String examName = data[index++];

                    Exam exam = new Exam(examDate, examName);
                    subject.getExams().add(exam);
                }

                subjects.add(subject);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("파일의 데이터 형식이 잘못되었습니다.");
        }
    }
}

