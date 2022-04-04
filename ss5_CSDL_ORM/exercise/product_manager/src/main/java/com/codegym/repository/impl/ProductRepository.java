package com.codegym.repository.impl;

import com.codegym.models.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT p FROM product as p ";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        entityManager.persist(product);

    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void removeProduct(Product product) {
        Product product1 = findById(product.getId());
        if (product1 != null){
            entityManager.remove(product1);
        }
    }

    @Override
    public List<Product> searchByName(String searchName) {
        String queryStr = "SELECT p FROM product as p where p.name like ?1";
        TypedQuery<Product> typedQuery = entityManager.createQuery(queryStr, Product.class);
        typedQuery.setParameter(1,"%"+searchName+"%");
        return typedQuery.getResultList();
    }


}
