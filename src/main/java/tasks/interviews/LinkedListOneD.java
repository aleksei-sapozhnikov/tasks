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
        if (this.head == null) {
            this.head = new Entry<>(value);
            this.tail = this.head;
        } else {
            Entry<V> entry = new Entry<V>(value);
            this.tail.next = entry;
            this.tail = entry;
        }
    }

    /**
     * Задача: дан односвязный список. Разверните его - сделайте
     * так, чтобы голова стала хвостом, а хвост - головой.
     * <p>
     * Для правдоподобности добавим, что пользоваться элементом tail НЕЛЬЗЯ.
     * (иначе слишком просто).
     * <p>
     * Было: a1-->a2-->a3-->a4
     * Стало: a4-->a3-->a2-->a1
     */
    public void revertThisList() {
        Entry<V> current = this.head;
        Entry<V> next = null;
        if (current != null) {
            next = current.next;
            current.next = null;
        }
        Entry<V> nextNext;
        while (next != null) {
            nextNext = next.next;
            next.next = current;
            current = next;
            next = nextNext;
        }
        this.head = current;
    }

    /**
     * Ровно та же задача с перевертыванием, но здесь мы
     * создаем новый лист, а не меняем существующий.
     * <p>
     * Задача: дан односвязный список. Разверните его - сделайте
     * так, чтобы голова стала хвостом, а хвост - головой.
     * <p>
     * Для правдоподобности добавим, что пользоваться элементом tail НЕЛЬЗЯ.
     * (иначе слишком просто).
     * <p>
     * Было: a1-->a2-->a3-->a4
     * Стало: a4-->a3-->a2-->a1
     */
    public LinkedListOneD<V> revertCreateNewList() {
        LinkedListOneD<V> result = new LinkedListOneD<>();
        Entry<V> head = this.head;
        Entry<V> toAdd = null;
        if (head != null) {
            toAdd = head.next;
            result.tail = new Entry<>(head.value);
            result.head = result.tail;
        }
        Entry<V> second;
        while (toAdd != null) {
            second = result.head;
            result.head = new Entry<>(toAdd.value);
            result.head.next = second;
            toAdd = toAdd.next;
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
