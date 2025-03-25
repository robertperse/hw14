package store.products;

import store.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceProduct that = (FixPriceProduct) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}