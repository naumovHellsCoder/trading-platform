package com.naumov.transactionservice.service;

import com.naumov.transactionservice.dao.OrderDao;
import com.naumov.transactionservice.entity.Orders;
import com.naumov.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class TransactionService {

    private final TransactionRepository orderRepository;
    @Autowired
    public TransactionService(TransactionRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional(
            readOnly = true,
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRES_NEW)

    public Orders createOrder(OrderDao orderDao){
        Integer sumTransaction = orderDao.getSumTransaction();
        Orders orders = new Orders();
        orders.setDateCreate(Instant.now());
        orders.setSumTransaction(sumTransaction);
        orderRepository.save(orders);
        return null;
    }

}
