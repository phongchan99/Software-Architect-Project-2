package com.example.test2asm;

import com.example.test2asm.entity.ReceivingDetail;
import com.example.test2asm.repository.ReceivingDetailRepository;
import com.example.test2asm.service.ReceivingService;
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
public class ReceivingServiceTests {

    @InjectMocks
    private ReceivingService service;
    @Mock
    private ReceivingDetailRepository repository;

    @Test
    public void findReceivingTest() {
        ReceivingDetail receivingDetail = new ReceivingDetail();
        receivingDetail.setReceivingdetail_id(1);

        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(receivingDetail)
        );
        assertEquals(1, receivingDetail.getReceivingdetail_id());
    }

    @Test
    public void findAllReceivingTest() {
        ReceivingDetail detail1 = new ReceivingDetail();
        ReceivingDetail detail2 = new ReceivingDetail();
        ReceivingDetail detail3 = new ReceivingDetail();
        detail1.setReceivingdetail_id(1);
        detail2.setReceivingdetail_id(2);
        detail3.setReceivingdetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(detail1, detail2, detail3));
        List<ReceivingDetail> receivingDetails = service.getReceivings();

        assertEquals(1, receivingDetails.get(0).getReceivingdetail_id());
        assertEquals(2, receivingDetails.get(1).getReceivingdetail_id());
        assertEquals(3, receivingDetails.get(2).getReceivingdetail_id());
    }

    @Test
    public void findReceivingNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        ReceivingDetail receivingDetail = service.getReceivingById(1);
    }
}
