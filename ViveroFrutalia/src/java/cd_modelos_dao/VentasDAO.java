/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Clientes;
import cl_modelos_pojos.Empleados;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.EtapasPlantaId;
import cl_modelos_pojos.ModificacionesPlantaVenta;
import cl_modelos_pojos.ModificacionesVentasPlanta;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.VentasPlanta;
import cl_modelos_pojos.PlantasVenta;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.HibernateException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Pochechito
 */
public class VentasDAO {

    public VentasDAO() {

    }

    public String obtenerDentroParentesis(String cadena) {
        Pattern p = Pattern.compile("([0|1|2|3|4|5|6|7|8|9]+)");
        Matcher m = p.matcher(cadena);
        if (m.find()) {
            return m.group(0);
        }
        return "";
    }

    public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from VentasPlanta ");
        List<PlantasVenta> listado = q.list();
        return Integer.parseInt(listado.get(0) + "");
    }

    public void eliminarVenta(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        Session s = sf.openSession();
        t = s.beginTransaction();
        Query q = s.createQuery("delete from VentasPlanta where id = :id");
        q.setInteger("id", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }

    public VentasPlanta crearVenta(String data, boolean id) {
        VentasPlanta venta = new VentasPlanta();
        try {
            JSONObject objeto = new JSONObject(data);
            if (!id) {

                venta.setId(maxId() + 1);
            } else {
                venta.setId(Integer.parseInt(objeto.getString("id")));
            }
            venta.setPlantasVentas(new HashSet<>());

            Clientes cliente = new Clientes();
            cliente.setCedula(Integer.parseInt(obtenerDentroParentesis(objeto.getString("cliente"))));

            Empleados empleado = new Empleados();
            empleado.setCedula(Integer.parseInt(obtenerDentroParentesis(objeto.getString("empleado"))));

            venta.setClientes(cliente);
            venta.setEmpleados(empleado);

            venta.setNroFactura(Integer.parseInt(objeto.getString("factura")));
            venta.setFecha(new Date(objeto.getString("fecha")));

        } catch (JSONException ex) {
            System.out.println(ex);
        }
        return venta;
    }

    public void crearArrayJSON(VentasPlanta venta, String filtro, String data, boolean t) {
        try {
            JSONObject objeto = new JSONObject(data);
            JSONArray array = objeto.getJSONArray(filtro);
            for (int i = 0; i < array.length(); i++) {

                EtapasPlanta ep = new EtapasPlanta();
                Plantas p = new Plantas();
                p.setId(
                        Integer.parseInt(
                                obtenerDentroParentesis(
                                        array.getJSONObject(i).getString("planta")
                                )
                        )
                );
                Etapas e = new Etapas();
                e.setId(
                        Integer.parseInt(
                                obtenerDentroParentesis(
                                        array.getJSONObject(i).getString("etapa")
                                )
                        )
                );
                ep.setEtapas(e);
                ep.setPlantas(p);
                ep.setId(new EtapasPlantaId(p.getId(), e.getId()));
                PlantasVenta pv = new PlantasVenta();
                if (t) {
                    pv.setId(array.getJSONObject(i).getInt("id"));
                } else {
                    pv.setId(-1);

                }
                pv.setCantidad(array.getJSONObject(i).getInt("cantidad"));
                pv.setDescuento(array.getJSONObject(i).getInt("descuento"));
                pv.setEtapasPlanta(ep);
                pv.setVentasPlanta(venta);
                venta.getPlantasVentas().add(pv);
            }
        } catch (NumberFormatException | JSONException e) {
            System.out.println("Exception");
            System.out.println(e);
        }
    }

    public void ingresarVenta(String data) {

        VentasPlanta venta = crearVenta(data, false);
        crearArrayJSON(venta, "lineas", data, false);

        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(venta);
            t.commit();
            s.close();
            for (PlantasVenta plantasVenta : venta.getPlantasVentas()) {
                plantasVenta.setVentasPlanta(venta);
                try {
                    EtapasPlantaDAO eD = new EtapasPlantaDAO();
                    eD.actualizarEtapasPlanta(plantasVenta.getEtapasPlanta());
                } catch (Exception e) {
                    System.out.println("1");
                    System.out.println(e);
                }
                try {
                    PlantasVentaDAO pvd = new PlantasVentaDAO();
                    plantasVenta.setId(pvd.maxId() + 1);
                    pvd.ingresarPlantasVenta(plantasVenta);
                } catch (Exception e) {
                    System.out.println("2");
                    System.out.println(e);
                }
            }

        } catch (HibernateException e) {
            t.rollback();
            throw new RuntimeException("No se pudo guardar el servicio");
        }
    }

    public VentasPlanta consultarVentaPorId(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        VentasPlanta ser = (VentasPlanta) s.get(VentasPlanta.class, id);
        List<PlantasVenta> listado = new LinkedList<>();
        Query q = s.createQuery("from PlantasVenta where id_ventas_planta = " + id);
        try {
            listado = q.list();

        } catch (Exception e) {
            System.out.println("____________________________________________________");
            System.out.println(e);
            System.out.println("____________________________________________________");
        }
        for (int i = 0; i < listado.size(); i++) {
            Plantas p = (Plantas) s.get(Plantas.class, listado.get(i).getEtapasPlanta().getPlantas().getId());
            Etapas p1 = (Etapas) s.get(Etapas.class, listado.get(i).getEtapasPlanta().getEtapas().getId());
            listado.get(i).setEtapasPlanta(new EtapasPlanta());
            listado.get(i).getEtapasPlanta().setPlantas(p);
            listado.get(i).getEtapasPlanta().setEtapas(p1);
        }

        Set<PlantasVenta> listado2 = new HashSet<>(listado);
        ser.setPlantasVentas(listado2);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void actualizarVenta(VentasPlanta v1, VentasPlanta v2) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
//Listas
        List<PlantasVenta> a1 = new LinkedList<>(v1.getPlantasVentas());
        List<PlantasVenta> a2 = new LinkedList<>(v2.getPlantasVentas());
        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(v2);

            System.out.println("la cantidad de lineas de enta es");
            System.out.println(v2.getPlantasVentas().size());
            for (PlantasVenta plantasVenta : v2.getPlantasVentas()) {
                try {
                    EtapasPlantaDAO eD = new EtapasPlantaDAO();
                    eD.ingresarActualizarEtapasPlanta(plantasVenta.getEtapasPlanta());
                } catch (Exception e) {
                    System.out.println("1");
                    System.out.println(e);
                }
                try {
                    PlantasVentaDAO pvd = new PlantasVentaDAO();
                    if (plantasVenta.getId() < 0) {

                        plantasVenta.setId(pvd.maxId() + 1);
                    }
                    pvd.ingresarPlantasVenta(plantasVenta);
                } catch (Exception e) {
                    System.out.println("2");
                    System.out.println(e);
                }
            }

            insertarDiferenciasVentasPlanta(calcularDiferenciasVentasPlanta(v1, v2));
            insertarDiferenciasPlantasVenta(calcularDiferenciasPlantasVenta(a1, a2));
            t.commit();
            s.close();
        } catch (HibernateException he) {
            System.out.println("Paso algo 1");

            System.out.println(he);
            he.getMessage();
        }
    }

    public List<ModificacionesVentasPlanta> calcularDiferenciasVentasPlanta(VentasPlanta v1, VentasPlanta v2) {
        List<ModificacionesVentasPlanta> modificaciones = new LinkedList<>();
        int x = new ModificacionesVentasPlantaDAO().maxId() + 1;
        if (v1.getClientes().getCedula() != v2.getClientes().getCedula()) {
            modificaciones.add(new ModificacionesVentasPlanta(x, v1.getId(), "clientes_cedula", v1.getClientes().getCedula() + "", Date.from(Instant.now())));
            x++;
        }
        if (v1.getEmpleados().getCedula() != v2.getEmpleados().getCedula()) {
            modificaciones.add(new ModificacionesVentasPlanta(x, v1.getId(), "cedula_empleado", v1.getEmpleados().getCedula() + "", Date.from(Instant.now())));
            x++;
        }
        if (v1.getNroFactura() != v2.getNroFactura()) {
            modificaciones.add(new ModificacionesVentasPlanta(x, v1.getId(), "nro_factura", v1.getNroFactura() + "", Date.from(Instant.now())));
            x++;
        }
        if (v1.getFecha().compareTo(v2.getFecha()) != 0) {
            String fecha = v1.getFecha().getDate() + "/" + v1.getFecha().getMonth() + "/" + v1.getFecha().getDay();
            modificaciones.add(new ModificacionesVentasPlanta(x, v1.getId(), "fecha", fecha, Date.from(Instant.now())));
            x++;
        }
        return modificaciones;
    }

    public PlantasVenta encontrarPlantaVentaPorId(List<PlantasVenta> p1, int id) {
        for (PlantasVenta plantasVenta : p1) {
            if (plantasVenta.getId() == id) {
                return plantasVenta;
            }
        }
        return null;
    }

    public List<ModificacionesPlantaVenta> calcularDiferenciasPlantasVenta(List<PlantasVenta> p1, List<PlantasVenta> p2) {
        List<ModificacionesPlantaVenta> modificaciones = new LinkedList<>();
        int x = new ModificacionesPlantasVentaDAO().maxId() + 1;
        List<Integer> indices = new LinkedList<>();
        for (int i = 0; i < p2.size(); i++) {
            PlantasVenta aux = encontrarPlantaVentaPorId(p1, p2.get(i).getId());
            if (aux != null) {

                if (aux.getVentasPlanta().getId() != p2.get(i).getVentasPlanta().getId()) {
                    modificaciones.add(new ModificacionesPlantaVenta(x, aux.getId(), "id_ventasPlanta", aux.getVentasPlanta().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getEtapasPlanta().getPlantas().getId() != p2.get(i).getEtapasPlanta().getPlantas().getId()) {
                    modificaciones.add(new ModificacionesPlantaVenta(x, aux.getId(), "plantas_id", aux.getEtapasPlanta().getPlantas().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getEtapasPlanta().getEtapas().getId() != p2.get(i).getEtapasPlanta().getEtapas().getId()) {
                    modificaciones.add(new ModificacionesPlantaVenta(x, aux.getId(), "etapas_id", aux.getEtapasPlanta().getEtapas().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getCantidad() != p2.get(i).getCantidad()) {
                    modificaciones.add(new ModificacionesPlantaVenta(x, aux.getId(), "cantidad", aux.getCantidad() + "", Date.from(Instant.now())));
                    x++;
                }
                if (!aux.getDescuento().equals(p2.get(i).getDescuento())) {
                    modificaciones.add(new ModificacionesPlantaVenta(x, aux.getId(), "descuento", aux.getDescuento() + "", Date.from(Instant.now())));
                    x++;
                }
            } else {
                modificaciones.add(new ModificacionesPlantaVenta(x, p2.get(i).getId(), "No existia la linea de venta", "", Date.from(Instant.now())));
                x++;
            }
        }

        for (int i = 0; i < p1.size(); i++) {
            PlantasVenta aux = encontrarPlantaVentaPorId(p2, p1.get(i).getId());
            if (aux == null) {

                modificaciones.add(new ModificacionesPlantaVenta(x, p1.get(i).getId(), "id_ventasPlanta", p1.get(i).getVentasPlanta().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantaVenta(x, p1.get(i).getId(), "plantas_id", p1.get(i).getEtapasPlanta().getPlantas().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantaVenta(x, p1.get(i).getId(), "etapas_id", p1.get(i).getEtapasPlanta().getEtapas().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantaVenta(x, p1.get(i).getId(), "cantidad", p1.get(i).getCantidad() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantaVenta(x, p1.get(i).getId(), "descuento", p1.get(i).getDescuento() + "", Date.from(Instant.now())));
                x++;
            }
        }
        return modificaciones;
    }

    public void insertarDiferenciasVentasPlanta(List<ModificacionesVentasPlanta> lista) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            for (ModificacionesVentasPlanta elemento : lista) {
                s.save(elemento);
            }
            t.commit();
            s.close();
        } catch (HibernateException e) {
            t.rollback();
            System.out.print("No se pudo guardar la venta planta");
            System.out.println(e);

        }

    }

    public void insertarDiferenciasPlantasVenta(List<ModificacionesPlantaVenta> lista) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            for (ModificacionesPlantaVenta elemento : lista) {
                s.save(elemento);
            }
            t.commit();
            s.close();
        } catch (HibernateException e) {
            t.rollback();
            System.out.println("No se pudo guardar la plnanta venta");
            System.out.println(e);
        }

    }

    public List<VentasPlanta> obtenerVentas() {
        List<VentasPlanta> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from VentasPlanta");
        lista = q.list();
        s.close();

        return lista;
    }

    public void actualizarVenta(String data) {

        VentasPlanta v2 = crearVenta(data, true);
        crearArrayJSON(v2, "lineas", data, false);
        crearArrayJSON(v2, "lineasExistentes", data, true);
        VentasPlanta v1 = consultarVentaPorId(v2.getId());
        actualizarVenta(v1, v2);

    }
}
