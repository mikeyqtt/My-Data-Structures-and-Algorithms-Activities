import java.util.*;

// Node structure for Multi-Way B-tree
class Inventory {
    int data; // Minimum degree
    boolean isLeaf;
    List<String> keys;
    List<Inventory> children;

    Inventory(int data, boolean isLeaf) {
        this.data = data;
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    void traverse() {
        int i;
        for (i = 0; i < keys.size(); i++) {
            if (!isLeaf) {
                children.get(i).traverse();
            }
            System.out.print(keys.get(i) + " ");
        }
        if (!isLeaf) {
            children.get(i).traverse();
        }
    }

    Inventory search(String key) {
        int i = 0;
        while (i < keys.size() && key.compareTo(keys.get(i)) > 0) {
            i++;
        }

        if (i < keys.size() && keys.get(i).equals(key)) {
            return this;
        }

        if (isLeaf) {
            return null;
        }

        return children.get(i).search(key);
    }
}

// Multi-Way B-tree
class InventoryManagement {
    Inventory root;
    int product;

    InventoryManagement(int product) {
        this.root = null;
        this.product = product;
    }

    void traverse() {
        if (root != null) {
            root.traverse();
        }
    }

    Inventory search(String key) {
        return root == null ? null : root.search(key);
    }

    // For simplicity, assume this implementation handles the basic insertion logic
    void insert(String key) {
        if (root == null) {
            root = new Inventory(product, true);
            root.keys.add(key);
        } else {
            Inventory currentNode = root;
            root.keys.add(key);
            Collections.sort(root.keys);
        }
    }
}

// Inventory Management System
public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement productTree = new InventoryManagement(3); // Degree 3 B-tree
        PriorityQueue<Product> stockHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.stock));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add a product");
            System.out.println("2. Search for a product");
            System.out.println("3. Display all products alphabetically");
            System.out.println("4. Display product with lowest stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add a product
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter stock quantity: ");
                    int stock = sc.nextInt();
                    productTree.insert(name);
                    stockHeap.add(new Product(name, stock));
                    System.out.println("Product added successfully!");
                    break;

                case 2: // Search for a product
                    System.out.print("Enter product name to search: ");
                    name = sc.nextLine();
                    Inventory result = productTree.search(name);
                    if (result != null) {
                        System.out.println("Product found: " + name);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3: // Display all products alphabetically
                    System.out.println("Products in alphabetical order:");
                    productTree.traverse();
                    System.out.println();
                    break;

                case 4: // Display product with lowest stock
                    if (!stockHeap.isEmpty()) {
                        Product lowestStockProduct = stockHeap.peek();
                        System.out.println("Product with lowest stock: " + lowestStockProduct.name +
                                " (Stock: " + lowestStockProduct.stock + ")");
                    } else {
                        System.out.println("No products in inventory.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Product class
class Product {
    String name;
    int stock;

    Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }
}
