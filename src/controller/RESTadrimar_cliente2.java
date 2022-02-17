/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.Model;
import database.ConnectDB;
import view.Vista;

/**
 *
 * @author Martin3
 */
public class RESTadrimar_cliente2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        ConnectDB con = new ConnectDB();       
        
        if(con.getConnection() != null){ 
            Controller myController;
            Model myModel;
            Vista myView; 
            
            myController = new Controller();
            myModel = new Model();            
            myView = new Vista();
            
            myController.setModel(myModel);
            myController.setView(myView);          
						
            myController.startController();
        }
    }   
}
