package org.marco.common.config;

import org.marco.common.data.repository.CustomerRepository;
import org.marco.common.data.repository.InventoryItemRepository;
import org.marco.common.data.repository.SalesOrderRepository;
import org.marco.common.service.InventoryService;
import org.marco.common.service.OrderService;
import org.marco.common.service.impl.InventoryServiceImpl;
import org.marco.common.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
// import spring configs from other files
@Import(DataConfig.class)
// declare a property source
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
public class AppConfig {
	
	// look for a value in a property source
	@Value("${greeting.text}")
	private String greetingText;
	
	@Value("${greeting.preamble}")
	private String greetingPreamble; 
	
	public class Worker{
		private String text;
		private String preamble;
		
		public Worker(String preamble, String text) {
			this.text = text;
			this.preamble = preamble;
		}
		
		public void execute() {
			System.out.println(preamble + "  "+ text);
		}
	}
	
	@Bean
	public Worker worker() {
		return new Worker(greetingPreamble, greetingText);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private InventoryItemRepository inventoryItemRepository;
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	

	@Bean
	public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
		return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
	}
	
	@Bean
	public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
		return new InventoryServiceImpl(inventoryItemRepository);
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = context.getBean(OrderService.class);
		
		String output = (orderService == null ? "not ok" : "ok");
		
		Worker worker = context.getBean(Worker.class);
		worker.execute();
		
		System.out.println(output);
	}
}
