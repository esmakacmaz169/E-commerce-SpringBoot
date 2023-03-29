package com.example.demo.service;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.OrderResponse;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;

    public OrderServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addOrder(OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }

    @Override
    public List<Customer> orderList() {
        return customerRepository.findAll();
    }

    @Override
    public List<OrderResponse> orderInformation() {
        return customerRepository.getJoinInformation();
    }

    @Override
    public Customer getOrderByCustomerId(int id) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("message.validation.service.customerIdMustNotBeEmpty");
        }
        return customerRepository.findById(id);
    }

    @Override
    public void deleteOrder(int id) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("message.validation.service.orderIdMustNotBeEmpty");
        }
        customerRepository.deleteById(id);
    }
}
