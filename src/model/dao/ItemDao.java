/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import database.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.vo.InventoryVo;
import model.vo.ItemVo;

/**
 *
 * @author pepe
 */
public class ItemDao {

    public ItemVo getNewItem(int idItem) {                  
        ConnectDB cnx_query = new ConnectDB();
        ItemVo itemvo = null;
        
        String sql = " SELECT art_clave, art_clavearticulo, art_nombreCorto, "+
                     "        art_nombreLargo, art_emp_clave, art_subg_clave"+
                     "   FROM articulos WHERE art_clave = "+idItem;      
        
        if(cnx_query.getConnection() != null){ 
           
            try{
                Statement st = cnx_query.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    itemvo = new ItemVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                }

                st.close();
                cnx_query.getConnection().close();               
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + ex.getMessage());
            } 
        }
        return itemvo;
    }
}
