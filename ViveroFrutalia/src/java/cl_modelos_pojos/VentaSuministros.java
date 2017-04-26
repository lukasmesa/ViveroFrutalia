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
 * VentaSuministros generated by hbm2java
 */
@Entity
@Table(name="venta_suministros"
    ,schema="public"
)
public class VentaSuministros  implements java.io.Serializable {


     private int id;
     private Clientes clientes;
     private Empleados empleados;
     private Date fecha;
     private int nroFactura;
     private Set<SuministrosVenta> suministrosVentas = new HashSet<SuministrosVenta>(0);

    public VentaSuministros() {
    }

	
    public VentaSuministros(int id, Clientes clientes, Empleados empleados, Date fecha, int nroFactura) {
        this.id = id;
        this.clientes = clientes;
        this.empleados = empleados;
        this.fecha = fecha;
        this.nroFactura = nroFactura;
    }
    public VentaSuministros(int id, Clientes clientes, Empleados empleados, Date fecha, int nroFactura, Set<SuministrosVenta> suministrosVentas) {
       this.id = id;
       this.clientes = clientes;
       this.empleados = empleados;
       this.fecha = fecha;
       this.nroFactura = nroFactura;
       this.suministrosVentas = suministrosVentas;
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
    @JoinColumn(name="cliente_cedula", nullable=false)
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="empleado_cedula", nullable=false)
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=13)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="nro_factura", nullable=false)
    public int getNroFactura() {
        return this.nroFactura;
    }
    
    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ventaSuministros")
    public Set<SuministrosVenta> getSuministrosVentas() {
        return this.suministrosVentas;
    }
    
    public void setSuministrosVentas(Set<SuministrosVenta> suministrosVentas) {
        this.suministrosVentas = suministrosVentas;
    }




}


