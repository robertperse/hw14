package store.products;

public class DiscountProduct extends Product {
    private double basePrice;
    private int discount;

    public DiscountProduct(String name, double basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discount / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + " (" + discount + "%)";
    }
}
