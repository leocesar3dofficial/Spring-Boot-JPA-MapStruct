package com.leo.finance.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leo.finance.dto.CategoryDTO;
import com.leo.finance.entity.Category;
import com.leo.finance.entity.OperationType;
import com.leo.finance.mapper.CategoryMapper;
import com.leo.finance.repository.CategoryRepository;
import com.leo.finance.repository.OperationTypeRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final OperationTypeRepository operationTypeRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, OperationTypeRepository operationTypeRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.operationTypeRepository = operationTypeRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO);
    }

    public CategoryDTO save(CategoryDTO dto) {
        OperationType operationType = operationTypeRepository.findById(dto.getOperationTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid operation type ID: " + dto.getOperationTypeId()));
        Category category = categoryMapper.toEntity(dto);
        category.setOperationType(operationType);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toDTO(saved);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
