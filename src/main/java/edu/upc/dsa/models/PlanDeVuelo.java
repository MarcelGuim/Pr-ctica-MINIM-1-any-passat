package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class PlanDeVuelo {
    String id;
    String IdPiloto;
    String IdDron;
    double dia;
    double horas;
    double LatOrigen;
    double LongOrigen;
    double LatDest;
    double LongDest;

    public PlanDeVuelo() {
        this.setId(RandomUtils.getId());
    }
    public PlanDeVuelo(String idPiloto, String idDron, double dia, double horas, double latOrigen, double longOrigen, double latDest, double longDest) {
        this(null,idPiloto,idDron,dia,horas,latOrigen,longOrigen,latDest,longDest);
    }
    public PlanDeVuelo(String id, String idPiloto, String idDron, double dia, double horas, double latOrigen, double longOrigen, double latDest, double longDest) {
        this();
        if (id != null) this.setId(id);
        IdPiloto = idPiloto;
        IdDron = idDron;
        this.dia = dia;
        this.horas = horas;
        LatOrigen = latOrigen;
        LongOrigen = longOrigen;
        LatDest = latDest;
        LongDest = longDest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPiloto() {
        return IdPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        IdPiloto = idPiloto;
    }

    public String getIdDron() {
        return IdDron;
    }

    public void setIdDron(String idDron) {
        IdDron = idDron;
    }

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getLatOrigen() {
        return LatOrigen;
    }

    public void setLatOrigen(double latOrigen) {
        LatOrigen = latOrigen;
    }

    public double getLongOrigen() {
        return LongOrigen;
    }

    public void setLongOrigen(double longOrigen) {
        LongOrigen = longOrigen;
    }

    public double getLatDest() {
        return LatDest;
    }

    public void setLatDest(double latDest) {
        LatDest = latDest;
    }

    public double getLongDest() {
        return LongDest;
    }

    public void setLongDest(double longDest) {
        LongDest = longDest;
    }

    @Override
    public String toString() {
        return "Plan de Vuelo [id="+id+", Dron=" + IdDron + ", piloto=" + IdPiloto +"]";
    }
}
