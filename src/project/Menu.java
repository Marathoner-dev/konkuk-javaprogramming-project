package project.src.project;

import project.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Subject> subjects = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void startMenu(){
        while(true){
            System.out.println("====기능 선택 ====");
            System.out.println("1. 시험 일정");
            System.out.println("2. 할 일");
            System.out.println("3. 과목");
            System.out.println("4. 스탑워치");
            System.out.println("5. 오답노트");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1 -> examMenu();

                case 2 -> todoMenu();

                case 3 -> subjectMenu();

                case 4 -> stopwatchMenu();

                case 5 -> wrongAnswerMenu();

                case 0 -> {
                    System.out.println("사용을 종료합니다.");
                    return;
                }

            }
        }
    }

    private void todoMenu() {
        while(true){
            System.out.println("==== 할 일 ====");
            System.out.println("1. 할 일 관리");
            System.out.println("2. 할 일 조회");
            System.out.println("3. 진척도 조회");
            System.out.println("0. 뒤로 가기");
            System.out.print("선택 >> ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1 -> manageTodo();
                case 2 -> checkTodo();
                case 3 -> progressShow();
                case 0 -> {return;}
            }
        }
    }


    private void manageTodo() {
        while(true){
            System.out.println("==== 할 일 관리====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 삭제");
            System.out.println("3. 할 일 수정");
            System.out.println("0. 뒤로 가기");
            System.out.print("선택 >> ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1 -> addTodo();
                case 2 -> deleteTodo();
                case 3 -> modifyTodo();
                case 0 -> {return;}
            }
        }
    }

    public void addTodo(){
        showSubjects();
        if (subjects.isEmpty()) return;
        System.out.print("과목 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();
        if (num < 1 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Subject subject = subjects.get(num - 1);
        System.out.print("마감 날짜(8자리 숫자로 입력 ex)20261120)>> ");
        String deadLine = scan.nextLine();
        if(deadLine.length()!=8){
            System.out.println("8자리숫자로 입력(ex)20261120) 하시오.");
            return;
        }
        System.out.print("할 일 내용 >> ");
        String todoName = scan.nextLine();
        Todo todo = new Todo(deadLine, todoName);
        todo.setState(false);
        subject.getTodos().add(todo);
        System.out.println("할 일이 추가되었습니다.");
    }

    public void deleteTodo(){
        showSubjects();
        if (subjects.isEmpty()) return;
        System.out.print("과목 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();
        if (num < 1 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Subject subject = subjects.get(num - 1);
        List<Todo> todos = subject.getTodos();
        if(todos.isEmpty()){System.out.println("할일이 없습니다");return;}
        for(int i =0;i<todos.toArray().length;i++){
            System.out.println((i+1)+". "+todos.get(i).getTodoName());
        }
        System.out.println("삭제할 번호 >>");
        num=scan.nextInt();
        scan.nextLine();
        if (num < 1 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        todos.remove(num-1);
        System.out.println("삭제 되었습니다.");
    }

    public void modifyTodo(){
        showSubjects();
        if (subjects.isEmpty()) return;
        System.out.print("과목 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();
        if (num < 1 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Subject subject = subjects.get(num-1);
        List<Todo> todos=subject.getTodos();
        for (int i = 0; i < todos.toArray().length; i++) {
            System.out.println((i + 1) + ". " + todos.get(i).getTodoName());
        }
        Todo todo =todos.get(scan.nextInt()-1);
        System.out.println("1. 할일 이름변경");
        System.out.println("2. 마감 기한 변경");
        System.out.println("3. 완료 상태 변경");
        System.out.println("0. 종료");
        int choice = scan.nextInt();
        switch (choice){
            case 1-> {
                System.out.println("변경할 이름 >> ");
                todo.setTodoName(scan.next());
                scan.nextLine();
                System.out.println("변경 완료");
                break;
            }
            case 2->{
                System.out.println("변경할 마감 기한(8자리 숫자로 입력 ex)20261120)>>");
                String str=scan.next();
                scan.nextLine();
                if(str.length()!=8) {
                    System.out.println("마감기한은 8자리 숫자로 입력해야함! ex)20261120");
                    break;
                }else {
                    todo.setDeadLine(str);
                    System.out.println("변경 완료");
                }
            }
            case 3-> {
                System.out.println("완료 상태를 입력해주십시오 : (True/False)");
                Boolean status = scan.nextBoolean();
                todo.setState(status);
            }
            case 0-> {return;}
            default -> {System.out.println("다시 입력하세요"); modifyTodo();}
        }
    }

    private void checkTodo() {
        while(true){
            System.out.println("==== 할 일 조회====");
            System.out.println("1. 일자별 할 일 조회");
            System.out.println("2. 과목별 할 일 조회");
            System.out.println("3. 전체 할 일 조회");
            System.out.println("0. 뒤로 가기");
            System.out.print("선택 >> ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1 -> checkTodoByDay();
                case 2 -> checkTodoBySub();
                case 3 -> checkAllTodo();
                case 0 -> {return;}
            }
        }
    }

    private void checkTodoByDay() {
        System.out.print("조회 날짜를 8자리 숫자로 입력해주세요.(ex : 20260101) >> ");
        String today = scan.nextLine();
        for(Subject sub : this.getSubjects()){
            for(Todo todo : sub.getTodos()){
                if(todo.getDeadLine().equals(today)){
                    System.out.println("과목 : " + sub.getName() + ", 내용 : " + todo.getTodoName() + ", 완료 여부 : " + todo.getState());
                }
            }
        }
        System.out.println("=============================");
    }

    private void checkTodoBySub() {
        System.out.print("조회할 과목을 입력해주세요. >>");
        String checkSub = scan.nextLine();
        boolean ch = false;
        for(Subject sub : this.getSubjects()){
            if (sub.getName().equals(checkSub)){
                ch = true;
                for(Todo todo : sub.getTodos()){
                    System.out.println("종료일 : " + todo.getDeadLine() + ", 내용 : " + todo.getTodoName() + ", 완료 여부 :" + todo.getState());
                }
            }
        }
        if (!ch){
            System.out.println("해당 과목이 없습니다.");
        }
        System.out.println("=============================");
    }

    private void checkAllTodo() {
        for(Subject sub : this.getSubjects()){
            for(Todo todo : sub.getTodos()){
                System.out.println("과목 : " + sub.getName() + ", 내용 : " + todo.getTodoName() + ", 완료 여부 : " + todo.getState());
            }
        }
        System.out.println("=============================");
    }

    public void progressShow(){
        showSubjects();
        System.out.println("1.과목별 진척도");
        System.out.println("2.날 진척도");
        int choice=scan.nextInt();
        switch (choice){
            case 1->{
                System.out.print("과목 선택>> ");
                int num=scan.nextInt();
                if (num < 1 || num > subjects.size()) {
                    System.out.println("잘못된 번호입니다.");
                    return;
                }
                Subject sub=subjects.get(num-1);
                int done=0;
                for(int i=0;i<sub.getTodos().toArray().length;i++){
                    if(sub.getTodos().get(i).getState()==true){done++;}
                }
                double progress=(double)done/sub.getTodos().size()*100;
                System.out.println(sub.getName()+"의 진척도 : "+(int)progress+"%");
            }
            case 2->{
                System.out.print("조회할 날짜를 8자리 숫자로 입력해주세요.(ex : 20260101) >> ");
                String str= scan.next();
                scan.nextLine();
                if(str.length()!=8){
                    System.out.println("기간은 8자리로 작성하시오! ex)20261120");return;
                }
                int all=0;int done=0;
                for(int i=0;i<subjects.toArray().length;i++){
                    for(int j=0;j<subjects.get(i).getTodos().toArray().length;j++){
                        if(subjects.get(i).getTodos().get(j).getDeadLine().equals(str)==true){
                            all++;
                            if(subjects.get(i).getTodos().get(j).getState()==true){
                                done++;
                            }
                        }
                    }
                }
                double progress =(double)done/all*100;
                System.out.println(str+"의 진척도>> "+(int)progress+"%");
            }
            default -> {System.out.println("올바르게 입력하시오");}
        }
    }

    public void subjectMenu() {
        while (true) {
            System.out.println("===== 과목 관리 =====");
            System.out.println("1.과목 추가");
            System.out.println("2.과목 삭제");
            System.out.println("3.과목 조회");
            System.out.println("0.뒤로 가기");
            System.out.print("선택 >> ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> {addSubject();}
                case 2 -> {deleteSubject();}
                case 3 -> {showSubjects();}
                case 0 -> {return;}
                default -> {System.out.println("다시 입력하세요");}
            }
        }
    }

    public void addSubject() {
        System.out.print("추가할 과목명 >> ");
        String name = scan.nextLine();
        Subject subject = new Subject(name);
        subjects.add(subject);
        System.out.println(name + " 과목이 추가되었습니다.");
    }
    public void deleteSubject() {
        showSubjects();
        int num;
        if (subjects.isEmpty()) {
            System.out.println("과목 리스트가 비어 있습니다.");
            return;
        }
        System.out.print("삭제할 과목 번호 >> ");
        num = scan.nextInt();
        scan.nextLine();
        if (num <=0 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Subject removed_subject = subjects.remove(num - 1);
        System.out.println(removed_subject.getName() + "이/가 삭제되었습니다.");
    }

    public void showSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
            return;
        }
        System.out.println("===== 과목 목록 =====");
        for (int i = 0; i <subjects.size(); i++) {
            System.out.println((i+1)+ ". " + subjects.get(i).getName());
        }
    }

    private void examMenu() {
        while (true) {
            System.out.println("\n===== 시험 일정 =====");
            System.out.println("1. 시험 추가");
            System.out.println("2. 시험 조회");
            System.out.println("3. 시험 수정");
            System.out.println("4. 시험 삭제");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택 >> ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> addExam();
                case 2 -> showExams();
                case 3 -> modifyExam();
                case 4 -> deleteExam();
                case 0 -> { return; }
                default -> System.out.println("잘못된 번호입니다.");
            }
        }
    }

    private void addExam() {
        Subject subject = selectSubject();
        if (subject == null) return;

        System.out.print("시험 날짜(8자리 숫자로 입력 ex)20261120) >> ");
        String theDay = scan.nextLine();
        if (theDay.length() != 8) {
            System.out.println("8자리 숫자로 입력(ex)20261120) 하시오.");
            return;
        }

        System.out.print("시험 이름(ex)중간고사, 기말고사) >> ");
        String examName = scan.nextLine();

        Exam exam = new Exam(theDay, examName);
        subject.getExams().add(exam);
        System.out.println("시험 일정이 추가되었습니다.");
    }

    private void showExams() {
        System.out.println("1. 과목별 시험 조회");
        System.out.println("2. 전체 시험 조회");
        System.out.print("선택 >> ");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice == 1) {
            Subject subject = selectSubject();
            if (subject == null) return;

            List<Exam> exams = subject.getExams();
            if (exams.isEmpty()) {
                System.out.println("등록된 시험 일정이 없습니다.");
                return;
            }

            System.out.println("\n===== " + subject.getName() + " 시험 일정 =====");
            for (int i = 0; i < exams.size(); i++) {
                Exam exam = exams.get(i);
                System.out.println((i + 1) + ". [" + exam.getTheDay() + "] " + exam.getExamName());
            }
        } else if (choice == 2) {
            boolean hasExam = false;
            System.out.println("\n===== 전체 시험 일정 =====");
            for (Subject sub : subjects) {
                for (Exam exam : sub.getExams()) {
                    hasExam = true;
                    System.out.println("과목: " + sub.getName() + " | 날짜: " + exam.getTheDay() + " | 시험명: " + exam.getExamName());
                }
            }
            if (!hasExam) {
                System.out.println("등록된 시험 일정이 없습니다.");
            }
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }

    private void modifyExam() {
        Subject subject = selectSubject();
        if (subject == null) return;

        List<Exam> exams = subject.getExams();
        if (exams.isEmpty()) {
            System.out.println("수정할 시험 일정이 없습니다.");
            return;
        }

        for (int i = 0; i < exams.size(); i++) {
            System.out.println((i + 1) + ". [" + exams.get(i).getTheDay() + "] " + exams.get(i).getExamName());
        }

        System.out.print("수정할 시험 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();

        if (num < 1 || num > exams.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        Exam exam = exams.get(num - 1);

        System.out.println("1. 시험 날짜 변경");
        System.out.println("2. 시험 이름 변경");
        System.out.println("0. 취소");
        System.out.print("선택 >> ");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("변경할 날짜(8자리 숫자로 입력 ex)20261120) >> ");
                String newDay = scan.nextLine();
                if (newDay.length() != 8) {
                    System.out.println("8자리 숫자로 입력해야 합니다.");
                    return;
                }
                exam.setTheDay(newDay);
                System.out.println("시험 날짜가 변경되었습니다.");
            }
            case 2 -> {
                System.out.print("변경할 시험 이름 >> ");
                String newName = scan.nextLine();
                exam.setExamName(newName);
                System.out.println("시험 이름이 변경되었습니다.");
            }
            case 0 -> { return; }
            default -> System.out.println("잘못된 번호입니다.");
        }
    }

    private void deleteExam() {
        Subject subject = selectSubject();
        if (subject == null) return;

        List<Exam> exams = subject.getExams();
        if (exams.isEmpty()) {
            System.out.println("삭제할 시험 일정이 없습니다.");
            return;
        }

        for (int i = 0; i < exams.size(); i++) {
            System.out.println((i + 1) + ". [" + exams.get(i).getTheDay() + "] " + exams.get(i).getExamName());
        }

        System.out.print("삭제할 시험 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();

        if (num < 1 || num > exams.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        exams.remove(num - 1);
        System.out.println("시험 일정이 삭제되었습니다.");
    }

    private Stopwatch stopwatch = new Stopwatch();
    public void stopwatchMenu() {

        while (true) {
            System.out.println("\n===== 스탑워치 =====");
            System.out.println("1. 시작");
            System.out.println("2. 정지");
            System.out.println("3. 재시작");
            System.out.println("4. 초기화");
            System.out.println("5. 경과 시간 확인");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택 >> ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    if (stopwatch.start()) {
                        System.out.println("스탑워치를 시작했습니다.");
                    } else {
                        System.out.println("이미 시작되었습니다.");
                    }
                    break;
                case 2:
                    stopwatch.stop();
                    System.out.println("스탑워치를 정지했습니다.");
                    break;

                case 3:
                    stopwatch.restart();
                    System.out.println("스탑워치를 재시작했습니다.");
                    break;

                case 4:
                    stopwatch.reset();
                    System.out.println("스탑워치를 초기화했습니다.");
                    break;

                case 5:
                    System.out.println("경과 시간: "
                            + stopwatch.getFormattedTime());
                    break;

                case 0:
                    return;

                default:
                    System.out.println("잘못된 번호입니다.");
            }
        }
    }

    private void wrongAnswerMenu() {
        while (true) {
            System.out.println("\n===== 오답노트 =====");
            System.out.println("1. 오답 추가");
            System.out.println("2. 오답 조회");
            System.out.println("3. 오답 삭제");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택 >> ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> addWrongAnswer();
                case 2 -> showWrongAnswers();
                case 3 -> deleteWrongAnswer();
                case 0 -> { return; }
                default -> System.out.println("잘못된 번호입니다.");
            }
        }
    }

    private Subject selectSubject() {
        showSubjects();

        if (subjects.isEmpty()) {
            return null;
        }

        System.out.print("과목 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();

        if (num < 1 || num > subjects.size()) {
            System.out.println("잘못된 번호입니다.");
            return null;
        }

        return subjects.get(num - 1);
    }

    private void addWrongAnswer() {
        Subject subject = selectSubject();

        if (subject == null) return;

        System.out.print("문제 내용 >> ");
        String question = scan.nextLine();

        System.out.print("내 답 >> ");
        String myAnswer = scan.nextLine();

        System.out.print("정답 >> ");
        String correctAnswer = scan.nextLine();

        System.out.print("해설 >> ");
        String explanation = scan.nextLine();

        WrongAnswerNote note = new WrongAnswerNote(question, myAnswer, correctAnswer, explanation);

        subject.addWrongAnswer(note);

        System.out.println("오답이 추가되었습니다.");
    }

    private void showWrongAnswers() {
        Subject subject = selectSubject();

        if (subject == null) return;

        List<WrongAnswerNote> notes = subject.getWrongAnswers();

        if (notes.isEmpty()) {
            System.out.println("등록된 오답이 없습니다.");
            return;
        }

        System.out.println("\n===== " + subject.getName() + " 오답 목록 =====");

        for (int i = 0; i < notes.size(); i++) {
            WrongAnswerNote note = notes.get(i);

            System.out.println("\n[" + (i + 1) + "번 오답]");
            System.out.println("문제 : " + note.getQuestion());
            System.out.println("내 답 : " + note.getMyAnswer());
            System.out.println("정답 : " + note.getCorrectAnswer());
            System.out.println("해설 : " + note.getExplanation());
        }
    }

    private void deleteWrongAnswer() {
        Subject subject = selectSubject();

        if (subject == null) return;

        List<WrongAnswerNote> notes = subject.getWrongAnswers();

        if (notes.isEmpty()) {
            System.out.println("삭제할 오답이 없습니다.");
            return;
        }

        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i).getQuestion());
        }

        System.out.print("삭제할 오답 번호 >> ");
        int num = scan.nextInt();
        scan.nextLine();

        if (num < 1 || num > notes.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        subject.removeWrongAnswer(num - 1);

        System.out.println("오답이 삭제되었습니다.");
    }
}

