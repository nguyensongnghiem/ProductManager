package repository;

import model.ExportProductFactory;
import model.ImportProductFactory;
import model.Product;
import utils.FileIo;

import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
    private String path;
    public ProductRepository(String path) {
        this.path = path;
    }

    @Override
    public void add(Product product) {
        FileIo file = new FileIo(path);
        ArrayList<Product> list = getAll();
        System.out.println(get(product.getProductId())!= null);

        if (get(product.getProductId())!= null ) {
            System.out.println(product.toCsv());
            file.writeLine(product.toCsv(),true);
        }
    }

    @Override
    public void delete(String productId) {
        FileIo file = new FileIo(path);
        ArrayList<Product> list = getAll();
        Product product = get(productId);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId().equals(productId)) {
                list.remove(i);
            }
        }
        ArrayList<String> arrCsv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrCsv.add(list.get(i).toCsv());
        }
        file.writeList(arrCsv,false);
    }

    @Override
    public Product get(String productId) {
        ArrayList<Product> list = getAll();
        for (Product product : list) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getAll() {
        FileIo file = new FileIo(path);
        ArrayList<Product> list = new ArrayList<>();
        ArrayList<String> arrCsv = file.readList();
        for (int i = 0; i < arrCsv.size(); i++) {
            String[] data = arrCsv.get(i).split(",");
            switch (data[0]) {
                case "Import" :
                    list.add(new ImportProductFactory().createProduct(data));
                  break;
                case "Export" :
                    list.add(new ExportProductFactory().createProduct(data));
                    break;
            }
        }
        return list;
    }
}
