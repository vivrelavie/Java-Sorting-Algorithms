package DSA;
import java.io.*;
import java.util.Scanner;

public class BubbleSort {
    static void bubbleSort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                System.out.print("Comparing " + arr[i] + " and " + arr[j] + ": ");
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
                System.out.println(java.util.Arrays.toString(arr));
            }
            if (!swapped) break;
        }
    }
    
    static void displayArray(int[] arr) {
        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.printf("Enter %d array elements: ", n);
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        do {
            System.out.print("""
                    Choose Sorting Algorithm: \
                    
                    A. Bubble Sort
                    B. Selection Sort
                    C. Insertion Sort
                    D. Merge Sort
                    Type (A/B/C/D) only:\s""");
            char userResponse = scanner.next().toUpperCase().charAt(0);
            switch (userResponse) {
                case 'A':
                    System.out.println("\nA. Bubble Sort");
                    System.out.print("Unsorted array: ");
                    displayArray(arr);
                    bubbleSort(arr, n);
                    System.out.print("Sorted array: ");
                    displayArray(arr);
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("B. Selection Sort");
                    break;
                case 'C':
                    System.out.println("C. Insertion Sort");
                    break;
                case 'D':
                    System.out.println("D. Merge Sort");
                    break;
                default:
                    System.out.println("Invalid Value.\n");
                    break;
            }
        } while (true);

    }
}
