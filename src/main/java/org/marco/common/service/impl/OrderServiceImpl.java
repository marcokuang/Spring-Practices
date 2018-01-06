package org.marco.common.service.impl;

import org.marco.common.data.repository.CustomerRepository;
import org.marco.common.data.repository.SalesOrderRepository;
import org.marco.common.domain.Customer;
import org.marco.common.domain.Order;
import org.marco.common.service.InventoryService;
import org.marco.common.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final InventoryService inventoryService;
    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;

    public OrderServiceImpl(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        this.inventoryService = inventoryService;
        this.customerRepository = customerRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    public Order createOrder(Customer customer, Map<String, Long> items) {
        return null;
    }

    public Order createOrder(String customerId, Map<String, Long> items) {
        return null;
    }

    public Order getOrder(String orderId) {
        return null;
    }
}
