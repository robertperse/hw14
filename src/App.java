package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 150);
        Product orange = new Product("Апельсин", 200);
        Product mango = new Product("Манго", 300);
        Product pineapple = new Product("Ананас", 500);
        Product grape = new Product("Виноград", 400);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(mango);
        basket.addProduct(pineapple);
        basket.addProduct(grape);

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        System.out.println("\nОбщая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("\nЕсть ли яблоко в корзине? " + basket.containsProduct("Яблоко"));
        System.out.println("Есть ли груша в корзине? " + basket.containsProduct("Груша"));

        System.out.println("\nОчистка корзины...");
        basket.clearBasket();

        System.out.println("\nСодержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("\nОбщая стоимость корзины после очистки: " + basket.getTotalPrice());

        System.out.println("\nЕсть ли банан в пустой корзине? " + basket.containsProduct("Банан"));
    }
}
