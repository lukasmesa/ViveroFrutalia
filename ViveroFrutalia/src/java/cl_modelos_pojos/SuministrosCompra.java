package cl_modelos_pojos;
// Generated 7/04/2017 03:07:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SuministrosCompra generated by hbm2java
 */
@Entity
@Table(name="suministros_compra"
    ,schema="public"
)
public class SuministrosCompra  implements java.io.Serializable {


     private int id;
     private CompraSuministros compraSuministros;
     private Suministros suministros;
     private int cantidad;
     private Integer descuento;

    public SuministrosCompra() {
    }

	
    public SuministrosCompra(int id, CompraSuministros compraSuministros, Suministros suministros, int cantidad) {
        this.id = id;
        this.compraSuministros = compraSuministros;
        this.suministros = suministros;
        this.cantidad = cantidad;
    }
    public SuministrosCompra(int id, CompraSuministros compraSuministros, Suministros suministros, int cantidad, Integer descuento) {
       this.id = id;
       this.compraSuministros = compraSuministros;
       this.suministros = suministros;
       this.cantidad = cantidad;
       this.descuento = descuento;
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
    @JoinColumn(name="id_compraSuministros", nullable=false)
    public CompraSuministros getCompraSuministros() {
        return this.compraSuministros;
    }
    
    public void setCompraSuministros(CompraSuministros compraSuministros) {
        this.compraSuministros = compraSuministros;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="suministro_id", nullable=false)
    public Suministros getSuministros() {
        return this.suministros;
    }
    
    public void setSuministros(Suministros suministros) {
        this.suministros = suministros;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="descuento")
    public Integer getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }




}

