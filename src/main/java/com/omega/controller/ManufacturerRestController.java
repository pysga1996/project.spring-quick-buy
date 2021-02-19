package com.omega.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.omega.model.dto.ManufacturerDTO;
import com.omega.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manufacturer")
@CrossOrigin(origins = {"https://omega-buy-service.herokuapp.com", "http://localhost:3000"},
        allowedHeaders = {"*"}, allowCredentials = "true", exposedHeaders = {HttpHeaders.SET_COOKIE})
public class ManufacturerRestController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerRestController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @JsonView(ManufacturerDTO.Views.Internal.class)
    public ResponseEntity<List<ManufacturerDTO>> getManufacturerList() {
        return ResponseEntity.ok(this.manufacturerService.getManufacturerList());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/drop-list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @JsonView(ManufacturerDTO.Views.Public.class)
    public ResponseEntity<List<ManufacturerDTO>> getManufacturerDropList() {
        return ResponseEntity.ok(this.manufacturerService.getManufacturerDropList());
    }

    @GetMapping("/search")
    @JsonView(ManufacturerDTO.Views.Internal.class)
    public ResponseEntity<List<ManufacturerDTO>> searchForManufacturers() {
        return ResponseEntity.ok(this.manufacturerService.getManufacturerList());
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @JsonView(ManufacturerDTO.Views.Internal.class)
    public ResponseEntity<ManufacturerDTO> getManufacturerById(@PathVariable("id") Long id) {
        Optional<ManufacturerDTO> manufacturerDTOOptional = this.manufacturerService.getManufacturerById(id);
        return manufacturerDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<Void> getManufacturerById(@Validated(ManufacturerDTO.Groups.Create.class)
                                                    @RequestBody ManufacturerDTO manufacturerDTO) {
        this.manufacturerService.saveManufacturer(manufacturerDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public ResponseEntity<Void> updateManufacturer(@Validated(ManufacturerDTO.Groups.Create.class)
                                                   @RequestBody ManufacturerDTO manufacturerDTO) {
        this.manufacturerService.saveManufacturer(manufacturerDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable("id") Long id) {
        this.manufacturerService.deleteManufacturer(id);
        return ResponseEntity.ok().build();
    }
}
