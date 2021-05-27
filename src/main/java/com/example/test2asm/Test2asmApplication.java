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

        //<editor-fold desc="REPOSITORY">
        OrderRepository orderRepository = configurableApplicationContext.getBean(OrderRepository.class);
        ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);
        CategoryRepository categoryRepository = configurableApplicationContext.getBean(CategoryRepository.class);
        StaffRepository staffRepository = configurableApplicationContext.getBean(StaffRepository.class);
        ProviderRepository providerRepository = configurableApplicationContext.getBean(ProviderRepository.class);
        OrderDetailRepository orderDetailRepository = configurableApplicationContext.getBean(OrderDetailRepository.class);
        ReceivingRepository receivingRepository = configurableApplicationContext.getBean(ReceivingRepository.class);
        ReceivingDetailRepository receivingDetailRepository = configurableApplicationContext.getBean(ReceivingDetailRepository.class);
        CustomerRepository customerRepository = configurableApplicationContext.getBean(CustomerRepository.class);
        InvoiceRepository invoiceRepository = configurableApplicationContext.getBean(InvoiceRepository.class);
        InvoiceDetailRepository invoiceDetailRepository = configurableApplicationContext.getBean(InvoiceDetailRepository.class);
		//</editor-fold>

		//<editor-fold desc="CATEGORY">
        Category vehicle = new Category("Bike");
        Category mobiles = new Category("Phones");
        Category computer = new Category("Laptop");
        List<Category> categories = Arrays.asList(vehicle, mobiles, computer);
        categoryRepository.saveAll(categories);
		//</editor-fold>

		//<editor-fold desc="PROVIDER">
        Provider north = new Provider("Apple");
        Provider south = new Provider("Samsung");
        List<Provider> providers = Arrays.asList(north, south);
        providerRepository.saveAll(providers);
		//</editor-fold>

		//<editor-fold desc="STAFF">
        Staff staff1 = new Staff("Phong", "Ho Chi Minh", "01234", "phongchan99");
        Staff staff2 = new Staff("Audrey", "Ha Noi", "05678", "Audreysomething");
        Staff staff3 = new Staff("Jimmy", "Go Vap", "012367", "Khang@gmail");
        List<Staff> staffs = Arrays.asList(staff1, staff2, staff3);
        staffRepository.saveAll(staffs);
		//</editor-fold>

		//<editor-fold desc="ORDER">
        OOrder order1 = new OOrder("2021-01-02", staff1, south);
        OOrder order2 = new OOrder("2021-03-23", staff2, north);
        List<OOrder> orders = Arrays.asList(order1, order2);
        orderRepository.saveAll(orders);
		//</editor-fold>

		//<editor-fold desc="PRODUCT">
        Product phone = new Product("iphone11", mobiles, 2000);
        Product electronic = new Product("Razer Laptop", computer, 5000);
        Product device = new Product("AirpodsPro", mobiles, 500);
        List<Product> products = Arrays.asList(phone, electronic, device);
        productRepository.saveAll(products);
		//</editor-fold>

		//<editor-fold desc="ORDER DETAIL">
        OrderDetail detailNum1 = new OrderDetail(order1, phone, 1);
        OrderDetail detailNum2 = new OrderDetail(order1, device, 3);
        OrderDetail detailNum3 = new OrderDetail(order2, electronic, 2);
        List<OrderDetail> orderDetails = Arrays.asList(detailNum1, detailNum2, detailNum3);
        orderDetailRepository.saveAll(orderDetails);
		//</editor-fold>

		//<editor-fold desc="RECEIVING">
        Receiving note1 = new Receiving("2021-05-25", staff3);
        Receiving note2 = new Receiving("2021-05-26", staff1);
        List<Receiving> receivings = Arrays.asList(note1, note2);
        receivingRepository.saveAll(receivings);
		//</editor-fold>

		//<editor-fold desc="RECEIVING DETAIL">
        ReceivingDetail receivingDetail1 = new ReceivingDetail(note1, detailNum2);
        ReceivingDetail receivingDetail2 = new ReceivingDetail(note2, detailNum1);
        List<ReceivingDetail> receivingDetails = Arrays.asList(receivingDetail1, receivingDetail2);
        receivingDetailRepository.saveAll(receivingDetails);
		//</editor-fold>

		//<editor-fold desc="CUSTOMER">
        Customer customer1 = new Customer("Luan", "LuanAddress", "LuanPhone");
        Customer customer2 = new Customer("Nguyen", "NguyenAddress", "NguyenPhone");
        Customer customer3 = new Customer("Quan", "QuanAddress", "QuanPhone");
        List<Customer> customers = Arrays.asList(customer1, customer2, customer3);
        customerRepository.saveAll(customers);
		//</editor-fold>

		//<editor-fold desc="INVOICE">
        Invoice invoice1 = new Invoice("2021-05-28", staff1);
        Invoice invoice2 = new Invoice("2021-05-29", staff2);
        Invoice invoice3 = new Invoice("2021-05-30", staff3);
        List<Invoice> invoices = Arrays.asList(invoice1, invoice2, invoice3);
        invoiceRepository.saveAll(invoices);
		//</editor-fold>

		//<editor-fold desc="INVOICE DETAIL">
        InvoiceDetail invoiceDetail1 = new InvoiceDetail(invoice1, phone, customer1, 5, 0);
        InvoiceDetail invoiceDetail2 = new InvoiceDetail(invoice2, electronic, customer2, 3, 0);
        InvoiceDetail invoiceDetail3 = new InvoiceDetail(invoice3, device, customer3, 2, 0);
        List<InvoiceDetail> invoiceDetails = Arrays.asList(invoiceDetail1, invoiceDetail2, invoiceDetail3);
        invoiceDetailRepository.saveAll(invoiceDetails);
		//</editor-fold>
    }

}
