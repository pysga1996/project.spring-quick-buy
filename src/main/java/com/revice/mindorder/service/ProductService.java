package com.revice.mindorder.service;

import com.revice.mindorder.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> getProductList();

    List<ProductDTO> getProductListFetchManufacturer();

    Optional<ProductDTO> getProductById(Long id);

    void saveProduct(ProductDTO manufacturerDTO);

    void deleteProduct(Long id);
}
