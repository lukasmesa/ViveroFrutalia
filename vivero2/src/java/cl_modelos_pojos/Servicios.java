package cl_modelos_pojos;
// Generated 12/03/2017 03:42:57 PM by Hibernate Tools 4.3.1



/**
 * Servicios generated by hbm2java
 */
public class Servicios  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private int costo;

    public Servicios() {
    }

    public Servicios(String nombre, String descripcion, int costo) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.costo = costo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCosto() {
        return this.costo;
    }
    
    public void setCosto(int costo) {
        this.costo = costo;
    }




}


