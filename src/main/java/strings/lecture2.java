package strings;

public class lecture2 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello"; //same object as a

        System.out.println(a == b); //comparator, checks value as well as ref variable/where the obj is stored
        System.out.println(a.equals(b)); //checks only the value

        String c = new String("hello"); //creates new string hello, new  object

        System.out.println(a == c); //comparator
        System.out.println(a.equals(c));

    }
}
