package store.basket;

import store.products.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName().toLowerCase(), _ -> new ArrayList<>()).add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int getSpecialProductCount() {
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public List<Product> removeProductByName(String name) {
        String key = name.toLowerCase();
        List<Product> removedProducts = products.remove(key);

        return (removedProducts == null) ? Collections.emptyList() : removedProducts;
    }

    public void printReceipt() {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }
}