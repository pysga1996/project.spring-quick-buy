package com.omega.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = {"https://omega-buy-service.herokuapp.com", "http://localhost:3000"},
        allowedHeaders = {"*"}, allowCredentials = "true", exposedHeaders = {HttpHeaders.SET_COOKIE})
public class OrderRestController {
}
