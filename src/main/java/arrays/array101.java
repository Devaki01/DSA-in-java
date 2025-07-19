package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class array101 {
    static void changeto(int arr[]){
        arr[0] = 9;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int[] arr1 = {1, 3, 5, 6, 7};

        // int[] - datatype of elements in the array
        //all type of data in the array is same
        int[] ros; // declaration of an array. ros is getting defined in the stack
        int[] ros1 = new int[5]; //initialisation of the array: object is been created here in the memory.(heap)

        //dynamic allocation
        //memory allocated at runtime
        //object created at runtime

        //array objects are in heap
        //heap objects are not continuos
        //each element of an array is an object.
        //they can be anywhere in a heap

        String[] str = new String[4];
        System.out.print(str[0]);
        //null is a value of any reference value
        //null is a literal

        //input using for loops

        for(int i=0; i<4; i++){
            arr[i] = sc.nextInt();
        }

        for(int num : arr){
            System.out.print(arr[num] + " ");
        }

        System.out.println(Arrays.toString(arr));

        int[] nums = {1, 2, 3, 5, 6};
        changeto(nums);

        System.out.println(Arrays.toString(nums));

    }
}
