/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ws;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;
import model.vo.InventoryList;
import model.vo.InventoryVo;
import model.vo.ItemList;
import model.vo.ItemVo;

/**
 *
 * @author Martin3
 */
public class WSInventory {
	
    public int getSecInventory(){
        Client cliente = Client.create();
        
        WebResource webresource = cliente.resource("http://ec2-54-235-11-14.compute-1.amazonaws.com:8080/RESTadrimar/webresources/inventory/idinv_final");
        ClientResponse response = webresource.accept("application/json").get(ClientResponse.class);
    
        if(response.getStatus() != 200){
            throw new RuntimeException("error de conexcion... "+response.getStatus());
        }
        
        String output = response.getEntity(String.class);
        int idSec = Integer.parseInt(output);
        
        return idSec;
    }
            
    public int getSecItem(){
        Client cliente = Client.create();
        
        WebResource webresource = cliente.resource("http://ec2-54-235-11-14.compute-1.amazonaws.com:8080/RESTadrimar/webresources/inventory/iditem_final");
        ClientResponse response = webresource.accept("application/json").get(ClientResponse.class);
    
        if(response.getStatus() != 200){
            throw new RuntimeException("error de conexcion... "+response.getStatus());
        }
        
        String output = response.getEntity(String.class);
        int idSec = Integer.parseInt(output);
        
        return idSec;
    }
       
    public List<InventoryVo> getRespListInv(InventoryList listInv){
                     
        Client cli_inv = Client.create();         
        WebResource resour_inv = cli_inv.resource("http://ec2-54-235-11-14.compute-1.amazonaws.com:8080/RESTadrimar/webresources/inventory/updatelist");       
        
        List<InventoryVo> respon_inv = resour_inv.type(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .post(new GenericType<List<InventoryVo>>(){}, listInv);
        
        return respon_inv;
    }
    
    public List<ItemVo> getRespListItem(ItemList listIt){
                     
        Client cli_inv = Client.create();         
        WebResource resour_inv = cli_inv.resource("http://ec2-54-235-11-14.compute-1.amazonaws.com:8080/RESTadrimar/webresources/inventory/newitem");       
        
        List<ItemVo> respon_item = resour_inv.type(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .post(new GenericType<List<ItemVo>>(){}, listIt);
        
        return respon_item;
    }
}
