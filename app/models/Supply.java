/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import play.data.validation.Constraints;

/**
 *
 * @author nahue
 */
@Entity
public class Supply extends BaseModel {
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public Integer stock;
    
    public Supply(){}
    
    public static Finder<Long, Supply> find = new Finder<Long, Supply>(Long.class, Supply.class);
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
