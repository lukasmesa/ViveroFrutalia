/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import cl_modelos_pojos.Suministros;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Angie
 */
public class Reporte {
    private List<PlantaReporte> plantas = new LinkedList<>();
    private List<Suministros> suministros = new LinkedList<>();

    public Reporte() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void mostrarListaPlantas(){
        for(PlantaReporte a : plantas){
            System.out.println("Nombre:"+a.getNombre()+" Etapa:"+a.getEtapa()+" Precio:"+a.getPrecio());
        }
    }

    /**
     * @return the suministros
     */
    public List<Suministros> getSuministros() {
        return suministros;
    }

    /**
     * @param suministros the suministros to set
     */
    public void setSuministros(List<Suministros> suministros) {
        this.suministros = suministros;
    }

    /**
     * @return the plantas
     */
    public List<PlantaReporte> getPlantas() {
        return plantas;
    }

    /**
     * @param plantas the plantas to set
     */
    public void setPlantas(List<PlantaReporte> plantas) {
        this.plantas = plantas;
    }

  
    
}
