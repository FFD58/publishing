package ru.fafurin.orderservice.mapper;

import ru.fafurin.orderservice.domen.Order;
import ru.fafurin.orderservice.dto.OrderResponse;

public class OrderMapper {

    public static Order getOrder(Order order, OrderResponse orderResponse) {
        order.setNumber(orderResponse.getNumber());
        order.setDeadline(orderResponse.getDeadline());
        order.setDescription(orderResponse.getDescription());
        return order;
    }
}
