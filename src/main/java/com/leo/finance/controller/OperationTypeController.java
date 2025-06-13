package com.leo.finance.controller;

import com.leo.finance.dto.OperationTypeDTO;
import com.leo.finance.service.OperationTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operation-types")
public class OperationTypeController {

    private final OperationTypeService service;

    public OperationTypeController(OperationTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<OperationTypeDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationTypeDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OperationTypeDTO> create(@RequestBody OperationTypeDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationTypeDTO> update(@PathVariable Long id, @RequestBody OperationTypeDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
