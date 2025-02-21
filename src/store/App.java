package store;

import store.articles.Article;
import store.products.*;
import store.search.*;
import store.basket.ProductBasket;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket(5);

        try {
            Product simpleProduct = new SimpleProduct("Молоко", 50.0);
            Product discountProduct = new DiscountProduct("Шоколад", 80.0, 20);
            Product fixPriceProduct = new FixPriceProduct("Книга");

            basket.addProduct(simpleProduct);
            basket.addProduct(discountProduct);
            basket.addProduct(fixPriceProduct);
            basket.printReceipt();

            Article article1 = new Article("История шоколада", "Шоколад появился тысячи лет назад...");
            Article article2 = new Article("Как выбрать молоко", "Молоко делится на несколько типов...");
            Article article3 = new Article("Лучшие книги 2024", "Список лучших книг этого года...");

            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(simpleProduct);
            searchEngine.add(discountProduct);
            searchEngine.add(fixPriceProduct);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);

            System.out.println("\nПоиск по слову 'шоколад':");
            System.out.println(Arrays.toString(searchEngine.search("шоколад")));

            System.out.println("\nПоиск по слову 'книга':");
            System.out.println(Arrays.toString(searchEngine.search("книга")));

            try {
                Searchable bestMatch = searchEngine.findBestMatch("молоко");
                System.out.println("Лучший результат: " + bestMatch);
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            try {
                Searchable bestMatch = searchEngine.findBestMatch("шоколад");
                System.out.println("Лучший результат: " + bestMatch);
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
