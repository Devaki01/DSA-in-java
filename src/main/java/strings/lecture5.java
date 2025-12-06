package strings;

public class lecture5 {
    public static void main(String[] args) {
        StringBuilder xoxo = new StringBuilder();

        for(int i=0; i<26; i++){
            char ch = (char)('a' + i);
            xoxo.append(ch);
        }

        System.out.println(xoxo);
        System.out.println(xoxo.reverse());

    }
}
