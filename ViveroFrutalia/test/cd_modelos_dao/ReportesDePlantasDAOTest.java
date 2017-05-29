/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import Modelos.PlantaReporte;
import Modelos.Reporte;
import cl_modelos_pojos.Suministros;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pochechito
 */
public class ReportesDePlantasDAOTest {

    public ReportesDePlantasDAOTest() {
    }


    /**
     * Test of consultarTodos method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("consultarTodos");
        String queryPlantas = "select p.id,p.nombre,p.descripcion, p.tipo, p.imagen, ee.nombre, e.precio_compra, e.precio_venta, ee.descripcion\n"
                + "from plantas p\n"
                + "inner join etapas_planta e\n"
                + "on p.id = 2 and e.plantas_id = p.id\n"
                + "inner join etapas ee\n"
                + "on ee.id = e.etapas_id";

        String querySuministros = "select * from suministros where visibilidad = 1";

        ReportesDePlantasDAO instance = new ReportesDePlantasDAO();

        Reporte expResult = new Reporte();

        PlantaReporte pr = new PlantaReporte();
        pr.setDescripcion("descripcipon de la acacia");
        pr.setEtapa("Germinación");
        pr.setImagen("temp.png");
        pr.setNombre("acacia");
        pr.setPrecio(6000);
        List<PlantaReporte> p = new LinkedList<>();
        p.add(pr);
        expResult.setPlantas(p);

        List<Suministros> s = new LinkedList<>();

        Suministros suministroPrueba = new Suministros();
        suministroPrueba.setId(1);
        suministroPrueba.setDescripcion("matero de barro");
        suministroPrueba.setNombre("matero");
        suministroPrueba.setPrecioCompra(6000);
        suministroPrueba.setPrecioVenta(10000);
        suministroPrueba.setVisibilidad(1);

        s.add(suministroPrueba);
        expResult.setSuministros(s);

        Reporte result = instance.consultarTodos(queryPlantas, querySuministros);

        assertEquals(expResult, result);
    }

    /**
     * Test of consultarPlantas method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarPlantas() {
        System.out.println("consultarPlantas");
        String queryPlantas = "select p.id,p.nombre,p.descripcion, p.tipo, p.imagen, ee.nombre, e.precio_compra, e.precio_venta, ee.descripcion\n"
                + "from plantas p\n"
                + "inner join etapas_planta e\n"
                + "on p.id = 2 and e.plantas_id = p.id\n"
                + "inner join etapas ee\n"
                + "on ee.id = e.etapas_id";
        ReportesDePlantasDAO instance = new ReportesDePlantasDAO();
        Reporte expResult = new Reporte();
        PlantaReporte pr = new PlantaReporte();
        pr.setDescripcion("descripcipon de la acacia");
        pr.setEtapa("Germinación");
        pr.setImagen("temp.png");
        pr.setNombre("acacia");
        pr.setPrecio(6000);
        List<PlantaReporte> p = new LinkedList<>();
        p.add(pr);
        expResult.setPlantas(p);
        Reporte result = instance.consultarPlantas(queryPlantas);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarSuministros method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarSuministros() {
        System.out.println("consultarSuministros");
        String querySuministros = "select * from suministros where visibilidad = 1";
        ReportesDePlantasDAO instance = new ReportesDePlantasDAO();
        Reporte expResult = new Reporte();

        List<Suministros> s = new LinkedList<>();

        Suministros suministroPrueba = new Suministros();
        suministroPrueba.setId(1);
        suministroPrueba.setDescripcion("matero de barro");
        suministroPrueba.setNombre("matero");
        suministroPrueba.setPrecioCompra(6000);
        suministroPrueba.setPrecioVenta(10000);
        suministroPrueba.setVisibilidad(1);

        s.add(suministroPrueba);
        expResult.setSuministros(s);
        Reporte result = instance.consultarSuministros(querySuministros);

    }

    /**
     * Test of consultarPlantasQuery method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarPlantasQuery() {
        System.out.println("consultarPlantasQuery");
        String consulta = "select p.id,p.nombre,p.descripcion, p.tipo, p.imagen, ee.nombre, e.precio_compra, e.precio_venta, ee.descripcion"
                + "from plantas p"
                + "inner join etapas_planta e"
                + "on p.id = 1 and e.plantas_id = p.id"
                + "inner join etapas ee"
                + "on ee.id = e.etapas_id";
        ReportesDePlantasDAO instance = new ReportesDePlantasDAO();
        PlantaReporte pr = new PlantaReporte();
        pr.setDescripcion("descripcipon de la millonaria");
        pr.setEtapa("Germinación");
        pr.setImagen("temp.png");
        pr.setNombre("millonaria");
        pr.setPrecio(5000);
        List<PlantaReporte> expResult = new LinkedList<>();
        expResult.add(pr);
        List<PlantaReporte> result = instance.consultarPlantasQuery(consulta);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarSuministrosQuery method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarSuministrosQuery() {
        System.out.println("consultarSuministrosQuery");
        String consulta = "select * from suministros where visibilidad = 1";
        ReportesDePlantasDAO instance = new ReportesDePlantasDAO();

        List<Suministros> expResult = new LinkedList<>();

        Suministros suministroPrueba = new Suministros();
        suministroPrueba.setId(1);
        suministroPrueba.setDescripcion("matero de barro");
        suministroPrueba.setNombre("matero");
        suministroPrueba.setPrecioCompra(6000);
        suministroPrueba.setPrecioVenta(10000);
        suministroPrueba.setVisibilidad(1);

        expResult.add(suministroPrueba);

        List<Suministros> result = instance.consultarSuministrosQuery(consulta);

        assertEquals(expResult, result);
    }

    /**
     * Test of consultarPrecioPlanta method, of class ReportesDePlantasDAO.
     */
    @Test
    public void testConsultarPrecioPlanta() {
        System.out.println("consultarPrecioPlanta");
        System.out.println("No implementado");
    }

}
