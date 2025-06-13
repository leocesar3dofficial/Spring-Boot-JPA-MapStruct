package com.leo.finance.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leo.finance.dto.OperationDTO;
import com.leo.finance.entity.Category;
import com.leo.finance.entity.Operation;
import com.leo.finance.mapper.OperationMapper;
import com.leo.finance.repository.CategoryRepository;
import com.leo.finance.repository.OperationRepository;

@Service
public class OperationService {

    private final OperationRepository operationRepository;
    private final CategoryRepository categoryRepository;
    private final OperationMapper operationMapper;

    public OperationService(OperationRepository operationRepository, CategoryRepository categoryRepository, OperationMapper operationMapper) {
        this.operationRepository = operationRepository;
        this.categoryRepository = categoryRepository;
        this.operationMapper = operationMapper;
    }

    public List<OperationDTO> findAll() {
        return operationRepository.findAll().stream()
                .map(operationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<OperationDTO> findById(Long id) {
        return operationRepository.findById(id)
                .map(operationMapper::toDTO);
    }

    public OperationDTO save(OperationDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + dto.getCategoryId()));
        Operation operation = operationMapper.toEntity(dto);
        operation.setCategory(category);
        Operation saved = operationRepository.save(operation);
        return operationMapper.toDTO(saved);
    }

    public void deleteById(Long id) {
        operationRepository.deleteById(id);
    }
}
