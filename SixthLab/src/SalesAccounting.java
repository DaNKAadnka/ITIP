import java.util.HashMap;
import java.util.Map;

public class SalesAccounting {
    public static void main (String[] args) {

        HashMap<Product, Integer> countOfProducts = new HashMap<>();

        Product product1 = new Product("Papaya", 100);
        Product product2 = new Product("Clock", 1000);
        Product product3 = new Product("Jewelry", 10000);
        Product product4 = new Product("Milk", 80);

        Product[] products = new Product[] {product1, product2, product3, product1, product4, product3};

        for (Product prod : products) {
            if (countOfProducts.containsKey(prod)) {
                countOfProducts.put(prod, countOfProducts.get(prod) + 1);
            }
            else {
                countOfProducts.put(prod, 1);
            }
        }

        for (Map.Entry<Product, Integer> entry : countOfProducts.entrySet()) {
            System.out.print(entry.getKey().getName());
            System.out.print(" ");
            System.out.println(entry.getValue());
        }
    }
}
