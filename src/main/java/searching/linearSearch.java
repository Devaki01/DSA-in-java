package searching;

public class linearSearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 6, 7, 3};
        int target = 6;

        int answer = linear_search(array, target);

        if (answer != -1) {
            System.out.println("Target " + target + " found at index: " + answer);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

    }

    static int linear_search(int[] arr, int target){

        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;

    }
}
