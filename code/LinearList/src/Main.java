public class Main {

    public static void main(String[] args) {
//        testArrayList();
//        testLinkedList();
//        testArrayStack();

    }

    private static void testArrayStack() {
        Stack<Integer> s = new Stack<>(5);
        System.out.println("s.isEmpty(): " + s.isEmpty());
        System.out.println("s.isFull(): " + s.isFull());
        System.out.println("s.push(1): " + s.push(1));
        System.out.println("s.push(2): " + s.push(2));
        System.out.println("s.push(3): " + s.push(3));
        System.out.println("s.push(4): " + s.push(4));
        System.out.println("s.push(5): " + s.push(5));
        System.out.println("s.isEmpty(): " + s.isEmpty());
        System.out.println("s.isFull(): " + s.isFull());
        System.out.println("s.length(): " + s.length());
        System.out.println("s.peek():" + s.peek());
        System.out.println("s.pop():" + s.pop());
        System.out.println("s.length(): " + s.length());
        System.out.println("s.isEmpty(): " + s.isEmpty());
        System.out.println("s.isFull(): " + s.isFull());
        System.out.println("s.clear(): ");
        s.clear();
        System.out.println("s.length(): " + s.length());
        System.out.println("s.isEmpty(): " + s.isEmpty());
        System.out.println("s.isFull(): " + s.isFull());
    }

    public static void testLinkedList() {
        Integer[] arr = {1, 2, 3};
        LinkedList<Integer> list = LinkedList.headGenerate(arr);
        list.add(4);
        list.add(5);
        System.out.println(list + "  // Expect [1, 2, 3, 4, 5]");
        System.out.println("list.insert(0, 20): " + list.insert(0, 20) + "  // Expect true");
        System.out.println("list.insert(3, 15): " + list.insert(3, 15) + "  // Expect true");
        System.out.println(list + "  // Expect [20, 1, 2, 15, 3, 4, 5]");
        System.out.println("list.get(0): " + list.get(0) + "  // Expect 20");
        System.out.println("list.get(2): " + list.get(2) + "  // Expect 2");
        System.out.println("list.get(5): " + list.get(5) + "  // Expect 4");
        System.out.println("list.length(): " + list.length() + "  // Expect 7");
        System.out.println("list.remove(0): " + list.remove(0) + "  // Expect 20");
        System.out.println("list.remove(2): " + list.remove(2) + "  // Expect 15");
        System.out.println("list.remove(4): " + list.remove(4) + "  // Expect 5");
        System.out.println("list.length():" + list.length() + "  // Expect 4");
        System.out.println("list.isEmpty(): " + list.isEmpty() + "  // Expect false");
        System.out.println("list.clear()");
        list.clear();
        System.out.println("list.length(): " + list.length() + "  // Expect 0");
        System.out.println("list.isEmpty(): " + list.isEmpty() + "  // Expect true");
    }

    public static void testArrayList() {
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("arr.add(1): " + arr.add(1));
        System.out.println("arr.add(2): " + arr.add(2));
        System.out.println("arr.add(3): " + arr.add(3));
        System.out.println("arr.add(4): " + arr.add(4));
        System.out.println("arr.add(5): " + arr.add(5));
        System.out.println("arr.add(null): " + arr.add(null));
        System.out.println(arr);  // Expect [1, 2, 3, 4, 5]
        System.out.println("arr.length(): " + arr.length());
        System.out.println("--------- Test Insert ----------");
        System.out.println("arr.insert(20, 6): " + arr.insert(20, 6));  // Expect false
        System.out.println("arr.insert(5, 6): " + arr.insert(5, 6));  // Expect true
        System.out.println("arr.insert(0, 0): " + arr.insert(0, 0));  // Expect true
        System.out.println("arr.insert(2, 4): " + arr.insert(2, 4));  // Expect true
        System.out.println("arr.insert(5, null): " + arr.insert(5, null));  // Expect false
        System.out.println(arr);  // Expect [0, 1, 4, 2, 3, 4, 5, 6]
        System.out.println("--------- Test Delete ----------");
        // System.out.println("arr.delete(20): " + arr.delete(20)); // Will throw a RunTimeException
        System.out.println("arr.delete(0): " + arr.delete(0));  // Expect 0
        System.out.println("arr.delete(1): " + arr.delete(1));  // Expect 4
        System.out.println("arr.delete(4): " + arr.delete(4));  // Expect 5
        System.out.println(arr);  // Expect [1, 2, 3, 4, 5]
        System.out.println("--------- Test IndexOf ----------");
        System.out.println("arr.indexOf(null): " + arr.indexOf(null));  // Expect -1
        System.out.println("arr.indexOf(50): " + arr.indexOf(50));  // Expect -1
        System.out.println("arr.indexOf(3): " + arr.indexOf(3));  // Expect 2
        System.out.println("--------- Test Get ----------");
        System.out.println("arr.get(-5): " + arr.get(-5)); // Expect null
        System.out.println("arr.get(200): " + arr.get(200)); // Expect null
        System.out.println("arr.get(4): " + arr.get(4)); // Expect 5
        System.out.println("--------- Test Clear/IsEmpty ----------");
        System.out.println("arr.isEmpty(): " + arr.isEmpty()); // Expect false
        System.out.println("arr.clear()");
        arr.clear();
        System.out.println("arr.isEmpty(): " + arr.isEmpty()); // Expect true
        System.out.println("arr.length(): " + arr.length()); // Expect 0
        System.out.println("arr.get(0): " + arr.get(0)); // Expect null
        System.out.println("arr.indexOf(0): " + arr.indexOf(0)); // Expect -1
    }

}
