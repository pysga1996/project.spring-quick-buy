package com.revice.mindorder.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.revice.mindorder.model.dto.OrderDetailCommentDTO;
import com.revice.mindorder.service.OrderDetailCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/manufacturer")
public class OrderDetailCommentRestController {

    private final OrderDetailCommentService orderDetailCommentService;

    @Autowired
    public OrderDetailCommentRestController(OrderDetailCommentService orderDetailCommentService) {
        this.orderDetailCommentService = orderDetailCommentService;
    }

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(OrderDetailCommentDTO.Views.Public.class)
    public ResponseEntity<Page<OrderDetailCommentDTO>> getManufacturerDropList(Pageable pageable) {
        return ResponseEntity.ok(this.orderDetailCommentService.getCommentPage(pageable));
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(OrderDetailCommentDTO.Views.Internal.class)
    public ResponseEntity<OrderDetailCommentDTO> getManufacturerById(@PathVariable("id") String id) {
        Optional<OrderDetailCommentDTO> manufacturerDTOOptional = this.orderDetailCommentService.getCommentById(id);
        return manufacturerDTOOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> getManufacturerById(@Validated(OrderDetailCommentDTO.Groups.Create.class)
                                                    @RequestBody OrderDetailCommentDTO orderDetailCommentDTO) {
        this.orderDetailCommentService.saveManufacturer(orderDetailCommentDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public ResponseEntity<Void> updateManufacturer(@Validated(OrderDetailCommentDTO.Groups.Create.class)
                                                   @RequestBody OrderDetailCommentDTO orderDetailCommentDTO) {
        this.orderDetailCommentService.saveManufacturer(orderDetailCommentDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable("id") String id) {
        this.orderDetailCommentService.deleteManufacturer(id);
        return ResponseEntity.ok().build();
    }
}
