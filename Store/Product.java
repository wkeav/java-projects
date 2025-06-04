package Store;

public class Product {

    protected String name;
    protected double price;
    protected int quantity;
    
    // Constructors method
    public Product(){
        this.name = " ";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

     // Getters and setters
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setPrice(double price) { 
        if (price < 0){
            System.out.println("Price cannot be negative. Please try again.");
        }
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        if (quantity < 0){
            System.out.println("Quantity cannot be negative. Please try again.");
        }
        this.quantity = quantity;
    }

    // Add to quantity method
    public void addQuantity(int amount){
        this.quantity += amount; 
    }

    // Remove from quantity method
    public boolean removeQuantity(int amount){
        if(amount > 0 && quantity >= amount){
            this.quantity -= amount;
            return true;
        }
        //
        return false;
    }

    @Override
    public String toString(){
        return name + " : $" + price + " ( " + quantity + " in stock )";
    }
}
