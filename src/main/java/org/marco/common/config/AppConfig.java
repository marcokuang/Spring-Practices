package org.marco.common.config;

import org.marco.common.data.repository.CustomerRepository;
import org.marco.common.data.repository.InventoryItemRepository;
import org.marco.common.data.repository.SalesOrderRepository;
import org.marco.common.service.InventoryService;
import org.marco.common.service.OrderService;
import org.marco.common.service.impl.InventoryServiceImpl;
import org.marco.common.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
		return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
	}
	
	@Bean
	public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
		return new InventoryServiceImpl(inventoryItemRepository);
	}
	
	@Bean
	public InventoryItemRepository inventoryItemRepository() {
		return new InventoryItemRepository();
	}
	
	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepository();
		
	}
	
	@Bean
	public SalesOrderRepository salesOrderRepository() {
		return new SalesOrderRepository();
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = context.getBean(OrderService.class);
		
		String output = (orderService == null ? "not ok" : "ok");
		
		System.out.println(output);
	}
}
