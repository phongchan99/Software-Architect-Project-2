package com.example.test2asm;

import com.example.test2asm.entity.*;
import com.example.test2asm.repository.*;
import com.example.test2asm.service.SaleInvoiceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(Assignment2Application.class, args);

        SaleInvoiceService service = new SaleInvoiceService();
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
        DeliveryRepository deliveryRepository = configurableApplicationContext.getBean(DeliveryRepository.class);
        DeliveryDetailRepository deliveryDetailRepository = configurableApplicationContext.getBean(DeliveryDetailRepository.class);
		//</editor-fold>

		//<editor-fold desc="CATEGORY">
        Category vehicle = new Category("Bike");
        Category mobiles = new Category("Phones");
        Category computer = new Category("Laptop");
        List<Category> categories = Arrays.asList(vehicle, mobiles, computer);
        categoryRepository.saveAll(categories);
		//</editor-fold>

		//<editor-fold desc="PROVIDER">
        Provider north = new Provider("Apple","AppleAddress","ApplePhone","AppleFax","AppleEmail","AppleContactPerson");
        Provider south = new Provider("Samsung","SamsungAddress","SamsungPhone","SamsungFax","SamsungEmail","SamsungContactPerson");
        List<Provider> providers = Arrays.asList(north, south);
        providerRepository.saveAll(providers);
		//</editor-fold>

		//<editor-fold desc="STAFF">
        Staff staff1 = new Staff("Phong", "PhongAddress","PhongPhone","PhongEmail");
        Staff staff2 = new Staff("Khang","KhangAddress","KhangPhone","KhangEmail");
        Staff staff3 = new Staff("Chris","ChrisAddress","ChrisPhone","ChrisEmail");
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
        Product phone = new Product("Phone","PhoneModel","PhoneBrand","PhoneCompany","PhoneDesc", mobiles, 2000);
        Product laptop = new Product("Laptop","LaptopModel","LaptopBrand","LaptopCompany","LaptopDesc", computer, 5000);
        Product bike = new Product("Bike","BikeModel","BikeBrand","BikeCompany","BikeDesc", vehicle, 500);
        List<Product> products = Arrays.asList(phone, laptop, bike);
        productRepository.saveAll(products);
		//</editor-fold>

		//<editor-fold desc="ORDER DETAIL">
        OrderDetail detailNum1 = new OrderDetail(order1, phone, 1);
        OrderDetail detailNum2 = new OrderDetail(order1, bike, 3);
        OrderDetail detailNum3 = new OrderDetail(order2, laptop, 2);
        List<OrderDetail> orderDetails = Arrays.asList(detailNum1, detailNum2, detailNum3);
        orderDetailRepository.saveAll(orderDetails);
		//</editor-fold>

		//<editor-fold desc="RECEIVING">
        ReceivingNote note1 = new ReceivingNote("2021-05-20", staff3);
        ReceivingNote note2 = new ReceivingNote("2021-05-21", staff1);
        List<ReceivingNote> receivingNotes = Arrays.asList(note1, note2);
        receivingRepository.saveAll(receivingNotes);
		//</editor-fold>

		//<editor-fold desc="RECEIVING DETAIL">
        ReceivingNoteDetail receivingNoteDetail1 = new ReceivingNoteDetail(note1, detailNum2);
        ReceivingNoteDetail receivingNoteDetail2 = new ReceivingNoteDetail(note2, detailNum1);
        List<ReceivingNoteDetail> receivingNoteDetails = Arrays.asList(receivingNoteDetail1, receivingNoteDetail2);
        receivingDetailRepository.saveAll(receivingNoteDetails);
		//</editor-fold>

        //<editor-fold desc="DELIVERY">
        DeliveryNote deli1 = new DeliveryNote("2021-05-23", staff1);
        DeliveryNote deli2 = new DeliveryNote("2021-05-24", staff2);
        DeliveryNote deli3 = new DeliveryNote("2021-05-25", staff3);
        List<DeliveryNote> deliveryNotes = Arrays.asList(deli1, deli2, deli3);
        deliveryRepository.saveAll(deliveryNotes);
        //</editor-fold>

        //<editor-fold desc="DELIVERY DETAIL">
        DeliveryNoteDetail deliveryNoteDetail1 = new DeliveryNoteDetail(deli1,phone, 11);
        DeliveryNoteDetail deliveryNoteDetail2 = new DeliveryNoteDetail(deli2,laptop, 22);
        DeliveryNoteDetail deliveryNoteDetail3 = new DeliveryNoteDetail(deli3,bike, 33);
        List<DeliveryNoteDetail> deliveryNoteDetails = Arrays.asList(deliveryNoteDetail1, deliveryNoteDetail2, deliveryNoteDetail3);
        deliveryDetailRepository.saveAll(deliveryNoteDetails);
        //</editor-fold>

		//<editor-fold desc="CUSTOMER">
        Customer customer1 = new Customer("Luan", "LuanAddress", "LuanPhone","LuanFax","LuanEmail","LuanContactPerson");
        Customer customer2 = new Customer("Nguyen", "NguyenAddress", "NguyenPhone","NguyenFax","NguyenEmail","NguyenContactPerson");
        Customer customer3 = new Customer("Quan", "QuanAddress", "QuanPhone","QuanFax","QuanEmail","QuanContactPerson");
        List<Customer> customers = Arrays.asList(customer1, customer2, customer3);
        customerRepository.saveAll(customers);
		//</editor-fold>

		//<editor-fold desc="INVOICE">
        SaleInvoice saleInvoice1 = new SaleInvoice("2021-05-27", staff1);
        SaleInvoice saleInvoice2 = new SaleInvoice("2021-05-28", staff2);
        SaleInvoice saleInvoice3 = new SaleInvoice("2021-05-29", staff3);
        SaleInvoice saleInvoice4 = new SaleInvoice("2021-05-30", staff3);
        List<SaleInvoice> saleInvoices = Arrays.asList(saleInvoice1, saleInvoice2, saleInvoice3,saleInvoice4);
        invoiceRepository.saveAll(saleInvoices);
		//</editor-fold>

		//<editor-fold desc="INVOICE DETAIL">
        SaleInvoiceDetail saleInvoiceDetail1 = new SaleInvoiceDetail(saleInvoice1, phone, customer1, 5);
        SaleInvoiceDetail saleInvoiceDetail2 = new SaleInvoiceDetail(saleInvoice2, laptop, customer2, 3);
        SaleInvoiceDetail saleInvoiceDetail3 = new SaleInvoiceDetail(saleInvoice3, bike, customer3, 2);
        SaleInvoiceDetail saleInvoiceDetail4 = new SaleInvoiceDetail(saleInvoice4, phone, customer2, 1);
        List<SaleInvoiceDetail> saleInvoiceDetails = Arrays.asList(saleInvoiceDetail1, saleInvoiceDetail2, saleInvoiceDetail3, saleInvoiceDetail4);
        invoiceDetailRepository.saveAll(saleInvoiceDetails);
		//</editor-fold>


    }

}
