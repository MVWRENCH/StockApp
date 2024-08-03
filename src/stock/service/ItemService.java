/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.service;

import java.util.List;
import stock.model.TransactionModel;

/**
 *
 * @author reynn
 */
public interface ItemService {
        
    public void insert(TransactionModel request);
    
    public Double getPrice(int id);
    
    public List<Object[]> report(String name);
}
