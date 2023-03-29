package com.example.demo.service;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.OrderResponse;
import com.example.demo.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    Customer addOrder(@RequestBody OrderRequest request);
    List<Customer> orderList();
    List<OrderResponse> orderInformation();
    Customer getOrderByCustomerId(@PathVariable int id) throws Exception;
    void deleteOrder(@PathVariable int id) throws Exception;

}
