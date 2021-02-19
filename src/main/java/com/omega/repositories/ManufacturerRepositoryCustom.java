package com.omega.repositories;

import com.omega.model.entity.Manufacturer;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ManufacturerRepositoryCustom {

    @NonNull
    List<Manufacturer> findAllNoFetch();
}
