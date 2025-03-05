package calculatorSecond;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    // 속성
    private List<Number> results = new ArrayList<>();

    // 생성자
    Calculator() {
    }


    // 기능
    Number operations(int numFirst, int numSecond, char operator){
        Number result = 0;

        if (operator == '+') {
            result = numFirst + numSecond;
            System.out.println(numFirst + " ➕ " + numSecond + " \uD83D\uDFF0 " + result);
        }
        else if (operator == '-') {
            result = numFirst - numSecond;
            System.out.println(numFirst + " ➖ " + numSecond + " \uD83D\uDFF0 " + result);
        } else if (operator == '*') {
            result = numFirst * numSecond;
            System.out.println(numFirst + " ✖\uFE0F " + numSecond + " \uD83D\uDFF0 " + result);
        } else {
            result = (double)numFirst / numSecond;
            System.out.println(numFirst + " ➗ " + numSecond + " \uD83D\uDFF0 " + result);
        }
        results.add(result); // results 리스트에 result 추가
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
}
