package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ModificacionesSuministrosCompra generated by hbm2java
 */
@Entity
@Table(name="modificaciones_suministros_compra"
    ,schema="public"
)
public class ModificacionesSuministrosCompra  implements java.io.Serializable {


     private int id;
     private Integer idSuministrosCompra;
     private String campoModificado;
     private String valorCampoModificado;
     private Date fechaModificacion;

    public ModificacionesSuministrosCompra() {
    }

	
    public ModificacionesSuministrosCompra(int id, String campoModificado, Date fechaModificacion) {
        this.id = id;
        this.campoModificado = campoModificado;
        this.fechaModificacion = fechaModificacion;
    }
    public ModificacionesSuministrosCompra(int id, Integer idSuministrosCompra, String campoModificado, String valorCampoModificado, Date fechaModificacion) {
       this.id = id;
       this.idSuministrosCompra = idSuministrosCompra;
       this.campoModificado = campoModificado;
       this.valorCampoModificado = valorCampoModificado;
       this.fechaModificacion = fechaModificacion;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="id_suministrosCompra")
    public Integer getIdSuministrosCompra() {
        return this.idSuministrosCompra;
    }
    
    public void setIdSuministrosCompra(Integer idSuministrosCompra) {
        this.idSuministrosCompra = idSuministrosCompra;
    }

    
    @Column(name="campo_modificado", nullable=false)
    public String getCampoModificado() {
        return this.campoModificado;
    }
    
    public void setCampoModificado(String campoModificado) {
        this.campoModificado = campoModificado;
    }

    
    @Column(name="valor_campo_modificado")
    public String getValorCampoModificado() {
        return this.valorCampoModificado;
    }
    
    public void setValorCampoModificado(String valorCampoModificado) {
        this.valorCampoModificado = valorCampoModificado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_modificacion", nullable=false, length=13)
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }




}


