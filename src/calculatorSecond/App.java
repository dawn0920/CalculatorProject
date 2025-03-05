package calculatorSecond;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        객체 불러오기
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

//        무한 루프문
        while (true) {
            // 첫번째 정수 입력
            System.out.print("첫번째 양의 정수(0 포함)를 입력해주시오. : ");
            int numFirst = sc.nextInt();

            // 사칙연산 기호 입력
            char operator;
            while (true) {
                System.out.print("사칙연산 기호(➕,➖,✖\uFE0F,➗)를 입력해주시오. : ");
                operator = sc.next().charAt(0);
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("입력된 기호가 사칙연산 기호가 아닙니다. 다시 입력해주세요.");
                } else { break; }
            }

            // 두번째 정수 입력
            int numSecond;
            while (true) {
                System.out.print("두번째 양의 정수(0 포함)를 입력해주시오. : ");
                numSecond = sc.nextInt();
                if (operator == '/' && numSecond == 0) { // int numSecond; 선언할 경우 값이 없기 떄문에 에러 발생
                    System.out.println("나눗셈 진행중... 숫자에 0이 들어갈 수 없습니다. 다시 입력해주세요.");
                } else { break; }
            }

            // 연산 및 출력을 위한 메소드 호출
            calculator.operations(numFirst, numSecond, operator);

            // 배열값 읽기
            System.out.println("지금까지 계산된 결과 : " + calculator.getResults());

            // 배열값 제거
            System.out.print("배열값을 제거하려면 >> remove << 를 입력해주세요. 가장 처음 입력한 값이 제거됩니다. : ");
            String remove = sc.next();
            if ("remove".equals(remove)) {
                System.out.println("배열을 삭제합니다. " + calculator.removeResults());
            }

            // 무한 반복 탈출을 위한 exit 코드
            System.out.print("계산기를 그만 사용하시려면 >> exit << 를 입력해주세요. : ");
            String exit = sc.next();
            if ("exit".equals(exit)) {
                System.out.println("계산기를 종료합니다.");
                break;
            } else {
                System.out.println("계산기를 다시 시작합니다.");
            }
        }
    }

}
