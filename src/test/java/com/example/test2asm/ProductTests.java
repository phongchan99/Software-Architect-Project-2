package com.example.test2asm;

import com.example.test2asm.entity.Category;
import com.example.test2asm.entity.Product;
import com.example.test2asm.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductTests {

    @Autowired
    private ProductRepository repository;

    private Category category = new Category();

    @Test
    public void testCreateProduct() {
        Product product = new Product("razer","","","","",category, 5000);
        Product savedProduct = repository.save(product);

        assertNotNull(savedProduct);
    }
}
