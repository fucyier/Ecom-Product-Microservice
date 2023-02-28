package com.acme.ecom.product.repository;

import com.acme.ecom.product.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categories",
        path = "categories")
public interface ProductCategoryRepository extends
        CrudRepository<ProductCategory, String> {
}