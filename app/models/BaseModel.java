/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author nahue
 */
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import play.db.ebean.Model;

@MappedSuperclass
public class BaseModel extends Model {
   @Id
   @GeneratedValue
   public Long id;
  
}