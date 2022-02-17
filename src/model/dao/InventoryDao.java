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

/**
 *
 * @author Martin3
 */
public class InventoryDao {
    
    public List<InventoryVo> getMovInventory(int ini) {                  
        ConnectDB cnx_query = new ConnectDB();
      
        String sql = " SELECT minvd_clave, minve_clave, minvd_art_clave, "+
                     "        minve_alm_claveorigen, minvd_edm"+
                     "   FROM movimientoinventariodetalle, articulos, "+
                     "        movimientoinventarioencabezado "+
                     "  WHERE minvd_minve_clave = minve_clave "+
                     "    and minvd_art_clave = art_clave and art_status = 1"+
                     "    and art_listavisible = 1 and minvd_clave > "+ini; 
        
        List<InventoryVo> lista = new ArrayList<>();
        
        if(cnx_query.getConnection() != null){ 

            try{
                Statement st = cnx_query.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    lista.add(new InventoryVo(rs.getInt(1), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(1)));                   
                }

                st.close();
                cnx_query.getConnection().close();               
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + ex.getMessage());
            } 
        }
        return lista;
    }
    
}
