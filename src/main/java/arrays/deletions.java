package arrays;

import java.util.Arrays;

public class deletions {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arr));
        System.out.println("deleting 1....");

        int pos = 1;

        for(int i=pos; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }

        System.out.println(Arrays.toString(arr));

    }
}
