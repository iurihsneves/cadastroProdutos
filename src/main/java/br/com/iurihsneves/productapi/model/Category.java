package br.com.iurihsneves.productapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.iurihsneves.productapi.dto.CategoryDto;
import lombok.Data;

@Data
@Entity(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;

    public static Category convert(CategoryDto categoryDto) {
        
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategory_name());

        return category;
    }

}
