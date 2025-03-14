package com.lt.ecommerce.service;

import com.lt.ecommerce.model.Order;
import com.lt.ecommerce.model.Product;
import com.lt.ecommerce.repository.OrderRepository;

public class OrderService {
    private static final OrderRepository orderDeliveryRepository = new OrderRepository();

    public void createOrder() {
        Order order = new Order();
        order.setId(1001);
        order.setCustomerId(2001);
        order.setProductId(3001);
        order.setPrice(122.3f);
        order.setQty(3);
        order.setTax(15);
        order.setFinalAmount(525);
        orderDeliveryRepository.createOrder(order);
    }

    public void getOrder(int orderId) {
        Order order = orderDeliveryRepository.getOrder(orderId);
        if(order != null) {
            System.out.println("Order details: " + order);
        }
    }

    public void displayAllOrders() {
        if(!orderDeliveryRepository.getAllOrders().isEmpty()) {
            orderDeliveryRepository.getAllOrders().forEach((orderId, order) -> {
                System.out.println("Order id: " + orderId + " and Order details are: " + order);
            });
        }
    }

    public void deleteOrder(int orderId) {
        if(orderDeliveryRepository.containsOrder(orderId)) {
            System.out.println("Removed order details = " + orderDeliveryRepository.deleteOrder(orderId));
        } else {
            System.out.println("Order id: " + orderId + " found to remove!!");
        }
    }

    public void deleteAllOrders() {
        if(orderDeliveryRepository.getOrdersSize() > 0) {
            orderDeliveryRepository.deleteAllOrders();
            System.out.println("Removed all order's");
        } else {
            System.out.println("No order's found to delete!!");
        }
    }
}
