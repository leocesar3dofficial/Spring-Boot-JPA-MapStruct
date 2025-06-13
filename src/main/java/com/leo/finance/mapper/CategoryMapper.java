package com.leo.finance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.leo.finance.dto.CategoryDTO;
import com.leo.finance.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "operationType.id", target = "operationTypeId")
    CategoryDTO toDTO(Category entity);
    
    @Mapping(source = "operationTypeId", target = "operationType.id")
    Category toEntity(CategoryDTO dto);
}
