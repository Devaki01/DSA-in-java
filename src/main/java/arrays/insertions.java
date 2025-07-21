package arrays;

public class insertions {

    public static void main(String[] args) {

        //1. Inserting a new element at the end of the Array.
        int[] intArray = new int[6];
        int length = 0;

        for(int i=0; i<3; i++){
            intArray[length] = i;
            length++;
        }
        intArray[length] = 10;

        System.out.println("After insertion at end position");

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }

        //2. Inserting a new element at the start of the Array.

        for(int j=4; j>=0; j--){
            intArray[j+1] = intArray[j];
            intArray[j] = 20;
        }

        System.out.println("After insertion at start position");

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }

        //3. Inserting a new element at the middle of the Array.

        for(int k=4; k >= 2; k--){
            intArray[k+1] = intArray[k];
        }
        intArray[2] = 99;

        System.out.println("After insertion at middle position");

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }
    }




}
