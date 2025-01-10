package prototype;

public class StringReference {

    public static void main(String[] args) {
        String s = new String("hi"); // This bypasses the String buffer, directly creates the object in heap
        String s1 = "hi"; // This first checks String buffer

        System.out.println(
                s1.equals(s) // true : value wise equal
        );

        System.out.println(
                s1 == s // false : reference wise not equal
        );
    }

}
