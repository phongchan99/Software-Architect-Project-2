package com.example.test2asm;

import com.example.test2asm.entity.Staff;
import com.example.test2asm.repository.StaffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StaffTests {

    @Autowired
    private StaffRepository repository;

    @Test
    public void testCreateStaff() {
        Staff staff = new Staff("Phong", "", "", "");
        Staff savedStaff = repository.save(staff);

        assertNotNull(savedStaff);
    }

    @Test
    public void testFindStaffByName() {
        Staff staff = new Staff("Phong", "", "", "");
        repository.save(staff);
        String name = "Phong";
        Staff test = repository.findByName(name);

        assertNotNull(test);
    }

    @Test
    public void testUpdateStaff() {
        String new_name = "Chris";
        Staff staff = new Staff(new_name, "", "", "");
        repository.save(staff);
        Staff updatedStaff = repository.findByName(new_name);

        assert(updatedStaff.getName().equals(new_name));
    }

    @Test
    public void testListStaffs() {
        Staff staff = new Staff("Phong", "", "", "");
        repository.save(staff);
        List<Staff> staffs = repository.findAll();

        assert (staffs).size() > 0;
    }

    @Test
    public void testDeleteStaff() {
        Staff staff = new Staff("Phong", "", "", "");
        repository.save(staff);
        Integer id = 1;
        staff.setStaff_id(id);

        boolean presentBeforeDelete = repository.findById(id).isPresent();
        repository.deleteById(id);
        boolean notPresentAfterDelete = repository.findById(id).isPresent();

        assertTrue(presentBeforeDelete);
        assertFalse(notPresentAfterDelete);

    }

}
