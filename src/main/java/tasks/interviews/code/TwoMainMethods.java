package tasks.interviews.code;

import java.lang.reflect.Field;

/**
 * Задачка с собеседования в Сбере:
 * Как изменить код программы, чтобы она компилировалась
 * и выводила в консоль "Right", при этом не изменяя код первого метода.
 */
public class TwoMainMethods {

    /*

    === Source (doesn't compile) ===

    public static void main(String[] args) {
        System.out.println("Wrong");
    }

    public static void main(String[] args) {
        System.out.println("Right");
    }

    */

}

/**
 * Первый вариант: вместо метода делаем статическую
 * инициализацию. Сначала срабатывает она, потом метод main.
 * Результат: сначала "Right", затем "Wrong"
 */
class AnswerOneSimple {
    static {
        System.out.println("Right");
    }

    public static void main(String[] args) {
        System.out.println("Wrong");
    }
}

/**
 * Второй вариант, хитрее. Создаем свой класс String. Теперь первый
 * метод ссылается на него, и тогда он уже не точка входа в программу,
 * так как сигнатура его изменилась.
 * <p>
 * Во втором методе мы явно указываем java.lang.String, поэтому его
 * сигнатура становится именно как сигнатура точки входа в программу.
 * <p>
 * Получается теперь, что первый метод main - это просто "перегрузка"
 * второго метода, принимающий в качестве аргументов массив нашего созданного
 * класса String[]. А второй метод - стандартная точка входа в программу.
 * <p>
 * Выполнение программы начнется со второго метода, а первый вообще вызван
 * не будет. В результате - будет написано только "Right".
 */
class AnswerTwoCreateCustomStringClassy {
    public static void main(String[] args) {
        System.out.println("Wrong");
    }

    public static void main(java.lang.String[] args) {
        System.out.println("Right");
    }

    class String {
    }
}

/**
 * Третий вариант, совсем хитрый.
 * <p>
 * При запросе литерала "Wrong" выдается один и тот же объект из стринг пула. Назовем его wrongObj.
 * В static{} блоке мы запрашиваем (и создаем) объект wrongObj и меняем в нем поле wrongObj.value = "Right".
 * <p>
 * В методе main при запросе литерала "Wrong" мы получаем уже созданный и измененный нами объект wrongObj.
 * В консоль по факту выводится wrongObj.value, поэтому println("Wrong") дает результат "Right".
 */
class AnswerThreeUsingReflection {
    static {
        try {
            String right = "Wrong";
            Field field = right.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(right, new char[]{'R', 'i', 'g', 'h', 't'});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Wrong");
    }


}