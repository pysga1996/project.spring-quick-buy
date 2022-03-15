package com.revice.mindorder.service.impl;

import com.revice.mindorder.error.BusinessException;
import com.revice.mindorder.mapper.ProductMapper;
import com.revice.mindorder.model.dto.ProductDTO;
import com.revice.mindorder.repositories.ProductRepository;
import com.revice.mindorder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductList() {
        return this.productRepository.findAll()
                .stream()
                .map(this.productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductListFetchManufacturer() {
        return this.productRepository.findAllFetchManufacturer()
                .stream()
                .peek((p) -> {p.setCategories(null); p.setInventories(null);})
                .map(this.productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDTO> getProductById(Long id) {
        return Optional.ofNullable(this.productMapper
                .entityToDto(this.productRepository.findById(id).orElse(null)));
    }

    @Override
    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        if (productDTO.getId() == null) {
            if (this.productRepository.existsByCode(productDTO.getCode())) {
                throw new BusinessException(409, "validation.product.exist");
            }
        } else {
            if (this.productRepository.existsByCodeAndIdNot(productDTO.getCode(), productDTO.getId())) {
                throw new BusinessException(409, "validation.product.exist");
            }
        }
        this.productRepository.save(this.productMapper.dtoToEntity(productDTO));
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
