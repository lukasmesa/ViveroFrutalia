package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proveedores generated by hbm2java
 */
@Entity
@Table(name="proveedores"
    ,schema="public"
)
public class Proveedores  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private String apellido;
     private String telefono;
     private String correo;
     private Set<ComprasPlanta> comprasPlantas = new HashSet<ComprasPlanta>(0);
     private Set<CompraSuministros> compraSuministroses = new HashSet<CompraSuministros>(0);
     private Set<PlantasProveedores> plantasProveedoreses = new HashSet<PlantasProveedores>(0);

    public Proveedores() {
    }

	
    public Proveedores(int cedula, String nombre, String apellido, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Proveedores(int cedula, String nombre, String apellido, String telefono, String correo, Set<ComprasPlanta> comprasPlantas, Set<CompraSuministros> compraSuministroses, Set<PlantasProveedores> plantasProveedoreses) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellido = apellido;
       this.telefono = telefono;
       this.correo = correo;
       this.comprasPlantas = comprasPlantas;
       this.compraSuministroses = compraSuministroses;
       this.plantasProveedoreses = plantasProveedoreses;
    }
   
     @Id 

    
    @Column(name="cedula", unique=true, nullable=false)
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="telefono", nullable=false)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="correo", nullable=false)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proveedores")
    public Set<ComprasPlanta> getComprasPlantas() {
        return this.comprasPlantas;
    }
    
    public void setComprasPlantas(Set<ComprasPlanta> comprasPlantas) {
        this.comprasPlantas = comprasPlantas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proveedores")
    public Set<CompraSuministros> getCompraSuministroses() {
        return this.compraSuministroses;
    }
    
    public void setCompraSuministroses(Set<CompraSuministros> compraSuministroses) {
        this.compraSuministroses = compraSuministroses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proveedores")
    public Set<PlantasProveedores> getPlantasProveedoreses() {
        return this.plantasProveedoreses;
    }
    
    public void setPlantasProveedoreses(Set<PlantasProveedores> plantasProveedoreses) {
        this.plantasProveedoreses = plantasProveedoreses;
    }




}


