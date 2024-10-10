import java.util.Scanner;
import java.util.Arrays;

public class ArrayOperation{
	public static void main(String []args){
		// initialize the scanner
		Scanner sc = new Scanner(System.in);
		// to get the size of the array
		System.out.print("Enter size of an elements: ");
		int size = sc.nextInt();
		int[]array = new int[size];
		// to get each value of the array
		System.out.println("Enter elements of an array: ");
		for (int a = 0; a < size; a++){
		array[a] = sc.nextInt();
		}
			//sort the elements
			Arrays.sort(array);
		        System.out.println("Sorted array: " + Arrays.toString(array));
		    	// Sorting choices
		        System.out.println("Choose a sorting algorithm:");
		        System.out.println("1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
		        System.out.print("Enter a sorting algorithm: ");
		        int choice = sc.nextInt();
				//print the sorting choices
		        int[] sortedArray = Arrays.copyOf(array, array.length);
		        switch (choice) {
		            case 1 -> insertionSort(sortedArray);
		            case 2 -> selectionSort(sortedArray);
		            case 3 -> mergeSort(sortedArray, 0, sortedArray.length - 1);
		            case 4 -> quickSort(sortedArray, 0, sortedArray.length - 1);
		            default -> System.out.println("Invalid choice");
		        }
		        //print the sorted array
        		System.out.println("Sorted array: " + Arrays.toString(sortedArray));

			}
	// 1. Insertion Sort
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
	// 2. Selection Sort
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
	// 3. Merge Sort
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

		    // 4. Quick Sort
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
