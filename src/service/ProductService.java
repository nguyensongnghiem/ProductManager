package service;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;

public class ProductService implements IProductService {
    private IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void delete(String productId) {
        repository.delete(productId);
    }

    @Override
    public Product get(String productId) {
        return repository.get(productId);
    }

    @Override
    public ArrayList<Product> getAll() {
        return repository.getAll();
    }
}
