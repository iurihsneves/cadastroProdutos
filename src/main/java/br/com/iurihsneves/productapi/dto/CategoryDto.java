package br.com.iurihsneves.productapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.iurihsneves.productapi.model.Category;
import lombok.Data;

@Data
public class CategoryDto {

    @NotNull
    private long id;
    @NotBlank
    private String category_name;

    public static CategoryDto convert(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        
        categoryDto.setId(category.getId());
        categoryDto.setCategory_name(category.getCategoryName());

        return categoryDto;
    }
    
}
