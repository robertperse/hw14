package store.basket;

import store.products.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public double getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public int getSpecialProductCount() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        products.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name))
                .forEach(entry -> removedProducts.addAll(entry.getValue()));
        products.values().removeIf(productsList -> productsList.stream().anyMatch(product -> product.getName().equalsIgnoreCase(name)));
        return removedProducts;
    }

    public void printReceipt() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }
}