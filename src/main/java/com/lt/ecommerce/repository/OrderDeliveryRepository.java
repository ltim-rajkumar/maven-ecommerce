package com.lt.ecommerce.repository;
import com.lt.ecommerce.model.OrderDelivery;

import java.util.HashMap;
import java.util.Map;

public class OrderDeliveryRepository {

    private static final Map<Integer, OrderDelivery> orderDeliveryMap = new HashMap<Integer, OrderDelivery>();

    public void createOrderDelivery(OrderDelivery orderDelivery) {
        orderDeliveryMap.put(orderDelivery.getId(), orderDelivery);
    }

    public OrderDelivery getOrderDelivery(int id) {
        return orderDeliveryMap.get(id);
    }

    public Map<Integer, OrderDelivery> getAllOrderDelivery() {
        return orderDeliveryMap;
    }

    public OrderDelivery deleteOrderDelivery(int id) {
        return orderDeliveryMap.remove(id);
    }

    public void deleteAllOrderDeliverys() {
        orderDeliveryMap.clear();
    }

    public int getOrderDeliverySize() {
        return orderDeliveryMap.size();
    }

    public boolean containOrderDelivery(int id) {
        return orderDeliveryMap.containsKey(id);
    }

}

