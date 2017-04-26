/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author Jaiver Castrillón
 */
public class Compra {
    
    private int id;
    private int nroFactura;
    private String detalle;
    private Date fecha;
    private int cedProveedor;

    public Compra() {
    }

    public Compra(int id, int nroFactura, String detalle, Date fecha, int cedProveedor) {
        this.id = id;
        this.nroFactura = nroFactura;
        this.detalle = detalle;
        this.fecha = fecha;
        this.cedProveedor = cedProveedor;
    }

    public int getCedProveedor() {
        return cedProveedor;
    }

    public void setCedProveedor(int cedProveedor) {
        this.cedProveedor = cedProveedor;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
