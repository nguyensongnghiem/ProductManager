package model;

public class ImportProduct extends Product {
    private double impPrice;
    private String province;
    private double tax;

    public ImportProduct() {
    }

    public ImportProduct(String name, String productId, double price, int quanity, String manufacturer, double impPrice, String province, double tax) {
        super(name, productId, price, quanity, manufacturer);
        this.impPrice = impPrice;
        this.province = province;
        this.tax = tax;
    }

    public double getImpPrice() {
        return impPrice;
    }

    public void setImpPrice(double impPrice) {
        this.impPrice = impPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return super.toString() + "ImportProduct{" +
                "impPrice=" + impPrice +
                ", province='" + province + '\'' +
                ", tax=" + tax +
                '}';
    }

    @Override
    public String toCsv() {
        return "Import" + "," + super.toCsv() +
                "," + impPrice +
                "," + province +
                "," + tax
                ;
    }
}
