public abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public abstract String toString();
}
