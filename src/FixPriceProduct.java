public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 100.0; // Фиксированная цена

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
        return name + ": Фиксированная цена " + FIXED_PRICE;
    }
}
