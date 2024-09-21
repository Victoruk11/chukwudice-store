package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.CategoryDTO;
import com.victoruk.chukwudice_store.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CategoryMapper {

        CategoryDTO toDTO(Category category);

        Category toEntity(CategoryDTO categoryDTO);

}
