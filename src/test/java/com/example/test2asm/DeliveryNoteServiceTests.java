package com.example.test2asm;

import com.example.test2asm.entity.DeliveryNoteDetail;
import com.example.test2asm.repository.DeliveryDetailRepository;
import com.example.test2asm.service.DeliveryNoteService;
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
public class DeliveryNoteServiceTests {

    @InjectMocks
    private DeliveryNoteService service;
    @Mock
    private DeliveryDetailRepository repository;

    @Test
    public void findDeliveryTest() {
        DeliveryNoteDetail deliveryNoteDetail = new DeliveryNoteDetail();
        deliveryNoteDetail.setDeliveryDetail_id(1);

        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(deliveryNoteDetail)
        );
        assertEquals(1, deliveryNoteDetail.getDeliveryDetail_id());
    }

    @Test
    public void findAllDeliveryTest() {
        DeliveryNoteDetail detail1 = new DeliveryNoteDetail();
        DeliveryNoteDetail detail2 = new DeliveryNoteDetail();
        DeliveryNoteDetail detail3 = new DeliveryNoteDetail();
        detail1.setDeliveryDetail_id(1);
        detail2.setDeliveryDetail_id(2);
        detail3.setDeliveryDetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(detail1, detail2, detail3));
        List<DeliveryNoteDetail> deliveryNoteDetails = service.getDeliveries();

        assertEquals(1, deliveryNoteDetails.get(0).getDeliveryDetail_id());
        assertEquals(2, deliveryNoteDetails.get(1).getDeliveryDetail_id());
        assertEquals(3, deliveryNoteDetails.get(2).getDeliveryDetail_id());
    }

    @Test
    public void findDeliveryNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        DeliveryNoteDetail deliveryNoteDetail = service.getDeliveryById(1);
    }

}
