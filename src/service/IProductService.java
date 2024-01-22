package service;

import model.Product;

import java.util.ArrayList;

public interface IProductService {
    public void add(Product product);
    public void delete(String productId);
    public Product get(String productId);
    public ArrayList<Product> getAll() ;
}
