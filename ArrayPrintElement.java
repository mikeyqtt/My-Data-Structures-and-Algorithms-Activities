import java.util.Arrays;
import java.util.Scanner;
public class ArrayPrintElement{
	public static void main(String []args){
		Scanner sc = new Scanner (System.in);
			System.out.print("Enter size of an array: ");
			int size = sc.nextInt();
			int[]array = new int[size];
			System.out.println("Enter elements of an array: ");
			for (int a = 0; a < size; a++){
				array[a] = sc.nextInt();
			}

			    System.out.print("Elements are: " +Arrays.toString(array));

}
}