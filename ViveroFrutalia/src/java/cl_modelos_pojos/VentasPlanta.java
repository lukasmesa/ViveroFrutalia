package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


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
@Table(name="ventas_planta"
    ,schema="public"
)
public class VentasPlanta  implements java.io.Serializable {


     private int id;
     private Clientes clientes;
     private Empleados empleados;
     private int nroFactura;
     private Date fecha;
     private Set<PlantaVentas> plantaVentases = new HashSet<PlantaVentas>(0);

    public VentasPlanta() {
    }

	
    public VentasPlanta(int id, Clientes clientes, Empleados empleados, int nroFactura, Date fecha) {
        this.id = id;
        this.clientes = clientes;
        this.empleados = empleados;
        this.nroFactura = nroFactura;
        this.fecha = fecha;
    }
    public VentasPlanta(int id, Clientes clientes, Empleados empleados, int nroFactura, Date fecha, Set<PlantaVentas> plantaVentases) {
       this.id = id;
       this.clientes = clientes;
       this.empleados = empleados;
       this.nroFactura = nroFactura;
       this.fecha = fecha;
       this.plantaVentases = plantaVentases;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clientes_cedula", nullable=false)
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cedula_empleado", nullable=false)
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    
    @Column(name="nro_factura", nullable=false)
    public int getNroFactura() {
        return this.nroFactura;
    }
    
    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=13)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ventasPlanta")
    public Set<PlantaVentas> getPlantaVentases() {
        return this.plantaVentases;
    }
    
    public void setPlantaVentases(Set<PlantaVentas> plantaVentases) {
        this.plantaVentases = plantaVentases;
    }




}

