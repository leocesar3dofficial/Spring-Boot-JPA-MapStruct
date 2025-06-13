package com.leo.finance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.leo.finance.dto.OperationDTO;
import com.leo.finance.entity.Operation;

@Mapper(componentModel = "spring")
public interface OperationMapper {
    @Mapping(source = "category.id", target = "categoryId")
    OperationDTO toDTO(Operation entity);

    @Mapping(source = "categoryId", target = "category.id")
    Operation toEntity(OperationDTO dto);
}
