/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marie
 */
public class TestUnitaire {
     Moniteur jojo;
    Club clubClub;
    Site site;
    Plongee plongee;
    Embauche embauche;
    Plongeur plongeur;
    Licence licence;
    Plongeur badPlongeur;
    Licence badLicence;

     @Before
    public void setUp() {
        Calendar dateMax = Calendar.getInstance();
        dateMax.add(Calendar.YEAR, -3);
        jojo = new Moniteur("4812", "lapin", "jojo", "Castres", "0000000000", Calendar.getInstance(), 4,96,"bon");
        clubClub = new Club(jojo, "clubClub", "1111111111");
        site = new Site("Marseilles", "rien");
        plongee = new Plongee(site, jojo, Calendar.getInstance(), 20, 10);
        embauche = new Embauche(Calendar.getInstance(), jojo, clubClub);
        plongeur = new Plongeur("33", "malin", "alain", "cestas", "2222222222", Calendar.getInstance(),  5);
        badPlongeur = new Plongeur("34", "Alaise", "Blaise", "Paris", "333333333", Calendar.getInstance(), 8);
        licence = new Licence(plongeur, "13", Calendar.getInstance(), 25, clubClub);
        badLicence = new Licence(badPlongeur, "13", dateMax, 25, clubClub);
    

    }
    
    @Test
    public void testNonConforme() {
        clubClub.organisePlongee(plongee);
        badPlongeur.ajouteLicence(badLicence);
        plongee.ajouteParticipant(badPlongeur);
        clubClub.plongeesNonConformes().size();
        assertEquals(1, clubClub.plongeesNonConformes().size());
    }

    @Test
    public void testEmployeur() {
        jojo.nouvelleEmbauche(clubClub, Calendar.getInstance());
        jojo.employeurActuel().getNom();
        assertEquals("clubClub", jojo.employeurActuel().getNom());
        embauche.terminer(Calendar.getInstance());
        assertTrue(jojo.emplois().get(0).estTerminee());
    } 
    
    @Test
    public void testClub() {
        clubClub.organisePlongee(plongee);
        plongeur.ajouteLicence(licence);
        plongee.ajouteParticipant(plongeur);
        clubClub.plongeesNonConformes().size();
        assertEquals(0, clubClub.plongeesNonConformes().size());

    }
}
    
