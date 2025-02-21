package store.products;

import store.search.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }
}
