package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Piloto {
    String id;
    String nombre;
    String apellidos;
    double HorasVuelo;
    List<PlanDeVuelo> lista;

    public Piloto() {
        this.setId(RandomUtils.getId());
    }
    public Piloto(String nombre, String apellidos) {
        this(null,nombre,apellidos);
    }
    public Piloto(String id, String nombre, String apellidos) {
        this();
        if (id != null) this.setId(id);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setHorasVuelo(0);
        this.lista = new ArrayList<PlanDeVuelo>();

    }

    public double getHorasVuelo() {
        return HorasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        HorasVuelo = horasVuelo;
    }

    public List<PlanDeVuelo> getLista() {
        return lista;
    }

    public void setLista(List<PlanDeVuelo> lista) {
        this.lista = lista;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void addPlanDeVuelo(PlanDeVuelo plan)
    {
        this.lista.add(plan);
    }
    public void deletePlanDeVuelo(PlanDeVuelo plan)
    {
        lista.removeIf(plan1 -> plan1.getId().equals(plan.getId()));
    }


    @Override
    public String toString() {
        return "Piloto [id="+id+", nombre=" + nombre + ", apellidos=" + apellidos +"]";
    }
}
