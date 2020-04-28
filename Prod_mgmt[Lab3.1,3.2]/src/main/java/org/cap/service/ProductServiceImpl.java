package org.cap.service;

import org.cap.dao.IProductDao;
import org.cap.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(IProductDao dao) {
        this.productDao = dao;
    }

    @Override
    public Product add(Product product) {
        product = productDao.add(product);
        return product;
    }

    @Override
    public List<Product> fetchAll() {
        List<Product> products = productDao.fetchAll();
        return products;
    }
    
}
