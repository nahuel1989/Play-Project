/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import play.data.validation.Constraints;
import play.db.ebean.Model;


/**
 *
 * @author nahue
 */
@Entity
public class Product extends BaseModel{
    
    @Constraints.Required
    public String name;
    
    public String description;
    
    public Boolean active;
    
    @ManyToMany(cascade=CascadeType.REMOVE)
    public List<Supply> supplys;
    
    public Product(){} 

    public static Model.Finder<Long,Product> find = new Model.Finder(Long.class, Product.class);

    public static Product findById( Long _id ){
           return find.where()
                   .eq( "id", _id )
                   .findUnique();
    }

    public static List<Product> findAll() {
       return find.all();   
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Supply> getSupplys() {
        return supplys;
    }

    public void setSupplys(List<Supply> supplys) {
        this.supplys = supplys;
    }
    
}
