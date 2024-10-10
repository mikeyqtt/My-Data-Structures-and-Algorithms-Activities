import java.util.Scanner;
import java.util.Arrays;

import java.util.Scanner;
public class BinarySearch{
	public static void main(String []args){
		Scanner sc = new Scanner (System.in);

					// To get the numbers of elements
			 		System.out.print("Enter the number of elements: ");
			        int num = sc.nextInt();

			        int[] array = new int[num];
			        // To get the value of each elements
			        System.out.println("Enter the elements of the array: ");
			        for (int i = 0; i < num; i++) {
			            array[i] = sc.nextInt();
	        }
	        		// Sorting the value of the elements
					 Arrays.sort(array);
					// Print the Sorted value of elements
       				 System.out.println("Sorted array for binary search: " + Arrays.toString(array));

       				 // Search the desired value to search
					 System.out.print("Enter the value to search using Binary Search: ");
					 int target = sc.nextInt();
					 int BinaryResult = BinarySearch(array, target, 0, array.length - 1);
        			 System.out.println("Binary Search result: " + (BinaryResult != -1 ? "Found at index " + BinaryResult : "Not found"));

		}
		// Binary Search methods
		public static int BinarySearch( int []array, int target, int low, int high){
			low = 0; high = array.length;

			 while ( low <= high){
					   int mid = low + (high - low) / 2 ;

						// Check if x is present at mid
					   if (array[mid] == target)
					   return mid;
						// If x greater, ignore left half
					   if (array[mid] < target )
						   low = mid + 1 ;
						// If x is smaller, ignore right half
						else
							high = mid - 1;
					   }
					   // If we reach here, then element was not present

			        return -1; // Placeholder
    }


	}