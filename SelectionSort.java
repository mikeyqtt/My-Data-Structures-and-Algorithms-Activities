import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort{
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
		selectionSort(array);
		System.out.print("Elements after sorting: ");
			// to loop and print the sorted array
			for ( int a = 0; a < array.length; a++){
				System.out.print(" "+array[a]+ " ");
		}
	}
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
}