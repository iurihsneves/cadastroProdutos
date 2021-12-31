package br.com.iurihsneves.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iurihsneves.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{


    
}
