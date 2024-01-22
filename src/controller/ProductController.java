package controller;

import model.Product;
import service.IProductService;

import java.util.ArrayList;

public class ProductController {
    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    public String add(Product product) {
        String productId = product.getProductId();
        System.out.println(get(productId));
        if (service.get(productId) == null) {
            service.add(product);
            return "Add successfull";
        }
        return "Product already exist !";

    }

    public String delete(String productId) {
        if (service.get(productId) != null) {
            service.delete(productId);
            return "Delete successfull";
        }
        return "Product does not exist !";
    }

    public ArrayList<Product> getAll() {
        return service.getAll();
    }
    public Product get(String productId) {
        return service.get(productId);
    }
}
