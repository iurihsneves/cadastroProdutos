package br.com.iurihsneves.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iurihsneves.productapi.dto.ProductDto;
import br.com.iurihsneves.productapi.model.Product;
import br.com.iurihsneves.productapi.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());

    }

    public List<ProductDto> getProductByCategoryId(Long categoryId) {

        List<Product> products = productRepository.getProductByCategory(categoryId);

        return products
                .stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());

    }

    public ProductDto findByProductIdentifier(String productIdentifier) {

        Product product = productRepository.findByProductIdentifier(productIdentifier);

        if(product != null) {
            return ProductDto.convert(product);
        }

        return null;

    }

    public ProductDto save(ProductDto productDto) {

        Product product = productRepository.save(Product.convert(productDto));
        
        return ProductDto.convert(product);

    }

    public void delete(long productId) {

        Optional<Product> product = productRepository.findById(productId);

        if(product.isPresent()) {
            productRepository.delete(product.get());
        }

    }

    
    
}
