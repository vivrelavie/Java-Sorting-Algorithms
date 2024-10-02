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

        void mergeSort(int[] array) {
            System.out.println("Unsorted Array: " + java.util.Arrays.toString(array));
            int arrayLength = array.length;

            if (arrayLength < 2) {
                return;
            } // means the array is empty, or it only has 1 in it
            // this means the array is already broken down

            int arrayHalfLen = arrayLength / 2;
            int[] firstHalf = new int[arrayHalfLen]; // get half the array (L)
            int[] secondHalf = new int[arrayLength - arrayHalfLen]; // get the other half (R)
            // second half is written like this because repeating arrayHalfLen would only work for EVEN sizes, whereas this can work on ODD too

            for (int i = 0 ; i < arrayHalfLen ; i++) {
                firstHalf[i] = array[i];
            }   // get the 1st half of the unsorted array, then transfer to firstHalf array
            System.out.println("First Half: " + java.util.Arrays.toString(firstHalf));

            for (int i = arrayHalfLen ; i < arrayLength ; i++) {
                secondHalf[i - arrayHalfLen] = array[i];
            }   // "i" starts at "arrayHalfLen" to get the remaining half of the unsorted array
            // afterward, same procedure as earlier
            System.out.println("Second Half: " + java.util.Arrays.toString(secondHalf));

            // recursively call the L/R halves of the unsorted array to break them down into index 0
            System.out.println("\nBreak Down First Half") ; mergeSort(firstHalf); System.out.println();
            System.out.println("Break Down Second Half") ; mergeSort(secondHalf); System.out.println();

            // while breaking them down to index 0, there is no problem if you start "merging" them together whilst the process is still incomplete
            // reason: they will be overwritten in the last iteration for the final sorting
            mergeSort(array, firstHalf, secondHalf); // combining the L/R arrays into one array
        }

        void mergeSort(int[] array, int[] firstHalf, int[] secondHalf) {
            int firstHalfLen = firstHalf.length;
            int secondHalfLen = secondHalf.length;

            Arrays.fill(array, 0); // for visualization purposes

            int iterate = 1, firstHalfRep = 0, secondHalfRep = 0, mergedRep = 0;
            // the output will look like the array has values. it does, but each index gets OVERWRITTEN to be sorted
            while( (firstHalfRep < firstHalfLen) && (secondHalfRep < secondHalfLen) ) {
                if( firstHalf[firstHalfRep] <= secondHalf[secondHalfRep] ) {
                    array[mergedRep] = firstHalf[firstHalfRep++];
                } else {
                    array[mergedRep] = secondHalf[secondHalfRep++];
                }
                System.out.printf("Merging %d: " + java.util.Arrays.toString(array) + "\n", iterate++);
                mergedRep++;
            }

            // after the initial loop, you are left with a few values in the L/R array that hasn't been merged with the main array
            while( firstHalfRep < firstHalfLen ) {
                array[mergedRep++] = firstHalf[firstHalfRep++];
                System.out.printf("Merging %d (Remaining Data): " + java.util.Arrays.toString(array) + "\n", iterate++);
            } // merges the remaining values from the FIRST HALF with the merged array

            while( secondHalfRep < secondHalfLen ) {
                array[mergedRep++] = secondHalf[secondHalfRep++];
                System.out.printf("Merging %d (Remaining Data): " + java.util.Arrays.toString(array) + "\n", iterate++);
            } // merges the remaining values from the SECOND HALF with the merged array

            System.out.println("Merged Array: " + java.util.Arrays.toString(array));
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
                        sort.mergeSort(sort.ArrayToBeSorted);
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
}
