package com.example.test2asm;

import com.example.test2asm.entity.Delivery;
import com.example.test2asm.entity.DeliveryDetail;
import com.example.test2asm.repository.DeliveryDetailRepository;
import com.example.test2asm.service.DeliveryService;
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
public class DeliveryServiceTests {

    @InjectMocks
    private DeliveryService service;
    @Mock
    private DeliveryDetailRepository repository;

    @Test
    public void findDeliveryTest() {
        DeliveryDetail deliveryDetail;
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(deliveryDetail = new DeliveryDetail(new Delivery(), 1))
        );

        deliveryDetail.setDeliverydetail_id(1);
        assertEquals(1, deliveryDetail.getDeliverydetail_id());
    }

    @Test
    public void findAllDeliveryTest() {
        DeliveryDetail detail1 = new DeliveryDetail();
        DeliveryDetail detail2 = new DeliveryDetail();
        DeliveryDetail detail3 = new DeliveryDetail();
        detail1.setDeliverydetail_id(1);
        detail2.setDeliverydetail_id(2);
        detail3.setDeliverydetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(detail1, detail2, detail3));
        List<DeliveryDetail> deliveryDetails = service.getDeliveries();

        assertEquals(1, deliveryDetails.get(0).getDeliverydetail_id());
        assertEquals(2, deliveryDetails.get(1).getDeliverydetail_id());
        assertEquals(3, deliveryDetails.get(2).getDeliverydetail_id());
    }

    @Test
    public void findDeliveryNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        DeliveryDetail deliveryDetail = service.getDeliveryById(1);
    }

}
