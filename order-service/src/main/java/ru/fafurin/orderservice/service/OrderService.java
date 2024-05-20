package ru.fafurin.orderservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fafurin.orderservice.domen.Customer;
import ru.fafurin.orderservice.domen.Order;
import ru.fafurin.orderservice.domen.Status;
import ru.fafurin.orderservice.dto.OrderResponse;
import ru.fafurin.orderservice.dto.StatusResponse;
import ru.fafurin.orderservice.exception.OrderNotFoundException;
import ru.fafurin.orderservice.mapper.OrderMapper;
import ru.fafurin.orderservice.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order save(OrderResponse orderResponse) {
        Order order = new Order();
        Customer customer = customerService
                .findByEmail(orderResponse.getCustomerResponse().getEmail());

        if (customer == null) {
            customer = customerService.save(orderResponse.getCustomerResponse());
        }
        order.setCustomer(customer);
        order.setStatus(Status.AWAIT);
        return orderRepository.save(
                OrderMapper.getOrder(order, orderResponse));
    }

    @Transactional
    public Order update(Long id, OrderResponse orderResponse) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return orderRepository.save(
                OrderMapper.getOrder(order, orderResponse));
    }

    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderRepository.delete(order);
    }

    public Order setInWorkStatus(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if (order.getStatus() == Status.AWAIT) {
            order.setStatus(Status.IN_WORK);
            orderRepository.save(order);
        }
        return order;
    }
}
