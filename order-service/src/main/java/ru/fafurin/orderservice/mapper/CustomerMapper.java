package ru.fafurin.orderservice.mapper;

import ru.fafurin.orderservice.domen.Customer;
import ru.fafurin.orderservice.dto.CustomerResponse;

public class CustomerMapper {

    public static Customer getCustomer(Customer customer, CustomerResponse customerResponse) {
        customer.setName(customerResponse.getName());
        customer.setEmail(customerResponse.getEmail());
        customer.setPhone(customerResponse.getPhone());
        return customer;
    }
}
