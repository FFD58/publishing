package ru.fafurin.orderservice.service;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.orderservice.domen.Customer;
import ru.fafurin.orderservice.dto.CustomerResponse;
import ru.fafurin.orderservice.exception.CustomerNotFoundException;
import ru.fafurin.orderservice.mapper.CustomerMapper;
import ru.fafurin.orderservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Nullable
    public Customer findByEmail(String email) {
        Optional<Customer> customerOptional = repository.findByEmail(email);
        if (customerOptional.isEmpty()) {
            return null;
        } else return customerOptional.get();
    }

    public Customer save(CustomerResponse customerResponse) {
        return repository.save(
                CustomerMapper.getCustomer(new Customer(), customerResponse));
    }

    public Customer update(Long id, CustomerResponse customerResponse) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return repository.save(
                CustomerMapper.getCustomer(customer, customerResponse));
    }

    public void delete(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        repository.delete(customer);
    }
}
