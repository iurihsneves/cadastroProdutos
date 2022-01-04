package br.com.iurihsneves.productapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iurihsneves.productapi.dto.ProductDto;
import br.com.iurihsneves.productapi.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/getAll")
    public List<ProductDto> getProducts() {
        
        List<ProductDto> products = productService.getAll();

        return products;

    }

    @GetMapping("/products/category/{id}")
    public List<ProductDto> getProductByCategory(@PathVariable Long categoryId) {

        List<ProductDto> products = productService.getProductByCategoryId(categoryId);

        return products;

    }

    @GetMapping("/products/identifier/{productIdentifier}")
    public ProductDto findById(@PathVariable String productIdentifier) {
        
        return productService.findByProductIdentifier(productIdentifier);

    }

    @PostMapping("/product/save")
    public ProductDto save(@Valid @RequestBody ProductDto productDto) {

        return productService.save(productDto);

    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable Long productId) {

        try {

            productService.delete(productId);

        } catch(Exception e) {

            System.out.println("Erro: " + e);

        }

    }

    
}
