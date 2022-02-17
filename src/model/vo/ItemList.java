/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.List;

/**
 *
 * @author pepe
 */
public class ItemList {
    
    private List <ItemVo> itemlist;
    
    public List<ItemVo> getListInv(){
        return itemlist;
    }
    
    public void setListInv(List<ItemVo> itemlist){
        this.itemlist = itemlist;
    }
}
