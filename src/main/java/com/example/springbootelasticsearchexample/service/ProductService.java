package com.example.springbootelasticsearchexample.service;

import com.example.springbootelasticsearchexample.entity.Product;
import com.example.springbootelasticsearchexample.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product insertProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Product product, int id){
        Product foundProduct = productRepo.findById(id).get();
        foundProduct.setPrice(product.getPrice());
        return foundProduct;

    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
