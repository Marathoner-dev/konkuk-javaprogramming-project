package project;

import java.util.Scanner;

public class Menu {
    private Stopwatch stopwatch = new Stopwatch();


    public void stopwatchMenu(Scanner scan) {

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

