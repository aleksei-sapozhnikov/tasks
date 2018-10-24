package tasks.interviews.code;

/**
 * Хитрости с тернарным оператором
 */
public class TernaryOperator {

}

/**
 * В коде задачка переделана на java8.
 * Оригинал задачки сделан на java 10:
 * <p>
 * Что будет выведено на экран?
 * <p>
 * final var targaryens = 2;
 * final var lannisters = 25;
 * final var starks = '1';
 * final var snow = true ? targaryens * lannisters : starks;
 * System.out.print(snow);
 * <p>
 * A. 2
 * B. 25
 * C. 1
 * D. 50
 * <p>
 * Ответ А: 2. Причина в том, что в данном тернарный оператор  определяет тип результата как char, и (char) 50 == '2'.
 * <p>
 * Логика его такова: если один из операндов - константа типа int  (а это targaryens * lannisters, поскольку они
 * объявлены как final и, следовательно,  компилятор переделает их в константы) , а другой оператор - типа byte,
 * short или char, то результат будет приведен к типу другого оператора (byte, short или char).
 * <p>
 * Оригинал: If one of the operands is of type Twhere T is byte, short, or char, and the other operand is a constant
 * expression (§15.28) of type intwhose value is representable in type T, then the type of the conditional
 * expression is T. http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.25
 */
class ResultType {
    public static void main(String[] args) {
        final int targaryens = 2;
        final int lannisters = 25;
        final char starks = '1';
        System.out.println("When starks instanceof char: " + (
                true ? targaryens * lannisters : starks
        ));
        System.out.println("When starks instanceof int:  " + (
                true ? targaryens * lannisters : (int) starks
        ));
    }
}



