import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - " + (inStock ? "In Stock" : "Out of Stock");
    }
}

public class Filtering {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Notebook",  12.99, true));
        products.add(new Product("Headphones",89.99, true));
        products.add(new Product("Pen",        3.50, true));
        products.add(new Product("Keyboard",  65.00, false));
        products.add(new Product("Mouse",     29.99, true));
        products.add(new Product("Monitor",  199.99, true));
        products.add(new Product("USB Cable",  8.00, false));
        products.add(new Product("Desk Lamp", 45.00, true));

        System.out.println("=== All Products ===");
        for (Product p : products) {
            System.out.println(p);
        }

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        products.removeIf(isAffordable.negate());

        System.out.println("\n=== Affordable & In-Stock Products ===");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
