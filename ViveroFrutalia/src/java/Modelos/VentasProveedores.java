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
public class VentasProveedores {
    
    private List<Venta> ventas;
    private List<Proveedores> proveedores;

    public VentasProveedores(List<Venta> ventas, List<Proveedores> proveedores) {
        this.ventas = ventas;
        this.proveedores = proveedores;
    }

    public VentasProveedores() {
    }

    /**
     * @return the ventas
     */
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the proveedores
     */
    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

    
    
    
}
