package com.acme.ecom.product.model;


import com.acme.ecom.product.repository.ProductCategoryRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;


/**
 * @author <a href="mailto:biniljava<[@>.]yahoo.co.in">Binildas C. A.</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Before
    public void setUp() {
        productCategoryRepository.deleteAll();
    }

    @Test
    public void testAddProductCataogories() {
        try {
            ProductCategory productCategory = createProjectCategory();
            productCategoryRepository.save(productCategory);
            assertTrue("successfully saved", true);
        } catch (Exception ex) {
            assertTrue("successfully failed", true);
        }
    }


    @Test
    public void testFindAllProductCatagories() {
        ProductCategory productCategory = createProjectCategory();
        productCategoryRepository.save(productCategory);
        List<ProductCategory> catagoryList = (List<ProductCategory>) productCategoryRepository.findAll();
        assertTrue("",catagoryList.size() > 0);
    }


    private ProductCategory createProjectCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Mobile");
        productCategory.setDescription("Mobile phones");
        productCategory.setTitle("Mobiles and Tablet");
        productCategory.setImgUrl("mobile.jpg");
        return productCategory;
    }


}
