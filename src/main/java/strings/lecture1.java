package strings;

public class lecture1 {
    public static void main(String[] args) {
        String name = "Devaki Joshi";

        //String is a class
        //String-> class | name-> ref variable | devaki joshi -> object
        //same objects are not recreated again in memory - string pooling
        //stored in heap

        String a = "hello";
        String b = "hello";

        System.out.println(a);

//        String a =  "hi"; cannot happen as strings are immutable
        a = "hi"; //created a new object
        //original a (hello) became garbage value
        System.out.println(a);


    }
}
