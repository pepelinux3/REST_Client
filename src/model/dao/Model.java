/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.vo.InventoryVo;
import model.vo.ItemVo;

/**
 *
 * @author Martin3
 */
public class Model {
    
    private InventoryDao inventDao;
    private ItemDao itemDao;
    
    public Model(){
        inventDao = new InventoryDao();
        itemDao = new ItemDao();
    }
    
    public List<InventoryVo> getListInv(int id){
        return inventDao.getMovInventory(id);
    }
    
    public ItemVo getNewItem(int id){
        return itemDao.getNewItem(id);
    }
}
