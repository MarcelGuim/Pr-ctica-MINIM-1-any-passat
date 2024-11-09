package edu.upc.dsa;

import edu.upc.dsa.exceptions.TrackNotFoundException;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanDeVuelo;
import edu.upc.dsa.models.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DronManagerTest {
    DronManager Dm;
    Dron dron1 = new Dron("Dron1","DSA","DronGrande");
    Dron dron2 = new Dron("Dron2","DSA","DronMediano");
    Dron dron3 = new Dron("Dron3","DSA","DronPequeño");
    Piloto piloto1 = new Piloto("Pablo","Escobar");
    Piloto piloto2 = new Piloto("Marclo", "Polo");
    Piloto piloto3 = new Piloto("Gifre", "ElPilos");
    PlanDeVuelo plan1 = new PlanDeVuelo(piloto1.getId(), dron1.getId(),1,1,1,1,1,1);
    PlanDeVuelo plan2 = new PlanDeVuelo(piloto2.getId(), dron1.getId(),2,1,1,1,1,1);
    PlanDeVuelo plan3 = new PlanDeVuelo(piloto1.getId(), dron3.getId(),4,1,1,1,1,1);
    @Before
    public void setUp() {
        this.Dm = DronManagerImpl.getInstance();
        dron1.setHorasVuelo(86);
        dron2.setHorasVuelo(76);
        dron3.setHorasVuelo(1000);
        piloto1.setHorasVuelo(12);
        piloto2.setHorasVuelo(13);
        piloto3.setHorasVuelo(11);
        this.Dm.AddDron(dron1);
        this.Dm.AddDron(dron2);
        this.Dm.AddDron(dron3);
        this.Dm.AddPiloto(piloto1);
        this.Dm.AddPiloto(piloto2);
        this.Dm.AddPiloto(piloto3);
        this.Dm.AddPlanDeVuelo(plan1);
        this.Dm.AddPlanDeVuelo(plan2);
        this.Dm.AddPlanDeVuelo(plan3);
    }

    @After
    public void tearDown() {
        // És un Singleton
        this.Dm.clear();
    }

    @Test
    public void addDron() {
        Assert.assertEquals(3, Dm.sizeDrones());
        this.Dm.AddDron("Marco", "DSA", "DronEnorme");
        Assert.assertEquals(4, Dm.sizeDrones());

    }
    @Test
    public void addPiloto() {
        Assert.assertEquals(3, Dm.sizePilots());
        this.Dm.AddPiloto("Marco", "Marco");
        Assert.assertEquals(4, Dm.sizePilots());
    }
    @Test
    public void addPlan(){
        Assert.assertEquals(3, Dm.sizePlans());
        this.Dm.AddPlanDeVuelo(piloto3.getId(),dron2.getId(),4,1,1,1,1,1);
        Assert.assertEquals(4, Dm.sizePlans());
    }
    @Test
    public void PonDronAReparar(){
        Assert.assertEquals(0,Dm.sizeReparaciones());
        this.Dm.PonDronAReparar(dron1);
        Assert.assertEquals(1,Dm.sizeReparaciones());
    }
    @Test
    public void RepararDron(){
        Assert.assertEquals(0,Dm.sizeReparaciones());
        this.Dm.PonDronAReparar(dron1);
        Assert.assertEquals(1,Dm.sizeReparaciones());
        this.Dm.ReparaDron();
        Assert.assertEquals(0,Dm.sizeReparaciones());
    }
    @Test
    public void NoPuedeAddPlanPorPilotoOcupado(){
        Assert.assertEquals(3, Dm.sizePlans());
        this.Dm.AddPlanDeVuelo(piloto2.getId(),dron2.getId(),2,1,1,1,1,1);
        Assert.assertEquals(3, Dm.sizePlans());
    }
    @Test
    public void NoPuedeAddPlanPorDronOcupado(){
        Assert.assertEquals(3, Dm.sizePlans());
        this.Dm.AddPlanDeVuelo(piloto3.getId(),dron1.getId(),2,1,1,1,1,1);
        Assert.assertEquals(3, Dm.sizePlans());
    }
    @Test
    public void NoPuedeAddPlanPorDronEnRepracion(){
        Assert.assertEquals(3, Dm.sizePlans());
        Assert.assertEquals(0,Dm.sizeReparaciones());
        this.Dm.PonDronAReparar(dron1);
        Assert.assertEquals(1,Dm.sizeReparaciones());
        this.Dm.AddPlanDeVuelo(piloto3.getId(),dron1.getId(),2,1,1,1,1,1);
        Assert.assertEquals(3, Dm.sizePlans());
    }
//
//    @Test
//    public void getTrackTest() throws Exception {
//        Assert.assertEquals(3, tm.size());
//
//        Track t = this.tm.getTrack("T2");
//        Assert.assertEquals("Despacito", t.getTitle());
//        Assert.assertEquals("Luis Fonsi", t.getSinger());
//
//        t = this.tm.getTrack2("T2");
//        Assert.assertEquals("Despacito", t.getTitle());
//        Assert.assertEquals("Luis Fonsi", t.getSinger());
//
//        Assert.assertThrows(TrackNotFoundException.class, () ->
//                this.tm.getTrack2("XXXXXXX"));
//
//    }
//
//    @Test
//    public void getTracksTest() {
//        Assert.assertEquals(3, tm.size());
//        List<Track> tracks  = tm.findAll();
//
//        Track t = tracks.get(0);
//        Assert.assertEquals("La Barbacoa", t.getTitle());
//        Assert.assertEquals("Georgie Dann", t.getSinger());
//
//        t = tracks.get(1);
//        Assert.assertEquals("Despacito", t.getTitle());
//        Assert.assertEquals("Luis Fonsi", t.getSinger());
//
//        t = tracks.get(2);
//        Assert.assertEquals("Ent3r S4ndm4n", t.getTitle());
//        Assert.assertEquals("Metallica", t.getSinger());
//
//        Assert.assertEquals(3, tm.size());
//
//    }
//
//    @Test
//    public void updateTrackTest() {
//        Assert.assertEquals(3, tm.size());
//        Track t = this.tm.getTrack("T3");
//        Assert.assertEquals("Ent3r S4ndm4n", t.getTitle());
//        Assert.assertEquals("Metallica", t.getSinger());
//
//        t.setTitle("Enter Sandman");
//        this.tm.updateTrack(t);
//
//        t = this.tm.getTrack("T3");
//        Assert.assertEquals("Enter Sandman", t.getTitle());
//        Assert.assertEquals("Metallica", t.getSinger());
//    }
//
//
//    @Test
//    public void deleteTrackTest() {
//        Assert.assertEquals(3, tm.size());
//        this.tm.deleteTrack("T3");
//        Assert.assertEquals(2, tm.size());
//
//        Assert.assertThrows(TrackNotFoundException.class, () ->
//                this.tm.getTrack2("T3"));
//
//    }
}
