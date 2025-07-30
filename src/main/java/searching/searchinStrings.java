package searching;

public class searchinStrings {
    public static void main(String[] args) {
        String[] names = {"Aarav", "Saanvi", "Vivaan", "Aanya", "Aditya", "Diya", "Rohan", "Priya", "Arjun", "Anika", "Ishaan", "Mira"};

        String target = "Diya";
        String target1 = "Phil Dunphy";

        int answer = search(names, target);
        int answer1 = search(names, target1);

        if (answer != -1) {
            System.out.println("Target " + target + " found at index: " + answer);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        if (answer1 != -1) {
            System.out.println("Target '" + target1 + "' found at index: " + answer1);
        } else {
            System.out.println("Target '" + target1 + "' not found in the array.");
        }

    }

    static int search(String[] arr, String target){

        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(target)){
                return i;
            }
        }

        return -1;
    }
}
