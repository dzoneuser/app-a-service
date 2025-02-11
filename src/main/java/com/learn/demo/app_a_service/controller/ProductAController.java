package com.learn.demo.app_a_service.controller;


import com.learn.demo.app_a_service.dto.BillingRequest;
import com.learn.demo.app_a_service.service.ProductAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductAController {

    @Autowired
    private ProductAService service;

    @PostMapping("v1/billing/{arg}")
    public ResponseEntity<String> saveBilling
            (@RequestBody BillingRequest billingRequest, @PathVariable String arg)
            throws ExecutionException, InterruptedException {

        service.saveBilling(billingRequest,arg);
        return new ResponseEntity<>("Resource Created", HttpStatus.CREATED);
    }


    @GetMapping("v1/billing")
    public ResponseEntity<List<BillingRequest>> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    @GetMapping("v1/billing/{id}")
    public ResponseEntity<BillingRequest> findById(@PathVariable long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @PostMapping("sso/billing/{arg}")
    public ResponseEntity<String> saveBillingSSO(@RequestBody BillingRequest billingRequest, @PathVariable String arg)
            throws ExecutionException, InterruptedException {
        service.saveBilling(billingRequest,arg);
        return new ResponseEntity<>("Resource Created", HttpStatus.CREATED);

    }

    @GetMapping("sso/billing")
    public ResponseEntity<List<BillingRequest>> findAllSSO(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }


}
