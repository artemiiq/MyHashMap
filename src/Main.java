public class Main {
    public static void main(String[] args) {
        MyHashMap list = new MyHashMap();

        list.put("Hello", 1);
        list.put("World", 2);
        list.put("GoIT courses", 3);

        System.out.println(list.get("World"));

        list.remove("Hello");

        System.out.println("Size after remove: " + list.size());

        list.clear();

        System.out.println("Size after clear: " + list.size());
    }
}