package store;

import store.articles.Article;
import store.products.*;
import store.search.*;
import store.basket.ProductBasket;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        try {
            Product simpleProduct = new SimpleProduct("Молоко", 50.0);
            Product discountProduct = new DiscountProduct("Шоколад", 80.0, 20);
            Product fixPriceProduct = new FixPriceProduct("Книга");

            basket.addProduct(simpleProduct);
            basket.addProduct(discountProduct);
            basket.addProduct(fixPriceProduct);
            basket.printReceipt();

            System.out.println("\nУдаляем 'Шоколад' из корзины:");
            List<Product> removedProducts = basket.removeProductByName("Шоколад");
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                removedProducts.forEach(System.out::println);
            }
            basket.printReceipt();

            System.out.println("\nУдаляем 'Сок' из корзины:");
            removedProducts = basket.removeProductByName("Сок");
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            }
            basket.printReceipt();

            Article article1 = new Article("История шоколада", "Шоколад появился тысячи лет назад...");
            Article article2 = new Article("Как выбрать молоко", "Молоко делится на несколько типов...");
            Article article3 = new Article("Лучшие книги 2024", "Список лучших книг этого года...");

            SearchEngine searchEngine = new SearchEngine();
            searchEngine.add(simpleProduct);
            searchEngine.add(discountProduct);
            searchEngine.add(fixPriceProduct);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);

            System.out.println("\nПоиск по слову 'шоколад':");
            searchEngine.search("шоколад").forEach(System.out::println);

            System.out.println("\nПоиск по слову 'книга':");
            searchEngine.search("книга").forEach(System.out::println);

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
