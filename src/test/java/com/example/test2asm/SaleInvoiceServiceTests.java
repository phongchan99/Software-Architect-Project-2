package com.example.test2asm;

import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.repository.InvoiceDetailRepository;
import com.example.test2asm.service.SaleInvoiceService;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SaleInvoiceServiceTests {

    @InjectMocks
    private SaleInvoiceService service;
    @Mock
    private InvoiceDetailRepository repository;

    @Test
    public void findInvoiceTest() {
        SaleInvoiceDetail invoice = new SaleInvoiceDetail();
        invoice.setInvoiceDetail_id(1);

        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(invoice)
        );
        assertEquals(1, invoice.getInvoiceDetail_id());
    }

    @Test
    public void findAllInvoiceTest() {
        SaleInvoiceDetail invoice1 = new SaleInvoiceDetail();
        SaleInvoiceDetail invoice2 = new SaleInvoiceDetail();
        SaleInvoiceDetail invoice3 = new SaleInvoiceDetail();
        invoice1.setInvoiceDetail_id(1);
        invoice2.setInvoiceDetail_id(2);
        invoice3.setInvoiceDetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(invoice1, invoice2, invoice3));
        List<SaleInvoiceDetail> invoices = service.getInvoices();

        assertEquals(1,invoices.get(0).getInvoiceDetail_id());
        assertEquals(2,invoices.get(1).getInvoiceDetail_id());
        assertEquals(3,invoices.get(2).getInvoiceDetail_id());
    }

    @Test
    public void findReceivingNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        SaleInvoiceDetail saleInvoiceDetail = service.getInvoiceById(1);
    }
}
