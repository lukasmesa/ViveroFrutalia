/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.EtapasPlantaId;
import cl_modelos_pojos.ModificacionesPlantasCompra;
import cl_modelos_pojos.ModificacionesCompraPlantas;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.ComprasPlanta;
import cl_modelos_pojos.PlantasCompra;
import cl_modelos_pojos.Proveedores;
import controllers.comprasController;
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
public class ComprasDAO {

    public ComprasDAO() {

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
        Query q = s.createQuery("select max(id) from ComprasPlanta ");
        List<PlantasCompra> listado = q.list();
        int res = 0;
        try {
            res = Integer.parseInt(listado.get(0) + "");
        } catch (Exception e) {
        }
        return res;
    }

    public void eliminarCompra(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        Session s = sf.openSession();
        t = s.beginTransaction();
        Query q = s.createQuery("delete from ComprasPlanta where id = :id");
        q.setInteger("id", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }

    public ComprasPlanta crearCompra(String data, boolean id) {
        ComprasPlanta compra = new ComprasPlanta();
        try {
            JSONObject objeto = new JSONObject(data);
            if (!id) {

                compra.setId(maxId() + 1);
            } else {
                compra.setId(Integer.parseInt(objeto.getString("id")));
            }
            compra.setPlantasCompras(new HashSet<>());

            Proveedores proveedor = new Proveedores();
            proveedor.setCedula(Integer.parseInt(obtenerDentroParentesis(objeto.getString("proveedor"))));

            compra.setProveedores(proveedor);

            compra.setNroFactura(Integer.parseInt(objeto.getString("factura")));
            compra.setFecha(new Date(objeto.getString("fecha")));

        } catch (JSONException ex) {
            System.out.println(ex);
        }
        return compra;
    }

    public void crearArrayJSON(ComprasPlanta compra, String filtro, String data, boolean t) {
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
                PlantasCompra pv = new PlantasCompra();
                if (t) {
                    pv.setId(array.getJSONObject(i).getInt("id"));
                } else {
                    pv.setId(-1);

                }
                pv.setCantidad(array.getJSONObject(i).getInt("cantidad"));
                pv.setDescuento(array.getJSONObject(i).getInt("descuento"));
                pv.setEtapasPlanta(ep);
                pv.setComprasPlanta(compra);
                compra.getPlantasCompras().add(pv);
            }
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e);
        }
    }

    public void ingresarCompra(String data) {

        ComprasPlanta compra = crearCompra(data, false);
        crearArrayJSON(compra, "lineas", data, false);

        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(compra);
            t.commit();
            s.close();
            for (PlantasCompra plantasCompra : compra.getPlantasCompras()) {
                plantasCompra.setComprasPlanta(compra);
                try {
                    EtapasPlantaDAO eD = new EtapasPlantaDAO();
                    eD.actualizarEtapasPlanta(plantasCompra.getEtapasPlanta());
                } catch (Exception e) {
                    System.out.println("1");
                    System.out.println(e);
                }
                try {
                    PlantasCompraDAO pvd = new PlantasCompraDAO();
                    plantasCompra.setId(pvd.maxId() + 1);
                    pvd.ingresarPlantasCompra(plantasCompra);
                } catch (Exception e) {
                    System.out.println("2");
                    System.out.println(e);
                }
            }

        } catch (Exception e) {
            t.rollback();
            throw new RuntimeException("No se pudo guardar el servicio");
        }
    }

    public ComprasPlanta consultarCompraPorId(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        ComprasPlanta ser = (ComprasPlanta) s.get(ComprasPlanta.class, id);
        List<PlantasCompra> listado = new LinkedList<>();
        Query q = s.createQuery("from PlantasCompra where id_compras_planta = " + id);
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

        Set<PlantasCompra> listado2 = new HashSet<>(listado);
        ser.setPlantasCompras(listado2);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void actualizarCompra(ComprasPlanta v1, ComprasPlanta v2) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
//Listas
        List<PlantasCompra> a1 = new LinkedList<>(v1.getPlantasCompras());
        List<PlantasCompra> a2 = new LinkedList<>(v2.getPlantasCompras());
        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            s.update(v2);

            for (PlantasCompra plantasCompra : v2.getPlantasCompras()) {
                try {
                    EtapasPlantaDAO eD = new EtapasPlantaDAO();
                    eD.ingresarActualizarEtapasPlanta(plantasCompra.getEtapasPlanta());
                } catch (Exception e) {
                    System.out.println("1");
                    System.out.println(e);
                }
                try {
                    PlantasCompraDAO pvd = new PlantasCompraDAO();
                    if (plantasCompra.getId() < 0) {

                        plantasCompra.setId(pvd.maxId() + 1);
                    }
                    pvd.ingresarPlantasCompra(plantasCompra);
                } catch (Exception e) {
                    System.out.println("2");
                    System.out.println(e);
                }
            }

            insertarDiferenciasComprasPlanta(calcularDiferenciasComprasPlanta(v1, v2));
            insertarDiferenciasPlantasCompra(calcularDiferenciasPlantasCompra(a1, a2));
            t.commit();
            s.close();
        } catch (HibernateException he) {
            System.out.println("Paso algo 1");

            System.out.println(he);
            he.printStackTrace();
        }
    }

    public List<ModificacionesCompraPlantas> calcularDiferenciasComprasPlanta(ComprasPlanta v1, ComprasPlanta v2) {
        List<ModificacionesCompraPlantas> modificaciones = new LinkedList<>();
        int x = new ModificacionesCompraPlantasDAO().maxId() + 1;

        if (v1.getProveedores().getCedula() != v2.getProveedores().getCedula()) {
            modificaciones.add(new ModificacionesCompraPlantas(x, v1.getId(), "proveedores_cedula", v1.getProveedores().getCedula() + "", Date.from(Instant.now())));
            x++;
        }
        if (v1.getNroFactura() != v2.getNroFactura()) {
            modificaciones.add(new ModificacionesCompraPlantas(x, v1.getId(), "nro_factura", v1.getNroFactura() + "", Date.from(Instant.now())));
            x++;
        }
        if (v1.getFecha().compareTo(v2.getFecha()) != 0) {
            String fecha = v1.getFecha().getYear()+ "/" + (v1.getFecha().getMonth()+1) + "/" + v1.getFecha().getDay();
            modificaciones.add(new ModificacionesCompraPlantas(x, v1.getId(), "fecha", v1.getFecha()+"", Date.from(Instant.now())));
            x++;
        }
        return modificaciones;
    }

    public PlantasCompra encontrarPlantaCompraPorId(List<PlantasCompra> p1, int id) {
        for (PlantasCompra plantasCompra : p1) {
            if (plantasCompra.getId() == id) {
                return plantasCompra;
            }
        }
        return null;
    }

    public List<ModificacionesPlantasCompra> calcularDiferenciasPlantasCompra(List<PlantasCompra> p1, List<PlantasCompra> p2) {
        List<ModificacionesPlantasCompra> modificaciones = new LinkedList<>();
        int x = new ModificacionesPlantasCompraDAO().maxId() + 1;
        List<Integer> indices = new LinkedList<>();
        for (int i = 0; i < p2.size(); i++) {
            PlantasCompra aux = encontrarPlantaCompraPorId(p1, p2.get(i).getId());
            if (aux != null) {

                if (aux.getComprasPlanta().getId() != p2.get(i).getComprasPlanta().getId()) {
                    modificaciones.add(new ModificacionesPlantasCompra(x, aux.getId(), "id_comprasPlanta", aux.getComprasPlanta().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getEtapasPlanta().getPlantas().getId() != p2.get(i).getEtapasPlanta().getPlantas().getId()) {
                    modificaciones.add(new ModificacionesPlantasCompra(x, aux.getId(), "plantas_id", aux.getEtapasPlanta().getPlantas().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getEtapasPlanta().getEtapas().getId() != p2.get(i).getEtapasPlanta().getEtapas().getId()) {
                    modificaciones.add(new ModificacionesPlantasCompra(x, aux.getId(), "etapas_id", aux.getEtapasPlanta().getEtapas().getId() + "", Date.from(Instant.now())));
                    x++;
                }
                if (aux.getCantidad() != p2.get(i).getCantidad()) {
                    modificaciones.add(new ModificacionesPlantasCompra(x, aux.getId(), "cantidad", aux.getCantidad() + "", Date.from(Instant.now())));
                    x++;
                }
                if (!aux.getDescuento().equals(p2.get(i).getDescuento())) {
                    modificaciones.add(new ModificacionesPlantasCompra(x, aux.getId(), "descuento", aux.getDescuento() + "", Date.from(Instant.now())));
                    x++;
                }
            } else {
                modificaciones.add(new ModificacionesPlantasCompra(x, p2.get(i).getId(), "No existia la linea de compra", "", Date.from(Instant.now())));
                x++;
            }
        }

        for (int i = 0; i < p1.size(); i++) {
            PlantasCompra aux = encontrarPlantaCompraPorId(p2, p1.get(i).getId());
            if (aux == null) {

                modificaciones.add(new ModificacionesPlantasCompra(x, p1.get(i).getId(), "id_comprasPlanta", p1.get(i).getComprasPlanta().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantasCompra(x, p1.get(i).getId(), "plantas_id", p1.get(i).getEtapasPlanta().getPlantas().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantasCompra(x, p1.get(i).getId(), "etapas_id", p1.get(i).getEtapasPlanta().getEtapas().getId() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantasCompra(x, p1.get(i).getId(), "cantidad", p1.get(i).getCantidad() + "", Date.from(Instant.now())));
                x++;
                modificaciones.add(new ModificacionesPlantasCompra(x, p1.get(i).getId(), "descuento", p1.get(i).getDescuento() + "", Date.from(Instant.now())));
                x++;
            }
        }
        return modificaciones;
    }

    public void insertarDiferenciasComprasPlanta(List<ModificacionesCompraPlantas> lista) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            for (ModificacionesCompraPlantas elemento : lista) {
                s.save(elemento);
            }
            t.commit();
            s.close();
        } catch (Exception e) {
            t.rollback();
            System.out.print("No se pudo guardar la compra planta");
            System.out.println(e);

        }

    }

    public void insertarDiferenciasPlantasCompra(List<ModificacionesPlantasCompra> lista) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            for (ModificacionesPlantasCompra elemento : lista) {
                s.save(elemento);
            }
            t.commit();
            s.close();
        } catch (Exception e) {
            t.rollback();
            System.out.println("No se pudo guardar la plnanta compra");
            System.out.println(e);
        }

    }

    public List<ComprasPlanta> obtenerCompras() {
        List<ComprasPlanta> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from ComprasPlanta");
        lista = q.list();
        s.close();

        return lista;
    }

    public void actualizarCompra(String data) {

        ComprasPlanta v2 = crearCompra(data, true);
        crearArrayJSON(v2, "lineas", data, false);
        crearArrayJSON(v2, "lineasExistentes", data, true);
        
        
        ComprasPlanta v1 = consultarCompraPorId(v2.getId());
        actualizarCompra(v1, v2);

    }
}
