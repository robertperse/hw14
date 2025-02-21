package store.basket;

import store.products.Product;

public class ProductBasket {
    private final Product[] products;
    private int count = 0;

    public ProductBasket(int size) {
        this.products = new Product[size];
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
        } else {
            System.out.println("Корзина переполнена! Нельзя добавить больше товаров.");
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int getSpecialProductCount() {
        int specialCount = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public void printReceipt() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }
}
