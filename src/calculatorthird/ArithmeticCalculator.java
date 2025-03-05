package calculatorthird;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    // 속성
    private List<Number> results = new ArrayList<>(); // 결과를 저장하는 리스트

    // 생성자
    ArithmeticCalculator() {
    }

    Number calculate(T numFirst, T numSecond, char operator) {
        Number result = 0;

        switch (operator) { // results가 인스턴스 변수인데, calculate() 메서드를 static 메서드로 선언하여 results를 접근하려 할 때 발생하는 에러
            case '+':
                result = OperatorType.PLUS.apply(numFirst, numSecond);
                System.out.println(numFirst + " ➕ " + numSecond + " \uD83D\uDFF0 " + OperatorType.PLUS.apply(numFirst, numSecond));
                break;
            case '-':
                result = OperatorType.MINUS.apply(numFirst, numSecond);
                System.out.println(numFirst + " ➖ " + numSecond + " \uD83D\uDFF0 " + OperatorType.MINUS.apply(numFirst, numSecond));
                break;
            case '*':
                result = OperatorType.MULTIPLY.apply(numFirst, numSecond);
                System.out.println(numFirst + " ✖\uFE0F " + numSecond + " \uD83D\uDFF0 " + OperatorType.MULTIPLY.apply(numFirst, numSecond));
                break;
            case '/':
                result = OperatorType.DIVIDE.apply(numFirst, numSecond);
                System.out.println(numFirst + " ➗ " + numSecond + " \uD83D\uDFF0 " + OperatorType.DIVIDE.apply(numFirst, numSecond));
                break;
            default:
                System.out.println("잘못된 접근입니다. ");
                break;
        }
        results.add(result);
        return result;
    }

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    List<Number> removeResults() {
        results.remove(0);
        return results;
    }

    // 문자열을 숫자(Number)로 변환하는 메서드
    public static Number parseNumber(String input) {
        try {
            // 입력이 정수일 경우
            if (input.contains(".")) {
                return Double.parseDouble(input);  // 실수 처리
            } else {
                return Integer.parseInt(input);  // 정수 처리
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력");
        }
    }

    // Scanner로 입력받은 값보다 큰 결과값들 출력
    public void reference(int reference){
        List<Number> filterRestult = results.stream()
                .filter(result -> result.doubleValue() > reference)
                .collect(Collectors.toList());
        System.out.println(filterRestult);
    }
}
