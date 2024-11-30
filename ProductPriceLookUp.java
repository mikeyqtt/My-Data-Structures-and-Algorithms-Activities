import java.util.Scanner;
import java.util.HashMap;

public class ProductPriceLookUp{
	 public static void main(String[] args) {
	        // Create a HashMap to store product names and their prices
	        HashMap<String, Integer> productPrices = new HashMap<>();

	        // Add some sample products
	        productPrices.put("Apple", 25);
	        productPrices.put("Banana", 15);
	        productPrices.put("Orange", 15);
	        productPrices.put("Lemon", 20);
	        productPrices.put("Watermelon", 10);

	        // Scanner for user input
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the ShopyMart!");

	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. See all products available!");
	            System.out.println("2. Add a new product");
	            System.out.println("3. Lookup a product price");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    // Display all product names
						System.out.println("Available products:");
						displayProductNames(productPrices);
	                    break;

	                case 2:
	                    // Add a new product
	                    System.out.print("Enter the product name: ");
	                    String newProduct = scanner.nextLine();
	                    System.out.print("Enter the product price: ");
	                    int price = scanner.nextInt();
	                    productPrices.put(newProduct, price);
	                    System.out.println("Product added successfully!");
	                    break;

	                case 3:
					       // See a product price
					       System.out.print("Enter the product name: ");
					       String product = scanner.nextLine();
					       if (productPrices.containsKey(product)) {
					           System.out.println("The price of " + product + " is P" + productPrices.get(product));
					       } else {
					           System.out.println("Product not found!");
					       }
    						break;

	                case 4:
	                    // Exit the program
	                    System.out.println("Thank you for Shopping. Goodbye!");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    // Method to display all product names
	    private static void displayProductNames(HashMap<String, Integer> productPrices) {
	        if (productPrices.isEmpty()) {
	            System.out.println("No products available.");
	        } else {
	            for (String product : productPrices.keySet()) {
	                System.out.println("- " + product);
	            }
	        }
	    }
}