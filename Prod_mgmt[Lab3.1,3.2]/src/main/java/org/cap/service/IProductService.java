package org.cap.service;

import org.cap.entities.Product;

import java.util.List;

public interface IProductService {
    Product add(Product product);

    List<Product> fetchAll();

}
