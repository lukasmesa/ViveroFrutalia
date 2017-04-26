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
public class Venta {
    
    private int id;
    private int nroFactura;
    private String detalle;
    private Date fecha;

    public Venta() {
    }

    public Venta(int id, int nroFactura, String detalle, Date fecha) {
        this.id = id;
        this.nroFactura = nroFactura;
        this.detalle = detalle;
        this.fecha = fecha;
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
