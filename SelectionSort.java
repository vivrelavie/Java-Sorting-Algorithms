import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = {67, 55, 24, 13, 37};
        int length = array.length;

        System.out.print("\nOriginal array:  ");
        // Prints all of the values in an array
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();

        // Selection sort algorithm
        for (int i = 0; i < length-1; i++) {
            // In the first iteration, it gets the index 0 
            int minIndex = i;
            // Compares index 0 to the index 1 onwards
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swapping the index 0 and the minimum element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            // Prints the process of sorting
            System.out.print("Iteration " + (i + 1) + ":  ");
            for (int k = 0; k < length; k++) {
                System.out.print(array[k] + "  ");
            }
            System.out.println();
        }

        // Prints the Sorted array
        System.out.print("\nSorted array:  ");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}