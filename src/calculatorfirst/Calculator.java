package calculatorfirst;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
//        Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
        Scanner sc = new Scanner(System.in);

//        반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
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

            // 연산을 위한 조건문
            int result = 0;
            if (operator == '+') {
                result = numFirst + numSecond;
                System.out.println(numFirst + " ➕ " + numSecond + " \uD83D\uDFF0 " + result);
            } else if (operator == '-') {
                result = numFirst - numSecond;
                System.out.println(numFirst + " ➖ " + numSecond + " \uD83D\uDFF0 " + result);
            } else if (operator == '*') {
                result = numFirst * numSecond;
                System.out.println(numFirst + " ✖\uFE0F " + numSecond + " \uD83D\uDFF0 " + result);
            } else {
                double result1 = 0;
                result1 = (double) numFirst / numSecond;
                System.out.println(numFirst + " ➗ " + numSecond + " \uD83D\uDFF0 " + result1);
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
