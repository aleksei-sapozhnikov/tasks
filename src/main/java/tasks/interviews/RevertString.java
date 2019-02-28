package tasks.interviews;

/**
 * Задача: развернуть строку.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class RevertString {

    /**
     * Представляем строку как массив char
     * и просто переставляем первый с последним,
     * второй с предпоследним и т.д.
     *
     * @param str Данная строка.
     * @return Перевернутая строка.
     */
    public String revertUsingCharArray(String str) {
        String result = "";
        if (str.length() > 0) {
            char[] array = str.toCharArray();
            int length = array.length;
            for (int i = 0; i < length / 2; i++) {
                int corr = length - i - 1;
                char temp = array[corr];
                array[corr] = array[i];
                array[i] = temp;
            }
            result = String.valueOf(array);
        }
        return result;
    }

    /**
     * Используем встроеннвую функцию StringBuilder-а.
     *
     * @param str Данная строка.
     * @return Перевернутая строка.
     */
    public String revertUsingStringBuilder(String str) {
        return new StringBuilder(str)
                .reverse()
                .toString();
    }

}
