package model;

public class Product {
    private String name;
    private String productId;
    private double price;
    private int quantity;
    private String manufacturer;

    public Product() {
    }

    public Product(String name, String productId, double price, int quanity, String manufacturer) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.quantity = quanity;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                ", quanity=" + quantity +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public String toCsv() {
        return name + ','
                + productId + ','
                + price + ','
                + quantity + ','
                + manufacturer;
    }
}
