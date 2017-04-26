package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


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

/**
 * Plantas generated by hbm2java
 */
@Entity
@Table(name="plantas"
    ,schema="public"
)
public class Plantas  implements java.io.Serializable {


     private int id;
     private TipoPlanta tipoPlanta;
     private String nombre;
     private String descripcion;
     private String imagen;
     private Set<PlantasProveedores> plantasProveedoreses = new HashSet<PlantasProveedores>(0);
     private Set<EtapasPlanta> etapasPlantas = new HashSet<EtapasPlanta>(0);

    public Plantas() {
    }

	
    public Plantas(int id, TipoPlanta tipoPlanta, String nombre, String descripcion, String imagen) {
        this.id = id;
        this.tipoPlanta = tipoPlanta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    public Plantas(int id, TipoPlanta tipoPlanta, String nombre, String descripcion, String imagen, Set<PlantasProveedores> plantasProveedoreses, Set<EtapasPlanta> etapasPlantas) {
       this.id = id;
       this.tipoPlanta = tipoPlanta;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.imagen = imagen;
       this.plantasProveedoreses = plantasProveedoreses;
       this.etapasPlantas = etapasPlantas;
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
    @JoinColumn(name="tipo", nullable=false)
    public TipoPlanta getTipoPlanta() {
        return this.tipoPlanta;
    }
    
    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="descripcion", nullable=false, length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="imagen", nullable=false)
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="plantas")
    public Set<PlantasProveedores> getPlantasProveedoreses() {
        return this.plantasProveedoreses;
    }
    
    public void setPlantasProveedoreses(Set<PlantasProveedores> plantasProveedoreses) {
        this.plantasProveedoreses = plantasProveedoreses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="plantas")
    public Set<EtapasPlanta> getEtapasPlantas() {
        return this.etapasPlantas;
    }
    
    public void setEtapasPlantas(Set<EtapasPlanta> etapasPlantas) {
        this.etapasPlantas = etapasPlantas;
    }




}


