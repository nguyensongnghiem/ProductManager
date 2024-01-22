package model;

public class ImportProductFactory implements IProductFactory{
    @Override
    public Product createProduct(String[] data) {
        ImportProduct impProduct = new ImportProduct();
        impProduct.setName(data[1]);
        impProduct.setProductId(data[2]);
        impProduct.setPrice(Double.parseDouble(data[3]));
        impProduct.setQuantity(Integer.parseInt(data[4]));
        impProduct.setManufacturer(data[5]);
        impProduct.setImpPrice(Double.parseDouble(data[6]));
        impProduct.setProvince(data[7]);
        impProduct.setTax(Double.parseDouble(data[8]));
        return impProduct;
    }
}
