package br.com.iurihsneves.productapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.iurihsneves.productapi.dto.ProductDto;
import lombok.Data;

@Data
@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private Float price;
    private String productDescription;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public static Product convert(ProductDto productDto) {
        
        Product product = new Product();

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setProductDescription(productDto.getProductDescription());
        product.setProductIdentifier(productDto.getProductIdentifier());
        product.setCategory(Category.convert(productDto.getCategoryDto()));

        return product;

    }

    
}
