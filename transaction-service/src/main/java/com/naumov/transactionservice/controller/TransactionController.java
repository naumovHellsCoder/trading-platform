package com.naumov.transactionservice.controller;


import com.naumov.transactionservice.dao.OrderDao;
import com.naumov.transactionservice.entity.Orders;
import com.naumov.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transaction/")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> createTransaction(@RequestBody OrderDao orderDao){
        Orders orders = transactionService.createOrder(orderDao);
        return ResponseEntity.ok(orders);

    }
}
