package calculatorthird;

@FunctionalInterface // 함수형 인터페이스 선언(하나의 추상 메서드)
interface operation<T>{ // T는 타입 매개변수 -> 당 인터페이스를 사용시 타입을 지정할 수 있음
    T num(T a, T b); // 두 개의 T 타입의 인자를 받아서 T 타입을 반환
}

public enum OperatorType {
    PLUS('+', (a, b) -> {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a + (Integer) b; // 두 값이 Integer일 경우 int로 반환
        } else {
            return a.doubleValue() + b.doubleValue(); // 그 외에는 double로 계산
        }

    }),
    MINUS('-', (a, b) -> {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a - (Integer) b;
        } else {
            return a.doubleValue() - b.doubleValue();
        }
    }),
    MULTIPLY('*', (a, b) -> {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a * (Integer) b;
        } else {
            return a.doubleValue() * b.doubleValue();
        }
    }),
    DIVIDE('/', (a, b) -> (Double) (a.doubleValue() / b.doubleValue()));


    private char operator;
    private operation<Number> operation;

    OperatorType(char operator, operation<Number> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    /* 조금 더 이해? 필요? */
    public static OperatorType getOpreratorType(char operator){
        for (OperatorType ot : OperatorType.values()) { // OperatorType.values() -> Enum 타입에 정의된 모든 Enum 상수들을 배열로 반환하는 메서드
            if(ot.getOperator() == operator){ // 사용자가 입력한 기호(operator), enum에 들어있는 사칙연산기호(ot.getOperator())
                return ot;
            }
        }
        return null;
    }

    // 메소드 호출 및 결과 반환
    public Number apply(Number a, Number b) {
        return operation.num(a, b); // 연산 실행
    }

    public char getOperator() {
        return operator; // 연산자 기호 반환
    }
}
