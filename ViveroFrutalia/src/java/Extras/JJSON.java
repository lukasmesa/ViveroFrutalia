package Extras;

import cl_modelos_pojos.Clientes;
import cl_modelos_pojos.ComprasPlanta;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.PlantasCompra;
import cl_modelos_pojos.PlantasVenta;
import cl_modelos_pojos.VentasPlanta;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pochechito
 */
public class JJSON {

    public JJSON() {
    }

    public String convertirListadoClientes(List<Clientes> c) {
        String mensaje = "";
        for (Clientes clientes : c) {
            mensaje += "[" + clientes.getCedula() + "," + clientes.getNombre() + "," + clientes.getApellido() + "," + clientes.getTelefono() + "," + clientes.getCorreo() + "]";
        }
        return mensaje;
    }

    public String convertirListadoPlantas(List<Plantas> c) {
        String mensaje = "[";
        for (Plantas planta : c) {
            mensaje += "[" + planta.getId() + ",\"" + planta.getNombre() + "\",\"" + planta.getDescripcion() + "\"," + planta.getTipoPlanta().getId() + ",\"" + planta.getImagen() + "\"],";
        }

        mensaje =  mensaje.substring(0, mensaje.length() - 1)+"]";
        return mensaje;
    }

    public String convertirListadoEtapas(List<Etapas> c) {
        String mensaje = "[";
        for (Etapas etapa : c) {
            mensaje += "[" + etapa.getId() + ",\"" + etapa.getNombre() + "\",\"" + etapa.getDescripcion() + "\"],";
        }
        return mensaje.substring(0, mensaje.length() - 1) + "]";
    }
    
    public String mapaPlantas(List<Plantas> c) {
        String mensaje = "[";
        for (Plantas planta : c) {
            mensaje += "{\"id\":\"" + String.valueOf(planta.getId()) + "\",\"nombre\":\"" + planta.getNombre() + "\",\"descripcion\":\"" + planta.getDescripcion() + "\",\"tipo\":\"" + String.valueOf(planta.getTipoPlanta().getId()) + "\",\"imagen\":\"" + planta.getImagen() + "\"},";
        }

        mensaje = mensaje.substring(0, mensaje.length() - 1) + "]";
        return mensaje;
    }
    
    public String mapaIngresosPlanta(VentasPlanta ventas) {
        System.out.println(ventas.getPlantasVentas().size());
        if (ventas.getPlantasVentas().size() > 0) {
            for (PlantasVenta plantaVentas : ventas.getPlantasVentas()) {
                if (plantaVentas.getEtapasPlanta().getPrecioVenta() > 0) {
                    String mensaje = "[";
                    int ingresos = 0;
                    for (PlantasVenta venta : ventas.getPlantasVentas()) {
                        ingresos = ingresos + (venta.getEtapasPlanta().getPrecioVenta() * venta.getCantidad());
                        mensaje += "{\"id\":\"" + String.valueOf(venta.getId()) + "\",\"nombre\":\"" + venta.getEtapasPlanta().getPlantas().getNombre() + "\",\"ingresos\":\"" + ingresos + "\",\"fecha\":\"" + venta.getVentasPlanta().getFecha().toString() + "\"},";
                    }
                    mensaje = mensaje.substring(0, mensaje.length() - 1) + "]";
                    return mensaje;
                } else {
                    return ventas.toString();
                }
            }
        }
        return ventas == null ? "nulo" : ventas.toString();
    }

    public String mapaEgresosPlanta(ComprasPlanta compras) {
        System.out.println(compras.getPlantasCompras().size());
        if (compras.getPlantasCompras().size() > 0) {
            for (PlantasCompra plantaCompras : compras.getPlantasCompras()) {
                if (plantaCompras.getEtapasPlanta().getPrecioCompra() != null) {
                    String mensaje = "[";
                    int egresos = 0;
                    for (PlantasCompra compra : compras.getPlantasCompras()) {
                        egresos = egresos + (compra.getEtapasPlanta().getPrecioCompra() * compra.getCantidad());
                        mensaje += "{\"id\":\"" + String.valueOf(compra.getId()) + "\",\"nombre\":\"" + compra.getEtapasPlanta().getPlantas().getNombre() + "\",\"egresos\":\"" + egresos + "\",\"fecha\":\"" + compra.getComprasPlanta().getFecha().toString() + "\"},";
                    }
                    mensaje = mensaje.substring(0, mensaje.length() - 1) + "]";
                    return mensaje;
                } else {
                    return compras.toString();
                }
            }
        }
        return compras == null ? "nulo" : compras.toString();
    }

    public String jsonPlanta(Plantas planta) {

        String mensaje = "[";
        mensaje += "{\"id\":\"" + String.valueOf(planta.getId()) + "\",\"nombre\":\"" + planta.getNombre() + "\",\"descripcion\":\"" + planta.getDescripcion() + "\",\"tipo\":\"" + String.valueOf(planta.getTipoPlanta().getId()) + "\",\"imagen\":\"" + planta.getImagen() + "\"},";
        return mensaje;
    }
    
}
