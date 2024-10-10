import java.util.Scanner;
import java.util.Arrays;
public class BubbleSort{ // this is the class
	// main method
	public static void main(String []args){
		Scanner sc = new Scanner (System.in);
		// To get the size of an array
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		// To loop and get what value of an element  you want to  put in an array
		 int[] array = new int[num];
		        System.out.println("Enter the elements of the array: ");
		        for (int i = 0; i < num; i++) {
		            array[i] = sc.nextInt();
	  }
        // Call out the Function
       BubbleSortFunction(array);
       // Loop the Element and Print the Ascending Order
       System.out.print("Array in Asscending Order:");
		for ( int a = 0; a < num; a++){
			System.out.print(" "+array[a]);
		}
}
// BubbleSort Function or Method
public	static  void BubbleSortFunction( int[] array){
	  	int a = array.length;
	    for (int i = 0; i < a; i++){
	    for ( int b = 0; b < a - i - 1; b++){
	    if ( array[b] > array [b + 1]){
		// Swap c and array [i]
		int c = array [b];
		array[b] = array[b + 1];
		array[b + 1] = c;
				}
			}
		}
	}
}
