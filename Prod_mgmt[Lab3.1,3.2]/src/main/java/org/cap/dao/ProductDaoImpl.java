package org.cap.dao;

import org.cap.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ProductDaoImpl implements IProductDao{
    

    private EntityManager entityManager;
    

    public EntityManager getEntityManager() {
		return entityManager;
	}

    @PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
    public Product add(Product product) {
          
		getEntityManager().persist(product);
		return product;
	}

    @Override
    public List<Product> fetchAll() {
       //Collection<Product>values= entityManager.
       String jql = "from Product";
       TypedQuery<Product> query = entityManager.createQuery(jql, Product.class);
       List<Product>list = query.getResultList();
       return list;
    }

}
