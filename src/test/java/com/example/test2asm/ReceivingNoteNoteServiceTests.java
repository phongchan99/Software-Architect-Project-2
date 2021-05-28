package com.example.test2asm;

import com.example.test2asm.entity.ReceivingNoteDetail;
import com.example.test2asm.repository.ReceivingDetailRepository;
import com.example.test2asm.service.ReceivingNoteService;
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
public class ReceivingNoteNoteServiceTests {

    @InjectMocks
    private ReceivingNoteService service;
    @Mock
    private ReceivingDetailRepository repository;

    @Test
    public void findReceivingTest() {
        ReceivingNoteDetail receivingNoteDetail = new ReceivingNoteDetail();
        receivingNoteDetail.setReceivingdetail_id(1);

        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(receivingNoteDetail)
        );
        assertEquals(1, receivingNoteDetail.getReceivingdetail_id());
    }

    @Test
    public void findAllReceivingTest() {
        ReceivingNoteDetail detail1 = new ReceivingNoteDetail();
        ReceivingNoteDetail detail2 = new ReceivingNoteDetail();
        ReceivingNoteDetail detail3 = new ReceivingNoteDetail();
        detail1.setReceivingdetail_id(1);
        detail2.setReceivingdetail_id(2);
        detail3.setReceivingdetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(detail1, detail2, detail3));
        List<ReceivingNoteDetail> receivingNoteDetails = service.getReceivings();

        assertEquals(1, receivingNoteDetails.get(0).getReceivingdetail_id());
        assertEquals(2, receivingNoteDetails.get(1).getReceivingdetail_id());
        assertEquals(3, receivingNoteDetails.get(2).getReceivingdetail_id());
    }

    @Test
    public void findReceivingNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        ReceivingNoteDetail receivingNoteDetail = service.getReceivingById(1);
    }
}
