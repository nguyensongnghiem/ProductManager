package model;

public class ExportProduct extends Product {
    private double expPrice;
    private String nation;

    public ExportProduct() {
    }

    public ExportProduct(String name, String productId, double price, int quanity, String manufacturer, double expPrice, String nation) {
        super(name, productId, price, quanity, manufacturer);
        this.expPrice = expPrice;
        this.nation = nation;
    }

    public double getExpPrice() {
        return expPrice;
    }

    public void setExpPrice(double expPrice) {
        this.expPrice = expPrice;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return super.toString() + "ExportProduct{" +
                "expPrice=" + expPrice +
                ", nation='" + nation + '\'' +
                '}';
    }
    @Override
    public String toCsv() {
        return "Export" + "," +
                super.toCsv() +
                "," + expPrice +
                "," + nation
                ;
    }
}
