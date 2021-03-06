package cl_modelos_pojos;
// Generated 21/04/2017 04:49:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VentasPlanta generated by hbm2java
 */
@Entity
@Table(name = "ventas_planta",
         schema = "public"
)
public class VentasPlanta implements java.io.Serializable {

    private int id;
    private Clientes clientes;
    private Empleados empleados;
    private int nroFactura;
    private Date fecha;
    private Set<PlantasVenta> plantasVentas = new HashSet<PlantasVenta>(0);

    public VentasPlanta() {
    }

    public VentasPlanta(int id, Clientes clientes, Empleados empleados, int nroFactura, Date fecha) {
        this.id = id;
        this.clientes = clientes;
        this.empleados = empleados;
        this.nroFactura = nroFactura;
        this.fecha = fecha;
    }

    public VentasPlanta(int id, Clientes clientes, Empleados empleados, int nroFactura, Date fecha, Set<PlantasVenta> plantasVentas) {
        this.id = id;
        this.clientes = clientes;
        this.empleados = empleados;
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.plantasVentas = plantasVentas;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_cedula", nullable = false)
    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula_empleado", nullable = false)
    public Empleados getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Column(name = "nro_factura", nullable = false)
    public int getNroFactura() {
        return this.nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false, length = 13)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ventasPlanta")
    public Set<PlantasVenta> getPlantasVentas() {
        return this.plantasVentas;
    }

    public void setPlantasVentas(Set<PlantasVenta> plantasVentas) {
        this.plantasVentas = plantasVentas;
    }

    @Override
    public String toString() {
        if (getPlantasVentas().size() > 0) {
            for (PlantasVenta ventas : getPlantasVentas()) {
                if (ventas.getEtapasPlanta().getPlantas() != null) {
                    return "Id: '" + getId() + "', nFactura: '" + getNroFactura() + "', fecha: '" + getFecha().toString() + "', setPlantaVentas: '" + getPlantasVentas().size() + "', ventaPlantaNombre: '" + ventas.getEtapasPlanta().getPlantas().getImagen() + "', ventasToString: '" + ventas.getEtapasPlanta().getPlantas().toString() + "'";
                } else {
                    return "getPlantas es nulo";
                }
            }
        }
        for (PlantasVenta ventas : getPlantasVentas()) {
            return "Id: '" + getId() + "', nFactura: '" + getNroFactura() + "', fecha: '" + getFecha().toString() + "', getEtapas: '" + ventas.getEtapasPlanta().getPlantas() + "'";
        }
        return "ventaEtapas es nulo";
    }

    /*@Override
    public String toString() {
        if (getPlantasVentas().size() > 0) {
            for (PlantasVenta ventas : plantasVentas) {
                if (ventas.getEtapasPlanta().getPrecioCompra() != null) {
                    return "Id: '" + getId() + "', nFactura: '" + getNroFactura() + "', fecha: '" + getFecha().toString() + "', setPlantaVentas: '" + getPlantasVentas().size() + "', ventaEtapaPlantaPrecio: '" + ventas.getEtapasPlanta().getPrecioCompra() +"', ventasToString: '" + ventas.toString() +"'";
                } else{
                    return "getEtapasPlanta es nulo";
                }
            }
        }
        return "Id: '" + getId() + "', nFactura: '" + getNroFactura() + "', fecha: '" + getFecha().toString() + "', setPlantaVentas: '" + getPlantasVentas().size() +"'";
    }*/
}
