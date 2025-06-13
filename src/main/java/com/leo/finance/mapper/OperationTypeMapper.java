package com.leo.finance.mapper;

import org.mapstruct.Mapper;

import com.leo.finance.dto.OperationTypeDTO;
import com.leo.finance.entity.OperationType;

@Mapper(componentModel = "spring")
public interface OperationTypeMapper {
    OperationTypeDTO toDTO(OperationType entity);
    OperationType toEntity(OperationTypeDTO dto);
}
