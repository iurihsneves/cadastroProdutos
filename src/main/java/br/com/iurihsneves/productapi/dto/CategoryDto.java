package br.com.iurihsneves.productapi.dto;

import br.com.iurihsneves.productapi.model.Category;
import lombok.Data;

@Data
public class CategoryDto {

    private long id;
    private String category_name;

    public static CategoryDto convert(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        
        categoryDto.setId(category.getId());
        categoryDto.setCategory_name(category.getCategoryName());

        return categoryDto;
    }
    
}
