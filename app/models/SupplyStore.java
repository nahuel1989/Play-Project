/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nahue
 */
public class SupplyStore {
    
    /*@SuppressWarnings("FieldMayBeFinal")
    private Map<Long, Supply> supplys = new HashMap<>();
 
    public Supply addStudent(Supply supply) {
        Long id = supplys.size();
        Supply.setId(id);
        supply.put(id, Supply);
        return supply;
    }
 
    public Supply getStudent(Long id) {
        return supplys.get(id);
    }
 
    public Set<Supply> getAllStudents() {
        return new HashSet<>(supplys.values());
    }
 
    public Supply updateStudent(Supply student) {
        int id = student.getId();
        if (supplys.containsKey(id)) {
            supplys.put(id, student);
            return student;
        }
        return null;
    }
 
    public boolean deleteStudent(int id) {
        return supplys.remove(id) != null;
    } */
    
}
