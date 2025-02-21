package store.basket;

import store.products.Product;

public class ProductBasket {
    private Product[] products;
    private int count;

    public ProductBasket(int capacity) {
        products = new Product[capacity];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
        } else {
            System.out.println("Корзина переполнена!");
        }
    }

    public void printReceipt() {
        double totalCost = 0;
        int specialCount = 0;

        for (int i = 0; i < count; i++) {
            Product product = products[i];
            System.out.println(product.toString());
            totalCost += product.getPrice();
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialCount);
    }
}
