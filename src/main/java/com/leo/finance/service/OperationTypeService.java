package com.leo.finance.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leo.finance.dto.OperationTypeDTO;
import com.leo.finance.entity.OperationType;
import com.leo.finance.mapper.OperationTypeMapper;
import com.leo.finance.repository.OperationTypeRepository;

@Service
public class OperationTypeService {

    private final OperationTypeRepository repository;
    private final OperationTypeMapper operationTypeMapper;

    public OperationTypeService(OperationTypeRepository repository, OperationTypeMapper operationTypeMapper) {
        this.repository = repository;
        this.operationTypeMapper = operationTypeMapper;
    }

    public List<OperationTypeDTO> findAll() {
        return repository.findAll().stream()
                .map(operationTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<OperationTypeDTO> findById(Long id) {
        return repository.findById(id).map(operationTypeMapper::toDTO);
    }

    public OperationTypeDTO save(OperationTypeDTO dto) {
        OperationType entity = operationTypeMapper.toEntity(dto);
        OperationType saved = repository.save(entity);
        return operationTypeMapper.toDTO(saved);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
