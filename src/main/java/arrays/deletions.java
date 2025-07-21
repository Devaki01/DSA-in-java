package arrays;

public class deletions {
    public static void main(String[] args) {
        int[] array = new int[10];
        int len = array.length;

        for(int i=0; i<10; i++){
            array[i] = i;
        }

        System.out.println("original array");

        for(int i=0; i<len; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("deleting one element at the end of the array");

        len--;

        for(int i=0; i<len; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("deleting one element at the start of the array");

        for(int i=1; i<len; i++){
            array[i-1] = array[i];
        }

        len--;

        for(int i=0; i<len; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("deleting one element at somewhere in the middle of the array");

        for(int i=3; i<len; i++){
            array[i-1] = array[i];
        }

        len--;

        for(int i=0; i<len; i++){
            System.out.print(array[i] + " ");
        }



    }
}
