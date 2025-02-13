import java.util.List;
import java.util.ArrayList;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printReceipt() {
        double totalCost = 0;
        int specialCount = 0;

        for (Product product : products) {
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
