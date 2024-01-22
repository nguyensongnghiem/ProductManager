package model;

public class ExportProductFactory implements IProductFactory{
    @Override
    public Product createProduct(String[] data) {
        ExportProduct exportProduct = new ExportProduct();
        exportProduct.setName(data[1]);
        exportProduct.setProductId(data[2]);
        exportProduct.setPrice(Double.parseDouble(data[3]));
        exportProduct.setQuantity(Integer.parseInt(data[4]));
        exportProduct.setManufacturer(data[5]);
        exportProduct.setExpPrice((Double.parseDouble(data[6])));
        exportProduct.setNation(data[7]);
        return exportProduct;
    }
}
