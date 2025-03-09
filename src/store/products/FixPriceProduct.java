package store.products;

public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 100.0;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Фиксированная цена: " + super.toString();
    }
}
