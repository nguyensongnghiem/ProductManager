package repository;

import model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    public void add(Product product);
    public void delete(String productId);
    public Product get(String productId);
    public ArrayList<Product> getAll() ;
}
