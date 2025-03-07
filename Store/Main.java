package Store;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Used for testing : 

        // lemonade  stand store 
        // Store lemonadeStand = new Store("Lemonade",3.75);  
        // double lemonadePrice = lemonadeStand.getPriceWithTax();

        // // cookie shop
        // Store cookieShop = new Store("Cookies", 5);
        // double cookiePrice = cookieShop.getPriceWithTax();
        // System.out.println(cookiePrice);

        // // general store  
        // Store store1 = new Store("General Store", 0);

        // store1.addProduct("Milk", 3.99, 10);
        // store1.addProduct("Bread", 2.49, 15);
        // store1.addProduct("Eggs", 4.99, 8);

        // System.out.println(store1.isInStock("null"));
        // System.out.println(store1.sellProduct("eggs", 2));
        // System.out.println(store1.searchProduct("eggs"));
        // store1.restockProduct("eggs", 11);
        // store1.displayInventory();
    


        Scanner scanner = new Scanner(System.in);

        System.out.println("===== STORE SETUP =====");
        System.out.print("Enter your store name: ");

        String storeName = scanner.nextLine();

        System.out.print("What type of products does your store sell? ");
        String productType = scanner.nextLine();

        Store store = new Store(productType);

        System.out.println("\nWelcome to " + storeName + "!");
        System.out.println("Your store selling " + productType + " has been created.");

        boolean running = true;
        System.out.println("Welcome to the Store Management System!");

        while(running){

            System.out.println("\n===== STORE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. Search for a product");
            System.out.println("4. Sell a product");
            System.out.println("5. Restock a product");
            System.out.println("6. Display all inventory");
            System.out.println("7. Exit");
            System.out.println("===================================");
            System.out.print("Enter your choice (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch(choice){
                case 1: // add new product 
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();

                    double price;
                    System.out.println("Enter product price:  $(0.00)");
                    try{
                        price = Double.parseDouble(scanner.nextLine());
                        if (price <= 0){
                            System.out.println("Price can't be negative. Product not added.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price. Product not added.");
                        continue;
                    }

                    int quantity;
                    System.out.println("Enter your product quantity: ");
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity <= 0) {
                            System.out.println("Quantity cannot be negative. Product not added.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Product not added.");
                        continue;
                    }
                    
                    store.addProduct(name, price, quantity);
                    System.out.println("Product added successfully!");
                    break;

                case 2: // remove a product
                    System.out.println("Enter the product name to be remove: ");
                    String product = scanner.nextLine();

                    if (store.deleteProduct(product)){
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Failed to remove product, please try again.");
                    }
                    break;

                case 3: // search a product
                    System.out.println("Enter the product name to search: ");
                    String productToSearch = scanner.nextLine();

                    String result = store.searchProduct(productToSearch);
                    System.out.println(result);
                    break;

                case 4:  // sell a product 
                    System.out.println("Enter the product name to be sell: ");
                    String productToSell = scanner.nextLine();

                    System.out.println("Enter quantity to sell: ");
                    int sellQuantity = 0;

                    try{
                        sellQuantity = Integer.parseInt(scanner.nextLine());
                        if (sellQuantity <= 0) {
                            System.out.println("Quantity cannot be negative.");
                            continue;
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid quantity. Sale failed.");
                        continue;
                    }

                    if(store.sellProduct(productToSell, sellQuantity)){
                        System.out.println("Sale completed successfully!");
                    } else {
                        System.out.println("Sale failed. Check if product exists and has enough stock.");
                    }
                    break;

                case 5: // restore a product 
                    System.out.println("Enter the product name to restock: ");
                    String restock = scanner.nextLine();

                    System.out.println("Enter quantity to restock: ");
                    int restockQuantity = 0;

                    try{
                        restockQuantity = Integer.parseInt(scanner.nextLine());
                        if (restockQuantity <= 0) {
                            System.out.println("Quantity must be positive");
                            continue;
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid quantity. Restock failed.");
                        continue;
                    }

                    store.restockProduct(restock, restockQuantity);
                    System.out.println("Product restocked successfully!");
                    continue;
                
                case 6: // display inventory
                    store.displayInventory();
                    break;
                
                case 7: // exist 
                    System.out.println("Thank you for using the Store Management System. Goodbye!");
                    running = false;
                    break;

                default: 
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }

    


    }

}
