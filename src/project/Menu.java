package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String userName;
    private List<Subject> subjects = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public Menu(String userName) {
        this.userName = userName;
    }

    public void startMenu(Scanner scan){
        while(true){
            System.out.print("====기능 선택 ====");
            System.out.println("1. 시험 일정");
            System.out.println("2. 할 일");
            System.out.println("3. 과목");
            System.out.println("4. 스탑워치");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int choice = scan.nextInt();

            switch(choice){
                case 1 -> examMenu();

                case 2 -> toDoMenu();

                case 3 -> subjectMenu();

                case 4 -> stopwatchMenu();

                case 0 -> {
                    System.out.println("사용을 종료합니다.");
                    return;
                }
                
            }
        }
    }

    private void toDoMenu() {
    }

    private void examMenu() {
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
                    stopwatch.start();
                    System.out.println("스탑워치를 시작했습니다.");
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


}

