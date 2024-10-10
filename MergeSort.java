import java.util.Scanner;
import java.util.Arrays;
public class MergeSort{
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
		//calling the function
		mergeSort(array, 0, array.length - 1);
		System.out.print("Elements after sorting: ");
			// to loop and print the sorted array
			for ( int a = 0; a < array.length; a++){
					System.out.print(" "+array[a]+ " ");
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
				}