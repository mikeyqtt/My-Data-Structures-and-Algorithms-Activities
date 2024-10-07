
import java.util.Arrays;
import java.util.Scanner;

public class PrahinogMikeArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Linear Search
        System.out.print("Enter the value to search using Linear Search: ");
        int target = sc.nextInt();
        int linearResult = linearSearch(array, target);
        System.out.println("Linear Search result: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));

        // Binary Search (Sorted Array)
        Arrays.sort(array);
        System.out.println("Sorted array for binary search: " + Arrays.toString(array));
        System.out.print("Enter the value to search using Binary Search: ");
        target = sc.nextInt();
        int binaryResult = binarySearch(array, target, 0, array.length - 1);
        System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));

        // Sorting
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
        int choice = sc.nextInt();

        int[] sortedArray = Arrays.copyOf(array, array.length);
        switch (choice) {
            case 1 -> bubbleSort(sortedArray);
            case 2 -> insertionSort(sortedArray);
            case 3 -> selectionSort(sortedArray);
            case 4 -> mergeSort(sortedArray, 0, sortedArray.length - 1);
            case 5 -> quickSort(sortedArray, 0, sortedArray.length - 1);
            default -> System.out.println("Invalid choice");
        }

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    // 1. Linear Search
    // This is Linear Search Function
    public static int linearSearch(int[] array, int target) {
        for ( int i = 0; i < array.length; i++) {
			if (array[i] == target){
				return i;
		}
	}
        return -1; // Placeholder
    }

    // 2. Binary Search (works only on sorted arrays)
    // This is the Binary Search Function
    public static int binarySearch(int[] array, int target, int low, int high) {
       low = 0;
       high = array.length ;
       while ( low <= high){
		   int mid = low + (high - low) / 2 ;

		   if (array[mid] == target)
		   return mid;

		   if (array[mid] < target )
			   low = mid + 1 ;

			else
				high = mid - 1;

		   }
        return -1; // Placeholder
    }

    // 3. Bubble Sort
    // Bubble Sort Function
    public static void bubbleSort(int[] array) {
       int a = array.length;
       for (int i = 0; i < a; i++)
       	for ( int b = 0; b < a - i - 1; b++)
       	if ( array[b] > array [b + 1]){
			// Swap c and array [i]
			int c = array [b];
			array[b] = array[b + 1];
			array[b + 1] = c;
		}
    }

    // 4. Insertion Sort
    // Insertion Sort Function
    public static void insertionSort(int[] array) {
       int a = array.length;
       for (int i = 0; i < a; i++){
		   int key = array[i];
		   int b = i - 1;

		while ( b >= 0 && array [b] > key){
			array[b + 1] = array [b];
			b = b - 1;
		}
		array[b + 1 ] = key;
    }
}

    // 5. Selection Sort
    // Selection Sort Function
    public static void selectionSort(int[] array) {
      int a = array.length;
	// this is  to move the unsorted subarray one by one
      for (int i = 0; i < a -1; i++){
		// To find the minimum element in unsorted array
		  int minIndex = i;
		  for (int b = i + 1; b < a; b++)
		  	if ( array[b] < array[minIndex])
		  		minIndex = b;
		// To swap the found element with the first element
		  	int c = array[minIndex];
		  	array[minIndex] = array[i];
		  	array[i] = c;
    }
}

    // 6. Merge Sort
    //Merge Sort Method
    public static void mergeSort(int[] array, int left, int right) {
       if ( left < right ){
		   int mid = left + (right - left) /2;

		   mergeSort(array, left, mid);
		   mergeSort(array, mid + 1, right);
		   merge(array, left, mid, right);
	   }
    }

    public static void merge(int[] array, int left, int mid, int right) {

		 // To find sizes of two subarrays to be merged
       int subArray1 = mid - left + 1;
       int subArray2 = right - mid;

       		int arr1[] = new int [subArray1];
       		int arr2[] = new int [subArray2];

       			for ( int a = 0; a < subArray1; ++a)
					arr1[a] = array[left + a];
				for ( int b = 0; b < subArray2; ++b)
					arr2[b] = array[ mid + 1 + b];

					int c = 0, e = 0;
					int d = left;
				while ( c < subArray1 && e < subArray2 ){
					 if (arr1[c] <= arr2[e] ) {
						 array[d] = arr1[c];
						 c++;
					}
					else {
						 array [d] = arr2[e];
						 e++;
					 }
					 d++;
				 }

				 while ( c < subArray1) {
					 array [d] = arr1[c];
					 c++;
					 d++;
				 }
				 while ( e < subArray2){
					 array[d] = arr2[e];
					 e++;
					 d++;
				 }
    }

    // 7. Quick Sort
    //Quick Sort Method
    public static void quickSort(int[] array, int low, int high) {
       if ( low < high ){
		   int pi = partition ( array, low, high);
		   quickSort (array, low, pi - 1);
		   quickSort (array, pi + 1, high);
	   }
    }

    public static int partition(int[] array, int low, int high) {


        int pivot = array[high];
        int a = (low - 1);

        for (int b = low; b <= high -1; b++){
			if (array[b] < pivot ){
				a++;

			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
			}
		}
				int temp = array [a + 1];
				array [a + 1] = array[high];
				array[high] = temp;
				return a + 1;
    }


}