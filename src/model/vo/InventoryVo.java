/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author pepe
 */
public class InventoryVo {
    
    private int idClave;
    private int idArticulo;
    private int idSurcursal;
    private int existencia;
    private int idUltimo;

    public InventoryVo() {
       
    }
    
    public InventoryVo(int idClave, int idArticulo, int idsurcursal, int existencia, int idultimo) {
        this.idClave = idClave;
        this.idArticulo = idArticulo;
        this.idSurcursal = idsurcursal;
        this.existencia = existencia;
        this.idUltimo = idultimo;
    }

    public int getIdClave() {
        return idClave;
    }
    public void setIdClave(int idClave) {
        this.idClave = idClave;
    }
    
    public int getIdArticulo() {
        return idArticulo;
    }
    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdSurcursal() {
        return idSurcursal;
    }
    public void setIdSurcursal(int idSurcursal) {
        this.idSurcursal = idSurcursal;
    }

    public int getExistencia() {
        return existencia;
    }
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getIdUltimo() {
        return idUltimo;
    }
    public void setIdUltimo(int idUltimo) {
        this.idUltimo = idUltimo;
    }
    
    
}
