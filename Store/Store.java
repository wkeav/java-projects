package Store;
import java.util.ArrayList;
import java.util.List;
public class Store {
    protected String productType;
    protected double price;
    protected List<Product> inventory; 

    public double tax = 0.08;
    
    // Constructor
    public Store (){
        this.price = 0;
        this.productType = null;
        this.inventory = new ArrayList<>();
    }
    public Store(String newProduct, double price) {
        this.productType = newProduct;
        this.price = price;
        this.inventory = new ArrayList<>();
    }
    
    public Store(String newProduct){
        this.productType = newProduct;
        this.inventory = new ArrayList<>();
    }

    // Inventory management methods 
    public void addProduct(String name, double price, int quantity){
        inventory.add(new Product(name,price,quantity));
    }

    public boolean deleteProduct(String name){
        if (name == null){
            System.out.println("Please enter what to remove");
        }

        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getName().equalsIgnoreCase(name) ){
                inventory.remove(i);
                return true;
            }

        }
        return false;
    }

    public String searchProduct(String name){
        if (name == null){
            return "invalid name";
        }

        for (Product product: inventory){
            if(product.getName().equalsIgnoreCase(name)){
                return product.toString();
            }
        }
        return "Product " + name + " not found!"; 
    
    }

    public Product findProduct(String name){

        for (Product product: inventory){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    public boolean isInStock(String productName){
        if (productName == null) {
            System.out.println("invalid name");
            return false;
        }
        
        for (Product product: inventory){
            if(product.getName().equalsIgnoreCase(productName)){
                return product.getQuantity() > 0; // No need to check product != null here
            }
        }
        // Only print "not found" once after checking the entire inventory
        System.out.println("Product " + productName + " not found!");
        return false;
    }

    public boolean sellProduct(String productName, int quantity){
        Product product = findProduct(productName);
        if(product != null && product.getQuantity() >= quantity){
            product.removeQuantity(quantity);
            return true;
        }
        return false;
    }

    public void restockProduct(String productName, int quantity){
        Product product = findProduct(productName);
        if (product != null && product.getQuantity() > 0){
            product.addQuantity(quantity);
        }
    }

    public void displayInventory(){
        System.out.println("Current Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }
    public void advertise() {
        String message = "Selling " + productType + "!";
        System.out.println(message);
    }
    
    public void greetCustomer(String customerName){
        System.out.println("Welcome to the store, " + customerName + "!");
    }

    public void increasePrice(double priceToAdd){
        double newPrice = price + priceToAdd;
        price = newPrice;
    }
    
    public double getPrice(){
        return price;
    }

    public double getPriceWithTax(){
        double totalPrice = price + price * tax;
        return totalPrice;
    }

    @Override
    public String toString(){
        return "This store sells " + productType + 
        " at a price of " + price;
    }
}

