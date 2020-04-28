package org.cap.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
    private int productId;

    public int getProductId(){
        return productId;
    }

    public void setProductId(int id){
        this.productId=id;
    }

    private String productName;

    public String getProductName(){
        return productName;
    }

    public void setProductName(String name){
        this.productName=name;
    }
    
    private double productPrice;

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
   
}
