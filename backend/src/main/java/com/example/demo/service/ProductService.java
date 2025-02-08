package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ResponseEntity<Product> save(Product product){
        return ResponseEntity.ok(repository.save(product));
    }

    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<Product> findById(Long id){
        Optional<Product> productOptional = repository.findById(id);
        if(productOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else{
            Product p = productOptional.get();
            return  ResponseEntity.ok(p);
        }
    }
    public ResponseEntity<Product> update(Long id, Product data){
        Optional<Product> productFound = repository.findById(id);

        if(productFound.isEmpty())
            return ResponseEntity.notFound().build();
        else{
            Product p = productFound.get();
            p.setName(data.getName());
            p.setPreco(data.getPreco());
            return ResponseEntity.ok(repository.save(p));
        }
    }

    public ResponseEntity<?> delete(Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
