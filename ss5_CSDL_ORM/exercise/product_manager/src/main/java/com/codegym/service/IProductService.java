package com.codegym.service;

import com.codegym.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void saveProduct(Product product);

    Product findById(int id);

    void updateProduct(Product product);

    void removeProduct(Product product);

    List<Product> searchByName(String searchName);
}
