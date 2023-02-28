package com.acme.ecom.product.repository;

import com.acme.ecom.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends CrudRepository<Product, String> {
    public List<Product> findByProductCategoryName(
            @Param("productCategory") String productCatagoryName);

    public List<Product> findByCode(@Param("code") String  code);
}
