package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Dron {
    String id;
    String nombre;
    String fabricante;
    String modelo;
    double HorasVuelo;
    List<PlanDeVuelo> lista;

    public Dron() {
        this.setId(RandomUtils.getId());
    }
    public Dron(String nombre, String fabricante, String modelo) {
        this(null,nombre,fabricante,modelo);
    }
    public Dron(String id, String nombre, String fabricante, String modelo) {
        this();
        if (id != null) this.setId(id);
        this.setNombre(nombre);
        this.setFabricante(fabricante);
        this.setNombre(nombre);
        this.setModelo(modelo);
        this.setHorasVuelo(0);
        this.lista = new ArrayList<PlanDeVuelo>();
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String moedelo) {
        this.modelo = moedelo;
    }

    public List<PlanDeVuelo> getLista() {
        return lista;
    }

    public void setLista(List<PlanDeVuelo> lista) {
        this.lista = lista;
    }
    public void addPlanDeVuelo(PlanDeVuelo plan)
    {
        this.lista.add(plan);
    }
    public void deletePlanDeVuelo(PlanDeVuelo plan)
    {
        lista.removeIf(plan1 -> plan1.getId().equals(plan.getId()));
    }

    public double getHorasVuelo() {
        return HorasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        HorasVuelo = horasVuelo;
    }

    @Override
    public String toString() {
        return "Dron [id="+id+", nombre=" + nombre + ", fabricatne=" + fabricante +", modelo=" +modelo+ "]";
    }
}
