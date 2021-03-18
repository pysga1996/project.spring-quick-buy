package com.omega.controller;

import com.fasterxml.jackson.annotation.JsonView;

import com.omega.model.dto.ProductDTO;
import com.omega.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(originPatterns = {"*"},
        allowedHeaders = {"*"}, allowCredentials = "true", exposedHeaders = {HttpHeaders.SET_COOKIE})
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @JsonView(ProductDTO.Views.Internal.class)
    public ResponseEntity<List<ProductDTO>> getProductList() {
        return ResponseEntity.ok(this.productService.getProductListFetchManufacturer());
    }

    @GetMapping("/search")
    @JsonView(ProductDTO.Views.Public.class)
    public ResponseEntity<List<ProductDTO>> searchForProducts() {
        return ResponseEntity.ok(this.productService.getProductList());
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @JsonView(ProductDTO.Views.Internal.class)
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        Optional<ProductDTO> optionalProductDTO = this.productService.getProductById(id);
        return optionalProductDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> getProductById(@Validated(ProductDTO.Groups.Create.class)
                                                    @RequestBody ProductDTO productDTO) {
        this.productService.saveProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@Validated(ProductDTO.Groups.Create.class)
                                                       @RequestBody ProductDTO productDTO) {
        this.productService.saveProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
