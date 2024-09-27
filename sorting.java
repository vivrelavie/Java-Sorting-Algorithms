import java.security.Key;
import java.util.*;

public class sorting {

    public static class Sort {
        private int[] ArrayToBeSorted;

        public Sort(int[] arr) {
            this.ArrayToBeSorted = arr;
        }

        public void InsertionSort() {
            int[] Array = this.ArrayToBeSorted; // Define an array to be sorted
            Array = Array.clone();
            // print Array first
            System.out.println("Unsorted Array: " + java.util.Arrays.toString(Array));

            int i, key, j; // Declare variables for indexing and the key element
            // Start iterating from the second element (index 1) because the first element
            // is considered sorted
            for (i = 1; i < Array.length; i++) {
                j = i - 1; // Set j to the index of the last sorted element
                key = Array[i]; // Store the current element that needs to be inserted into the sorted portion

                // Compare the key with each element on the left of it until we find the correct
                // position
                while (j >= 0 && Array[j] > key) {
                    System.out.print("Key: " + key + "; ");
                    System.out.print("Comparing to: " + Array[j] + ": ");

                    System.out.println(java.util.Arrays.toString(Array));
                    Array[j + 1] = Array[j]; // Shift the element to the right
                    j = j - 1; // Move to the previous element to compare with the key

                }
                // Insert the key at its correct position
                Array[j + 1] = key;

            }
            // print array
            System.out.println("Sorted Array: " + java.util.Arrays.toString(Array));

        }

        void bubbleSort() {
            int[] arr = this.ArrayToBeSorted;
            arr = arr.clone();
            int n = arr.length;
            int i, j, temp;
            boolean swapped;

            System.out.println("Unsorted Array: " + java.util.Arrays.toString(arr));
            for (i = 0; i < n - 1; i++) {
                swapped = false;

                for (j = 0; j < n - i - 1; j++) {
                    System.out.print("Compared " + arr[j] + " and " + arr[j + 1] + ": ");
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                    System.out.println(java.util.Arrays.toString(arr));
                }
                if (!swapped)
                    break;
            }
            System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));

        }

        void SelectionSort() {
            int[] array = this.ArrayToBeSorted;
            array = array.clone();
            System.out.println("Unsorted Array: " + java.util.Arrays.toString(array));
            int length = array.length;
            for (int i = 0; i < length - 1; i++) {
                // In the first iteration, it gets the index 0
                int minIndex = i;
                // Compares index 0 to the index 1 onwards
                for (int j = i + 1; j < length; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }

                // Swapping the index 0 and the minimum element
                System.out.print("Comparing " + array[i] + " to " + array[i + 1] + ": ");
                System.out.println(java.util.Arrays.toString(array));

                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;

                // Prints the process of sorting

            }

            // Prints the Sorted array
            System.out.println("Sorted Array: " + java.util.Arrays.toString(array));

        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] SortArray = new int[n];

        System.out.printf("Enter %d array elements: ", n);
        for (int i = 0; i < n; i++) {
            SortArray[i] = scanner.nextInt();
        }
        Sort sort = new Sort(SortArray);

        do {
            System.out.print("""
                    \nChoose Sorting Algorithm: \

                    A. Bubble Sort
                    B. Selection Sort
                    C. Insertion Sort
                    D. Merge Sort
                    Type (A/B/C/D) only:\s\n""");

            System.out.print("Sorting Algorithm: ");
            char userResponse = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
            System.out.println();

            switch (userResponse) {
                case 'A':
                    System.out.println("Bubble Sort");
                    sort.bubbleSort();
                    break;
                case 'B':
                    System.out.println("Selection Sort");
                    sort.SelectionSort();
                    break;
                case 'C':
                    System.out.println("Insertion Sort");
                    sort.InsertionSort();
                    break;
                case 'D':
                    System.out.println("Merge Sort");
                    break;
                case 'E':
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (true);
    }
}
