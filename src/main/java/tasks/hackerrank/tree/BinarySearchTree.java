package tasks.hackerrank.tree;

/**
 * Name: Binary search tree. From: hackerrank.com. Date: 17.10.2018
 * <p>
 * Изначально заданием было найти высоту дерева, но для этого нужно создать дерево.
 * Поэтому получился класс бинарного дерева (очень простого), чтобы вспомнить как оно делается.
 * <p>
 * The height of a binary search tree is the number of edges between the tree's root and its furthest leaf.
 * You are given a pointer, root, pointing to the root of a binary search tree.
 * Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
 */
public class BinarySearchTree {

    /**
     * Tree root.
     */
    private Node root;

    /**
     * Create new tree node and insert it into the tree.
     * <p>
     * Идея метода: рекурсия. Вначале нам дают корень дерева. Если он null, значит, нужно создать дерево.
     * Возвращаем просто новую ноду, и у нас дерево из одной ноды.
     * <p>
     * Если корень не null, то смотрим значения. Если наш элемент меньше (или равен) значению в корне -
     * его нужно в левую ветвь. Если больше - в правую.
     * <p>
     * Зайдя в ветвь, мы по сути имеем новое дерево, у которого корень - root.left или root.right.
     * Нам в это дерево нужно вставить элемент, для чего у нас есть функция insert.
     * То есть, снова вызываем функцию insert(node, value).
     * <p>
     * Рано или поздно мы дойдем до конца дерева, то есть до того, что вызовем insert (null, data).
     * Этот метод вернет нам новую ноду с нашим значением.
     * Результат будет использован в методе insert родителя как parent.right = cur или parent.left = cur.
     * В свою очередь, результат метода insert родителя использует метод insert прародителя (parent of parent)
     * и так далее, пока не дойдем до корневого элемента.
     * <p>
     * Далее нам просто осталось присвоить эту ноду как лист родительского узла.
     *
     * @param root Root of the tree. If given <tt>null</tt>, creates new root and returns it.
     * @param data Data to insert.
     * @return Root node of the tree.
     */
    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node cur;
        if (data <= root.value) {
            cur = this.insert(root.left, data);
            root.left = cur;
        } else {
            cur = this.insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    /**
     * Дерево строится так. Сначала берется первый элемент - это будет корень нашего дерева.
     * Затем каждый элемент прогоняется через метод insert, чтобы создать ноду с соответствующим
     * значением в нужном месте.
     *
     * @param values Array of values.
     * @return Result tree.
     */
    public BinarySearchTree buildTree(int... values) {
        this.root = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        return this;
    }

    public int getTreeHeight() {
        return this.getHeight(this.root);
    }

    /**
     * Логика поиска высоты дерева (максимальной длины от корня до последнего узла):
     * мы заходим в очередную ноду, смотрим - если она null, значит, наш поиск окончен, и мы возвращаем -1.
     * <p>
     * Если же нода не null, то мы берем два поддерева: левое и правое. И ищем их высоту этим же
     * методом (рекурсия). Затем сравниваем, что получилось больше: левое или правое.
     * Большее возвращаем более высокой ноде, та сравнивает свои правое-левое значения, возвращает большее и т.д.
     * <p>
     * В итоге в "верхнем" методе getHeight мы получим максимальное значение высоты.
     * <p>
     * Возвращаемое значение - это высота поддерева + 1 (т. е. плюс наш элемент). Но в таком случае, если нода
     * будет null, она тоже вернула бы 1 - как элемент. Поэтому если нода null, мы возвращаем -1.
     * Итого, от нулевой ноды вернется 0, от ненулевой: +1.
     * <p>
     * Сделать так, чтобы null нода возвращала 0, а в return не было +1, нельзя. Тогда мы просто
     * не будем учитывать нашу текущую ненулевую ноду, сумма не будет расти. И итоговая длина всегда будет 0.
     *
     * @param root Current Node.
     * @return Maximum of left and right subtrees lengths.
     */
    private int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int dLeft = this.getHeight(root.left);
        int dRight = this.getHeight(root.right);
        return Math.max(dLeft, dRight) + 1;
    }

    /**
     * Node class.
     */
    private class Node {
        private Node left = null;
        private Node right = null;
        private int value;

        private Node(int value) {
            this.value = value;
        }
    }

}
