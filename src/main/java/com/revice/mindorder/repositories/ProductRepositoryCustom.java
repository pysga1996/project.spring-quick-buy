package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.Product;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductRepositoryCustom {

    @NonNull
    List<Product> findAllFetchManufacturer();
}
