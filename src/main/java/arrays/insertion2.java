package arrays;

public class insertion2 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        int len = arr.length;

        for(int i=1; i<5; i++){
            arr[i] = i;
        }

        for(int i=0; i<len; i++){
            System.out.print(arr[i] + " ");
        }

        //inserting an element at the end

        arr[arr.length-1] = 11;

        System.out.println(" ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        //inserting 1 after every even number

        for(int i=0; i<len; i++){
            if(arr[i]%2 == 0){
                arr[i+2] = arr[i+1];
            }
            arr[i+1] = 1;
        }

        for (int k : arr) {
            System.out.print(k + " ");
        }








    }
}
