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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = {"org.marco.common"})
public class AppConfig {

    @Value("${greeting.text}")
    private String greetingText;

    @Value("${greeting.preamble}")
    private String greetingPreamble;


    public class Worker{
        private String preamble;
        private String text;

        public Worker(String preamble, String text){
            this.preamble = preamble;
            this.text = text;
            System.out.println("New Instance");
        }

        public void execute(){
            System.out.println(preamble + " " + text);
        }

    }
    
    @Bean
    public Worker worker() {
    	return new Worker(greetingPreamble, greetingText);
    }


    public static void main (String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Worker worker = context.getBean(Worker.class);
        worker.execute();
        
        OrderService orderService = context.getBean(OrderServiceImpl.class);
    }
}
