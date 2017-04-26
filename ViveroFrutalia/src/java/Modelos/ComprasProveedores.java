/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import cl_modelos_pojos.Proveedores;
import java.util.List;

/**
 *
 * @author Jaiver Castrillón
 */
public class ComprasProveedores {
    
    private List<Compra> compras;
    private List<Proveedores> proveedores;

    public ComprasProveedores(List<Compra> compras, List<Proveedores> proveedores) {
        this.compras = compras;
        this.proveedores = proveedores;
    }

    public ComprasProveedores() {
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }
    
    
    
}
