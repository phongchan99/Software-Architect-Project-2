package com.example.test2asm;

import com.example.test2asm.entity.*;
import com.example.test2asm.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Test2asmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(Test2asmApplication.class, args);

		OrderRepository orderRepository = configurableApplicationContext.getBean(OrderRepository.class);
		ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);
		CategoryRepository categoryRepository = configurableApplicationContext.getBean(CategoryRepository.class);
		StaffRepository staffRepository = configurableApplicationContext.getBean(StaffRepository.class);
		ProviderRepository providerRepository = configurableApplicationContext.getBean(ProviderRepository.class);
		OrderDetailRepository orderDetailRepository = configurableApplicationContext.getBean(OrderDetailRepository.class);
		ReceivingNoteRepository receivingNoteRepository = configurableApplicationContext.getBean(ReceivingNoteRepository.class);
		ReceivingDetailRepository receivingDetailRepository = configurableApplicationContext.getBean(ReceivingDetailRepository.class);
		CustomerRepository customerRepository = configurableApplicationContext.getBean(CustomerRepository.class);

		//CATEGORY
		Category vehicle = new Category("Bike");
		Category mobiles = new Category("Phones");
		Category computer = new Category("Laptop");
		List<Category> categories = Arrays.asList(vehicle, mobiles,computer);
		categoryRepository.saveAll(categories);

		//PROVIDER
		Provider north = new Provider("Apple");
		Provider south = new Provider("Samsung");
		List<Provider> providers = Arrays.asList(north, south);
		providerRepository.saveAll(providers);

		//STAFF
		Staff staff1 = new Staff("Phong","Ho Chi Minh","01234","phongchan99");
		Staff staff2 = new Staff("Audrey","Ha Noi","05678","Audreysomething");
		Staff staff3 = new Staff("Jimmy", "Go Vap", "012367", "Khang@gmail");
		List<Staff> staffs = Arrays.asList(staff1, staff2,staff3);
		staffRepository.saveAll(staffs);

		//ORDER
		OOrder order1 = new OOrder("02/01/2000",staff1, south);
		OOrder order2 = new OOrder("23/01/2003", staff2, north);
		List<OOrder> orders = Arrays.asList(order1,order2);
		orderRepository.saveAll(orders);

		//PRODUCT
		Product phone = new Product("iphone11",mobiles,2000);
		Product electronic = new Product("Razer Laptop",computer,5000);
		Product device = new Product("AirpodsPro",mobiles,500);
		List<Product> products = Arrays.asList(phone, electronic, device);
		productRepository.saveAll(products);

		//ORDER DETAIL
		OrderDetail detailNum1 = new OrderDetail(order1, phone,1);
		OrderDetail detailNum2 = new OrderDetail(order1,device,3);
		OrderDetail detailNum3 = new OrderDetail(order2, electronic, 2);
		List<OrderDetail> orderDetails = Arrays.asList(detailNum1,detailNum2,detailNum3);
		orderDetailRepository.saveAll(orderDetails);

		//RECEIVING
		ReceivingNote note1 = new ReceivingNote("25/05/2021", staff3);
		ReceivingNote note2 = new ReceivingNote("26/05/2021", staff1);
		List<ReceivingNote> receivingNotes = Arrays.asList(note1, note2);
		receivingNoteRepository.saveAll(receivingNotes);

		//RECEIVING DETAIL
		ReceivingDetail receivingDetail1 = new ReceivingDetail(note1, detailNum2);
		ReceivingDetail receivingDetail2 = new ReceivingDetail(note2, detailNum1);
		List<ReceivingDetail> receivingDetails = Arrays.asList(receivingDetail1, receivingDetail2);
		receivingDetailRepository.saveAll(receivingDetails);

		//CUSTOMER
		Customer customer1 = new Customer("Luan");
		Customer customer2 = new Customer("Nguyen");
		Customer customer3 = new Customer("Quan");
		List<Customer> customers = Arrays.asList(customer1, customer2, customer3);
		customerRepository.saveAll(customers);
	}

}
