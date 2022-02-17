/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Controller;
import database.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.DefaultCaret;
import model.dao.InventoryDao;
import model.dao.Model;
import model.vo.InventoryList;
import model.vo.InventoryVo;
import model.vo.ItemList;
import model.vo.ItemVo;
import model.ws.WSInventory;
import view.Vista;

/**
 *
 * @author Martin3
 */
public class ControllerThread extends TimerTask {
    private Model th_model;
    private Vista th_view;
	
    int cont;
    
    @Override
    public void run() { 
        boolean itemNew = false;
        WSInventory wsinv = new WSInventory();
        
        int idsec_invFin = wsinv.getSecInventory();
        int idsec_iteFin = wsinv.getSecItem();

        List <InventoryVo> queryList = new ArrayList<InventoryVo>();
        queryList = th_model.getListInv(idsec_invFin);
      
        List <ItemVo> listNewItem = new ArrayList<ItemVo>();
        
        for(InventoryVo ob : queryList){     
            if(ob.getIdClave() > idsec_iteFin){
                int idItem = ob.getIdArticulo();
                listNewItem.add(th_model.getNewItem(idItem));
                itemNew = true;
            }
        }   
        
        if(itemNew = true){
            ItemList itemList = new ItemList();
            itemList.setListInv(listNewItem);
            
            wsinv.getRespListItem(itemList);
        }
        
        InventoryList invList = new InventoryList();
        invList.setListInv(queryList);

        getListStr(wsinv.getRespListInv(invList));           
    }

    public void setView(Vista th_view) {
        this.th_view = th_view;
    }
	
    public void setModel(Model th_model) {
        this.th_model = th_model;
    }
		    
    private void getListStr (List<InventoryVo> list_inv){        
        Date fechaHoy = new Date();
        Date horaHoy = new Date();
        
        SimpleDateFormat formatfecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formathora = new SimpleDateFormat("HH:mm:ss");
        			
	th_view.textArea.append(" No.: "+cont+"         Fecha.: "+formatfecha.format(fechaHoy)+"         Hora.: "+formathora.format(horaHoy)+"\n");
	th_view.textArea.append(" -------------------------------------------------------------------------------------------- "+"\n");	
		
        for(InventoryVo ob : list_inv){                           
            System.out.println("Clave.: "+ob.getIdClave()+",   Art.: "+ob.getIdArticulo()+",   Suc.: "+ob.getIdSurcursal()+",   Exi.: "+ob.getExistencia());                       
				
            String idClave = " Clave.: "+ob.getIdClave();			
            String idArt = "\f\tArt.: "+ob.getIdArticulo();				
            String idSuc = "\f\t     Suc.: "+ob.getIdSurcursal();			
            String exis = "\f\t   Exi.: "+ob.getExistencia();  
              
            String strListInv = idClave+idArt+idSuc+exis;
					
            th_view.textArea.append(strListInv);
            th_view.textArea.append(System.getProperty("line.separator"));
							
            th_view.scrollBar.setValue(th_view.scrollBar.getMaximum() );
        }
			
	th_view.textArea.append("\n");		
        cont++;
    }
}

