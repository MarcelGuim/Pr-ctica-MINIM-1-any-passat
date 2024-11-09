package edu.upc.dsa;
import edu.upc.dsa.exceptions.DronNotFoundException;
import edu.upc.dsa.exceptions.PilotNotFoundException;
import edu.upc.dsa.exceptions.PlanDeVueloNotFoundException;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanDeVuelo;


import java.util.List;
public interface DronManager {
    public void AddDron(Dron dron);
    public void AddPiloto(Piloto piloto);
    public void AddPlanDeVuelo(PlanDeVuelo plan);
    public List<Dron> listaDrones();
    public  List<Piloto> listaPilotos();
    public void PonDronAReparar(Dron dron);
    public  void ReparaDron();
    public  List<PlanDeVuelo> DameListaPlanesDron (String Id);
    public List<PlanDeVuelo> DameListaPlanesPiloto (String Id);
    public int sizeDrones();
    public int sizePilots();
    public int sizePlans();
    public List<Dron> DameListaReparacion();
}
