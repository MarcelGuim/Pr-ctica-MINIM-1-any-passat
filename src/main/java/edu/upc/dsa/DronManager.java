package edu.upc.dsa;
import edu.upc.dsa.exceptions.DronNotFoundException;
import edu.upc.dsa.exceptions.PilotNotFoundException;
import edu.upc.dsa.exceptions.PlanDeVueloNotFoundException;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanDeVuelo;


import java.util.List;
public interface DronManager {
    public Dron AddDron(Dron dron);
    public Dron AddDron(String id, String name, String fabricante, String modelo);
    public Dron AddDron(String name, String fabricante, String modelo);
    public Piloto AddPiloto(Piloto piloto);
    public Piloto AddPiloto(String id, String nombre, String apellidos);
    public Piloto AddPiloto(String nombre, String apellidos);
    public PlanDeVuelo AddPlanDeVuelo(PlanDeVuelo plan);
    public PlanDeVuelo AddPlanDeVuelo(String id, String IdPiloto, String IdDron, double Dia, double horas, double latOrigen, double longOrigen, double latDest, double longDest);
    public PlanDeVuelo AddPlanDeVuelo(String IdPiloto, String IdDron, double Dia, double horas, double latOrigen, double longOrigen, double latDest, double longDest);
    public List<Dron> listaDrones();
    public  List<Piloto> listaPilotos();
    public void PonDronAReparar(Dron dron);
    public  void ReparaDron();
    public  List<PlanDeVuelo> DameListaPlanesDron (String Id);
    public List<PlanDeVuelo> DameListaPlanesPiloto (String Id);
    public int sizeDrones();
    public int sizePilots();
    public int sizePlans();
    public int sizeReparaciones();
    public List<Dron> DameListaReparacion();
    public void clear();
}
