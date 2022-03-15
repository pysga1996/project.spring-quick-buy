package com.revice.mindorder.service;

import com.revice.mindorder.model.dto.ManufacturerDTO;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<ManufacturerDTO> getManufacturerList();

    List<ManufacturerDTO> getManufacturerDropList();

    Optional<ManufacturerDTO> getManufacturerById(Long id);

    void saveManufacturer(ManufacturerDTO manufacturerDTO);

    void deleteManufacturer(Long id);
}
