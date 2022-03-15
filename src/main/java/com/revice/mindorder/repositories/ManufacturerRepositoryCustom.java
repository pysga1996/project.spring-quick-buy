package com.revice.mindorder.repositories;

import com.revice.mindorder.model.entity.Manufacturer;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ManufacturerRepositoryCustom {

    @NonNull
    List<Manufacturer> findAllNoFetch();
}
