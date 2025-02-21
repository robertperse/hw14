import store.products.*;
import store.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket(5);

        Product simpleProduct = new SimpleProduct("Молоко", 50.0);
        Product discountProduct = new DiscountProduct("Шоколад", 80.0, 20);
        Product fixPriceProduct = new FixPriceProduct("Книга");

        basket.addProduct(simpleProduct);
        basket.addProduct(discountProduct);
        basket.addProduct(fixPriceProduct);

        basket.printReceipt();
    }
}
