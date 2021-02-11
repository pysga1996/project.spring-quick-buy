package com.omega.service;

import com.omega.model.dto.ManufacturerDTO;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<ManufacturerDTO> getManufacturerList();

    Optional<ManufacturerDTO> getManufacturerById(Long id);

    void saveManufacturer(ManufacturerDTO manufacturerDTO);

    void deleteManufacturer(Long id);
}
