package com.revice.mindorder.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(originPatterns = {"*"},
        allowedHeaders = {"*"}, allowCredentials = "true", exposedHeaders = {HttpHeaders.SET_COOKIE})
public class InventoryRestController {
}
