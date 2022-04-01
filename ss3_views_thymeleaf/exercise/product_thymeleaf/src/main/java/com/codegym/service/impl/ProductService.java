package com.codegym.service.impl;

import com.codegym.models.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.saveProduct(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        iProductRepository.removeProduct(product);
    }

    @Override
    public List<Product> searchByName(String seachName) {
        return iProductRepository.searchByName(seachName);
    }
}
