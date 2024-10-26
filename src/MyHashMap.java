public class MyHashMap {
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private Node[] nodes;

    public MyHashMap() {
        nodes = new Node[INITIAL_CAPACITY];
    }

    public static class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node current = nodes[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = nodes[index];
        nodes[index] = newNode;
        size++;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node current = nodes[index];

        while (current!= null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(Object key) {
        int index = getIndex(key);
        Node current = nodes[index];
        Node previous = null;

        while (current!= null) {
            if (current.key.equals(key)) {
                if (previous!= null) {
                    previous.next = current.next;
                } else {
                    nodes[index] = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        nodes = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int getIndex(Object key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }
}
