import java.util.Scanner;
import java.util.Arrays;
public class QuickSort{
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
		quickSort(array, 0, array.length - 1);
		System.out.print("Elements after sorting: ");
			// to loop and print the sorted array
			for ( int a = 0; a < array.length; a++){
				System.out.print(" "+array[a]+ " ");
		}
	}
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