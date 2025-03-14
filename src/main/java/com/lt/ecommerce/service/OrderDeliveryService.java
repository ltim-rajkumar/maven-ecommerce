package com.lt.ecommerce.service;

import com.lt.ecommerce.model.Order;
import com.lt.ecommerce.model.OrderDelivery;
import com.lt.ecommerce.repository.OrderDeliveryRepository;
import com.lt.ecommerce.repository.OrderRepository;
import com.lt.ecommerce.util.OrderDeliveryStatus;

import java.time.LocalDateTime;

public class OrderDeliveryService {
    private static final OrderDeliveryRepository orderDeliveryRepository = new OrderDeliveryRepository();

    public void createOrderDelivery() {
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setId(5001);
        orderDelivery.setOrderId(1001);
        orderDelivery.setDeliveryPersonId(2002);
        orderDelivery.setDeliveryStatus(OrderDeliveryStatus.PREPARING);
        orderDelivery.setRemark("Preparing order");
        orderDelivery.setCreatedAt(LocalDateTime.now());
        orderDeliveryRepository.createOrderDelivery(orderDelivery);
    }

    public void getOrderDelivery(int id) {
        OrderDelivery orderDelivery = orderDeliveryRepository.getOrderDelivery(id);
        if(orderDelivery != null) {
            System.out.println("Order delivery details: " + orderDelivery);
        }
    }

    public void displayAllOrderDelivery() {
        if(!orderDeliveryRepository.getAllOrderDelivery().isEmpty()) {
            orderDeliveryRepository.getAllOrderDelivery().forEach((id, orderDelivery) -> {
                System.out.println("Order delivery id: " + id + " and Order delivery details are: " + orderDelivery);
            });
        }
    }

    public void deleteOrderDelivery(int id) {
        if(orderDeliveryRepository.containOrderDelivery(id))
            System.out.println("Removed order delivery details = " + orderDeliveryRepository.deleteOrderDelivery(id));
        else {
            System.out.println("Order delivery id: " + id + " found to remove!!");
        }
    }

    public void deleteAllOrderDeliverys() {
        if(orderDeliveryRepository.getOrderDeliverySize() > 0) {
            orderDeliveryRepository.deleteAllOrderDeliverys();
            System.out.println("Removed all order delivery's");
        } else {
            System.out.println("No order delivery's found to delete!!");
        }
    }
}
