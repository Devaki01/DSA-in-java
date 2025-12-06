package strings;

import java.util.Arrays;

public class lecture5 {
    public static void main(String[] args) {
        StringBuilder xoxo = new StringBuilder();

        for(int i=0; i<26; i++){
            char ch = (char)('a' + i);
            xoxo.append(ch);
        }

        System.out.println(xoxo);
        System.out.println(xoxo.reverse());

        String name = "hehehehehe";
        System.out.println(Arrays.toString(name.toCharArray()));

        String var = "HAHAHAHAH";
        System.out.println(var.toLowerCase());

        String word = "palindrome";
        System.out.println(word.indexOf("o"));
        System.out.println(word.lastIndexOf("e"));

        String sen = "hello, my name is devaki";
        System.out.println(Arrays.toString(sen.split(" ")));
    }
}
