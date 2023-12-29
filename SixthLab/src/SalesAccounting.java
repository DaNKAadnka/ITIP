import java.util.HashMap;
import java.util.Map;

public class SalesAccounting {
    public static void main (String[] args) {

        Sales s1 = new Sales();

        Product product1 = new Product("Papaya", 100);
        Product product2 = new Product("Clock", 1000);
        Product product3 = new Product("Jewelry", 10000);
        Product product4 = new Product("Milk", 80);


        Product[] products = new Product[] {product1, product2, product3, product1, product4, product3};

        for (Product prod : products) {
            s1.add(prod);
        }

        System.out.println(s1.getSumOfSales());
        System.out.println(s1.topProduct().getName());

        s1.printSales();
    }
}

class Sales {

    private int sumOfSales = 0;
    private HashMap<Product, Integer> countOfProducts = new HashMap<>();
    private int maxCnt = 0;
    private Product maxProduct = new Product("Nothing", 0);

    public Sales() {}

    public void add (Product prod) {
        if (countOfProducts.containsKey(prod)) {
            int currentCnt = countOfProducts.get(prod) + 1;
            if (currentCnt > maxCnt) {
                maxCnt = currentCnt;
                maxProduct = prod;
            }
            countOfProducts.put(prod, currentCnt);
        }
        else {
            countOfProducts.put(prod, 1);
        }
        sumOfSales += prod.getPrice();
    }

    public int getSumOfSales () {
        return this.sumOfSales;
    }

    public Product topProduct () {
        return this.maxProduct;
    }

    public void printSales () {
        for (Map.Entry<Product, Integer> entry : countOfProducts.entrySet()) {
            System.out.print(entry.getKey().getName());
            System.out.print(" ");
            System.out.println(entry.getValue());
        }
    }
}
