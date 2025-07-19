package arrays;

import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> sock = new ArrayList<>(5);
        //cannot write int

        for(int i=0; i<7; i++){
            sock.add(i);
        }

        System.out.println(sock);
        System.out.println(sock.contains(9));//false
        sock.set(6, 9); //setting 6th index to 9
        System.out.println(sock.contains(9));//true
        sock.remove(1);
        System.out.println(sock);

        //for inputting
        sock.get(6);
    }
}
