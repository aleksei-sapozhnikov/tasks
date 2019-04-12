package tasks.interviews;

import java.util.StringJoiner;

/**
 * Простой односвязный список.
 * В него добавляются методы по заданиям.
 *
 * @param <V>
 */
public class LinkedListOneD<V> {
    /**
     * Первый и последний элементы списка
     * Если список пуст - оба null.
     * Если только один элемент - то head == tail.
     */
    private Entry<V> head = null;
    private Entry<V> tail = null;

    /**
     * Не по заданию, просто чтобы добавлять методы.
     *
     * @param value Добавляемое значение.
     */
    public void add(V value) {
        Entry<V> addition = new Entry<>(value);
        if (this.head == null) {
            this.head = addition;
        } else {
            this.tail.next = addition;
        }
        this.tail = addition;
    }

    /**
     * Задача: дан односвязный список. Разверните его - сделайте
     * так, чтобы голова стала хвостом, а хвост - головой.
     * НЕ СОЗДАВАЯ НОВЫЙ СПИСОК.
     * <p>
     * Было: a1-->a2-->a3-->a4
     * Стало: a4-->a3-->a2-->a1
     * <p>
     * Решение: проходим по списку и меняем
     * ссылку со следующего элемента на
     * предыдущий:
     * a1<--a2<--a3<--a4
     * Получится a1.next==null, a2.next==a1 и т.д.
     */
    public void revertThisList() {
        /* More complex code, for history */
        /*
        Entry<V> next = null;
        if (this.head != null) {
            next = this.head.next;
            this.head.next = null;
        }
        Entry<V> prev = this.head;
        Entry<V> current = next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        */

        /* Simplified ccde, still not sure all corner-cases work */
        this.tail = this.head;
        Entry<V> prev = null;
        Entry<V> cur = this.head;
        Entry<V> next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        this.head = prev;
    }

    /**
     * Задача: дан односвязный список. Разверните его - сделайте
     * так, чтобы голова стала хвостом, а хвост - головой.
     * СОЗДАВ ПРИ ЭТОМ НОВЫЙ СПИСОК
     * <p>
     * Было: a1-->a2-->a3-->a4
     * Стало: a4-->a3-->a2-->a1
     */
    public LinkedListOneD<V> revertCreateNewList() {
        /* More complex code, for history */
        /*
        LinkedListOneD<V> result = new LinkedListOneD<>();
        Entry<V> current = null;
        if (this.head != null) {
            result.head = new Entry<>(this.head.value);
            result.tail = result.head;
            current = this.head.next;
        }
        while (current != null) {
            Entry<V> added = new Entry<>(current.value);
            added.next = result.head;
            result.head = added;
            current = current.next;
        }
        return result;
        */

        /* Simplified ccde, still not sure all corner-cases work */
        LinkedListOneD<V> result = new LinkedListOneD<>();
        result.tail = this.head;
        Entry<V> cur = this.head;
        while (cur != null) {
            Entry<V> add = new Entry<>(cur.value);
            add.next = result.head;
            result.head = add;
            cur = cur.next;
        }
        return result;
    }

    /**
     * Метод для отображения списка.
     *
     * @return Отображение списка.
     */
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(" --> ", "{ ", " }");
        Entry<V> current = this.head;
        while (current != null) {
            result.add(current.toString());
            current = current.next;
        }
        return result.toString();
    }

    /**
     * Нода листа.
     *
     * @param <E> Тип хранимого значения.
     */
    private class Entry<E> {
        private Entry<E> next = null;
        private E value;

        private Entry(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
