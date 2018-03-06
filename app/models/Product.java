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
    
    @ManyToMany(cascade=CascadeType.ALL)
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
    
    
}
