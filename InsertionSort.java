import java.util.Scanner;
import java.util.Arrays;
public class InsertionSort{
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
		// Calling tje function
		insertionSort(array);
		System.out.print("Elements after sorting: ");
		// to loop and print the sorted array
			for ( int a = 0; a < array.length; a++){
				System.out.print(" "+array[a]+ " ");
		}
	}
	//InsertionSort function
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
		}