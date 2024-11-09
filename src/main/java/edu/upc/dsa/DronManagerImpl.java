package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanDeVuelo;
import edu.upc.dsa.models.Track;
import org.apache.log4j.Logger;

import java.util.*;

public class DronManagerImpl implements DronManager {
    private static DronManager instance;
    protected List<Dron> drons;
    protected List<Piloto> pilotos;
    protected List<PlanDeVuelo> planDeVuelo;
    protected Stack<Dron> reparaciones;
    final static Logger logger = Logger.getLogger(TracksManagerImpl.class);

    private DronManagerImpl() {
        this.drons = new LinkedList<>();
        this.pilotos = new LinkedList<>();
        this.planDeVuelo = new LinkedList<>();
        this.reparaciones = new Stack<>();
    }

    public static DronManager getInstance() {
        if (instance==null) instance = new DronManagerImpl();
        logger.info("insatce created");
        return instance;
    }

    public void AddDron(Dron dron){
        drons.add(dron);
        logger.info("Drone " +dron+" added");
    }
    public void AddPiloto(Piloto piloto){
        pilotos.add(piloto);
        logger.info("Pilot " +piloto+" added");
    }
    public Piloto getPiloto(String Id){
        for(Piloto piloto: pilotos)
        {
            if(piloto.getId().equals(Id))
                return piloto;
        }
        return null;
    }
    public Dron getDron(String Id){
        for(Dron dron: drons)
        {
            if(dron.getId().equals(Id))
                return dron;
        }
        return null;
    }
    public void AddPlanDeVuelo(PlanDeVuelo plan){
        Piloto piloto = getPiloto(plan.getIdPiloto());
        Dron dron = getDron(plan.getIdDron());
        List<PlanDeVuelo> PlanesDeVueloPiloto = piloto.getLista();
        List<PlanDeVuelo> PlanesDeVueloDron = dron.getLista();
        boolean no = false;
        for(PlanDeVuelo planDron: PlanesDeVueloDron)
        {
            if(planDron.getIdDron().equals(plan.getIdDron()) && planDron.getDia() == plan.getDia())
            {
                logger.info("No se puede añadir el plan de vuelo "+plan+", el dron esta ocupado" );
                no = true;
            }
        }
        for(PlanDeVuelo planPiloto: PlanesDeVueloPiloto)
        {
            if(planPiloto.getIdDron().equals(plan.getIdDron()) && planPiloto.getDia() == plan.getDia())
            {
                logger.info("No se puede añadir el plan de vuelo "+plan+", el piloto esta ocupado" );
                no = true;
            }
        }
        for(Dron dronR: reparaciones)
        {
            if(dronR.getId().equals(plan.getIdDron()))
            {
                logger.info("No se puede añadir el plan de vuelo "+plan+", el dron esta reaparaciones" );
                no = true;
            }
        }
        if(!no)
        {
            planDeVuelo.add(plan);
            piloto.addPlanDeVuelo(plan);
            dron.addPlanDeVuelo(plan);
            logger.info("Se ha añadido el plan de vuelo "+plan);

        }
    }

    public  List<Dron> listaDrones(){
        List<Dron> listaOrdenada = drons;
        listaOrdenada.sort(Comparator.comparingDouble(Dron::getHorasVuelo).reversed());
        logger.info("lista de Drones retornada");
        return listaOrdenada;
    }
    public   List<Piloto> listaPilotos(){
        List<Piloto> listaOrdenada = pilotos;
        listaOrdenada.sort(Comparator.comparingDouble(Piloto::getHorasVuelo).reversed());
        logger.info("lista de Pilotos retornada");
        return listaOrdenada;
    }
    public  void PonDronAReparar(Dron dron){
        reparaciones.push(dron);
        logger.info("El Dron: "+dron+" esta en reparaciones");
    }
    public  void ReparaDron(){
        Dron dron = reparaciones.pop();
        logger.info("El Dron: "+dron+" esta en reparado");
    }
    public  List<PlanDeVuelo> DameListaPlanesDron (String id){
        List<PlanDeVuelo> listaRespuesta = new ArrayList<>();
        for(PlanDeVuelo plan: planDeVuelo){
            if(plan.getIdDron().equals(id))
            {
                listaRespuesta.add(plan);
            }
        }
        logger.info("se ha retornado la Lista de planes de vuelo del dron "+id);
        return listaRespuesta;
    }
    public  List<PlanDeVuelo> DameListaPlanesPiloto (String id){
        List<PlanDeVuelo> listaRespuesta = new ArrayList<>();
        for(PlanDeVuelo plan: planDeVuelo){
            if(plan.getIdPiloto().equals(id))
            {
                listaRespuesta.add(plan);
            }
        }
        logger.info("se ha retornado la Lista de planes de vuelo del piloto "+id);
        return listaRespuesta;
    }
    public List<Dron> DameListaReparacion(){
        List<Dron> respuesta = reparaciones;
        return respuesta;
    }

    @Override
    public int sizeDrones() {
        int ret = this.drons.size();
        logger.info("size drones " + ret);
        return ret;
    }
    @Override
    public int sizePilots() {
        int ret = this.pilotos.size();
        logger.info("size pilotos " + ret);
        return ret;
    }
    @Override
    public int sizePlans() {
        int ret = this.planDeVuelo.size();
        logger.info("size Flight Plans " + ret);
        return ret;
    }
}
