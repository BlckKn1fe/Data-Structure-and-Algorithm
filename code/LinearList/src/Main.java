public class Main {

    public static void main(String[] args) {
        testArrayList();
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
        System.out.println("--------- Delete Insert ----------");
        // System.out.println("arr.delete(20): " + arr.delete(20)); // Will throw a RunTimeException
        System.out.println("arr.delete(0): " + arr.delete(0));  // Expect 0
        System.out.println("arr.delete(1): " + arr.delete(1));  // Expect 4
        System.out.println("arr.delete(5): " + arr.delete(5));  // Expect 6
        System.out.println(arr);  // Expect [1, 2, 3, 4, 5]
        System.out.println("--------- IndexOf Insert ----------");
        System.out.println("arr.indexOf(null): " + arr.indexOf(null));  // Expect -1
        System.out.println("arr.indexOf(50): " + arr.indexOf(50));  // Expect -1
        System.out.println("arr.indexOf(3): " + arr.indexOf(3));  // Expect 2
        System.out.println("--------- Get Insert ----------");
        System.out.println("arr.get(-5): " + arr.get(-5)); // Expect null
        System.out.println("arr.get(200): " + arr.get(200)); // Expect null
        System.out.println("arr.get(4): " + arr.get(4)); // Expect 5
        System.out.println("--------- Clear/IsEmpty Insert ----------");
        System.out.println("arr.isEmpty(): " + arr.isEmpty()); // Expect false
        System.out.println("arr.clear()");
        arr.clear();
        System.out.println("arr.isEmpty(): " + arr.isEmpty()); // Expect true
        System.out.println("arr.length(): " + arr.length()); // Expect 0
        System.out.println("arr.get(0): " + arr.get(0)); // Expect null
        System.out.println("arr.indexOf(0): " + arr.indexOf(0)); // Expect -1
    }

}
