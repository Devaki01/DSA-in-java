package arrays;

public class twoD_arrays {
    public static void main(String[] args) {
        int[][] array = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] nums = new int[2][];

        //adding rows is mandatory while declaring.(not columns)
        //size of individuals rows(columns) can vary, as each is an individual object.

        for(int row=0; row<array.length; row++){
            for(int col=0; col<array[row].length; col++){
                System.out.print(array[row][col] + " ");
            }
            System.out.println(" ");
        }



    }
}
