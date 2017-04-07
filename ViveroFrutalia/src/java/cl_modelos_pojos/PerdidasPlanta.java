package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerdidasPlanta generated by hbm2java
 */
@Entity
@Table(name="perdidas_planta"
    ,schema="public"
)
public class PerdidasPlanta  implements java.io.Serializable {


     private int id;
     private EtapasPlanta etapasPlanta;
     private MotivosPerdidasPlanta motivosPerdidasPlanta;
     private int cantidad;
     private Date fecha;

    public PerdidasPlanta() {
    }

	
    public PerdidasPlanta(int id, EtapasPlanta etapasPlanta, int cantidad) {
        this.id = id;
        this.etapasPlanta = etapasPlanta;
        this.cantidad = cantidad;
    }
    public PerdidasPlanta(int id, EtapasPlanta etapasPlanta, MotivosPerdidasPlanta motivosPerdidasPlanta, int cantidad, Date fecha) {
       this.id = id;
       this.etapasPlanta = etapasPlanta;
       this.motivosPerdidasPlanta = motivosPerdidasPlanta;
       this.cantidad = cantidad;
       this.fecha = fecha;
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
    @JoinColumns( { 
        @JoinColumn(name="plantas_id", referencedColumnName="plantas_id", nullable=false), 
        @JoinColumn(name="etapas_id", referencedColumnName="etapas_id", nullable=false) } )
    public EtapasPlanta getEtapasPlanta() {
        return this.etapasPlanta;
    }
    
    public void setEtapasPlanta(EtapasPlanta etapasPlanta) {
        this.etapasPlanta = etapasPlanta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_motivo")
    public MotivosPerdidasPlanta getMotivosPerdidasPlanta() {
        return this.motivosPerdidasPlanta;
    }
    
    public void setMotivosPerdidasPlanta(MotivosPerdidasPlanta motivosPerdidasPlanta) {
        this.motivosPerdidasPlanta = motivosPerdidasPlanta;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", length=13)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


