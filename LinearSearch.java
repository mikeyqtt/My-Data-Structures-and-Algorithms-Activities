import java.util.Scanner;
public class LinearSearch{
	public static void main(String []args){
		Scanner sc = new Scanner (System.in);
			// To get the tje numbers of element
	 		System.out.print("Enter the number of elements: ");
	        int num = sc.nextInt();
			// To get the value of each elements
	        int[] array = new int[num];
	        System.out.println("Enter the elements of the array: ");
	        for (int i = 0; i < num; i++) {
	            array[i] = sc.nextInt();
	        }

	        System.out.print("Enter the Element to search: ");
	        int target = sc.nextInt();
	        // calling the LinearSearch method
	        int LinearResult = LinearSearch(array, target);
	       System.out.println("Linear Search result: " + (LinearResult != -1 ? "Found at index " + LinearResult : "Not found"));
	}

// Linear Search Method
public static int LinearSearch (int[] array, int target){
	for (int a = 0; a < array.length; a++){
		if (array[a] == target){
			return a; // return the value
		}
	}
		return -1;
}
}

