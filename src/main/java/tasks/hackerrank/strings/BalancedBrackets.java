package tasks.hackerrank.strings;

import java.util.Stack;

/**
 * Name: Java Stack. From: hackerrank.com. Date: 03.11.2018
 * https://www.hackerrank.com/challenges/java-stack/problem
 * <p>
 * Find out if given string of brackets is balanced or not.
 * <p>
 * Balanced examples: "{}()"     "[{()}]"    "({()})"
 * <p>
 * Unbalanced examples: "{}("     "({)}"     "[[", "}{"
 */
public class BalancedBrackets {

    /**
     * Сначала удаляем все не-скобочные сиимволы в строке с помощью regexp.
     * Остаются только скобки: (  )  [  ]  {  }.
     * <p>
     * Затем используем стек. Он позволят увидеть вложенность скобок.
     * <p>
     * Мы проходим по строке и смотрим: если текущая скобка закрывает предыдущую (в стеке),
     * то они друг друга уничтожают: убираем прошлую из стека и не добавляем текущую.
     * <p>
     * Далее смотрим следующую: закрывает ли она новую скобку из стека (следующий уровень) или нет.
     * И так далее.
     *
     * @param input Input String.
     * @return <tt>true</tt> if brackets balanced, <tt>false</tt> if not.
     */
    /*
    Пример работы:
            1) Дана строка (a + b *[3 - 2] + {18})
            2) Удаляем все лишнее, остается: ([]{})
            3) Читаем символы, получаем стек:
                (   -->     стек пустой         -->     стек: (
                {   -->     сравниваем ( и [    -->     стек: ([
                ]   -->     сравниваем [ и ]    -->     стек: (
                {   -->     сравниваем ( и {    -->     стек: ({
                }   -->     сравниваем { и }    -->     стек: (
                )   -->     сравниваем ( и )    -->     стек: пустой
            4) Все символы прочитаны, стек пустой.
            Значит, все скобки друг друга уничтожили.
            Значит, эта строка сбалансированна.
     */
    public boolean hasBalancedBrackets(String input) {
        // get rid of non-brackets: (  )  [  ]  {  }
        input = input.replaceAll("[^(){}\\[\\]]", "");
        Stack<Character> stack = new Stack<>();
        for (char cur : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                char prev = stack.peek();
                if ((prev == '(' && cur == ')')
                        || (prev == '[' && cur == ']')
                        || (prev == '{' && cur == '}')
                ) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean[] hasBalancedBrackets(String... inputs) {
        boolean[] results = new boolean[inputs.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = this.hasBalancedBrackets(inputs[i]);
        }
        return results;
    }
}
