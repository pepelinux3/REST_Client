/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import javax.ws.rs.core.MediaType;
import model.dao.Model;
import model.vo.InventoryList;
import model.vo.InventoryVo;
import view.Vista;

/**
 *
 * @author Martin3
 */
public class Controller implements ActionListener {

    private Model myModel;
    private Vista view;
    
    public void startController(){
        this.view.bt_start.addActionListener(this);
        this.view.bt_Cancel.addActionListener(this);
       				
	this.view.textArea.setTabSize(6);		
        this.view.setVisible(true);        
    }
    
    public void setModel(Model myModel) {
        this.myModel = myModel;
    } 
    
    public void setView(Vista view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      //  System.out.println("Evento... ");
        
        if(e.getSource() == view.bt_start){
            System.out.println("Evento de start.... ");                  
            
            Timer timer = new Timer();
            ControllerThread task = new ControllerThread();
			
            task.setView(view);
            task.setModel(myModel);
			
            view.bt_start.setEnabled(false);
            timer.schedule(task, 0, 5*60000);  
        }       
        
        if(e.getSource() == view.bt_Cancel){
            System.out.println("Sale Boton.... ");
            System.exit(0);
        }
    }
}
