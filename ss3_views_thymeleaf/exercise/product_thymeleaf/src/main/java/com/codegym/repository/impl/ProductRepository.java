package com.codegym.repository.impl;

import com.codegym.models.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> productList = new HashMap<>();
    static int autoIncrease = 1;

    static {
        Product product = new Product(autoIncrease++, "Iphone X", 890);
        Product product1 = new Product(autoIncrease++, "SamSung Galaxy S9", 500);
        productList.put(product.getId(), product);
        productList.put(product1.getId(), product1);
//        productList.put(autoIncrease++,new Product(autoIncrease++,"Iphone X",890));
//        productList.add(autoIncrease__new Product(autoIncrease++,"SamSung Galaxy S9",500));
//        productList.add(new Product(autoIncrease++,"Iphone 13",1000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void saveProduct(Product product) {
        product.setId(autoIncrease++);
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {

        return productList.get(id);
    }

    @Override
    public void updateProduct(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product.getId());
    }

    @Override
    public List<Product> searchByName(String seachName) {
        List<Product> list = new ArrayList<>();

        for (Product product : productList.values()) {
            if (product.getName().toLowerCase().contains(seachName)){
                list.add(product);
            }
        }
        return list;
    }


}
