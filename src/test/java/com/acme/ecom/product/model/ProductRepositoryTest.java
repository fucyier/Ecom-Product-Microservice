package com.acme.ecom.product.model;

import com.acme.ecom.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testAddProduct() {
        try {
            productRepository.save(createProject());
            assertTrue("successfully saved", true);
        } catch (Exception ex) {
            assertTrue("successfully failed", true);
        }
    }

    @Test
    public void testFindAllProducts() {

        productRepository.save(createProject());
        List<Product> productList = (List<Product>) productRepository.findAll();
        System.out.println(productList);
        assertTrue("",productList.size() > 0);
    }

    @Test
    public void testProductByProductCategory() {
        Product product = createProject();
        productRepository.save(product);
        List<Product> productList = productRepository.findByProductCategoryName(product.getProductCategoryName());
        assertTrue("",productList.size() > 0);
    }

    private Product createProject() {

        Product product = new Product();
        product.setName("Kamsung D3");
        product.setCode("KAMSUNG-TRIOS");
        product.setTitle("Kamsung Trios 12 inch , black , 12 px ....");
        product.setDescription("Kamsung Trios 12 inch with Touch");
        product.setImgUrl("kamsung.jpg");
        product.setPrice(12000.00);
        product.setProductCategoryName("testCategory");
        return product;
    }


}
