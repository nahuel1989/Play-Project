/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import play.data.validation.Constraints;

/**
 *
 * @author nahue
 */
@Entity
public class Sale extends BaseModel{
    
    @Constraints.Required
    public String customer;
    
    @Constraints.Required
    @OneToOne
    public Product product;
    
    @Constraints.Required
    public Integer amount;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    
}
