package br.com.iurihsneves.productapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.iurihsneves.productapi.model.Product;
import lombok.Data;

@Data
public class ProductDto {
    
    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String productName;
    @NotBlank
    private String productDescription;
    @NotNull
    private Float price;
    @NotNull
    private CategoryDto categoryDto;

    public static ProductDto convert(Product product) {
        
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setProductIdentifier(product.getProductIdentifier());
        productDto.setPrice(product.getPrice());
        productDto.setProductDescription(product.getProductDescription());
        if(product.getCategory() != null) {
            productDto.setCategoryDto(CategoryDto.convert(product.getCategory()));
        }

        return productDto;

    }

}
