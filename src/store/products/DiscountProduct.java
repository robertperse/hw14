package store.products;

import store.search.Searchable;

import java.util.Objects;

public class DiscountProduct extends Product {
    private final double basePrice;
    private final int discountPercent;

    public DiscountProduct(String name, double basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discountPercent / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return discountPercent > 0;
    }

    @Override
    public String toString() {
        return "Скидочный продукт: " + super.toString() + " (скидка: " + discountPercent + "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}